//-------------輪播---------------------------
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