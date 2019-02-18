<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	function change(){
		var x = document.getElementById("lc");
   		var y = document.getElementById("room");
   		 y.options.length = 0
   		 if(x.selectedIndex == 0){
   		 	y.options.add(new Option("请先选中楼层", "0"));
   		 }
		 if(x.selectedIndex == 1){
		 	y.options.add(new Option("请选择", "0"));
		 	y.options.add(new Option("1001", "1001"));
			y.options.add(new Option("1002", "1002"));
			y.options.add(new Option("1003", "1003"));
			y.options.add(new Option("1004", "1004"));
			y.options.add(new Option("1005", "1005"));
			y.options.add(new Option("1006", "1006"));
			y.options.add(new Option("1007", "1007"));
			y.options.add(new Option("1008", "1008"));
			y.options.add(new Option("1009", "1009"));
			y.options.add(new Option("1010", "1010"));
		 }
		  if(x.selectedIndex == 2){
		 	y.options.add(new Option("请选择", "0"));
		 	y.options.add(new Option("2001", "2001"));
			y.options.add(new Option("2002", "2002"));
			y.options.add(new Option("2003", "2003"));
			y.options.add(new Option("2004", "2004"));
			y.options.add(new Option("2005", "2005"));
			y.options.add(new Option("2006", "2006"));
			y.options.add(new Option("2007", "2007"));
			y.options.add(new Option("2008", "2008"));
			y.options.add(new Option("2009", "2009"));
			y.options.add(new Option("2010", "2010"));
		 }
		  if(x.selectedIndex == 3){
		 	y.options.add(new Option("请选择", "0"));
		 	y.options.add(new Option("3001", "3001"));
			y.options.add(new Option("3002", "3002"));
			y.options.add(new Option("3003", "3003"));
			y.options.add(new Option("3004", "3004"));
			y.options.add(new Option("3005", "3005"));
			y.options.add(new Option("3006", "3006"));
			y.options.add(new Option("3007", "3007"));
			y.options.add(new Option("3008", "3008"));
			y.options.add(new Option("3009", "3009"));
			y.options.add(new Option("3010", "3010"));
		 }
		  if(x.selectedIndex == 4){
		 	y.options.add(new Option("请选择", "0"));
		 	y.options.add(new Option("4001", "4001"));
			y.options.add(new Option("4002", "4002"));
			y.options.add(new Option("4003", "4003"));
			y.options.add(new Option("4004", "4004"));
			y.options.add(new Option("4005", "4005"));
			y.options.add(new Option("4006", "4006"));
			y.options.add(new Option("4007", "4007"));
			y.options.add(new Option("4008", "4008"));
			y.options.add(new Option("4009", "4009"));
			y.options.add(new Option("4010", "4010"));
		 }
		  if(x.selectedIndex == 5){
		 	y.options.add(new Option("请选择", "0"));
		 	y.options.add(new Option("5001", "5001"));
			y.options.add(new Option("5002", "5002"));
			y.options.add(new Option("5003", "5003"));
			y.options.add(new Option("5004", "5004"));
			y.options.add(new Option("5005", "5005"));
			y.options.add(new Option("5006", "5006"));
			y.options.add(new Option("5007", "5007"));
			y.options.add(new Option("5008", "5008"));
			y.options.add(new Option("5009", "5009"));
			y.options.add(new Option("5010", "5010"));
		 }
		  if(x.selectedIndex == 6){
		  	
		 	y.options.add(new Option("请选择", "0"));
		 	y.options.add(new Option("6666", "6666"));
		 }
	}
	function lockstate(){
		var x = document.getElementById("room");
		var y = document.getElementById("state");
		y.options.length = 0
		if(x.selectedIndex != 0){
			y.options.add(new Option(" ", "0"));
		}else{
			y.options.add(new Option("可入住 ", "可入住"));
			y.options.add(new Option("已住", "已住"));
		}
	}
	function selectAll(){
		var indexlc=document.getElementById("lc").selectedIndex;//获取当前选择项的索引.
		var lc=document.getElementById("lc").options[indexlc].value;//获取当前选择项的值.
		
		var indexroomid=document.getElementById("room").selectedIndex;//获取当前选择项的索引.
		var roomid=document.getElementById("room").options[indexroomid].value;//获取当前选择项的值.
		
		var indexstate=document.getElementById("state").selectedIndex;//获取当前选择项的索引.
		var state=document.getElementById("state").options[indexstate].value;//获取当前选择项的值.
		
		location.href="house_list.jsp?lc="+lc+"&room="+roomid+"&state="+state;
	}
	function showA(){
		var maxpage=document.getElementById("divmsg").value;
		if(maxpage=="1"){
			var div=document.getElementById("lianjie");
			div.style.display="none";
		}else{
			var div=document.getElementById("lianjie");
			div.style.display="inline";
		}
	}
