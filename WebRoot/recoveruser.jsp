<%@page import="cn.yisou.hotel.service.impl.UserServiceHImpl"%>
<%@page import="cn.yisou.hotel.service.UserServiceH"%>
<%@page import="cn.yisou.hotel.service.impl.CheckServiceHImpl"%>
<%@page import="cn.yisou.hotel.service.CheckServiceH"%>
<%@page import="java.net.URLDecoder"%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String uid=request.getParameter("uid");
	uid = URLDecoder.decode(uid,"UTF-8");
	UserServiceH us=new UserServiceHImpl();
	boolean f=us.changeGradeByUid(uid, "vip0");
	pageContext.setAttribute("f", f);
 %>
${f}