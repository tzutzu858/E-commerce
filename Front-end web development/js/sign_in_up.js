const signIn = document.querySelector('#signIn');
const register = document.querySelector('#register');
signIn.classList.toggle('signIn-session')


// document.querySelectorAll('.signIn-button').addEventListener('click', (e) => {
//     console.log(e.target)
// });

// document.querySelectorAll('.sigUp-button').addEventListener('click', (e) => {
//     console.log(e.target)
// });

// signIn.classList.toggle('signIn-session')
// signIn.classList.toggle('signUp-session')

/*  -----------------開關切換---------------------  */
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
