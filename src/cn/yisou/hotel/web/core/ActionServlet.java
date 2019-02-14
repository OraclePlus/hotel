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


public class ActionServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//从应用程序中拿出配置信息
		Properties config = (Properties)this.getServletContext().getAttribute("config");
		//从应用程序中拿出action池
		//我们用类名作为key，对应的实例作为值
		Properties actionPool = (Properties)this.getServletContext().getAttribute("actionPool");
		//得到页面提交的路径
		String uri = req.getRequestURI();
		//获得最后一个斜杠和点进行截取
		int a = uri.lastIndexOf("/");
		int b = uri.lastIndexOf(".");
		if(b>a && a>0){
			uri = uri.substring(a+1, b);//uri=calc;
		}
		//============form的操作================================
		String formKey = uri+"Form";//calcForm
		//cn.zkingsoft.web.form.CalcForm
		String formClassName = config.getProperty(formKey);
		ActionForm form = null;
		try {
			//实例化了form
			Class c = Class.forName(formClassName);
			form = (ActionForm)c.newInstance();
			//拿到页面所有的请求参数
			Map<String, String[]> map  = req.getParameterMap();
			Set<Map.Entry<String, String[]>> set = map.entrySet();
			Iterator<Map.Entry<String, String[]>> it = set.iterator();
			while(it.hasNext()){
				Map.Entry<String, String[]> me = it.next();
				String key = me.getKey();
				String[] values = me.getValue();
				//key就是first或者second
				String methodName = "set"+key.substring(0, 1).toUpperCase()+key.substring(1);
				Method m = c.getMethod(methodName, new Class[]{String.class});
				//调用set方法
				m.invoke(form, values[0]);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		//============================================
		//将截取的uri作为key，在配置中找到要处理的类
		//cn.zkingsoft.web.action.CalcExtendAction
		String className = config.getProperty(uri);
		Action action = null;
		try {
			action = (Action)actionPool.get(className);
			if(action==null){
				//表示第一次访问该action
				action = (Action)Class.forName(className).newInstance();
				//存入action池
				actionPool.put(className, action);
			}
			//调用execute得到Actionforward
			ActionForward af = action.execute(req,resp,form);
			//跳转
			if(af!=null){
				af.forward(req, resp);
			}
		//============================================
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void init() throws ServletException {
		//应该初始化就读取配置文件
		String path = this.getServletContext().getRealPath("/");//到工程名；
		path += this.getInitParameter("configLocation");//通过xml文件找到这个配置文件；
		//加载
		Properties config = new Properties();
		//存放action实例的池
		Properties actionPool = new Properties();
		try {
			config.load(new FileInputStream(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//存入应用程序中
		this.getServletContext().setAttribute("config", config);
		this.getServletContext().setAttribute("actionPool", actionPool);
	}
	
}
