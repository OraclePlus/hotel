<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="#" />
    <link type="text/css" rel="styleSheet"  href="css/main.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理员注册登录</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        
        html,
        body {
            height: 100%;
        }

        @font-face {
            font-family: 'neo';
            src: url("fonts/NEOTERICc.ttf");
        }
        input:focus{
			outline: none;
		}
		.form input{
			width: 300px;
			height: 30px;
			font-size: 18px;
            background: none;
            border: none;
            border-bottom: 1px solid #fff;
            color: #fff;
            margin-bottom: 20px;
		}
        .form input::placeholder{
            color: rgba(255,255,255,0.8);
            font-size: 18px;
            font-family: "neo";
        }
        .confirm{
            height: 0;
            overflow: hidden;
            transition: .25s;
        }
		.btn{
			width:140px;
			height: 40px;
			border: 1px solid #fff;
            background: none;
			font-size:20px;
			color: #fff;
            cursor: pointer;
            margin-top: 25px;
            font-family: "neo";
            transition: .25s;
		}
        .btn:hover{
            background: rgba(255,255,255,.25);
        }
        #login_wrap{
            width: 980px;
            min-height: 500px;
            border-radius: 10px;
            font-family: "neo";
            overflow: hidden;
            box-shadow: 0px 0px 120px rgba(0, 0, 0, 0.25);
            position: fixed;
            top: 50%;
            right: 50%;
            margin-top: -250px;
            margin-right: -490px;
        }
        #login{
            width: 50%;
            height: 100%;
            min-height: 500px;
            background: linear-gradient(45deg, #9a444e, #e06267);
            position: relative;
            float: right;
        }
        #login #status{
            width: 90px;
            height: 35px;
            margin: 40px auto;
            color: #fff;
            font-size: 30px;
            font-weight: 600;
            position: relative;
            overflow: hidden;
        }
        #login #status i{
            font-style: normal;
            position: absolute;
            transition: .5s
        }
        #login span{
            text-align: center;
            position: absolute;
            left: 50%;
            margin-left: -150px;
            top: 52%;
            margin-top: -140px;
        }
        #login span a{
            text-decoration: none;
            color: #fff;
            display: block;
            margin-top: 80px;
            font-size: 18px;
        }
        #bg{
            background: linear-gradient(45deg, #211136, #bf5853);
            height: 100%;
        }
        /*ç»å¾*/
        #login_img{
            width: 50%;
            min-height: 500px;
            background: linear-gradient(45deg, #221334, #6c3049);
            float: left;
            position: relative;
        }
        #login_img span{
            position: absolute;
            display: block;
        }
        #login_img .circle{
            width: 200px;
            height: 200px;
            border-radius: 50%;
            background: linear-gradient(45deg, #df5555, #ef907a);
            top: 70px;
            left: 50%;
            margin-left: -100px;
            overflow: hidden;
        }
        #login_img .circle span{
            width: 150px;
            height: 40px;
            border-radius: 50px;
            position: absolute;
        }
        #login_img .circle span:nth-child(1){
            top: 30px;
            left: -38px;
            background: #c55c59;
        }
        #login_img .circle span:nth-child(2){
            bottom: 20px;
            right: -35px;
            background: #934555;
        }
        #login_img .star span{
            background: radial-gradient(#fff 10%,#fff 20%,rgba(72, 34, 64, 0));
            border-radius: 50%;
            box-shadow: 0 0 7px #fff;
        }
        #login_img .star span:nth-child(1){
            width: 15px;
            height: 15px;
            top: 50px;
            left: 30px;
        }
        #login_img .star span:nth-child(2){
            width: 10px;
            height: 10px;
            left: 360px;
            top: 80px;
        }
        #login_img .star span:nth-child(3){
            width: 5px;
            height: 5px;
            top: 400px;
            left: 80px;
        }
        #login_img .star span:nth-child(4){
            width: 8px;
            height: 8px;
            top: 240px;
            left: 60px;
        }
        #login_img .star span:nth-child(5){
            width: 4px;
            height: 4px;
            top: 20px;
            left: 200px;
        }
        #login_img .star span:nth-child(6){
            width: 4px;
            height: 4px;
            top: 460px;
            left: 410px;
        }
        #login_img .star span:nth-child(7){
            width: 6px;
            height: 6px;
            top: 250px;
            left: 350px;
        }
        #login_img .fly_star span{
            width: 90px;
            height: 3px;
            background: -webkit-linear-gradient(left, rgba(255, 255, 255, 0.67), rgba(255,255,255,0));
            background: -o-linear-gradient(left, rgba(255, 255, 255, 0.67), rgba(255,255,255,0));
            background: linear-gradient(to right, rgba(255, 255, 255, 0.67), rgba(255,255,255,0));
            transform: rotate(-45deg);
        }
        #login_img .fly_star span:nth-child(1){
            top:60px;
            left: 80px;
        }
        #login_img .fly_star span:nth-child(2){
            top: 210px;
            left: 332px;
            opacity: 0.6;
        }
        #login_img p{
            text-align: center;
            color: #af4b55;
            font-weight: 600;
            margin-top: 365px;
            font-size: 25px;
        }
        #login_img p i{
            font-style: normal;
            margin-right: 45px;
        }
        #login_img p i:nth-last-child(1){
            margin-right: 0;
        }
        /*æç¤º*/
        #hint{
            width: 100%;
            line-height: 70px;
            background: linear-gradient(-90deg, #9b494d, #bf5853);
            text-align: center;
            font-size: 25px;
            color: #fff;
            box-shadow: 0 0 20px #733544;
            display: none;
            opacity: 0;
            transition: .5s;
            position: absolute;
            top: 0;
            z-index: 999;
        }
        /* ååºå¼ */
        @media screen and (max-width:1000px ) {
            #login_img{
                display: none;
            }
            #login_wrap{
                width: 490px;
                margin-right: -245px;
            }
            #login{
                width: 100%;
                
            }
        }
        @media screen and (max-width:560px ) {
            #login_wrap{
                width: 330px;
                margin-right: -165px;
            }
            #login span{
                margin-left: -125px;
            }
            .form input{
                width: 250px;
            }
            .btn{
                width: 113px;
            }
        }
        @media screen and (max-width:345px ) {
            #login_wrap {
                width: 290px;
                margin-right: -145px;
            }
        }
    </style>
