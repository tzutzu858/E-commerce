<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="nav-bar">
    <div class="nav-logo-block">
        <h1><a href="controller?action=list">Dream</a></h1>
        <c:if test="${not empty customerName}">
            <div class="username-block">Hello，${customerName}</div>
        </c:if>
    </div>

    <ul class="menu">
        <li><a href="controller?action=list"><i class="list icon"></i>商品列表</a></li>

        <li class="shopping_cart">
            <a href="controller?action=cart">
                <i class="cart icon"></i>購物車
                <input id="cart_num" type="text" class="badge_add" readonly="readonly" value="${num}">
            </a>
        </li>

        <c:if test="${empty customerName}">
            <li><a href="member.jsp"><i class="id card icon"></i>會員專區</a></li>
        </c:if>
        <c:if test="${not empty customerName}">
            <li><a href="controller?action=logout"><i class="id card icon"></i>登出</a></li>
        </c:if>
    </ul>
</div>