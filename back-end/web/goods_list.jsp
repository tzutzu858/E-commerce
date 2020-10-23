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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/all.css"/>

</head>
<body>
<div class="wraper">
    <div class="header">
        <%@ include file="nav_bar.jsp" %>
        <div class="banner">
            <h2>BUY A DREAM</h2>
            <p class="banner_msg">A dedached space for the soul to settle in the hustle and bustle of the confused
                city.</p>
        </div>
    </div>
    <div class="goodslist-intro">
        <div class="goodslist-intro-title">
            <h3>選擇下列商品，讓今夜在迷茫城市喧囂裡</h3>
            <h3>有個讓心靈沉澱的超然空間</h3>
            <h2>熱銷搶購中</h2>
        </div>
        <div class="swiper">
            <div class="swiper-container">
                <!-- Additional required wrapper -->
                <div class="swiper-wrapper">
                    <!-- Slides -->
                    <c:forEach var="goods" items="${goodsList}" varStatus="status">
                        <div class="swiper-slide"><img src="img/${goods.image}"></div>
                    </c:forEach>
                </div>
                <!-- If we need pagination -->
                <!-- <div class="swiper-pagination"></div> -->

                <!-- If we need navigation buttons -->
                <!-- <div class="swiper-button-prev"></div>
                <div class="swiper-button-next"></div> -->

                <!-- If we need scrollbar -->
                <!-- <div class="swiper-scrollbar"></div> -->
            </div>
        </div>
        <div class="goodslist-section">
            <h4 class="goodslist_msg">請從商品列表中選擇您喜愛的商品</h4>
            <br>
            <ul class="goods-ul">
                <c:forEach var="goods" items="${goodsList}" varStatus="status">
                    <li>
                        <a href="controller?action=detail&id=${goods.id}">
                            <img src="img/${goods.image}" alt="">
                        </a>
                        <div class="buy-info">
                            <h5 class="goods-name">${goods.name}</h5>
                            <i class="goods-price">${goods.price}</i>
                            <span><a class="add_goods"
                                     href="controller?action=add&pagename=list&id=${goods.id}&name=${goods.name}&price=${goods.price}&img=${goods.image}&num=${num}"><i
                                    class="add icon" ></i></a></span>
                        </div>
                    </li>
                </c:forEach>
            </ul>
            <ul class="pagination">
                <li><a href="controller?action=paging&page=prev">«</a></li>
                <c:forEach var="page" begin="1" end="${totalPageNumber}">
                    <li><a
                            <c:if test="${page == currentPage}">
                                class="active"
                            </c:if>
                            href="controller?action=paging&page=${page}">${page}</a></li>
                </c:forEach>
                <li><a href="controller?action=paging&page=next">»</a></li>
            </ul>
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