</head>


<body>
    <div id="bg">
        <div id="hint"><!-- æç¤ºæ¡ -->
            <p>ç»å½å¤±è´¥</p>
        </div>
        <div id="login_wrap">
            <div id="login"><!-- ç»å½æ³¨ååæ¢å¨ç» -->
                <div id="status">
                    <i style="top: 0">Log</i>
                    <i style="top: 35px">Sign</i>
                    <i style="right: 5px">in</i>
                </div>
                <span>
                    <form action="post">
                        <p class="form"><input type="text" id="user" placeholder="username"></p>
                        <p class="form"><input type="password" id="passwd" placeholder="password"></p>
                        <p class="form confirm"><input type="password" id="confirm-passwd" placeholder="confirm password"></p>
                        <input type="button" value="Log in" class="btn" onclick="login()" style="margin-right: 20px;">
                        <input type="button" value="Sign in" class="btn" onclick='signin()' id="btn">
                    </form>
                    <a href="#">Forget your password?</a>
                </span>
            </div>

            <div id="login_img"><!-- å¾çç»å¶æ¡ -->
                <span class="circle">
                    <span></span>
                    <span></span>
                </span>
                <span class="star">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </span>
                <span class="fly_star">
                    <span></span>
                    <span></span>
                </span>
                <p id="title">CLOUD</p>
            </div>
        </div>
    </div>
