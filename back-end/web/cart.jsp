<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>購物車</title>
    <link rel="stylesheet" type="text/css" href="css/public.css">
    <style type="text/css">
        table {
            border-collapse: collapse;
        }

        .threeboder {
            border: 1px solid #5B96D0;
        }

        .trow {
            border-right: 1px solid #5B96D0;
            border-bottom: 1px solid #5A96D6;
        }

        .theader {
            background-color: #A5D3FF;
            font-size: 14px;
            border-right: 1px solid #5B96D0;
            border-bottom: 1px solid #5A96D6;
        }
    </style>

    <script>
        function calc(rowid, quantityInput) {

            quantity = quantityInput.value
            if (isNaN(quantity)) {
                alert("數值無效！");
                quantityInput.value = 0;
                quantity = quantityInput.value
                quantityInput.focus();
                // return;
            }
            // 單價id
            var price_id = 'price_' + rowid;
            // 單價
            var price = parseFloat(document.getElementById(price_id).innerText);

            // 小計id
            var subtotal_id = 'subtotal_' + rowid;
            //小計(更新前)
            subtotal1 = parseFloat(document.getElementById(subtotal_id).innerText);
            //四捨五入保留兩位小數
            subtotal1 = subtotal1.toFixed(2);
            document.getElementById(subtotal_id).innerText = quantity * price;
            // 小計(更新後)
            subtotal2 = parseFloat(document.getElementById(subtotal_id).innerText);
            // 合計
            total = parseFloat(document.getElementById('total').innerText);
            // 計算合計
            total = total - subtotal1 + subtotal2;
            //四捨五入保留兩位小數
            total = total.toFixed(2);
            //更新合計
            document.getElementById('total').innerText = total;

        }
    </script>

</head>

<body>
<jsp:include page="goods_header.jsp" flush="true" >
    <jsp:param name="image" value="mycar.jpg" />
</jsp:include>
<hr width="100%"/>
<div class="text3" align="center">購物車內的商品</div>
<br>
<form action="controller" method="post">
    <table width="100%" border="0" align="center" class="threeboder">
        <tr bgcolor="#A5D3FF">
            <td height="50" align="center" class="theader">商品名稱</td>
            <td width="8%" align="center" class="theader">數量</td>
            <td width="15%" align="center" class="theader">單價</td>
            <td width="15%" align="center" class="theader">小計</td>
        </tr>
        <c:forEach var="row" items="${cart}">
            <tr>
                <td height="50" align="left" class="trow">&nbsp;&nbsp;${row.goodsname}</td>
                <td align="center" class="trow">
                    <input name="quantity_${row.goodsid}" type="text" value="${row.quantity}"
                           onblur="calc(${row.goodsid}, this)"/>
                </td>
                <td align="center" class="trow">&yen;<span id="price_${row.goodsid}">${row.price}</span></td>
                <td align="center" class="trow">&yen;<span
                        id="subtotal_${row.goodsid}">${row.price * row.quantity}</span>
                </td>
            </tr>
        </c:forEach>

        <tr>
            <td height="50" colspan="5" align="right">合计：&yen;<span id="total">${total}</span>&nbsp;&nbsp;</td>
        </tr>
    </table>
    <br>
    <div align="center">
        <c:if test="${not empty cart}">
            <input type="image" src="images/submit_order.jpg" border="0">&nbsp;&nbsp;
        </c:if>
    </div>
    <input type="hidden" name="action" value="sub_ord">
</form>
<%@include file="footer.jsp" %>

</body>
</html>
