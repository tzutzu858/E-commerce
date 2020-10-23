<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>訂單完成</title>

    <meta property="og:title" content="DreamStore" />
    <meta property="og:description" content="java">
    <meta property="og:type" content="website" />
    <meta property="og:url" content="FB上的網址" />
    <meta property="og:image" content="FB的圖片" />
    <meta name="viewport" content="width=device-width,initial-scle=1.0">

    <link rel="shortcut icon" href="https://icons.iconarchive.com/icons/dakirby309/simply-styled/48/Java-icon.png">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
    <link rel="stylesheet" type="text/css" href="css/all.css"/>
    <style type="text/css">
        a:link {
            font-size: 18px;
            color: #DB8400;
            text-decoration: none;
            font-weight: bolder;
        }
        a:visited {
            font-size: 18px;
            color: #DB8400;
            text-decoration: none;
            font-weight: bolder;
        }
        a:hover {
            font-size: 18px;
            color: #DB8400;
            text-decoration: underline;
            font-weight: bolder;
        }

        .context {
            padding: 40px 0;
        }

        .thanks-msg {
            margin: 20px;
        }

        .thanks-img {
            width: 200px;
        }
    </style>
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
            <h2>BUY A DREAM</h2>
            <p class="banner_msg">A dedached space for the soul to settle in the hustle and bustle of the confused city.</p>
        </div>
    </div>
    <div class="context">
        <div align="center" >
            <img class="thanks-img" src="img/thankyou.png">
            <h3 class="thanks-msg"> 谢谢您的購物！ </h3>
            <h3 class="thanks-msg"> 您的訂單編號是：${ordersid} </h3>
            <h3 class="thanks-msg"> 您可以繼續購物！ </h3>
            <h3 class="thanks-msg">
                <a href="controller?action=list">返回主頁面</a>
            </h3>
        </div>
    </div>
    <%@ include file="footer.jsp" %>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
</body>
</html>
