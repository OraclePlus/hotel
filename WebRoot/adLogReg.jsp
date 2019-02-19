<%@page import="cn.yisou.hotel.utils.PrimaryKeyUUID"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="cn.hutool.captcha.CircleCaptcha"%>
<%@page import="cn.hutool.captcha.CaptchaUtil"%>
<%@page import="cn.hutool.captcha.ShearCaptcha"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

<!-- Head -->
<head>

	<title>登录表单</title>

	<!-- Meta-Tags -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //Meta-Tags -->

	<!-- Style --> <link rel="stylesheet" href="css/loginstyle.css" type="text/css" media="all">
	
	<% 
		String uid=PrimaryKeyUUID.getPrimaryKey();
		pageContext.setAttribute("uid", uid);
	%>
	<script type="text/javascript">
		function showmsg(){
			var val = document.getElementById("msginput").value;
			var log = document.getElementById("msglog").value;
			
			if(val=="注册失败"){
				document.getElementById("msgdiv").innerHTML=val;
				document.getElementById("msgdiv").style.color="red";
				document.getElementById("msgdiv").style.display="inline";
			}else{
				document.getElementById("msgdiv").innerHTML="";
				document.getElementById("msgdiv").style.display="none";
			}
			if(log=="密码错误"){
				document.getElementById("logmsg").innerHTML=log;
				document.getElementById("logmsg").style.color="red";
				document.getElementById("logmsg").style.display="inline";
			}else{
				document.getElementById("logmsg").innerHTML="";
				document.getElementById("logmsg").style.display="none";
			}
		}
		function clearnmsg(){
			document.getElementById("logmsg").innerHTML="";
			document.getElementById("logmsg").style.display="none";
		}
		String.prototype.trim=function(){
			var l = this.replace(this.match(/^\s+/),"");
			var r = l.replace(this.match(/\s+$/),"");
			return r;
		};
		var xmlHttp;
		function createXmlHttp(){
			if(window.XMLHttpRequest){
				xmlHttp = new XMLHttpRequest();
			}else{
				try{
					xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
				}catch(e){
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				}
			}
		} 
		function pswjudge(){
			var psw = document.getElementById("psw").value;
			var confirmpsw = document.getElementById("confirmpsw").value;
			if(psw!=confirmpsw){
				document.getElementById("pswdiv").innerHTML="两次密码不一致";
				document.getElementById("pswdiv").style.color="red";
				document.getElementById("pswdiv").style.display="inline";
			}else{
				document.getElementById("pswdiv").innerHTML="";
				document.getElementById("pswdiv").style.display="none";
			}
		}
	

		function dataisnull(){
			var uid=document.getElementById("uid").value;
			var psw=document.getElementById("psw").value;
			var confirmpsw=document.getElementById("confirmpsw").value;
			if(uid!=null&&psw!=null&&confirm!=null){
				return true;
			}else{
				return false;
			}
		}
		
		function regtijiao(){
			var msgdiv=document.getElementById("msgdiv").html5;
			var pswdiv=document.getElementById("pswdiv").html5;
			if((msgdiv==undefined||msgdiv=="")&&(pswdiv==undefined||pswdiv=="")){
				var confirm=dataisnull();
				if(confirm){
					return true; 
				}else{
					return false;
				}
			}else{
				return false;
			}
		}
	</script>

</head>
<!-- //Head -->

<!-- Body -->
<body onload="showmsg()">

	<h1>申请管理员</h1>

	<div class="container w3layouts agileits">

		<div class="login w3layouts agileits">
			<h2>登 录</h2>
			<form action="adlog.do" method="post" >
				<input type="hidden" value="<%=session.getAttribute("logmsg") %>" id="msglog"/> 
				<input type="text" name="Adid" placeholder="账号" required="">
				<input type="password" name="Adlogpassword" placeholder="密码" required="" onfocus="clearnmsg()">
				<div style="display:none" id="logmsg"></div><br/>
				<div class="send-button w3layouts agileits">
				<input type="submit" value="登 录">
			</form>
			</div>
			<div class="social-icons w3layouts agileits">
	
			</div>
			<div class="clear"></div>
		</div><div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>
		<div class="register w3layouts agileits">
			<h2>注 册</h2>
			<form action="adreg.do" method="post" id="formid" onsubmit="return regtijiao()">
				<input type="hidden" value="<%=session.getAttribute("regmsg") %>" id="msginput"/>
				<input type="text" name="adid" placeholder="账号" required="" id="uid" readonly=true value="<%=pageContext.getAttribute("uid") %>">
				<input type="password" name="adpsw" placeholder="密码" required="" id="psw">
				<input type="password" name="adpsw" placeholder="确认密码" required="" id="confirmpsw" onblur="pswjudge()"><div style="display:none" id="pswdiv"></div><br/>
				 <div class="food wow agileits w3layouts slideInLeft">
              
				<div class="send-button w3layouts agileits">
					<input type="submit" value="免费注册" >
				</div>
			</form>
			
			<div class="clear"></div>
		</div>

		<div class="clear"></div>

	</div>

	<!-- <div class="footer w3layouts agileits">
		<p>Copyright &copy; More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
	</div> -->

</body>
<!-- //Body -->
		
</html>
