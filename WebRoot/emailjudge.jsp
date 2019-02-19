<%@page import="cn.hutool.core.util.ReUtil"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="cn.yisou.hotel.pojo.User"%>
<%@page import="cn.yisou.hotel.service.impl.UserServiceHImpl"%>
<%@page import="cn.yisou.hotel.service.UserServiceH"%>
<%@page import="cn.hutool.core.util.IdcardUtil"%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	
	String email = request.getParameter("e_mail");
	email = URLDecoder.decode(email,"UTF-8");
	System.out.println(email);
	boolean f= ReUtil.isMatch("\\w+@\\w+([.]|[.]\\w+[.])(com|cn|org)", email);
	System.out.println(f);
	pageContext.setAttribute("f", f);
 %>
${f}