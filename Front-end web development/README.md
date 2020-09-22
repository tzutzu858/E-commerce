# E-commerce

https://tzutzu858.github.io/E-commerce/<br />
<br />
[swiper](https://github.com/tzutzu858/E-commerce/blob/master/README.md#20200915-%E8%BC%AA%E6%92%AD%E6%95%88%E6%9E%9C)
## design sketch :<br />
index page<br />
<img src="https://github.com/tzutzu858/E-commerce/blob/master/Front-end%20web%20development/diagram/index.jpg?raw=true" width="300" ><br /><br />
register page<br />
<img src="https://github.com/tzutzu858/E-commerce/blob/master/Front-end%20web%20development/diagram/sign_up%E9%A0%81%E9%9D%A2.jpg?raw=true" width="300" ><br /><br />
order page <br />
<img src="https://github.com/tzutzu858/E-commerce/blob/master/Front-end%20web%20development/diagram/%E8%A8%82%E5%96%AE%E9%A0%81%E9%9D%A2-01.jpg?raw=true" width="300" ><br /><br />
**************************
## 20200915 輪播效果

<img src="https://github.com/tzutzu858/E-commerce/blob/master/Front-end%20web%20development/diagram/swiper.gif?raw=true" width="500" ><br /><br />


html
```html
 <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.css">
 
<div class="swiper-container">
<div class="swiper-wrapper">               
   <div class="swiper-slide"><img src="img/cat-3169476_640.jpg" ></div>
   <div class="swiper-slide"><img src="img/cat-3169476_640.jpg" ></div>
   <div class="swiper-slide"><img src="img/cat-3169476_640.jpg" ></div>    
</div>
<script src="https://unpkg.com/swiper/swiper-bundle.js"></script>
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
```


js
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
