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
        <%@ include file="nav_bar.jsp" %>
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
            <div>
                <div class="goods_detail_block">
                    <div class="goods_title">
                        <p style="font-size: xx-large">${goods.name}</p>
                        <div class="detail_img">
                            <img src="img/${goods.image}"/>
                        </div>
                        <div class="detail_price">價格：$${goods.price}元</div>
                    </div>
                    <div class="goods_description">
                        <div class="goods_msg">${goods.description}</div>
                        <a class="detail_add_btn" href="controller?action=add&pagename=list&id=${goods.id}&name=${goods.name}&price=${goods.price}&img=${goods.image}&description=${goods.description}">添加到購物車</a>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="footer.jsp" %>
</div>
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script src="js/goodlist.js" type="text/javascript" charset="utf-8"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>

</body>
</html>
