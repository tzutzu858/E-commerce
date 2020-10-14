<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>

<head>
    <meta charset="utf-8">

    <link rel="stylesheet" href="https://necolas.github.io/normalize.css/8.0.1/normalize.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <link rel="shortcut icon" href="https://icons.iconarchive.com/icons/dakirby309/simply-styled/48/Java-icon.png">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
    <link rel="stylesheet" href="css/order_page_style.css">
    <title>Dream Store</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">


</head>

<body>
<section>
    <div class="wrapper">
        <div class="nav-bar">
            <h1><a href="controller?action=list">Dream</a></h1>
            <ul class="menu">
                <li><a href="controller?action=list"><i class="list icon"></i>商品列表</a></li>
<%--                <input type="hidden" name="action" value="update_ord">--%>
                <li><a href="controller?action=cart"><i class="cart icon"></i>購物車</a></li>
                <c:if test="${empty customerName}">
                    <li><a href="member.jsp"><i class="id card icon"></i>會員專區</a></li>
                </c:if>
                <c:if test="${not empty customerName}">
                    <li><a href="controller?action=logout"><i class="id card icon"></i>登出</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</section>

<form action="controller" method="post">

    <div class="container">
        <div class="row order_list center-vertical">

            <div class="col-5 justify-content-start">
                商品
            </div>
            <div class="col center-vertical">
                單價
            </div>
            <div class="col center-vertical">
                數量
            </div>
            <div class="col center-vertical">
                總計
            </div>
            <div class="col center-vertical">
                操作
            </div>
        </div>
        <div class="goods">
            <c:forEach var="row" items="${cart}">
                <div class="row order_list">
                    <div class="col-5 center-vertical justify-content-start">
                        <img class="order_goods_img" src="img/${row.goodsimg}"/>
                        <p class="order_goods_name">${row.goodsname}</p>
                    </div>
                    <div class="col center-vertical">
                        <span id="price_${row.goodsid}">${row.price}</span>
                    </div>
                    <div class="col center-vertical">
                        <div class="center-vertical amount">
                            <button class="amount_btn minus_btn" type="button">-</button>
                            <input class="order_amount" name="quantity_${row.goodsid}"
                                   onblur="calc(${row.goodsid}, this)" value="${row.quantity}" readonly="readonly"/>
                            <button class="amount_btn add_btn" type="button">+</button>
                        </div>
                    </div>
                    <div class="col center-vertical">
                        <span class="order_price_total" id="subtotal_${row.goodsid}">${row.price * row.quantity}</span>
                    </div>
                    <div class="col center-vertical">
                        <button class="del_btn" type="button" data-toggle="modal" data-target="#staticBackdrop">刪除
                        </button>

                        <!-- 跳出結帳 alert -->
                        <div class="modal fade" id="checkAccounts" data-backdrop="static" data-keyboard="false"
                             tabindex="-1"
                             aria-labelledby="staticBackdropLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="staticBackdropLabel">結帳</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        確定將訂單結帳 ?
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                                        <button type="submit" class="btn btn-primary delCommodity">確定</button>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- 跳出刪除 alert -->
                            <%--                        <div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false"--%>
                            <%--                             tabindex="-1"--%>
                            <%--                             aria-labelledby="staticBackdropLabel" aria-hidden="true">--%>
                            <%--                            <div class="modal-dialog">--%>
                            <%--                                <div class="modal-content">--%>
                            <%--                                    <div class="modal-header">--%>
                            <%--                                        <h5 class="modal-title" id="staticBackdropLabel">確定刪除 ? </h5>--%>
                            <%--                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
                            <%--                                            <span aria-hidden="true">&times;</span>--%>
                            <%--                                        </button>--%>
                            <%--                                    </div>--%>
                            <%--                                    <div class="modal-body">--%>
                            <%--                                        確定要將此商品刪除 ?--%>
                            <%--                                    </div>--%>
                            <%--                                    <div class="modal-footer">--%>
                            <%--                                        <button type="button" id="cel" class="btn btn-secondary" data-dismiss="modal">--%>
                            <%--                                            取消--%>
                            <%--                                        </button>--%>
                            <%--                                        <button type="button" id="delDetermine" class="btn btn-primary"--%>
                            <%--                                                data-dismiss="modal">確定刪除--%>
                            <%--                                        </button>--%>
                            <%--                                    </div>--%>
                            <%--                                </div>--%>
                            <%--                            </div>--%>
                            <%--                        </div>--%>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
    <footer class="footer_block">
        <div class="settle_accounts_block">

            <div class="sub_total">
                <div>商品總金額</div>
                <c:if test="${not empty cart}">
                    <span class="total_price" id="total">${total}</span>
                    <input class="settle_accounts_btn" type="button" value="結帳" data-toggle="modal"
                           data-target="#checkAccounts" >
                </c:if>
            </div>
            <input type="hidden" name="action" value="sub_ord">
        </div>
    </footer>
</form>
<script>
        <c:if test="${empty customerName}">
        document.querySelector('.settle_accounts_btn').addEventListener('click',(e) => {
            alert("請先登入會員")
            e.stopPropagation();
        });
        </c:if>
</script>
<script src="js/order.js" type="text/javascript" charset="utf-8"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
</body>

</html>