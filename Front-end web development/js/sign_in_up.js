const signIn = document.querySelector('#signIn');
const register = document.querySelector('#register');
signIn.classList.toggle('signIn-session')

/*  -----------------登入和註冊 form 切換---------------------  */
const signInBtn = document.querySelectorAll('.signIn-button');

for (i = 0; i < signInBtn.length; i++) {
    signInBtn[i].addEventListener('click', () => {
        if (document.querySelector('.signIn-session')) {
            signIn.classList.toggle('signIn-session')
            register.classList.toggle('register-section')
        }
    });
}

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

const formSignIn = document.querySelector('#form_signIn');
const formRegister = document.querySelector('#form_register');
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
    var hasCheck = false;
    for (const inputName of formBlockInput) {
        const errP = inputName.querySelector('p');
        const inputValue = inputName.querySelector('input');
        console.log(inputValue.value);
        if (inputValue.value) {
            errP.className = 'input-ok';
            hasCheck = true;
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