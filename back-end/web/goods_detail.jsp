<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <title>商品詳細資料</title>
  <link rel="stylesheet" type="text/css" href="css/public.css">
  <style type="text/css">
    .title {
      font-size: 20px;
      color: #FF6600;
      font-style: italic;
    }
  </style>
</head>
<body>
<jsp:include page="goods_header.jsp" flush="true" >
  <jsp:param name="image" value="info.jpg" />
</jsp:include>
<hr width="100%"/>
<div class="text3" align="center">${goods.description}</div>
<table width="100%" border="0" align="center">
  <tr>
    <td width="40%" align="right">
      <div><img src="goods_images/${goods.image}" width="360px" height="360px"/></div>
      <br></td>
    <td>
      <div align="center" class="text4">價格：<span class="title">$${goods.price}元</span></div>
      <br>
      <table width="80%" height="200" border="0">
        <tbody>

        </tbody>
      </table>
      <br>
      <br>
      <div><a href="controller?action=add&pagename=detail&id=${goods.id}&name=${goods.name}&price=${goods.price}"><img src="images/button.jpg"/></a></div>
    </td>
  </tr>
</table>
<%@include file="footer.jsp" %>
</body>
</html>
