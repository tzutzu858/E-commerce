<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>商品列表</title>

    <meta property="og:title" content="DreamStore"/>
    <meta property="og:description" content="java">
    <meta property="og:type" content="website"/>
    <meta property="og:url" content="FB上的網址"/>
    <meta property="og:image" content="FB的圖片"/>
    <meta name="viewport" content="width=device-width,initial-scle=1.0">

    <link rel="shortcut icon" href="https://icons.iconarchive.com/icons/dakirby309/simply-styled/48/Java-icon.png">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">
    <link rel="stylesheet" type="text/css" href="css/all.css"/>
    <link rel="stylesheet" type="text/css" href="css/goods_detail.css"/>

</head>
<body>
<div class="wraper">
    <div class="header">
        <div class="nav-bar">
            <h1><a href="controller?action=list">Dream</a></h1>
            <ul class="menu">
                <li><a href="controller?action=list"><i class="list icon"></i>商品列表</a></li>
                <li><a href="controller?action=cart"><i class="cart icon"></i>購物車</a></li>
                <li><a href="member.jsp"><i class="id card icon"></i>會員專區</a></li>
            </ul>
        </div>
        <div class="banner">
            <h2 align="left">BUY A DREAM</h2>
            <p>A dedached space for the soul to settle in the hustle and bustle of the confused city.</p>
        </div>
    </div>
    <div class="goodslist-intro">
        <div class="goodslist-intro-title">
            <h3>選擇下列商品，讓今夜在迷茫城市喧囂裡</h3>
            <h3>有個讓心靈沉澱的超然空間</h3>
            <h2>熱銷搶購中</h2>

            <hr width="100%"/>

            <div>
                <div class="goods_detail_block">
                    <div class="goods_title">
                        <p style="font-size: xx-large">${goods.name}</p>

                        <div style="margin: 30px"><img src="img/${goods.image}" width="360px" height="360px"/></div>
                        <div align="center">價格：<span class="title">$${goods.price}元</span></div>
                    </div>
                    <div class="goods_description">
                        <div class="goods_msg">${goods.description}</div>
                        <span>
                        <a href="controller?action=add&pagename=list&id=${goods.id}&name=${goods.name}&price=${goods.price}&img=${goods.image}&description=${goods.description}"><input
                                type="button" value="添加到購物車"></a>
                    </span>
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
                    <a href="goods_list.jsp"><img class="footer_loge" src="svg/title_logo.svg"/></a>
                    <ul class="social_network">
                        <li><a href=""><img class='icon' src="svg/facebook.svg"/></a></li>
                        <li><a href=""><img class='icon' src="svg/instagram-sketched.svg"/></a></li>
                        <li><a href=""><img class='icon' src="svg/twitter.svg"/></a></li>
                    </ul>
                </div>
            </div>
            <div class="footer_bottom">
                <p>happy coding © 2020 I Love Java.有限公司版權所有</p>
            </div>
        </div>
    </div>
</div>
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script src="js/goodlist.js" type="text/javascript" charset="utf-8"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>

</body>
</html>
