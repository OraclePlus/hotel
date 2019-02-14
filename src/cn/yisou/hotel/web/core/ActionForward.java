package cn.yisou.hotel.web.core;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 这个类就是专门用来做跳转页面的类
 * 包含是否重定向还是转发，以及逻辑页面名称
 * @author Administrator
 *
 */
public class ActionForward {
	private boolean isRedirect = false;
	private String path = null;
	public ActionForward(String path) {
		this(false,path);
	}
	public ActionForward(boolean isRedirect,String path) {
		this.isRedirect = isRedirect;
		this.path = path;
	}
	
	public void forward(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		//拿到全局的配置文件信息
		Properties config = (Properties)request.getSession().getServletContext().getAttribute("config");
		if(isRedirect){
			response.sendRedirect(config.getProperty(path));
		}else{
			request.getRequestDispatcher(config.getProperty(path)).forward(request, response);
		}
	}
}
