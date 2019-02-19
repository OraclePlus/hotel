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
		function teljudge(){
			var tel = document.getElementById("tel").value;
			var myreg=/^[1][3,4,5,7,8,9][0-9]{9}$/;  
          	if (!myreg.test(tel)) {  
         	  document.getElementById("teldiv").innerHTML="手机号格式不正确";
			  document.getElementById("teldiv").style.color="red";
			  document.getElementById("teldiv").style.display="inline";
        	} else {  
         	    document.getElementById("teldiv").innerHTML="";
				document.getElementById("teldiv").style.display="none";
         	} 
		}
		function judge(){
			createXmlHttp();
			var idcard = document.getElementById("idcard").value;
			idcard = encodeURI(encodeURI(idcard));
			xmlHttp.open("GET","idcardistrue.jsp?idcard="+idcard,true);
			xmlHttp.onreadystatechange=callback;
			xmlHttp.send();
		}
		function callback(){
			if(xmlHttp.readyState==4){
				if(xmlHttp.status==200){
					//一切正常并能开始获得返回的结果
					var result= xmlHttp.responseText;
					if(result.trim()=="true"){
						document.getElementById("msgdiv").innerHTML="身份证号错误或此身份证已经注册";
						document.getElementById("msgdiv").style.color="red";
						document.getElementById("msgdiv").style.display="inline";
					}else{
						document.getElementById("msgdiv").innerHTML="";
						document.getElementById("msgdiv").style.display="none";
					}
					
				}
			}
		}
		function dataisnull(){
			var uid=document.getElementById("uid").value;
			var name=document.getElementById("name").value;
			var sex=document.getElementById("sex").value;
			var idcard=document.getElementById("idcard").value;
			var psw=document.getElementById("psw").value;
			var confirmpsw=document.getElementById("confirmpsw").value;
			var tel=document.getElementById("tel").value;
			if(uid!=null&&name!=null&&sex!=null&&idcard!=null&&psw!=null&&confirm!=null&&tel!=null){
				return true;
			}else{
				return false;
			}
		}
		
		function regtijiao(){
			var msgdiv=document.getElementById("msgdiv").html5;
			var pswdiv=document.getElementById("pswdiv").html5;
			var teldiv=document.getElementById("teldiv").html5;
			if((msgdiv==undefined||msgdiv=="")&&(pswdiv==undefined||pswdiv=="")&&(teldiv==undefined||teldiv=="")){
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

	<h1>欢迎登录</h1>

	<div class="container w3layouts agileits">

		<div class="login w3layouts agileits">
			<h2>登 录</h2>
			<form action="log.do" method="post" >
				<input type="hidden" value="<%=session.getAttribute("logmsg") %>" id="msglog"/> 
				<input type="text" name="userid" placeholder="账号" required="">
				<input type="password" name="logpassword" placeholder="密码" required="" onfocus="clearnmsg()">
				<div style="display:none" id="logmsg"></div><br/>
				<div class="send-button w3layouts agileits">
				<input type="submit" value="登 录">
			</form>
			</div>
			<div class="social-icons w3layouts agileits">
				<p>- 其他方式登录 -</p>
				<ul>
					<li class="qq"><a href="#">
					<span class="icons w3layouts agileits"></span>
					<span class="text w3layouts agileits">QQ</span></a></li>
					<li class="weixin w3ls"><a href="#">
					<span class="icons w3layouts"></span>
					<span class="text w3layouts agileits">微信</span></a></li>
					<li class="weibo aits"><a href="#">
					<span class="icons agileits"></span>
					<span class="text w3layouts agileits">微博</span></a></li>
					<div class="clear"> </div>
				</ul>
			</div>
			<div class="clear"></div>
		</div><div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>
		<div class="register w3layouts agileits">
			<h2>注 册</h2>
			<form action="reg.do" method="post" id="formid" onsubmit="return regtijiao()">
				<input type="hidden" value="<%=session.getAttribute("regmsg") %>" id="msginput"/>
				<input type="text" name="uid" placeholder="账号" required="" id="uid" readonly=true value="<%=pageContext.getAttribute("uid") %>">
				<input type="text" name="name" placeholder="用户名"  required="" id="name">
				<input type="password" name="regpassword" placeholder="密码" required="" id="psw">
				<input type="password" name="psw" placeholder="确认密码" required="" id="confirmpsw" onblur="pswjudge()"><div style="display:none" id="pswdiv"></div><br/>
				<input type="text" name="tel" placeholder="手机号码" required="" id="tel" onblur="teljudge()" ><div style="display:none" id="teldiv"></div><br/>
				<input type="text" name="idcard" placeholder="身份证号" required="" id="idcard" onblur="judge()" ><div style="display:none" id="msgdiv"></div><br/>
				<input type="text" name="sex" id="sex" placeholder="性别" required="" >
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
