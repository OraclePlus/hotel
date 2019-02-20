<%@page import="cn.yisou.hotel.pojo.Room"%>
<%@page import="cn.yisou.hotel.service.impl.RoomServiceHImpl"%>
<%@page import="cn.yisou.hotel.service.RoomServiceH"%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showroom.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 	<%
   		String roomid = request.getParameter("roomid");
   		RoomServiceH rs = new RoomServiceHImpl();
   		Room room = rs.findRoomByRoomid(roomid);
   		pageContext.setAttribute("room", room);
   	%>
	<style type="text/css">
		td{
			font-size: 20;
			font-weight: bold;
		}
		body{    
	        background-image: url(${room.photo});    
	        background-size:cover;  
     	}
     	#info {
     		width:300px;
			background-color: white;
			opacity:0.5;
		}
	</style>
  </head>
 
  <body>
    	<center>
    		<br/>
    		<br/>
    		<br/>
    		<br/>
    		<br/>
    		<br/>
    		<br/>
    		<div id="info">
	    		<h1>房间信息</h1>
	    		<table>
	    			<tbody>
	    				<tr>
	    					<td>房间编号：</td>
	    					<td>${room.roomid}</td>
	    				</tr>
	    				<tr>
	    					<td>房间类型：</td>
	    					<td>${room.type}</td>
	    				</tr>
	    				<tr>
	    					<td>房间价格：</td>
	    					<td>${room.price}</td>
	    				</tr>
	    				<tr>
	    					<td>房间状态：</td>
	    					<td>${room.state}</td>
	    				</tr>
	    				<tr>
	    					<td>房间人数：</td>
	    					<td>${room.peoplenum}</td>
	    				</tr>
	    			</tbody>
   				</table>
    		</div>
    	</center>
  </body>
</html>
