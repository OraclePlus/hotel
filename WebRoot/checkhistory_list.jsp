<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="scripts/jquery/jquery-1.7.1.js"></script>
<link href="style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="style/authority/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css" href="style/authority/jquery.fancybox-1.3.4.css" media="screen"></link>
<script type="text/javascript" src="scripts/artDialog/artDialog.js?skin=default"></script>
<title>信息管理系统</title>
<script type="text/javascript">
	function selectAll(){
		var uid=document.getElementById("uid").value;
		location.href="check_list.jsp?uid="+uid;
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
	function deleteUsersCheck(number){
		var flag=confirm("是否确认删除该订单");
		if(flag){
			createXmlHttp();
			number = encodeURI(encodeURI(number));
			xmlHttp.open("GET","deletecheck.jsp?number="+number,true);
			xmlHttp.onreadystatechange=callback;
			xmlHttp.send();
		}
	}
	function callback(){
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				//一切正常并能开始获得返回的结果
				var result= xmlHttp.responseText;
				if(result.trim()=="true"){
					location.href="checkhistory_list.jsp";
				}
				
			}
		}
	}
</script>
<style>
	.alt td{ background:black !important;}
</style>
</head>
<body>
	<form id="submitForm" name="submitForm" action="" method="post">
		<input type="hidden" name="allIDCheck" value="" id="allIDCheck"/>
		<input type="hidden" name="fangyuanEntity.fyXqName" value="" id="fyXqName"/>
		<div id="container">
			<div class="ui_content">
				<div class="ui_text_indent">
					<div id="box_border">
						<div id="box_top">搜索</div>
						<div id="box_center">
							用户ID
							<input type="text" name="uid" id="uid" class="ui_select01" value=""  oninput="value=value.replace(/[^\d]/g,'')" >
                            <button onclick="selectAll()">搜索</button>
						</div>
					</div>
				</div>
			</div>
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<thead>
						<tr>
							<th width="30"><input type="checkbox" id="all" onclick="selectOrClearAllCheckbox(this);" />
							</th>
							<th>序号</th>
							<th>订单号</th>
							<th>房间号</th>
							<th>用户id</th>
							<th>用户姓名</th>
							<th>入住人数</th>
							<th>实付金额</th>
							<th>入住时间</th>
							<th>离开时间</th>
							<th>操作</th>
							<th>备注</th>
						</tr>
						</thead>
						<tbody>
							<c:forEach items="${checkhistorylist}" var="cs" varStatus="sta">
    					<tr id="tr${cs.number }"  >
    						<td><input type="checkbox" name="IDCheck" value="${cs.number }" class="acb" /></td>
	    					<td>${sta.count}</td>
	    					<td   id="number">${cs.number}</td>
	    					<td   id="roomid">${cs.roomid}</td>
	    					<td   id="uid">${cs.uid}</td>
	    					<td   id="name">${cs.name}</td>
	    					<td   id="peoplenum">${cs.peoplenum}</td>
	    					<td   id="money">${cs.money}</td>
	    					<td   id="checktime">${cs.checktime}</td>
	    					<td   id="leavetime">${cs.leavetime}</td>
	    					<td>
	    						<button onclick="deleteCheck('${cs.number }')">删除</button>
	    					</td>
    					</tr>	
    				</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="ui_tb_h30">
					<div class="ui_flt" style="height: 30px; line-height: 30px;">
						当前第
						<span class="ui_txt_bold04">${checkhistorypageNo }
						/
						${checkhistorymaxPage }</span>
						页
					</div>
					<div class="ui_frt">
						<a href="check_list.jsp?checkhistorypageNo=1&checkhistorypageSize=${checkhistorypageSize }">首页</a>
				  	 	<a href="check_list.jsp?checkhistorypageNo=${checkhistorypageNo-1}&checkhistorypageSize=${checkhistorypageSize }">上一页</a>
				  	 	<a href="check_list.jsp?checkhistorypageNo=${checkhistorypageNo+1}&checkhistorypageSize=${checkhistorypageSize }">下一页</a>
				  	 	<a href="check_list.jsp?checkhistorypageNo=${checkhistorymaxPage }&checkhistorypageSize=${checkhistorypageSize }">末页</a>
					</div>
				</div>
			</div>
		</div>
	</form>

</body>
</html>
