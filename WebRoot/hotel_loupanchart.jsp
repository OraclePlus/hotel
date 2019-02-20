<%--
  Created by IntelliJ IDEA.
  User: oracle
  Date: 2019/1/28
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@page import="cn.yisou.hotel.pojo.Room"%>
<%@page import="java.util.List"%>
<%@page import="cn.yisou.hotel.service.impl.RoomServiceHImpl"%>
<%@page import="cn.yisou.hotel.service.RoomServiceH"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style/authority/basic_layout.css" rel="stylesheet"
	type="text/css">
<link href="style/authority/common_style.css" rel="stylesheet"
	type="text/css">
<link href="style/authority/zTreeStyle.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript" src="scripts/jquery/jquery-1.4.4.min.js"></script>
<script type="text/javascript"
	src="scripts/zTree/jquery.ztree.core-3.2.js"></script>
<script type="text/javascript"
	src="scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript"
	src="scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css"
	href="style/authority/jquery.fancybox-1.3.4.css" media="screen" /></link>
<script type="text/javascript"
	src="scripts/artDialog/artDialog.js?skin=default"></script>
<link rel="shortcut icon"  href="images/hotelicon.png" type="image/x-icon" />
<title>信息管理系统</title>
<script type="text/javascript">

	/** ----------------leftMenu zTree部分开始----------------  **/
	var zTree;
	var setting = {
		view : {
			dblClickExpand : false,
			showLine : true,
			selectedMulti : false,
			expandSpeed : ($.browser.msie && parseInt($.browser.version) <= 6) ? ""
				: "fast"
		},
		data : {
			key : {
				name : "weiduName"
			},
			simpleData : {
				enable : true,
				idKey : "weiduID",
				pIdKey : "parentID",
				rootPId : ""
			}
		},
		callback : {
			beforeClick : beforeClick,
			onClick : onClick
		}
	};

	var zNodes = [
		{
			"checked" : false,
			"crospID" : 0,
			"delFlag" : 1,
			"parentID" : 0,
			"weiduCode" : "FANGYUANGUANLI",
			"weiduGrade" : 0,
			"weiduID" : 5,
			"weiduName" : "房源管理",
			"weiduOrder" : 2,
			"weiduType" : "FANGYUANGUANLI"
		},
		{
			"checked" : false,
			"crospID" : 0,
			"delFlag" : 1,
			"parentID" : 5,
			"weiduCode" : "KANGJUXINCHENG",
			"weiduGrade" : 1,
			"weiduID" : 6,
			"weiduName" : "瑞景河畔",
			"weiduOrder" : 1,
			"weiduType" : "FANGYUANGUANLI"
		},
		{
			"checked" : false,
			"crospID" : 0,
			"delFlag" : 1,
			"parentID" : 5,
			"weiduCode" : "YULANXIAOQU",
			"weiduGrade" : 1,
			"weiduID" : 77,
			"weiduName" : "蔚蓝小区",
			"weiduOrder" : 2,
			"weiduType" : "FANGYUANGUANLI"
		},
		{
			"checked" : false,
			"crospID" : 0,
			"delFlag" : 1,
			"parentID" : 5,
			"weiduCode" : "HESHENGYUAN",
			"weiduGrade" : 1,
			"weiduID" : 83,
			"weiduName" : "和盛园小区",
			"weiduOrder" : 3,
			"weiduType" : "FANGYUANGUANLI"
		},
		{
			"checked" : false,
			"crospID" : 0,
			"delFlag" : 1,
			"parentID" : 83,
			"weiduCode" : " HESHENGYUAN1HAOLOU",
			"weiduGrade" : 2,
			"weiduID" : 84,
			"weiduName" : " 和盛园小区112号楼",
			"weiduOrder" : 1,
			"weiduType" : "FANGYUANGUANLI"
		},
		{
			"checked" : false,
			"crospID" : 0,
			"delFlag" : 1,
			"parentID" : 6,
			"weiduCode" : "KANGJUXINCHENG500HAO1DONG",
			"weiduGrade" : 2,
			"weiduID" : 16,
			"weiduName" : "瑞景河畔16号楼",
			"weiduOrder" : 1,
			"weiduType" : "FANGYUANGUANLI"
		},
		{
			"checked" : false,
			"crospID" : 0,
			"delFlag" : 1,
			"parentID" : 77,
			"weiduCode" : "YULANXIAOQU2HAOLOU",
			"weiduGrade" : 2,
			"weiduID" : 78,
			"weiduName" : "蔚蓝小区4号楼",
			"weiduOrder" : 1,
			"weiduType" : "FANGYUANGUANLI"
		},
		{
			"checked" : false,
			"crospID" : 0,
			"delFlag" : 1,
			"parentID" : 77,
			"weiduCode" : "YULANXIAOQU5HAOLOU",
			"weiduGrade" : 2,
			"weiduID" : 79,
			"weiduName" : "蔚蓝小区5号楼",
			"weiduOrder" : 2,
			"weiduType" : "FANGYUANGUANLI"
		},
		{
			"checked" : false,
			"crospID" : 0,
			"delFlag" : 1,
			"parentID" : 6,
			"weiduCode" : "KANGJUXINCHENG500HAO2DONG",
			"weiduGrade" : 2,
			"weiduID" : 17,
			"weiduName" : "瑞景河畔17号楼",
			"weiduOrder" : 2,
			"weiduType" : "FANGYUANGUANLI"
		},
		{
			"checked" : false,
			"crospID" : 0,
			"delFlag" : 1,
			"parentID" : 83,
			"weiduCode" : " HESHENGYUAN2HAOLOU",
			"weiduGrade" : 2,
			"weiduID" : 85,
			"weiduName" : " 和盛园小区113号楼",
			"weiduOrder" : 2,
			"weiduType" : "FANGYUANGUANLI"
		},
		{
			"checked" : false,
			"crospID" : 0,
			"delFlag" : 1,
			"parentID" : 6,
			"weiduCode" : "KANGJUXINCHENG500HAO3DONG",
			"weiduGrade" : 2,
			"weiduID" : 69,
			"weiduName" : "瑞景河畔18号楼",
			"weiduOrder" : 3,
			"weiduType" : "FANGYUANGUANLI"
		},
		{
			"checked" : false,
			"crospID" : 0,
			"delFlag" : 1,
			"parentID" : 77,
			"weiduCode" : "YULANXIAOQU7HAOLOU",
			"weiduGrade" : 2,
			"weiduID" : 80,
			"weiduName" : "蔚蓝小区7号楼",
			"weiduOrder" : 3,
			"weiduType" : "FANGYUANGUANLI"
		},
		{
			"checked" : false,
			"crospID" : 0,
			"delFlag" : 1,
			"parentID" : 77,
			"weiduCode" : "YULANXIAOQU8HAOLOU",
			"weiduGrade" : 2,
			"weiduID" : 81,
			"weiduName" : "蔚蓝小区8号楼",
			"weiduOrder" : 4,
			"weiduType" : "FANGYUANGUANLI"
		},
		{
			"checked" : false,
			"crospID" : 0,
			"delFlag" : 1,
			"parentID" : 6,
			"weiduCode" : "RUIJINGHEPAN20HAOLOU",
			"weiduGrade" : 2,
			"weiduID" : 72,
			"weiduName" : "瑞景河畔20号楼",
			"weiduOrder" : 4,
			"weiduType" : "FANGYUANGUANLI"
		},
		{
			"checked" : false,
			"crospID" : 0,
			"delFlag" : 1,
			"parentID" : 6,
			"weiduCode" : "RUIJINGHEPAN22HAOLOU",
			"weiduGrade" : 2,
			"weiduID" : 73,
			"weiduName" : "瑞景河畔22号楼",
			"weiduOrder" : 5,
			"weiduType" : "FANGYUANGUANLI"
		},
		{
			"checked" : false,
			"crospID" : 0,
			"delFlag" : 1,
			"parentID" : 6,
			"weiduCode" : "RUIJINGHEPAN23HAOLOU",
			"weiduGrade" : 2,
			"weiduID" : 74,
			"weiduName" : "瑞景河畔23号楼",
			"weiduOrder" : 6,
			"weiduType" : "FANGYUANGUANLI"
		},
		{
			"checked" : false,
			"crospID" : 0,
			"delFlag" : 1,
			"parentID" : 6,
			"weiduCode" : "RUIJINGHEPAN24HAOLOU",
			"weiduGrade" : 2,
			"weiduID" : 75,
			"weiduName" : "瑞景河畔24号楼",
			"weiduOrder" : 7,
			"weiduType" : "FANGYUANGUANLI"
		} ];
	$(document).ready(function() {
		$.fn.zTree.init($("#tree"), setting, zNodes);
		zTree = $.fn.zTree.getZTreeObj("tree");
		// 默认展开所有节点
		zTree.expandAll(true);
	});

	function beforeClick(treeId, treeNode) {
		var check = (treeNode && treeNode.isParent && treeNode.weiduGrade != 2);
		if (check) {
			art.dialog({
				icon : 'error',
				title : '友情提示',
				drag : false,
				resize : false,
				content : '只能选择小区栋号',
				ok : true,
			});
			return false;
		}
		return true;
	}

	/** 左键单击 **/
	function onClick(e, treeId, treeNode) {
		var fyXqCode = treeNode.getParentNode().weiduID;
		var fyDhCode = treeNode.weiduID;
		/* $("#submitForm").attr("action", "/xngzf/archives/showLoupanChart.action?fyXqCode=" + fyXqCode + "&fyDhCode=" + fyDhCode).submit(); */
		$("#submitForm").attr("action", "hotel_loupanchart.jsp").submit();
	}
	/** ----------------leftMenu  zTree部分开始----------------  **/
