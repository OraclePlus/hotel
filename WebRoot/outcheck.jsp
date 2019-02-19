<%@page import="cn.yisou.hotel.service.impl.RoomServiceHImpl"%>
<%@page import="cn.yisou.hotel.service.RoomServiceH"%>
<%@page import="cn.yisou.hotel.pojo.Check"%>
<%@page import="cn.yisou.hotel.service.impl.CheckServiceHImpl"%>
<%@page import="cn.yisou.hotel.service.CheckServiceH"%>
<%@page import="java.net.URLDecoder"%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String number=request.getParameter("number");
	number = URLDecoder.decode(number,"UTF-8");
	CheckServiceH cs=new CheckServiceHImpl();
	RoomServiceH rs=new RoomServiceHImpl();
	Check check=cs.findCheckByNumber(number);
	boolean ff=cs.changeStateByNumber(number, "已退");
	boolean f=rs.changeStateByRoomid(check.getRoomid(), "可入住");
	f=f&&ff;
	pageContext.setAttribute("f", f);
 %>
${f}