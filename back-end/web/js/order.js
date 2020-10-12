document.querySelector('.container').addEventListener('click', (e) => {
    const {target} = e;
    total = document.getElementById("total").innerText;

    /*  -----------------刪除商品項目-----------------------*/
    if (target.classList.contains('del_btn')) {
        const totalDel = target.parentNode.parentNode.children[3].children[0].innerText
        document.getElementById('total').innerText = parseInt(total) - parseInt(totalDel);
        target.parentNode.parentNode.remove();
        console.log(target.parentNode.parentNode)

        /*  -----------------[bug] 跳出 alert 按取消事件依然被記錄-----------------------*/
        // document.querySelector('#delDetermine').addEventListener('click', (e) => {
        //     document.getElementById('total').innerText = parseInt(total) - parseInt(totalDel);
        //     target.parentNode.parentNode.remove();
        //     console.log(target.parentNode.parentNode)
        // });

        /*  -----------------[bug] 也想過移除監聽，但還是失敗-----------------------*/
        // document.querySelector('.del_btn').removeEventListener('onmouseup', (e) => {
        //     console.log('取消 ok')
        // });

     }

    /*  -----------------改變商品數量-----------------------*/
    if (target.classList.contains('add_btn')) {
        var count = target.parentNode.children[1].value;
        var price = target.parentNode.parentNode.parentNode.children[1].innerText;
        target.parentNode.children[1].value = ++count;
        var subtotle1 = target.parentNode.children[1].value
        target.parentNode.parentNode.parentNode.children[3].children[0].innerText = subtotle1 * price;
        total = parseInt(total) + parseInt(price);
        document.getElementById('total').innerText = total;
    }

    if (target.classList.contains('minus_btn')) {
        var count = target.parentNode.children[1].value;
        var price = target.parentNode.parentNode.parentNode.children[1].innerText;

        if (count > 0) {
            target.parentNode.children[1].value = --count;
            var subtotle1 = target.parentNode.children[1].value;
            target.parentNode.parentNode.parentNode.children[3].children[0].innerText = subtotle1 * price;
            total = parseInt(total) - parseInt(price);
            document.getElementById('total').innerText = total;

        }
    }
});
