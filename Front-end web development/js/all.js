// var mySwiper = new Swiper('.swiper-container', {
//     // Optional parameters
//     // direction: 'vertical',
//     loop: true,
//     speed:1500,
//     autoplay: {
//        delay: 2000,
//     },
//     effect:'cube',
//     // If we need pagination
//     pagination: {
//       el: '.swiper-pagination',
//     },
  
//     // Navigation arrows
//     navigation: {
//       nextEl: '.swiper-button-next',
//       prevEl: '.swiper-button-prev',
//     },
  
//     // And if we need scrollbar
//     scrollbar: {
//       // el: '.swiper-scrollbar',
//     },
//   })
  // =================登入註冊頁面＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
  const signInForm = document.querySelector('.signIn-form');
  var signInSpan = document.querySelector('.signIn-span');
  const signUpForm = document.querySelector('.signUp-form');
  var signUpSpan =document.querySelector('.signUp-span');
  
  // signIn.classList.toggle('signIn-session')
  
  /* ---------------登入和註冊 form 切換---------------------  */
  var signInSwitch = document.querySelector('.signIn-switch');
  var signUpSwitch =document.querySelector('.sigUp-switch');
  signInSwitch.onclick=function(e){  
	e.preventDefault();
	signInForm.setAttribute('style','display: flex;');
	signUpForm.setAttribute('style','display: none;');
	signInSpan.setAttribute('style','display: none;');
	signUpSpan.setAttribute('style','display: inline;');
	
  }
  signUpSwitch.onclick=function(e){
	  e.preventDefault();
	  signInForm.setAttribute('style','display: none;');
	  signUpForm.setAttribute('style','display: flex;');
	  signInSpan.setAttribute('style','display: inline;');
	  signUpSpan.setAttribute('style','display: none;');
	  
  }
  //----------------檢查註冊表單----------------------------
  function signUpverify(myform) {
              var errorMes = "";
              if (myform.userid.value == "") {
                  errorMes += "請填寫帳號!\n";
              }
              if (myform.name.value == "") {
                  errorMes += "請填寫姓名!\n";
              }
              if (myform.password.value == "") {
                  errorMes += "請填寫密碼!\n";
              }
              if (myform.password.value != myform.password2.value) {
                  errorMes += "密碼不一致!\n";
              }
			  if(myform.phone.value == ""){
				  errorMes += "請填寫電話!\n";
			  }
  
              var pattern = /^((((19|20)(([02468][048])|([13579][26]))-02-29))|((20[0-9][0-9])|(19[0-9][0-9]))-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))$/;
  
              if (!pattern.test(myform.birthday.value)) {
                  errorMes += "出生日期格式錯誤！\n";
              } 
              if (errorMes == "") {
                  return true;
              } else {
                  alert(errorMes);
                  return false;
              }
          }
  function signIpverify(myform) {
              var errorMes = "";
              if (myform.userid.value == "") {
                  errorMes += "請輸入帳號!\n";
              }
              if (myform.password.value == "") {
                  errorMes += "請輸入密碼!\n";
              }
              if (errorMes == "") {
                  return true;
              } else {
                  alert(errorMes);
                  return false;
              }
          }