</script>
<style>
	.alt td{ background:black !important;}
</style>
</head>
<body onload="showA()">
	<form id="submitForm" name="submitForm" action="" method="post">
		<input type="hidden" name="allIDCheck" value="" id="allIDCheck"/>
		<input type="hidden" name="fangyuanEntity.fyXqName" value="" id="fyXqName"/>
		<div id="container">
			<div class="ui_content">
				<div class="ui_text_indent">
					<div id="box_border">
						<div id="box_top">搜索</div>
						<div id="box_center">
							楼层
							<select name="lc" id="lc" class="ui_select01" onchange="change()">
                                <option value="0">--请选择--</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                            </select>
							房间号
							<select name="room" id="room" class="ui_select01" onchange="lockstate()">
                                <option value="0">--请先选择楼层--</option>
                            </select>
							状态
							<select name="state" id="state" class="ui_select01">
                                <option value="0">--请选择--</option>
                                <option value="可入住">可入住</option>
                                <option value="已住">已住</option>
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
							<th>房间号</th>
							<th>房间类型</th>
							<th>房间价格</th>
							<th>状态</th>
							<th>是否为钟点房</th>
							<th>可住人数</th>
							<th>房间电话</th>
							<th>操作</th>
							<th>备注</th>
						</tr>
						</thead>
						<tbody id="tbody">
    					<c:forEach items="${roomlist}" var="r" varStatus="sta">
    					<tr id="tr${r.roomid }"  >
    						<td><input type="checkbox" name="IDCheck" value="${r.roomid }" class="acb" /></td>
	    					<td>${sta.count}</td>
	    					<td   id="roomid">${r.roomid}</td>
	    					<td   id="type">${r.type}</td>
	    					<td   id="price">${r.price}</td>
	    					<td   id="state">${r.state}</td>
	    					<td   id="hourroom">${r.hourroom}</td>
	    					<td   id="peoplenum">${r.peoplenum}</td>
	    					<td   id="roomtel">${r.roomtel}</td>
	    					<td><button onclick="deleteUsers('${r.roomid }')">删除</button>
	    						<input type="button" value="修改" onclick="updateUsers('${r.roomid}')"/>
	    					</td>
    					</tr>	
    				</c:forEach>
    			</tbody>
					</table>
				</div>
				<div class="ui_tb_h30">
					<div class="ui_flt" style="height: 30px; line-height: 30px;">
						当前第
						<span class="ui_txt_bold04">${roompageNo }
						/
						${roommaxPage }</span>
						页
					</div>
					<div class="ui_frt" id="lianjie">
						<input type="hidden" value="<%=session.getAttribute("roommaxPage") %>" id="divmsg">
						<a href="house_list.jsp?roompageNo=1&roompageSize=${roompageSize }">首页</a>
				  	 	<a href="house_list.jsp?roompageNo=${roompageNo-1}&roompageSize=${roompageSize }">上一页</a>
				  	 	<a href="house_list.jsp?roompageNo=${roompageNo+1}&roompageSize=${roompageSize }">下一页</a>
				  	 	<a href="house_list.jsp?roompageNo=${roommaxPage }&roompageSize=${roompageSize }">末页</a>
					</div>
				</div>
			</div>
		</div>
	</form>

</body>
</html>
