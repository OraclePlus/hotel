<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

    <title>Title
    </title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>SCT-后台系统</title>
<link href="style/authority/login_css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/jquery/jquery-1.7.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#login_sub").click(function(){
			$("#submitForm").attr("action", "hotel_index.jsp").submit();
		});
	});
	
	/*回车事件*/
	function EnterPress(e){ //传入 event 
		var e = e || window.event; 
		if(e.keyCode == 13){ 
			$("#submitForm").attr("action", "hotel_index.jsp").submit();
		} 
	} 
</script>

</head>
<body>
	<div id="login_center">
		<div id="login_area">
			<div id="login_box">
				<div id="login_form">
					<form id="submitForm" action="" method="post">
						<div id="login_tip">
							<span id="login_err" class="sty_txt2"></span>
						</div>
						<div>
							 账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：<input type="text" name="adid" class="username" id="id">
						</div>
						<div>
							密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" class="pwd" id="pwd" onkeypress="EnterPress(event)" onkeydown="EnterPress()">
						</div>
						<div>
							确认密码：<input type="password" name="psw" class="pwd" id="psw" onkeypress="EnterPress(event)" onkeydown="EnterPress()">
						</div>
						<div>
							权&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;限：<input type="text" name="power"  id="power" onkeypress="EnterPress(event)" onkeydown="EnterPress()">
						</div>
						<div id="btn_area">
							<input type="button" class="login_btn" id="login_sub"  value="登  录">
							<input type="reset" class="login_btn" id="login_ret" value="重 置">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>