<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>會員專區</title>
		
		<meta property="og:title" content="DreamStore" />
	 	<meta property="og:description" content="java">
		<meta property="og:type" content="website" />
		<meta property="og:url" content="FB上的網址" />
		<meta property="og:image" content="FB的圖片" />
		<meta name="viewport" content="width=device-width,initial-scle=1.0">
		
		<link rel="shortcut icon" href="https://icons.iconarchive.com/icons/dakirby309/simply-styled/48/Java-icon.png">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
		<link rel="stylesheet" type="text/css" href="css/all.css"/>
	</head>
	<body>
		<div class="wraper">
			<div class="header member-header">
				<div class="nav-bar">
					<h1><a href="controller?action=list">Dream</a></h1>
					<ul class="menu">
						<li><a href="controller?action=list"><i class="list icon"></i>商品列表</a></li>
						<li><a href="cart.jsp"><i class="cart icon"></i>購物車</a></li>
						<li><a href="member.jsp"><i class="id card icon"></i>會員專區</a></li>
					</ul>
				</div>
				<div class="banner">
					<ul>
						<c:forEach var="error" items="${errors}">
							<li class="error">${error}</li>
						</c:forEach>
					</ul>
					<div class="member-section ">
							<!-- 註冊 -->
							<form class="member-form signUp-form" action="controller" method="post" onsubmit="return signUpverify(this)">
								帳號：
								<input type="text" name="userid" id="" value="" />
								姓名：
								<input type="text" name="name" id="" value="" />
								密碼：
								<input type="password" name="password" id="" value="" />
								再輸入一次：
								<input type="password" name="password2" id="" value="" />
								生日： 格式（YYYY-MM-DD）
								<input type="text" name="birthday" id="" value="" />
								電話：
								<input type="text" name="phone" id="" value="" />
								
								<input type="submit" class="submit-button" name="" value="sign up" />
								<input type="hidden" name="action" value="reg" >
							</form>
							<!-- 登入 -->
							<form class="member-form signIn-form" action="controller" method="post" onsubmit="return signIpverify(this)">
								<img src="img/moon.png" >
								帳號：
								<input type="text" name="userid" />
								密碼：
								<input type="password" name="password">
								
								<input type="submit" class="submit-button" name="" value="sign in" />

								<input type="hidden" name="action" value="login">
							</form>
							<div class="sign-switch">
								<span class="signIn-span">已有帳號了嗎</span><span class="signUp-span">還沒有註冊嗎</span>
								<a href="" class="signIn-switch">sign in</a><a href="" class="sigUp-switch">sign up</a>
							</div>
						</div>
				</div>
			</div>
			<div class="footer">
				<div class="footer_info">
                    <p>公司地址：台灣市台灣路台灣號123樓</p>
                    <p>客服專線：01-1314-5566</p>
                    <p>來電時間：週一〜週五 09:00~18:00 / 週六、週日、國定假日（含連假）休息</p>
                    <p>email：java02@thatsdreaming.com.tw</p>
                </div>
				<div class="footer_icon">
					<a href="controller?action=list"><img class="footer_loge" src="svg/title_logo.svg" /></a>
                    <ul class="social_network">
                        <li><a href=""><img class='icon' src="svg/facebook.svg"/></a></li>
                        <li><a href=""><img class='icon' src="svg/instagram-sketched.svg" /></a></li>
                        <li><a href=""><img class='icon' src="svg/twitter.svg" /></a></li>
                    </ul>
				</div>
			</div>
			<div class="footer_bottom">
            happy coding © 2020 I Love Java.有限公司版權所有
			</div>
		</div>
		<script src="js/member.js" type="text/javascript" charset="utf-8"></script>
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>	
		<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
	</body>
</html>
e