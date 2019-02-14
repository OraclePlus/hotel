package cn.yisou.hotel.web.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse reponse,ActionForm form)throws ServletException, IOException;
}
