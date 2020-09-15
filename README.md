# E-commerce

https://tzutzu858.github.io/E-commerce/<br />
<br />
## design sketch :<br />
index page<br />
<img src="https://github.com/tzutzu858/E-commerce/blob/master/diagram/index.jpg?raw=true" width="300" ><br /><br />
register page<br />
<img src="https://github.com/tzutzu858/E-commerce/blob/master/diagram/sign_up%E9%A0%81%E9%9D%A2.jpg?raw=true" width="300" ><br /><br />
order page <br />
<img src="https://github.com/tzutzu858/E-commerce/blob/master/diagram/%E8%A8%82%E5%96%AE%E9%A0%81%E9%9D%A2-01.jpg?raw=true" width="300" ><br /><br />
**************************
## 20200915 輪播效果

<img src="https://github.com/tzutzu858/E-commerce/blob/master/diagram/swiper.gif?raw=true" width="500" ><br /><br />
### JavaScript 控制
<br />

```js
var mySwiper = new Swiper('.swiper-container', {
    // Optional parameters
    // direction: 'vertical',
    loop: true,
    speed:1500,
    autoplay: {
       delay: 2000,
    },
    effect:'cube',
    // If we need pagination
    pagination: {
      el: '.swiper-pagination',
    },
  
    // Navigation arrows
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
  
    // And if we need scrollbar
    scrollbar: {
      // el: '.swiper-scrollbar',
    },
  })
  ```
