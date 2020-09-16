<?php
session_start();
require_once "conn.php";
$result = $conn->query("SELECT * FROM tzu_comments2 ORDER BY id DESC");
if (!$result) {
    die('Error:' . $conn->error);
}
?>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="./style.css">
    <link rel="stylesheet" href="https://necolas.github.io/normalize.css/8.0.1/normalize.css">
    <title>Dream Store</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">

</head>
<body>
    <section class="banner">
        <nav class='navbar'>
            <div class="wrapper">
                <img class="site-name" src="svg/title_logo.svg" />
                <div class='navbar_list'>
                    <div class="navbar_item"><a href="#"><img class='nav_icon' src="svg/smartcart.svg" />結帳</a></div>
                    <div class="navbar_item"><a href="#"><img class='nav_icon' src="svg/question.svg" />FAQ</a></div>
                    <div class="navbar_login navbar_register"><a href="#">註冊</a></div>
                    <div class="navbar_login"><a href="#">登入</a></div>
                </div>
            </div>
        </nav>
        <h2>BUY A DREAM</h2>
        <p>A dedached space for the soul to settle in the hustle and bustle of the confused city.</p>
    </section>
    <section class="section">
        <h3>選擇下列商品，讓今夜在迷茫城市喧囂裡</h3>
        <h3>有個讓心靈沉澱的超然空間</h3>
        <div class="hot_sell_title">熱銷搶購中</div>
    </section>
    <section class="test1">
        <div class="test2">
            <h2>滑動頁面</h2>
        </div>
    </section>
    <section class="section">
        <div class="buy_title">立即輕鬆選購</div>
        <img class='buy_icon' src="svg/back.svg" />
        <div class="card_block">
        <?php
            while ($row = $result->fetch_assoc()) {
        ?>
            <div class="card">
                <img class="card_img" src="<?php echo $row['img']; ?>" />
                <img class="card_add" src="svg/add.svg" />
                <div class="card_bottom">
                    <div class="card_info">
                        <div class="card_name">
                            <?php echo $row['name']; ?>
                        </div>
                        <div class="card_price">
                           <?php echo $row['price']; ?>
                        </div>
                    </div>

                </div>
            </div>
        <?php }?>
        </div>
    </section>
    <footer>
        <div class="footer_top">
            <div class="wrapper">
                <div class="footer_info">
                    <div>公司地址：台灣市台灣路台灣號123樓</div>
                    <div>客服專線：01-1314-5566</div>
                    <div>來電時間：週一〜週五 09:00~18:00 / 週六、週日、國定假日（含連假）休息</div>
                    <div>email：happycoding@thatsdreaming.com.tw</div>
                </div>
                <div>
                    <img class="site-name_footer" src="svg/title_logo.svg" />
                    <div class="footer_icon_block">
                        <img class='icon' src="svg/facebook.svg" />
                        <img class='icon' src="svg/instagram-sketched.svg" />
                        <img class='icon' src="svg/twitter.svg" />
                    </div>
                </div>
            </div>
        </div>

        <div class="footer_bottom">
            happy coding © 2020 有限公司版權所有
        </div>
    </footer>
    <script src="index.js"></script>
</body>
</html>
