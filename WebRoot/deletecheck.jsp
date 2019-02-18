<%@page import="cn.yisou.hotel.service.impl.CheckServiceHImpl"%>
<%@page import="cn.yisou.hotel.service.CheckServiceH"%>
<%@page import="java.net.URLDecoder"%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String number=request.getParameter("number");
	number = URLDecoder.decode(number,"UTF-8");
	CheckServiceH cs=new CheckServiceHImpl();
	boolean f=cs.removeInfoByNumber(number);
	pageContext.setAttribute("f", f);
 %>
${f}