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
		var name=document.getElementById("name").value;
		var uid=document.getElementById("uid").value;
		var indexgrade=document.getElementById("grade").selectedIndex;//获取当前选择项的索引.
		var grade=document.getElementById("grade").options[indexgrade].value;//获取当前选择项的值.
		
		location.href="user_list.jsp?name="+name+"&uid="+uid+"&grade="+grade;
	}
	function lockname(){
		var name=document.getElementById("name");
		name.readOnly=true;
	}
	function unlockname(){
		var uid=document.getElementById("uid").value;
		if(uid==null||uid==""){
			var name=document.getElementById("name");
		name.readOnly=false;
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
							用户名
							<input type="text" name="name" id="name" class="ui_select01" value="">
							ID
							<input type="text" name="uid" id="uid" class="ui_select01" value="" onblur="unlockname()" oninput="value=value.replace(/[^\d]/g,'')" onkeydown="lockname()">
							vip等级
							<select name="grade" id="grade" class="ui_select01">
                                <option value="0">--请选择--</option>
                                <option value="vip0">铜卡</option>
                                <option value="vip1">银卡</option>
                                <option value="vip2">金卡</option>
                                <option value="vip3">钻石卡</option>
                                <option value="vip4">至尊卡</option>
                            </select>
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
							<th>用户id</th>
							<th>用户姓名</th>
							<th>身份证</th>
							<th>性别</th>
							<th>电话</th>
							<th>会员等级</th>
							<th>操作</th>
							<th>备注</th>
						</tr>
						</thead>
						<tbody>
							<c:forEach items="${userlist}" var="u" varStatus="sta">
    					<tr id="tr${u.uid }"  >
    						<td><input type="checkbox" name="IDCheck" value="${u.uid }" class="acb" /></td>
	    					<td>${sta.count}</td>
	    					<td   id="uid">${u.uid}</td>
	    					<td   id="name">${u.name}</td>
	    					<td   id="idcard">${u.idcard}</td>
	    					<td   id="sex">${u.sex}</td>
	    					<td   id="utel">${u.utel}</td>
	    					<td   id="grade">${u.grade}</td>
	    					<td><button onclick="deleteUsers('${u.uid }')">删除</button>
	    						<input type="button" value="修改" onclick="updateUsers('${u.uid}')"/>
	    					</td>
    					</tr>	
    				</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="ui_tb_h30">
					<div class="ui_flt" style="height: 30px; line-height: 30px;">
						当前第
						<span class="ui_txt_bold04">${userpageNo }
						/
						${usermaxPage }</span>
						页
					</div>
					<div class="ui_frt">
						<a href="user_list.jsp?userpageNo=1&userpageSize=${userpageSize }">首页</a>
				  	 	<a href="user_list.jsp?userpageNo=${userpageNo-1}&userpageSize=${userpageSize }">上一页</a>
				  	 	<a href="user_list.jsp?userpageNo=${userpageNo+1}&userpageSize=${userpageSize }">下一页</a>
				  	 	<a href="user_list.jsp?userpageNo=${usermaxPage }&userpageSize=${userpageSize }">末页</a>
					</div>
				</div>
			</div>
		</div>
	</form>

</body>
</html>
