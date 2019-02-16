package cn.yisou.hotel.web.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Properties config=(Properties)this.getServletContext().getAttribute("config");
		Properties actionPool = (Properties)this.getServletContext().getAttribute("actionPool");
		String uri=req.getRequestURI();
		int dot=uri.lastIndexOf(".");
		int xie=uri.lastIndexOf("/");
		uri=uri.substring(xie+1,dot);
		String formKey = uri+"Form";//logForm
		String formClassName = config.getProperty(formKey);
		ActionForm form = null;
		try {
			Class c = Class.forName(formClassName);
			form = (ActionForm)c.newInstance();
			Map<String, String[]> map  = req.getParameterMap();
			Set<Map.Entry<String, String[]>> set = map.entrySet();
			Iterator<Map.Entry<String, String[]>> it = set.iterator();
			while(it.hasNext()){
				Map.Entry<String, String[]> me = it.next();
				String key = me.getKey();
				String[] values = me.getValue();
				String methodName = "set"+key.substring(0, 1).toUpperCase()+key.substring(1);
				Method m = c.getMethod(methodName, new Class[]{String.class});
				m.invoke(form, values[0]);//Éú³Ébean£»
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String className = config.getProperty(uri);
		Action action = null;
		try {
			action = (Action)actionPool.get(className);
			if(action==null){
				action = (Action)Class.forName(className).newInstance();
				actionPool.put(className, action);
			}
			ActionForward af = action.excute(req,resp,form);
			if(af!=null){
				af.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void init() throws ServletException {
		String path=this.getServletContext().getRealPath("/");
		path+=this.getInitParameter("configLocation");
		Properties config=new Properties();
		Properties actionPool=new Properties();
		try {
			config.load(new FileInputStream(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.getServletContext().setAttribute("config", config);
		this.getServletContext().setAttribute("actionPool", actionPool);
	}
}
