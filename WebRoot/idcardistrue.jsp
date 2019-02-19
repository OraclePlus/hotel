<%@page import="java.net.URLDecoder"%>
<%@page import="cn.yisou.hotel.pojo.User"%>
<%@page import="cn.yisou.hotel.service.impl.UserServiceHImpl"%>
<%@page import="cn.yisou.hotel.service.UserServiceH"%>
<%@page import="cn.hutool.core.util.IdcardUtil"%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	UserServiceH us=new UserServiceHImpl();
	String idcard = request.getParameter("idcard");
	idcard = URLDecoder.decode(idcard,"UTF-8");
	boolean f=false;
	boolean ff=false;
	User user=us.findUserByIdcard(idcard);
	f=IdcardUtil.isValidCard(idcard);
	if(user.getUid()!=null){
		ff=true;
	}
	f=f&&ff;
	pageContext.setAttribute("f", f);
 %>
${f}