</script>


<script type="text/javascript">
	$(document).ready(function() {
		$(".fy_table_td").fancybox({
			'width' : 900,
			'height' : 650,
			'type' : 'iframe',
			'hideOnOverlayClick' : false,
		});

		var lists = $('.unit-the-table tr').eq(0);
		$.each(lists, function() {
			var tds = $(this).find('td[unitname]');
			var names = {};
			$.each(tds, function() {
				var unitname = $(this).attr('unitname');
				names[unitname] = names[unitname] ? names[unitname] + 1 : 1;
			});
			var html = '<tr><th width="40" class="fang_th">单元</th>';
			$.each(names, function(i, n) {
				html += '<th width="40" colspan="' + n + '" class="fang_th">' + i + '单元</th>';
			});
			$('#unit-thead').html(html);
		});
	});
</script>
<style type="text/css">
#sider {
	position: absolute;
	top: 0;
	left: 25px;
	bottom: 0px;
	width: 260px;
	border: 1px solid #DEDFDF;
}

#main {
	position: absolute;
	top: 0;
	left: 285px;
	right: 0px;
	bottom: 0px;
	border: 1px solid #DEDFDF;
	overflow: auto;
}

#box_border {
	border: 1px solid #EDEDED;
	height: 50px;
	line-height: 50px;
	text-align: center;
}

