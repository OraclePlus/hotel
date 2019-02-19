<%--
  Created by IntelliJ IDEA.
  User: oracle
  Date: 2019/1/22
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<!-- Head -->
<head>
		<style type="text/css">
	/* 	.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
		 */
		 img {
		 	width: 100px;
		 
		 }
		</style>
    <title>Booking</title>

    <!-- Meta-Tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    
    <link rel="shortcut icon"  href="images/hotelicon.png" type="image/x-icon" />
    
    <!-- //Meta-Tags -->

    <!-- Custom-Stylesheet-Links -->
    <!-- Bootstrap-CSS --> 	<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" media="all">
    <!-- Index-Page-CSS --> <link rel="stylesheet" href="css/style_2.css" 		type="text/css" media="all">
    <!-- Index-Page-CSS --> <link rel="stylesheet" href="css/jquery-ui.css" 	type="text/css" media="all">
    <!-- Animate.CSS --> 	<link rel="stylesheet" href="css/animate.css" 		type="text/css" media="all">
    <!-- //Custom-Stylesheet-Links -->
	<script type="text/javascript">
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
		function judge(){
			createXmlHttp();
			var e_mail = document.getElementById("e_mail").value;
			e_mail = encodeURI(encodeURI(e_mail));
			xmlHttp.open("GET","emailjudge.jsp?e_mail="+e_mail,true);
			xmlHttp.onreadystatechange=callback2;
			xmlHttp.send();
			
		}
		function callback2(){
			if(xmlHttp.readyState==4){
				if(xmlHttp.status==200){
					//一切正常并能开始获得返回的结果
					var result= xmlHttp.responseText;
					if(result.trim()!="true"){
						document.getElementById("msgdiv").innerHTML="邮箱输入错误";
						document.getElementById("msgdiv").style.color="red";
						document.getElementById("msgdiv").style.display="inline";
					}else{
						document.getElementById("msgdiv").innerHTML="";
						document.getElementById("msgdiv").style.display="none";
					}
					
				}
			}
		}
		
		function idjudge(){
			createXmlHttp();
			var idcard = document.getElementById("idcard").value;
			idcard = encodeURI(encodeURI(idcard));
			xmlHttp.open("GET","idcardjudge.jsp?idcard="+idcard,true);
			xmlHttp.onreadystatechange=callback1;
			xmlHttp.send();
		}
		function callback1(){
			if(xmlHttp.readyState==4){
				if(xmlHttp.status==200){
					//一切正常并能开始获得返回的结果
					var result= xmlHttp.responseText;
					if(result.trim()!="true"){
						document.getElementById("iddiv").innerHTML="身份证输入错误";
						document.getElementById("iddiv").style.color="red";
						document.getElementById("iddiv").style.display="inline";
					}else{
						document.getElementById("iddiv").innerHTML="";
						document.getElementById("iddiv").style.display="none";
					}
					
				}
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
	</script>
    
</head>
<!-- //Head -->



<!-- Body -->
<body>

<!-- Header -->
<div class="header agileits w3layouts" id="home">

    <!-- Navbar -->
    <nav class="navbar navbar-default inner-pages-navbar agileits w3layouts wow bounceInUp">
        <div class="container">

            <div class="navbar-header agileits w3layouts">
                <button type="button" class="navbar-toggle agileits w3layouts collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false">
                    <span class="sr-only agileits w3layouts">Toggle navigation</span>
                    <span class="icon-bar agileits w3layouts"></span>
                    <span class="icon-bar agileits w3layouts"></span>
                    <span class="icon-bar agileits w3layouts"></span>
                </button>
                <a class="navbar-brand agileits w3layouts" href="index.jsp">Tropical Resorts</a>
            </div>

            <div id="navbar" class="navbar-collapse agileits w3layouts navbar-right collapse">
                <ul class="nav navbar-nav agileits w3layouts">
                    <li ><a href="hotels-list.jsp">酒店</a></li>
                    <li><a href="about.jsp">关于我们</a></li>
                    <li><a href="#">美食</a></li>
                    <li><a href="#">酒店照片</a></li>
                    <li><a href="register.jsp">登录</a></li>
                    <li class="active"><a href="booking.jsp">预定</a></li>

                </ul>
            </div>

        </div>
    </nav>
    <!-- //Navbar -->


    <!-- Banner -->
    <div class="banner agileits w3layouts">
        <img src="images/banner.jpg" alt="Agileits W3layouts">
        <h1 class="wow agileits w3layouts fadeInDown">BOOKING & CONTACT</h1>
    </div>
    <!-- //Banner -->

</div>
<!-- //Header -->



<!-- Location -->
<div class="location agileits w3layouts">
    <div class="container">

        <div class="col-md-6 col-sm-6 agileits w3layouts location-grids location-grids-1 wow slideInLeft">
            <h3>Where We Are</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod	tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        </div>

        <div class="col-md-6 col-sm-6 agileits w3layouts location-grids location-grids-2 wow slideInRight">
            <img src="images/location.jpg" alt="Agileits W3layouts">
        </div>
        <div class="clearfix"></div>

    </div>
</div>
<!-- //Location -->


  <input type="hidden" value="<%=request.getParameter("roomtype")%>" id="roomt"> 
<!-- Booking -->
<form  method="post" name="ok" id="formpay" >
<div class="reg agileits w3layouts">
    <div class="container">

        <div class="register agileits w3layouts">

            <h2>Book Your Resort!</h2>

            <!-- <div class="place wow  agileits w3layoutsslideInLeft">
                <div class="dropdown-button agileits w3layouts">
                    <h4>地点</h4>
                    <select class="dropdown agileits w3layouts" tabindex="10" data-settings='{"wrapperClass":"flat"}'>
                        <option value="1"></option>
                        <option value="1">Atlantis</option>
                        <option value="2">Bahamas</option>
                        <option value="2">Cannes</option>
                        <option value="3">Goa</option>
                        <option value="2">Hawaii</option>
                        <option value="3">Ibiza</option>
                        <option value="4">Jamaica</option>
                        <option value="4">Miami</option>
                        <option value="4">Pataya</option>
                    </select>
                </div>
            </div>
 --> 		
	
		
            <div class="members wow agileits w3layouts slideInLeft">
                <div class="adult agileits w3layouts">
              
                    <h4>成年人数量</h4>
                    <div class="dropdown-button agileits w3layouts">
                        <select class="dropdown agileits w3layouts" tabindex="10" data-settings='{"wrapperClass":"flat"}' name="adult">
                            <option value=""></option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </div>
                </div>

                <div class="child wow slideInLeft agileits w3layouts">
                    <h4>儿童数量</h4>
                    <div class="dropdown-button agileits w3layouts">
                        <select class="dropdown agileits w3layouts" tabindex="10" data-settings='{"wrapperClass":"flat"}' name="child">
                            <option value=""></option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                        </select>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>

          <div class="suite wow slideInLeft agileits w3layouts">
                <div class="dropdown-button agileits w3layouts">
                    <h4>房型</h4>
                    <select class="dropdown agileits w3layouts" id="roomtype" name="roomtype" tabindex="10" onchange="roomnum()" data-settings='{"wrapperClass":"flat"}'>
                        <option id="rooms" value="亲子主题房">亲子主题房</option>
                        <option id="rooms" value="全海景套房">全海景套房</option>
                        <option id="rooms" value="家庭影院套房">家庭影院套房</option>
                        <option id="rooms" value="总统套房">总统套房</option>
                        <option id="rooms" value="情侣主题房">情侣主题房</option>
                        <option id="rooms" value="普通大床">普通大床</option>
                        <option id="rooms" value="景观房">景观房</option>
                        <option id="rooms" value="池畔房">池畔房</option>
                        <option id="rooms" value="河景大床">河景大床</option>
                        <option id="rooms" value="花园大床房">花园大床房</option>
                        <option id="rooms" value="高档标间">高档标间</option>
                        <option id="rooms" value="豪华海景房">豪华海景房</option>
                        <option id="rooms" value="豪华家庭海景套房">豪华家庭海景套房</option>
                    </select>   
                    <div style="display:none" id="roommsg"></div>      
                  
                </div>                    
            </div>                        
            <div class="book-pag wow agileits w3layouts slideInLeft">
                <h4>Select Date</h4>
                <div class="book-pag-frm1 agileits w3layouts wow slideInLeft">
                    <label>入住日期</label>
                    <input class="date agileits w3layouts" name = "inhotel" id="datepicker1" type="text" placeholder="选择入住日期">
                </div>
                
                <div class="book-pag-frm2 wow agileits w3layouts slideInLeft">
                    <label>离开日期</label>
                    <input class="date agileits w3layouts" name ="outhotel" id="datepicker2" type="text"  placeholder="选择离开日期">
                </div>
                <div class="clearfix"></div>
            </div>
				
           <div class="food wow agileits w3layouts slideInLeft">
                <h4>选择支付方式</h4>
                <div class="radio-btns agileits w3layouts">
                    <ul>
                        <li>
                            <input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked" />
                            <label class="w3-validate">工商银行</label>
                        </li>
                        <li class="li2">
                           	<input type="radio" name="pd_FrpId" value="BOC-NET-B2C" />
                            <label class="w3-validate">中国银行</label>
                        </li>
                        <li>
                            <input type="radio" name="pd_FrpId" value="ABC-NET-B2C" />
                            <label class="w3-validate">农业银行</label>
                        </li>
                   </ul>
                </div>
            </div> 
            
            
         <%--    <div style="margin-top:5px;margin-left:5px;">
						<strong>选择银行：</strong>
						<p>
							<br/>
							<input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked" />工商银行
							<img src="${pageContext.request.contextPath}/bank_img/icbc.bmp" align="middle" width="30" height="30" />&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="BOC-NET-B2C" />中国银行
							<img src="${pageContext.request.contextPath}/bank_img/bc.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="ABC-NET-B2C" />农业银行
							<img src="${pageContext.request.contextPath}/bank_img/abc.bmp" align="middle" />
							<br/>
							<br/>
							<input type="radio" name="pd_FrpId" value="BOCO-NET-B2C" />交通银行
							<img src="${pageContext.request.contextPath}/bank_img/bcc.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="PINGANBANK-NET" />平安银行
							<img src="${pageContext.request.contextPath}/bank_img/pingan.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="CCB-NET-B2C" />建设银行
							<img src="${pageContext.request.contextPath}/bank_img/ccb.bmp" align="middle" />
							<br/>
							<br/>
							<input type="radio" name="pd_FrpId" value="CEB-NET-B2C" />光大银行
							<img src="${pageContext.request.contextPath}/bank_img/guangda.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C" />招商银行
							<img src="${pageContext.request.contextPath}/bank_img/cmb.bmp" align="middle" />

						</p>
						<hr/>
						<p style="text-align:right;margin-right:100px;">
							<a href="javascript:document.getElementById('orderForm').submit();">
								<img src="${pageContext.request.contextPath}/images/finalbutton.gif" width="204" height="51" border="0" />
							</a>
						</p>
					</div>
             --%>
            
            
            
            <div class="submit wow agileits w3layouts slideInLeft">
                <a class="popup-with-zoom-anim agileits w3layouts" id="pay" href="#small-dialog">BOOK NOW</a>
            </div>

<!-- 支付页面 -->
            <!-- Popup-Box -->
            <div id="popup">
                <div id="small-dialog" class="mfp-hide agileits w3layouts">
                    <div class="pop_up agileits w3layouts">
                        <div class="payment-online-form-left agileits w3layouts">
                            
                                <h4><span class="shipping agileits w3layouts"> </span>Customer Details</h4>
                                <ul class="agileits w3layouts">
                                    <li class="agileits w3layouts">
                                    <input  id="uname" class="text-box-dark agileits w3layouts" type="text" placeholder="入住人姓名"  name = "uname"></li>
                                    <li class="agileits w3layouts">
                                    <input  id="idcard" class="text-box-dark agileits w3layouts" type="text"  onblur="idjudge()" placeholder="身份证号码"  name ="idcard"></li>
                                    <div style="display:none" id="iddiv"></div><br/>
                                </ul>
                                <ul class="agileits w3layouts">
                                    <li class="agileits w3layouts">
                                    <input class="text-box-dark agileits w3layouts" id="e_mail" type="text" onblur="judge()" placeholder="email"  name ="e_mail"></li>
                                    <div style="display:none" id="msgdiv"></div><br/>
                                    <li class="agileits w3layouts">
                                    <input class="text-box-dark agileits w3layouts" id="tel" type="text" placeholder="联系电话" oninput="value=value.replace(/[^\d]/g,'')" onblur="teljudge()" name= "tel">></li>
                                    <div style="display:none" id="teldiv"></div><br/>
                                   	<%-- <%session.setAttribute("tel") %> --%>
                                </ul>
                                <div class="clearfix"></div>
                                <!-- <h4 class="paymenthead agileits w3layouts"><span class="payment agileits w3layouts"></span>Payment Details</h4>
                                <div class="clearfix"></div>
                                <ul class="payment-type agileits w3layouts">
                                    <li class="agileits w3layouts"><span class="col_checkbox agileits w3layouts">
												<input id="3" class="css-checkbox1 agileits w3layouts" type="checkbox">
												<label for="3" class="css-label1 agileits w3layouts"></label>
												<a class="visa agileits w3layouts" href="#"></a>
											</span>
                                    </li>
                                    <li class="agileits w3layouts">
											<span class="col_checkbox agileits w3layouts">
												<input id="4" class="css-checkbox2 agileits w3layouts" type="checkbox">
												<label for="4" class="css-label2 agileits w3layouts"></label>
												<a class="paypal agileits w3layouts" href="#"></a>
											</span>
                                    </li>
                                </ul> -->
                                <!-- <ul class="agileits w3layouts">
                                    <li class="agileits w3layouts"><input required="" class="text-box-dark agileits w3layouts" type="text" value="Card Number" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Card Number';}"></li>
                                    <li class="agileits w3layouts"><input required="" class="text-box-dark agileits w3layouts" type="text" value="Name on card" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name on card';}"></li>
                                </ul>
                                <ul class="agileits w3layouts">
                                    <li class="agileits w3layouts"><input required="" class="text-box-light hasDatepicker agileits w3layouts" type="text" id="datepicker" value="Expiration Date" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Expiration Date';}"><em class="pay-date"> </em></li>
                                    <li class="agileits w3layouts"><input required="" class="text-box-dark agileits w3layouts" type="text" value="Security Code" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Security Code';}"></li>
                                </ul> -->
                                <ul class="payment-sendbtns agileits w3layouts">
                                    <li class="agileits w3layouts"><input type="reset" value="Reset"></li>
                                    <li class="agileits w3layouts"><input type="button" value="Process Payment" class="order" onclick="pay()"></li>
                                </ul>
                                <div class="clearfix"></div>
                            
                        </div>
                    </div>
                </div>
            </div>   
            <button title="Close (Esc)" type="button" class="mfp-close agileits w3layouts">×</button>
            <!-- //Popup-Box -->
        		</div>
    		</div>
		</div>
	</form>
<!-- //Booking -->


<!-- Contact -->
<div class="contact agileits w3layouts">
    <div class="container">

        <h2 class="wow agileits w3layouts slideInLeft">KEEP IN TOUCH WITH US</h2>
        <p class="contact-p wow agileits w3layouts slideInLeft">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequateu fugiat nulla pariatur.</p>

        <div class="contact-grids agileits w3layouts">

            <div class="col-md-6 col-sm-6 agileits w3layouts contact-grid contact-grid-1">
                <div class="address wow agileits w3layouts slideInLeft">
                    <h4>Address</h4>
                    <address>
                        <ul>
                            <li><span class="glyphicon agileits w3layouts glyphicon-map-marker" aria-hidden="true"></span> Parma Via Modena</li>
                            <li><span class="glyphicon agileits w3layouts glyphicon-map-marker" aria-hidden="true"></span> 40019</li>
                            <li><span class="glyphicon agileits w3layouts glyphicon-map-marker" aria-hidden="true"></span> Sant'Agata Bolognese</li>
                            <li><span class="glyphicon agileits w3layouts glyphicon-map-marker" aria-hidden="true"></span> BO, Italy</li>
                        </ul>
                    </address>
                </div>
                <div class="phone wow agileits w3layouts slideInLeft">
                    <h4>Phone</h4>
                    <p><span class="glyphicon agileits w3layouts glyphicon-earphone" aria-hidden="true"></span> +1 (734) 123-4567</p>
                    <p><span class="glyphicon agileits w3layouts glyphicon-earphone" aria-hidden="true"></span> +1 (739) 648-7114</p>
                </div>
                <div class="email wow agileits w3layouts slideInLeft">
                    <h4>Email</h4>
                    <p><span class="glyphicon agileits w3layouts glyphicon-envelope" aria-hidden="true"></span> <a href="mailto:mail@example.com"> info@example.com</a></p>
                </div>
                <div class="clearfix"></div>
            </div>

            <div class="col-md-6 col-sm-6 agileits w3layouts contact-grid contact-grid-2 wow slideInLeft">
                <form action="#" method="post">
                    <input type="text" class="text wow agileits w3layouts slideInLeft" name="Name" placeholder="Name" required="">
                    <input type="text" class="text wow agileits w3layouts slideInLeft" name="E_mail" placeholder="E_mail" required="">
                    <textarea name="Message" class="wow agileits w3layouts slideInLeft" placeholder="Message" required=""></textarea>
                    <input type="submit" class="more_btn wow agileits w3layouts slideInLeft" value="Send Message">
                </form>
            </div>
            <div class="clearfix"></div>

        </div>

    </div>
</div>
<!-- //Contact -->



<!-- Map-iFrame -->
<!-- <div class="map wow agileits w3layouts slideInUp" id="map">
    <div class="map-hover agileits w3layouts">
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d22702.22744502486!2d11.113366067229226!3d44.662878362361056!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x477fc3eca9065c15%3A0x12ec8a03aadae866!2s40019+Sant&#39;Agata+Bolognese+BO%2C+Italy!5e0!3m2!1sen!2sin!4v1451281303075" allowfullscreen></iframe>
        <div class="map-hover-1 agileits w3layouts"></div>
    </div>
</div> -->
<!-- //Map-iFrame -->



<!-- Footer -->
<div class="footer agileits w3layouts">
    <div class="container">

        <div class="col-md-6 col-sm-6 agileits w3layouts footer-grids">
            <div class="col-md-4 col-sm-4 agileits w3layouts footer-grid footer-grid-1 wow fadeInUp">
                <ul class="agileits w3layouts">
                    <li class="agileits w3layouts">5 Star Hotels</li>
                    <li class="agileits w3layouts">Beach Resorts</li>
                    <li class="agileits w3layouts">Beach Houses</li>
                    <li class="agileits w3layouts">Water Houses</li>
                </ul>
            </div>
            <div class="col-md-4 col-sm-4 footer-grid agileits w3layouts footer-grid-2 wow fadeInUp">
                <ul class="agileits w3layouts">
                    <li class="agileits w3layouts"><a href="gallery.jsp">Bahamas</a></li>
                    <li class="agileits w3layouts"><a href="gallery.jsp">Hawaii</a></li>
                    <li class="agileits w3layouts"><a href="gallery.jsp">Miami</a></li>
                    <li class="agileits w3layouts"><a href="gallery.jsp">Ibiza</a></li>
                </ul>
            </div>
            <div class="col-md-4 col-sm-4 footer-grid agileits w3layouts footer-grid-2 wow fadeInUp">
                <ul class="agileits w3layouts">
                    <li class="agileits w3layouts"><a href="index.jsp">Home</a></li>
                    <li class="agileits w3layouts"><a href="about.jsp">About</a></li>
                    <li class="agileits w3layouts"><a href="cuisines.jsp">Cuisines</a></li>
                    <li class="agileits w3layouts"><a href="gallery.jsp">Gallery</a></li>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>

        <div class="col-md-6 col-sm-6 footer-grids agileits w3layouts newsletter wow fadeInUp">
            <h4>Stay Connected</h4>
            <p>Subscribe to our newsletter and get informed of our newest projects.</p>
            <form action="#" method="post">
                <input type="text" placeholder="E_mail" name="E_mail" required="">
                <input type="submit" value="SUBSCRIBE">
            </form>
        </div>

        <div class="col-md-6 col-sm-6 footer-grids agileits w3layouts social wow fadeInUp">
            <ul class="social-icons agileits w3layouts">
                <li class="agileits w3layouts"><a href="#" class="facebook agileits w3layouts" title="Go to Our Facebook Page"></a></li>
                <li class="agileits w3layouts"><a href="#" class="twitter agileits w3layouts" title="Go to Our Twitter Account"></a></li>
                <li class="agileits w3layouts"><a href="#" class="googleplus agileits w3layouts" title="Go to Our Google Plus Account"></a></li>
                <li class="agileits w3layouts"><a href="#" class="instagram agileits w3layouts" title="Go to Our Instagram Account"></a></li>
                <li class="agileits w3layouts"><a href="#" class="youtube agileits w3layouts" title="Go to Our Youtube Channel"></a></li>
            </ul>
        </div>

        <div class="col-md-6 col-sm-6 footer-grids agileits w3layouts copyright wow fadeInUp">
            <p>Copyright &copy; 2017.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">香格里拉酒店</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
        </div>
        <div class="clearfix"></div>

    </div>
</div>
<!-- //Footer -->



<!-- Necessary-JavaScript-Files-&-Links -->

<!-- Default-JavaScript -->	  <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<!-- Bootstrap-JavaScript --> <script type="text/javascript" src="js/bootstrap.min.js"></script>

<!-- Animate.CSS-JavaScript -->
<script src="js/wow.min.js"></script>
<script>
    new WOW().init();
</script>
<!-- //Animate.CSS-JavaScript -->

<!-- Booking-Popup-Box-JavaScript -->
<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
<script>
    $(document).ready(function() {
        $('.popup-with-zoom-anim').magnificPopup({
            type: 'inline',
            fixedContentPos: false,
            fixedBgPos: true,
            overflowY: 'auto',
            closeBtnInside: true,
            preloader: false,
            midClick: true,
            removalDelay: 300,
            mainClass: 'my-mfp-zoom-in'
        });
    });
</script>
<!-- //Booking-Popup-Box-JavaScript -->


<!-- Slide-To-Top JavaScript (No-Need-To-Change) -->
<script type="text/javascript">
    $(document).ready(function() {
        var defaults = {
            containerID: 'toTop', // fading element id
            containerHoverID: 'toTopHover', // fading element hover id
            scrollSpeed: 100,
            easingType: 'linear'
        };
        $().UItoTop({ easingType: 'easeOutQuart' });
    });
</script>
<a href="#" id="toTop" class="agileits w3layouts" style="display: block;"> <span id="toTopHover" style="opacity: 0;"> </span></a>
<!-- //Slide-To-Top JavaScript -->

<!-- Smooth-Scrolling-JavaScript -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
    jQuery(document).ready(function($) {
        $(".scroll, .navbar li a, .footer li a").click(function(event){
            $('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
        });
    });
</script>
<!-- //Smooth-Scrolling-JavaScript -->

<!-- Date-Picker-JavaScript -->
<script src="js/jquery-ui.js"></script>
<script>
    $(function() {
        $( "#datepicker,#datepicker1,#datepicker2" ).datepicker();
    });
</script>
<script type="text/javascript">
/* $(function(){
	$(".popup-with-zoom-anim agileits w3layouts").click(function (){
			$("#pay").sub();
	})
}) */
	function pay(){
	var form=document.getElementById("formpay");
	
	form.action="ok.do?uname="+document.getElementById("uname").value+"&idcard="+
	document.getElementById("idcard").value+"&email="+document.getElementById("e_mail").value+
	"&tel="+document.getElementById("tel").value;
	
	form.submit();
	}
	
	
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
		function callback(){
			if(xmlHttp.readyState==4){
				if(xmlHttp.status==200){
					//一切正常并能开始获得返回的结果
					var result= xmlHttp.responseText;
					var num=result.trim();
					if(num==0){
						/* $("#pay").attr("disabled",true).css("pointer-events","none");  */
						document.getElementById("pay").href="javascript:volid(0);";
						document.getElementById("roommsg").innerHTML="该房间类型现在剩余"+num;
						document.getElementById("roommsg").style.color="red";
						document.getElementById("roommsg").style.display="inline";
					}else{
						document.getElementById("pay").href="#small-dialog";
						document.getElementById("roommsg").innerHTML="该房间类型现在剩余"+num;
						document.getElementById("roommsg").style.color="red";
						document.getElementById("roommsg").style.display="inline";
					}
					
				}
			}
		}
	function roomnum(){
		var roomtype =document.getElementById("roomtype").value;
					roomtype=encodeURI(encodeURI(roomtype));
				createXmlHttp();
				xmlHttp.open("GET", "roomnum.jsp?roomtype="+roomtype,true);
				xmlHttp.onreadystatechange=callback;
				xmlHttp.send();
			}
	/* function defaults(){
		var rooms=document.getElementById("#rooms");
		alert(1111)
	} */
		window.onload=function(){
		
			var rooms=document.getElementById("rooms").value
			var rooms2=document.getElementById("roomt").value
			<%-- alert(<%=request.getParameter("roomtype")%>); --%>
			
		}
</script>
<!-- //Date-Picker-JavaScript -->

<!-- //Necessary-JavaScript-Files-&-Links -->



</body>
<!-- //Body -->

</html>
