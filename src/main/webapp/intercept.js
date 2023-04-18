"use strict";
// Handling radio button selection value access
// https://stackoverflow.com/questions/7275597/getting-the-selected-radio-without-using-id-but-name
function init() {
    let forms = document.querySelectorAll('form');
    forms.forEach((form) => {
        form.addEventListener('submit', (event) => {
            event.preventDefault();
            let formId = event.target.id;
            if (formId === 'MA' || formId === 'DA' || formId === 'PA' || formId === 'SA') {
                redirectA(formId);
            } else if (formId === 'MB' || formId === 'DB' || formId === 'PB' || formId === 'SB') {
                redirectB(formId);
            } else {
                redirectC(formId);
            }
        });
    });
}
function redirectA(formId) {
    let addressField = document.querySelector(`#address${formId}`).value;
    let dataFieldA = document.querySelector(`input[name=field1${formId}]:checked`).value;
    let url = `http://localhost:8080/ComPostingv3_war${addressField}/${dataFieldA}`;
    window.location.href = url;
}
function redirectB(formId) {
    let addressField = document.querySelector(`#address${formId}`).value;
    let dataFieldA = document.querySelector(`input[name=field1${formId}]`).value;
    let dataFieldB = document.querySelector(`input[name=field2${formId}]:checked`).value;
    let url = `http://localhost:8080/ComPostingv3_war${addressField}/${dataFieldA}/${dataFieldB}`;
    window.location.href = url;
}
function redirectC(formId) {
    let addressField = document.querySelector(`#address${formId}`).value;
    let dataFieldA = document.querySelector(`input[name=field1${formId}]`).value;
    let dataFieldB = document.querySelector(`input[name=field2${formId}]`).value;
    let url = `http://localhost:8080/ComPostingv3_war${addressField}/${dataFieldA}/${dataFieldB}`;
    document.body.innerHTML += `<form id="postForm" style="display: none" action="${url}" method="post"></form>`;
    let form = document.getElementById("postForm");
    form.submit();
}
