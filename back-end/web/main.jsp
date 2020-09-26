<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <title>Store</title>
  <link rel="stylesheet" type="text/css" href="css/public.css">
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
  </style>
</head>

<body>
<div class="header">Store</div>
<hr width="100%"/>
<div>
  <p class="text1"><img src="images/4.jpg" align="absmiddle"/> <a href="controller?action=list">商品列表</a></p>
  <p class="text2"> 您可以從商品列表中進行購買的動作 </p>
</div>
<hr width="100%"/>
<div>
  <p class="text1"><img src="images/mycar1.jpg" align="absmiddle"/> <a href="controller?action=cart">購物車</a></p>
  <p class="text2"> 您可以將喜愛的商品添加至購物車內 </p>
</div>
<div class="footer">
  <hr width="100%"/>
  Copyright © 2020. All Rights Reserved
</div>
</body>
</html>
