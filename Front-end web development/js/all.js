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
  const signUpForm = document.querySelector('.signUp-form');
  // signIn.classList.toggle('signIn-session')
  
  /*  -----------------登入和註冊 form 切換---------------------  */
  var signInSwitch = document.querySelector('.signIn-switch');
  var signUpSwitch =document.querySelector('.sigUp-switch');
  signInSwitch.onclick=function(e){  
	e.preventDefault();
	signInForm.setAttribute('style','display: flex;')
	signUpForm.setAttribute('style','display: none;')
  }
  signUpSwitch.onclick=function(e){
	  e.preventDefault();
	  signInForm.setAttribute('style','display: none;')
	  signUpForm.setAttribute('style','display: flex;')
  }
  // for (i = 0; i < signInBtn.length; i++) {
  //     signInBtn[i].addEventListener('click', () => {
  //         if (document.querySelector('.signIn-session')) {
  //             signIn.classList.toggle('signIn-session')
  //             register.classList.toggle('register-section')
  //         }
  //     });
  // }
  
  
  const signUpBtn = document.querySelectorAll('.sigUp-button');
  
  for (i = 0; i < signUpBtn.length; i++) {
      signUpBtn[i].addEventListener('click', () => {
          if (document.querySelector('.register-section')) {
              signIn.classList.toggle('signIn-session')
              register.classList.toggle('register-section')
          }
      });
  }
  
  
  
  /*  -----------------檢查 input 是否填寫
  ---------------------如果沒有填寫完整就不送表單出去  */
  
  const formSignIn = document.querySelector('.signIn-form');
  const formRegister = document.querySelector('.register-form');
  formRegister.addEventListener('submit',
      (e) => {
          console.log("register_ok")
          if (!(checkInputIsOk(formRegister))) {
              e.preventDefault();
          }
      });
  
      formSignIn.addEventListener('submit',
      (e) => {
          console.log("signIn_ok")
          if (!(checkInputIsOk(formSignIn))) {
              e.preventDefault();
          }
      });
  
  
  function checkInputIsOk(form) {
      const formBlockInput = form.querySelectorAll('.form_block_input');
      console.log(formBlockInput);
      var hasCheck = true;
      for (const inputName of formBlockInput) {
          const errP = inputName.querySelector('p');
          const inputValue = inputName.querySelector('input');
          console.log(inputValue.value);
          if (inputValue.value) {
              errP.className = 'input-ok';
              
          } else {
              errP.className = 'input-err';
              hasCheck = false;
          }
      }
  
      if (hasCheck) {
          return true;
      }
      return false;
  }