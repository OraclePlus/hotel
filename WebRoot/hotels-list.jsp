﻿<%@page import="cn.yisou.hotel.pojo.Room"%>
<%@page import="java.util.List"%>
<%@page import="cn.yisou.hotel.service.impl.RoomServiceHImpl"%>
<%@page import="cn.yisou.hotel.service.RoomServiceH"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>房间选择</title>

<!--== META TAGS ==-->
<meta charset="utf-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- GOOGLE FONTS -->

<!-- FONT-AWESOME ICON CSS -->
<link rel="stylesheet" href="css/font-awesome.min.css">

<!--== ALL CSS FILES ==-->
<link rel="stylesheet" href="css/style_1.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/mob.css">
<link rel="stylesheet" href="css/radio.css">
<link rel="shortcut icon"  href="images/hotelicon.png" type="image/x-icon" />


</head>

<body>

	<%
		RoomServiceH rs = new RoomServiceHImpl();
		List<Room> list = rs.findAllRoomType();
		pageContext.setAttribute("list", list);
	%>



	<!--====== TOP HEADER ==========-->
	<!-- ================================================================================================================ -->
	<!-- ================================================================================================================ -->


	<!--====== NAVIGATION MENU ==========-->
	<section>
		<div class="rows main_menu">
			<div class="container res-menu">
				<nav class="navbar navbar-inverse">
					<div>
						<!-- Brand and toggle get grouped for better mobile display(MOBILE MENU) -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse" data-target="#myNavbar">
								<span class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
							<img src="images/logo.png" alt="" class="mob_logo" />
						</div>
						<!-- NAVIGATION MENU -->
						<!--页眉  -->
						<div class="collapse navbar-collapse" id="myNavbar">
							<ul class="nav navbar-nav">
								<li><a href="index.jsp">Home</a></li>
								<li><a href="register.jsp">LOGIN</a>
								<li><a href="register.jsp">REGISTER</a></li>
								<li><a href="#">Blog</a></li>
								<li><a href="#">Places</a></li>
								<li><a href="#">Contact Us</a></li>
							</ul>
							<!-- <div class="menu_book">
								<a href="booking.html">Book Your Package</a>
							</div> -->
						</div>
					</div>
				</nav>
			</div>
		</div>
	</section>
	<!--====== HOTELS LIST ==========-->
	<section class="hot-page2-alp hot-page2-pa-sp-top">
		<div class="container">
			<div class="row inner_banner bg-none">
				<div class="hot-page2-alp-tit">
					<h1>Hotel & Restaurants in Vancouver</h1>
					<ul>
						<li><a href="index.jsp">Home</a></li>
						<li><i class="fa fa-angle-right" aria-hidden="true"></i></li>
						<li><a href="#inner-page-title" class="bread-acti">LOGIN
								& REGISTER</a></li>
					</ul>
					<p>World's leading Hotel Booking website,Over 30,000 Hotel
						rooms worldwide.</p>
				</div>
			</div>
			<div class="row">
				<div class="hot-page2-alp-con">
					<!--LEFT LISTINGS-->
					<div class="col-md-3 hot-page2-alp-con-left">
						<!--PART 1 : LEFT LISTINGS-->
						<div class="hot-page2-alp-con-left-1">
							<h3>Suggesting Hotels</h3>
						</div>
						<!--PART 2 : LEFT LISTINGS-->
						<div class="hot-page2-hom-pre hot-page2-alp-left-ner-notb">
							<ul>
								<!--LISTINGS-->
								<li><a href="#">
										<div class="hot-page2-hom-pre-1 hot-page2-alp-cl-1-1">
											<img src="images/hotels/1.jpg" alt="">
										</div>
										<div class="hot-page2-hom-pre-2 hot-page2-alp-cl-1-2">
											<h5>Taaj Club House</h5>
											<span>City: illunois, United States</span>
										</div>
										<div class="hot-page2-hom-pre-3 hot-page2-alp-cl-1-3">
											<span>4.2</span>
										</div>
								</a></li>
								<!--LISTINGS-->
								<li><a href="#">
										<div class="hot-page2-hom-pre-1 hot-page2-alp-cl-1-1">
											<img src="images/hotels/2.jpg" alt="">
										</div>
										<div class="hot-page2-hom-pre-2 hot-page2-alp-cl-1-2">
											<h5>Lake Palace view Hotel</h5>
											<span>City: Beijing,China</span>
										</div>
										<div class="hot-page2-hom-pre-3 hot-page2-alp-cl-1-3">
											<span>4.4</span>
										</div>
								</a></li>
								<!--LISTINGS-->
								<li><a href="#">
										<div class="hot-page2-hom-pre-1 hot-page2-alp-cl-1-1">
											<img src="images/hotels/3.jpg" alt="">
										</div>
										<div class="hot-page2-hom-pre-2 hot-page2-alp-cl-1-2">
											<h5>First Class Grandd Hotel</h5>
											<span>City: Berlin,Germany</span>
										</div>
										<div class="hot-page2-hom-pre-3 hot-page2-alp-cl-1-3">
											<span>5.0</span>
										</div>
								</a></li>
								<!--LISTINGS-->
								<li><a href="#">
										<div class="hot-page2-hom-pre-1 hot-page2-alp-cl-1-1">
											<img src="images/hotels/4.jpg" alt="">
										</div>
										<div class="hot-page2-hom-pre-2 hot-page2-alp-cl-1-2">
											<h5>Barcelona Grand Pales</h5>
											<span>City: Chennai,India</span>
										</div>
										<div class="hot-page2-hom-pre-3 hot-page2-alp-cl-1-3">
											<span>3.0</span>
										</div>
								</a></li>
								<!--LISTINGS-->
								<li><a href="#">
										<div class="hot-page2-hom-pre-1 hot-page2-alp-cl-1-1">
											<img src="images/hotels/8.jpg" alt="">
										</div>
										<div class="hot-page2-hom-pre-2 hot-page2-alp-cl-1-2">
											<h5>Universal luxury Grand Hotel</h5>
											<span>City: Rio,Brazil</span>
										</div>
										<div class="hot-page2-hom-pre-3 hot-page2-alp-cl-1-3">
											<span>3.4</span>
										</div>
								</a></li>
							</ul>
						</div>
						<!--PART 7 : LEFT LISTINGS-->
						<div class="hot-page2-alp-l3 hot-page2-alp-l-com">
							<h4>
								<i class="fa fa-calendar-check-o" aria-hidden="true"></i> Room
								Available Check
							</h4>
							<div class="hot-page2-alp-l-com1 hot-room-ava-check">
								<form>
									<ul>
										<li><label>Enter Your City</label> <input type="text"
											placeholder="Enter City"></li>
										<li><label>Depart Date</label> <input type="date">
										</li>
										<li><label>Return Date</label> <input type="date">
										</li>
										<li><input type="submit" value="SUBMIT"></li>
									</ul>
								</form>
							</div>
						</div>
						<!--PART 4 : LEFT LISTINGS-->
						<div class="hot-page2-alp-l3 hot-page2-alp-l-com">
							<h4>
								<i class="fa fa-map-marker" aria-hidden="true"></i> Select City
								& Country
							</h4>
							<div class="hot-page2-alp-l-com1 hot-page2-alp-p4">
								<form>
									<ul>
										<li>
											<div class="checkbox checkbox-info checkbox-circle">
												<input id="chp41" class="styled" type="checkbox" checked="">
												<label for="chp41"> Nashville, USA </label>
											</div>
										</li>
										<li>
											<div class="checkbox checkbox-info checkbox-circle">
												<input id="chp42" class="styled" type="checkbox"> <label
													for="chp42"> Hull, England </label>
											</div>
										</li>
										<li>
											<div class="checkbox checkbox-info checkbox-circle">
												<input id="chp43" class="styled" type="checkbox"> <label
													for="chp43"> Seoul, South Korea </label>
											</div>
										</li>
										<li>
											<div class="checkbox checkbox-info checkbox-circle">
												<input id="chp44" class="styled" type="checkbox"> <label
													for="chp44"> Ljubljana, Slovenia </label>
											</div>
										</li>
										<li>
											<div class="checkbox checkbox-info checkbox-circle">
												<input id="chp45" class="styled" type="checkbox"> <label
													for="chp45"> Wroclaw, Poland </label>
											</div>
										</li>
									</ul>
								</form>
								<a href="javascript:void(0);" class="hot-page2-alp-p4-btn-s">view
									more</a>
							</div>
						</div>
						<!--END PART 4 : LEFT LISTINGS-->
						<!--PART 5 : LEFT LISTINGS-->
						<div class="hot-page2-alp-l3 hot-page2-alp-l-com">
							<h4>
								<i class="fa fa-dollar" aria-hidden="true"></i> Select Price
								Range
							</h4>
							<div class="hot-page2-alp-l-com1 hot-page2-alp-p5">
								<form>
									<ul>
										<li>
											<div class="checkbox checkbox-info checkbox-circle">
												<input id="chp51" class="styled" type="checkbox" checked="">
												<label for="chp51"> $5000 - Above </label>
											</div>
										</li>
										<li>
											<div class="checkbox checkbox-info checkbox-circle">
												<input id="chp52" class="styled" type="checkbox"> <label
													for="chp52"> $4000 - $5000 </label>
											</div>
										</li>
										<li>
											<div class="checkbox checkbox-info checkbox-circle">
												<input id="chp53" class="styled" type="checkbox"> <label
													for="chp53"> $3000 - $4000 </label>
											</div>
										</li>
										<li>
											<div class="checkbox checkbox-info checkbox-circle">
												<input id="chp54" class="styled" type="checkbox"> <label
													for="chp54"> $2000 - $3000 </label>
											</div>
										</li>
										<li>
											<div class="checkbox checkbox-info checkbox-circle">
												<input id="chp55" class="styled" type="checkbox"> <label
													for="chp55"> $2000 - Below </label>
											</div>
										</li>
									</ul>
								</form>
								<a href="javascript:void(0);" class="hot-page2-alp-p5-btn-s">view
									more</a>
							</div>
						</div>
						<!--END PART 5 : LEFT LISTINGS-->
						<!--PART 6 : LEFT LISTINGS-->
						<!-- <div class="hot-page2-alp-l3 hot-page2-alp-l-com">
							<h4>
								<i class="fa fa-star-o" aria-hidden="true"></i> Select Ratings
							</h4>
							<div class="hot-page2-alp-l-com1 hot-page2-alp-p5">
								<form>
									<ul>
										<li>
											<div class="checkbox checkbox-info checkbox-circle">
												<input id="chp61" class="styled" type="checkbox" checked="">
												<label for="chp61"> <span
													class="ho-hot-rat-star-list"> <span
														class="hot-list-left-part-rat">5.0</span> <i
														class="fa fa-star" aria-hidden="true"></i><i
														class="fa fa-star" aria-hidden="true"></i><i
														class="fa fa-star" aria-hidden="true"></i><i
														class="fa fa-star" aria-hidden="true"></i><i
														class="fa fa-star" aria-hidden="true"></i>
												</span>
												</label>
											</div>
										</li>
										<li>
											<div class="checkbox checkbox-info checkbox-circle">
												<input id="chp62" class="styled" type="checkbox"> <label
													for="chp62"> <span class="ho-hot-rat-star-list">
														<span class="hot-list-left-part-rat">4.0</span> <i
														class="fa fa-star" aria-hidden="true"></i><i
														class="fa fa-star" aria-hidden="true"></i><i
														class="fa fa-star" aria-hidden="true"></i><i
														class="fa fa-star" aria-hidden="true"></i><i
														class="fa fa-star-o" aria-hidden="true"></i>
												</span>
												</label>
											</div>
										</li>
										<li>
											<div class="checkbox checkbox-info checkbox-circle">
												<input id="chp63" class="styled" type="checkbox"> <label
													for="chp63"> <span class="ho-hot-rat-star-list">
														<span class="hot-list-left-part-rat">3.0</span> <i
														class="fa fa-star" aria-hidden="true"></i><i
														class="fa fa-star" aria-hidden="true"></i><i
														class="fa fa-star" aria-hidden="true"></i><i
														class="fa fa-star-o" aria-hidden="true"></i><i
														class="fa fa-star-o" aria-hidden="true"></i>
												</span>
												</label>
											</div>
										</li>
										<li>
											<div class="checkbox checkbox-info checkbox-circle">
												<input id="chp64" class="styled" type="checkbox"> <label
													for="chp64"> <span class="ho-hot-rat-star-list">
														<span class="hot-list-left-part-rat">2.0</span> <i
														class="fa fa-star" aria-hidden="true"></i><i
														class="fa fa-star" aria-hidden="true"></i><i
														class="fa fa-star-o" aria-hidden="true"></i><i
														class="fa fa-star-o" aria-hidden="true"></i><i
														class="fa fa-star-o" aria-hidden="true"></i>
												</span>
												</label>
											</div>
										</li>
										<li>
											<div class="checkbox checkbox-info checkbox-circle">
												<input id="chp65" class="styled" type="checkbox"> <label
													for="chp65"> <span class="ho-hot-rat-star-list">
														<span class="hot-list-left-part-rat">1.0</span> <i
														class="fa fa-star" aria-hidden="true"></i><i
														class="fa fa-star-o" aria-hidden="true"></i><i
														class="fa fa-star-o" aria-hidden="true"></i><i
														class="fa fa-star-o" aria-hidden="true"></i><i
														class="fa fa-star-o" aria-hidden="true"></i>
												</span>
												</label>
											</div>
										</li>
									</ul>
								</form>
								<a href="javascript:void(0);" class="hot-page2-alp-p5-btn-s">view
									more</a>
							</div>
						</div> -->
						<!--END PART 5 : LEFT LISTINGS-->
						<!--PART 6 : LEFT LISTINGS-->
						<div class="hot-page2-alp-l3 hot-page2-alp-l-com">
							<h4>
								<i class="fa fa-heart-o" aria-hidden="true"></i> Hotel Amenities
							</h4>
							<div class="hot-page2-alp-l-com1 hot-page2-alp-p5">
								<form>
									<ul>
										<li>
											<div class="checkbox checkbox-info checkbox-circle">
												<input id="chp71" class="styled" type="checkbox" checked="">
												<label for="chp71"> Swimming pools </label>
											</div>
										</li>
										<li>
											<div class="checkbox checkbox-info checkbox-circle">
												<input id="chp72" class="styled" type="checkbox"> <label
													for="chp72"> Wi-Fi & Computer </label>
											</div>
										</li>
										<li>
											<div class="checkbox checkbox-info checkbox-circle">
												<input id="chp73" class="styled" type="checkbox"> <label
													for="chp73"> Kitchen facilities </label>
											</div>
										</li>
										<li>
											<div class="checkbox checkbox-info checkbox-circle">
												<input id="chp74" class="styled" type="checkbox"> <label
													for="chp74"> Music & GYM </label>
											</div>
										</li>
										<li>
											<div class="checkbox checkbox-info checkbox-circle">
												<input id="chp75" class="styled" type="checkbox"> <label
													for="chp75"> Dining </label>
											</div>
										</li>
									</ul>
								</form>
								<a href="javascript:void(0);" class="hot-page2-alp-p5-btn-s">view
									more</a>
							</div>
						</div>
						<!--END PART 7 : LEFT LISTINGS-->
					</div>
					<!--END LEFT LISTINGS-->

					<!--RIGHT LISTINGS-->
					<div class="col-md-9 hot-page2-alp-con-right">
						<div class="hot-page2-alp-con-right-1">
							<!--LISTINGS-->
							<div class="row">

								<c:forEach items="${list}" var="room">
									<c:if test="${room.count gt 0}">
										<!--LISTINGS START-->
										<div class="hot-page2-alp-r-list">
											<div class="col-md-4 hot-page2-alp-r-list-re-sp">
												<a href="javascript:void(0);"> <!-- <div class="hotel-list-score">4.5</div> -->
													<div class="hot-page2-hli-1">
														<img src="${room.photo}" alt="">
													</div>
													<div class="hom-hot-av-tic hom-hot-av-tic-list">剩余房间
														: ${room.count}</div>
												</a>
											</div>
											<div class="col-md-6">
												<div class="hot-page2-alp-ri-p2">
													<a href="#"><h3>${room.type}</h3></a>
													<ul>
														<li>湖南省-长沙市-岳麓区-麓谷街道-延农大厦</li>
														<li>+86 151-1522-2744</li>
													</ul>
													<p>
														<b>设施: </b>厨房设施、游泳池、电视、WiFi、吹风机、毛巾、餐饮、锻炼、停车、音乐、健身房、操场等。
													</p>
												</div>
											</div>
											<div class="col-md-2">
												<div class="hot-page2-alp-ri-p3">
													<div class="hot-page2-alp-r-hot-page-rat">VIP 75%</div>
													<span class="hot-list-p3-1">每 晚 价 格</span> <span
														class="hot-list-p3-2">${room.price*0.75}</span> <span
														class="hot-list-p3-3">${room.price}</span> <span
														class="hot-list-p3-4"> <a href="booking.jsp"
														class="hot-page2-alp-quot-btn">立即预订</a>
													</span>
												</div>
											</div>
										</div>
										<!--END LISTINGS-->
									</c:if>
								</c:forEach>

							</div>
						</div>
					</div>
					<!--END RIGHT LISTINGS-->
				</div>
			</div>
		</div>
	</section>
	<!--====== TIPS BEFORE TRAVEL ==========-->
	<!-- <section>
        <div class="rows tips tips-home tb-space home_title">
            <div class="container tips_1">
                TIPS BEFORE TRAVEL
                <div class="col-md-4 col-sm-6 col-xs-12">
                    <h3>Tips Before Travel</h3>
                    <div class="tips_left tips_left_1">
                        <h5>Bring copies of your passport</h5>
                        <p>Aliquam pretium id justo eget tristique. Aenean feugiat vestibulum blandit.</p>
                    </div>
                    <div class="tips_left tips_left_2">
                        <h5>Register with your embassy</h5>
                        <p>Mauris efficitur, ante sit amet rhoncus malesuada, orci justo sollicitudin.</p>
                    </div>
                    <div class="tips_left tips_left_3">
                        <h5>Always have local cash</h5>
                        <p>Donec et placerat ante. Etiam et velit in massa. </p>
                    </div>
                </div>
                CUSTOMER TESTIMONIALS
                <div class="col-md-8 col-sm-6 col-xs-12 testi-2">
                    TESTIMONIAL TITLE
                    <h3>Customer Testimonials</h3>
                    <div class="testi">
                        <h4>John William</h4>
                        <p>Ut sed sem quis magna ultricies lacinia et sed tortor. Ut non tincidunt nisi, non elementum lorem. Aliquam gravida sodales</p>
                        <address>Illinois, United States of America</address>
                    </div>
                    ARRANGEMENTS & HELPS
                    <h3>Arrangement & Helps</h3>
                    <div class="arrange">
                        <ul>
                            LOCATION MANAGER
                            <li>
                                <a href="#"><img src="images/Location-Manager.png" alt="">
                                </a>
                            </li>
                            PRIVATE GUIDE
                            <li>
                                <a href="#"><img src="images/Private-Guide.png" alt="">
                                </a>
                            </li>
                            ARRANGEMENTS
                            <li>
                                <a href="#"><img src="images/Arrangements.png" alt="">
                                </a>
                            </li>
                            EVENT ACTIVITIES
                            <li>
                                <a href="#"><img src="images/Events-Activities.png" alt="">
                                </a>
                            </li>
                        </ul>
                    </div>

                </div>
            </div>
        </div>
    </section> -->

	<!--====== FOOTER 1 ==========-->
	<!-- ========================================================================================================================= -->
	<!--     <section>
        <div class="rows">
            <div class="footer1 home_title tb-space">
                <div class="pla1 container">
                    FOOTER OFFER 1
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="disco">
                            <h3>30%<span>OFF</span></h3>
                            <h4>Eiffel Tower,Rome</h4>
                            <p>valid only for 24th Dec</p>
                            <a href="booking.html">Book Now</a>
                        </div>
                    </div>
                    FOOTER OFFER 2
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="disco1 disco">
                            <h3>42%<span>OFF</span></h3>
                            <h4>Colosseum,Burj Al Arab</h4>
                            <p>valid only for 18th Nov</p>
                            <a href="booking.html">Book Now</a>
                        </div>
                    </div>
                    FOOTER MOST POPULAR VACATIONS
                    <div class="col-md-6 col-sm-12 col-xs-12 foot-spec footer_places">
                        <h4><span>Most Popular</span> Vacations</h4>
                        <ul>
                            <li><a href="tour-details.html">Angkor Wat</a>
                            </li>
                            <li><a href="tour-details.html">Buckingham Palace</a>
                            </li>
                            <li><a href="tour-details.html">High Line</a>
                            </li>
                            <li><a href="tour-details.html">Sagrada Família</a>
                            </li>
                            <li><a href="tour-details.html">Statue of Liberty </a>
                            </li>
                            <li><a href="tour-details.html">Notre Dame de Paris</a>
                            </li>
                            <li><a href="tour-details.html">Taj Mahal</a>
                            </li>
                            <li><a href="tour-details.html">The Louvre</a>
                            </li>
                            <li><a href="tour-details.html">Tate Modern, London</a>
                            </li>
                            <li><a href="tour-details.html">Gothic Quarter</a>
                            </li>
                            <li><a href="tour-details.html">Table Mountain</a>
                            </li>
                            <li><a href="tour-details.html">Bayon</a>
                            </li>
                            <li><a href="tour-details.html">Great Wall of China</a>
                            </li>
                            <li><a href="tour-details.html">Hermitage Museum</a>
                            </li>
                            <li><a href="tour-details.html">Yellowstone</a>
                            </li>
                            <li><a href="tour-details.html">Musée d'Orsay</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section> -->
	<!-- ========================================================================================================================= -->

	<!--====== FOOTER 2 ==========-->
	<section>
		<div class="rows">
			<div class="footer">
				<div class="container">
					<div class="foot-sec2">
						<div>
							<div class="row">
								<div class="col-sm-3 foot-spec foot-com">
									<h4>
										<span>Holiday</span> Tour & Travels
									</h4>
									<p>World's leading tour and travels Booking website,Over
										30,000 packages worldwide.</p>
								</div>
								<div class="col-sm-3 foot-spec foot-com">
									<h4>
										<span>Address</span> & Contact Info
									</h4>
									<p>28800 Orchard Lake Road, Suite 180 Farmington Hills,
										U.S.A. Landmark : Next To Airport</p>
									<p>
										<span class="strong">Phone: </span> <span class="highlighted">+101-1231-1231</span>
									</p>
								</div>
								<div class="col-sm-3 col-md-3 foot-spec foot-com">
									<h4>
										<span>SUPPORT</span> & HELP
									</h4>
									<ul class="two-columns">
										<li><a href="#">About Us</a></li>
										<li><a href="#">FAQ</a></li>
										<li><a href="#">Feedbacks</a></li>
										<li><a href="#">Blog </a></li>
										<li><a href="#">Use Cases</a></li>
										<li><a href="#">Advertise us</a></li>
										<li><a href="#">Discount</a></li>
										<li><a href="#">Vacations</a></li>
										<li><a href="#">Branding Offers </a></li>
										<li><a href="#">Contact Us</a></li>
									</ul>
								</div>
								<div class="col-sm-3 foot-social foot-spec foot-com">
									<h4>
										<span>Follow</span> with us
									</h4>
									<p>Join the thousands of other There are many variations of
										passages of Lorem Ipsum available</p>
									<ul>
										<li><a href="#"><i class="fa fa-facebook"
												aria-hidden="true"></i></a></li>
										<li><a href="#"><i class="fa fa-google-plus"
												aria-hidden="true"></i></a></li>
										<li><a href="#"><i class="fa fa-twitter"
												aria-hidden="true"></i></a></li>
										<li><a href="#"><i class="fa fa-linkedin"
												aria-hidden="true"></i></a></li>
										<li><a href="#"><i class="fa fa-youtube"
												aria-hidden="true"></i></a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!--====== FOOTER - COPYRIGHT ==========-->
	<section>
		<div class="rows copy">
			<div class="container">
				<p>Copyrights © 2019 YISOU. All Rights Reserved</p>
			</div>
		</div>
	</section>

	<!-- ================================================================================================================ -->


	<!--     <section>
        <div class="icon-float">
            <ul>
                <li><a href="#" class="sh">1k <br> Share</a>
                </li>
                <li><a href="#" class="fb1"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                </li>
                <li><a href="#" class="gp1"><i class="fa fa-google-plus" aria-hidden="true"></i></a>
                </li>
                <li><a href="#" class="tw1"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                </li>
                <li><a href="#" class="li1"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
                </li>
                <li><a href="#" class="sh1"><i class="fa fa-envelope-o" aria-hidden="true"></i></a>
                </li>
            </ul>
        </div>
    </section> -->

	<!-- ================================================================================================================ -->

	<!--========= Scripts ===========-->
	<script src="js/jquery-latest.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/wow.min.js"></script>
	<script src="js/custom.js"></script>
</body>

</html>