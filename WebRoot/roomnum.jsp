<%@page import="java.net.URLDecoder"%>
<%@page import="cn.yisou.hotel.service.impl.RoomServiceHImplZ"%>
<%@page import="cn.yisou.hotel.service.RoomServiceZ"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

  <%
   		String roomtype=request.getParameter("roomtype");
   		roomtype=URLDecoder.decode(roomtype,"UTF-8");
   		RoomServiceZ roomZ=new RoomServiceHImplZ();
   		int num=roomZ.findRoomNumByType(roomtype);
   		request.setAttribute("num", num);
   		System.out.print(num);
    %>
    ${num}
  