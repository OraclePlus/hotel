package cn.yisou.hotel.web.core;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
