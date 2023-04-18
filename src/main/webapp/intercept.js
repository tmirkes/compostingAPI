"use strict";

function init() {
        const forms = document.querySelectorAll('form');
        forms.forEach((form) => {
            form.addEventListener('submit', (event) => {
                event.preventDefault();
                const formId = event.target.id;
                if (formId === 'MA' || formId === 'DA' || formId === 'PA' || formId === 'SA') {
                    redirectA(formId);
                } else {
                    redirectB(formId);
                }
            });
        });
}
function redirectA(formId) {
    const form = document.getElementById(formId);
    const addressField = form.querySelector("input[name='address" + formId + "']").value;
    const dataFieldA = form.querySelector("input[name='field1" + formId + "']").value;
    console.log("addressField = " + addressField);
    console.log("dataFieldA = " + dataFieldA);
    const url = `http://localhost:8080/ComPostingv3_war/${addressField}/${dataFieldA}`;
    console.log("url = " + url);
    window.location.href = url;
}
function redirectB(formId) {
    const form = document.getElementById(formId);
    const addressField = form.querySelector("input[name='address" + formId + "']").value;
    const dataFieldA = form.querySelector("input[name='field1" + formId + "']").value;
    const dataFieldB = form.querySelector("input[name='field2" + formId + "']").value;
    console.log("addressField = " + addressField);
    console.log("dataFieldA = " + dataFieldA);
    console.log("dataFieldB = " + dataFieldB);
    const url = `http://localhost:8080/ComPostingv3_war/${addressField}/${dataFieldA}/${dataFieldB}`;
    console.log("url = " + url);
    window.location.href = url;
}