#fang_type {
	list-style-type: none;
}

#fang_type li {
	width: 80px;
	height: 22px;
	line-height: 22px;
	color: #FFF;
	display: inline-block;
}

.fy_table_td {
	color: #fff;
}

.fang_th {
	background: #044599 no-repeat;
	text-align: center;
	border-left: 1px solid #02397F;
	border-right: 1px solid #02397F;
	border-bottom: 1px solid #02397F;
	border-top: 1px solid #02397F;
	letter-spacing: 2px;
	text-transform: uppercase;
	font-size: 14px;
	color: #fff;
	height: 37px;
}
</style>
</head>
<body>
	<%
		RoomServiceH rs = new RoomServiceHImpl();
		List<Room> tier1 = rs.splitQuery(10, 1); //一楼
		List<Room> tier2 = rs.splitQuery(10, 2); //二楼
		List<Room> tier3 = rs.splitQuery(10, 3); //三楼
		List<Room> tier4 = rs.splitQuery(10, 4); //四楼
		List<Room> tier5 = rs.splitQuery(10, 5); //五楼
		List<Room> tier6 = rs.splitQuery(10, 6); //六楼
		Object[] tiers = { tier1, tier2, tier3, tier4, tier5, tier6 };
		pageContext.setAttribute("tiers", tiers);
	%>
	<form id="submitForm" name="submitForm"
		action="/xngzf/archives/showLoupanChart.action" method="post"
		enctype="multipart/form-data">
		<div id="container">
			<div id="sider">
				<ul id="tree" class="ztree"></ul>
			</div>
			<div id="main">
				<div id="box_border">
					<ul id="fang_type">
						<li style="width: 160px;"><span class="ui_txt_bold05">瑞景河畔16号楼</span></li>
						<li style="background-color: blue;">可入住</li>
						<li style="background-color: red;">已入住</li>
						<li style="background-color: green;">钟点房</li>
					</ul>
				</div>
				<table class="unit-the-table table" cellspacing="0" cellpadding="0"
					width="100%" align="center" border="0">
					<thead id="unit-thead"></thead>
					<tbody>

						<c:forEach var="i" begin="1" end="6">
							<tr>
								<td style="color:#1853A1;">${i}层</td>
								<c:forEach items="${tiers[i-1]}" var="room" varStatus="n">
									<c:if test="${ room.state eq '可入住'}">
										<!-- 根据房间状态来显示不同的背景色 -->
										<c:if test="${n.count le 3}">
											<!-- 根据房间号显示不同的单元(一单元...) -->
											<td width="40" style="background-color: blue" unitname='1'>
												<a
												href="showroom.jsp?roomid=${room.roomid}"
												class="fy_table_td" style="color:#fff;">${room.roomid }</a>
											</td>
										</c:if>
										<c:if test="${n.count gt 3 and n.count le 6}">
											<td width="40" style="background-color: blue" unitname='2'>
												<a
												href="showroom.jsp?roomid=${room.roomid}"
												class="fy_table_td" style="color:#fff;">${room.roomid }</a>
											</td>
										</c:if>
										<c:if test="${n.count gt 6}">
											<td width="40" style="background-color: blue" unitname='3'>
												<a
												href="showroom.jsp?roomid=${room.roomid}"
												class="fy_table_td" style="color:#fff;">${room.roomid }</a>
											</td>
										</c:if>
									</c:if>

									<c:if test="${ room.state eq '已入住'}">
										<!-- 根据房间状态来显示不同的背景色 -->
										<c:if test="${n.count le 3}">
											<td width="40" style="background-color: red" unitname='1'>
												<a
												href="showroom.jsp?roomid=${room.roomid}"
												class="fy_table_td" style="color:#fff;">${room.roomid }</a>
											</td>
										</c:if>
										<c:if test="${n.count gt 3 and n.count le 6}">
											<td width="40" style="background-color: red" unitname='2'>
												<a
												href="showroom.jsp?roomid=${room.roomid }"
												class="fy_table_td" style="color:#fff;">${room.roomid }</a>
											</td>
										</c:if>
										<c:if test="${n.count gt 6}">
											<td width="40" style="background-color: red" unitname='3'>
												<a
												href="showroom.jsp?roomid=${room.roomid }"
												class="fy_table_td" style="color:#fff;">${room.roomid }</a>
											</td>
										</c:if>
									</c:if>

									<c:if test="${ room.state eq '钟点房'}">
										<!-- 根据房间状态来显示不同的背景色 -->
										<c:if test="${n.count le 3}">
											<td width="40" style="background-color: green" unitname='1'>
												<a
												href="showroom.jsp?roomid=${room.roomid }"
												class="fy_table_td" style="color:#fff;">${room.roomid }</a>
											</td>
										</c:if>
										<c:if test="${n.count gt 3 and n.count le 6}">
											<td width="40" style="background-color: green" unitname='2'>
												<a
												href="showroom.jsp?roomid=${room.roomid }"
												class="fy_table_td" style="color:#fff;">${room.roomid }</a>
											</td>
										</c:if>
										<c:if test="${n.count gt 6}">
											<td width="40" style="background-color: green" unitname='3'>
												<a
												href="showroom.jsp?roomid=${room.roomid }"
												class="fy_table_td" style="color:#fff;">${room.roomid }</a>
											</td>
										</c:if>
									</c:if>
								</c:forEach>
							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>
		</div>
	</form>

</body>
</html>