</body>
<script>
    var onoff = true//æ ¹æ®æ­¤å¸å°å¼å¤æ­å½åä¸ºæ³¨åç¶æè¿æ¯ç»å½ç¶æ
    var confirm = document.getElementsByClassName("confirm")[0]
    //var user = document.getElementById("user")
    //var passwd = document.getElementById("passwd")
    //var con_pass = document.getElementById("confirm-passwd")
    
    //èªå¨å±ä¸­title
    var name_c = document.getElementById("title")
    name = name_c.innerHTML.split("")
    name_c.innerHTML = ""
    for (i = 0; i < name.length; i++)
        if (name[i] != ",")
            name_c.innerHTML += "<i>" + name[i] + "</i>"
    //å¼ç¨hint()å¨æä¸æ¹å¼¹åºæç¤º
    function hint() {
        let hit = document.getElementById("hint")
        hit.style.display = "block"
        setTimeout("hit.style.opacity = 1", 0)
        setTimeout("hit.style.opacity = 0", 2000)
        setTimeout('hit.style.display = "none"', 3000)
    }
    //åè°å½æ°
    /*function submit(callback) {
        //if (passwd.value == con_pass.value) {
        let request = new XMLHttpRequest()
        let url = ""
        request.open("post", url, true)
        let data = new FormData()
        data.append("user", user.value)
        data.append("passwd", passwd.value)
        request.onreadystatechange = function() {
            if (this.readyState == 4) {
                callback.call(this, this.response)
                //console.log(this.responseText)
            }
        }
        request.send(data)
    }*/
    /*else {
               hit.innerHTML = "ä¸¤æ¬¡å¯ç ä¸å"
               hitting()
           }
       }*/
    //æ³¨åæé®
    function signin() {
        let status = document.getElementById("status").getElementsByTagName("i")
        let hit = document.getElementById("hint").getElementsByTagName("p")[0]
        if (onoff) {
            confirm.style.height = 51 + "px"
            status[0].style.top = 35 + "px"
            status[1].style.top = 0
            onoff = !onoff
        } else {
            /*if (!/^[A-Za-z0-9]+$/.test(user.value))
                hit.innerHTML = "è´¦å·åªè½ä¸ºè±æåæ°å­"
            else if (user.value.length < 6)
                hit.innerHTML = "è´¦å·é¿åº¦å¿é¡»å¤§äº6ä½"
            else if (passwd.value.length < 6)
                hit.innerHTML = "å¯ç é¿åº¦å¿é¡»å¤§äº6ä½"
            else if (passwd.value != con_pass.value)
                hit.innerHTML = "ä¸¤æ¬¡å¯ç ä¸ç¸ç­"
            else if (passwd.value = con_pass.value) {
                submit(function(res) {
                    if (res == "exist")
                        hit.innerHTML = "è¯¥è´¦å·å·²å­å¨"
                    else if (res == true) {
                        hit.innerHTML = "è´¦å·æ³¨åæåï¼ä¸¤ç§åèªå¨å·æ°é¡µé¢"
                        setTimeout("window.location.reload()", 2000)
                    } else if (res == false)
                        hit.innerHTML = "è´¦å·æ³¨åå¤±è´¥"
                })
            }
            hint()*/
        }
    }

    //ç»å½æé®
    function login() {
        if (onoff) {
            /*let request = new XMLHttpRequest()
            let url = ""
            request.open("post", url, true)
            let data = new FormData()
            data.append("user", user.value)
            data.append("passwd", passwd.value)
            request.onreadystatechange = function() {
                if (this.readyState == 4) {
                    if (this.responseText == false)
                        hint()
                    else
                        window.location.href = this.responseText;
                }
            }
            request.send(data)*/
        } else {
            let status = document.getElementById("status").getElementsByTagName("i")
            confirm.style.height = 0
            status[0].style.top = 0
            status[1].style.top = 35 + "px"
            onoff = !onoff
        }
    }

</script>
æ´å¤æ¨¡æ¿ï¼<a href="http://www.mycodes.net/" target="_blank">æºç ä¹å®¶</a>
</html>
