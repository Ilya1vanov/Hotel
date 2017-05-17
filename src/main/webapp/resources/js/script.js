var link = document.querySelector(".trigger");
var popup = document.querySelector(".modal-window");
var content = popup.querySelector(".modal-content");
var close = popup.querySelector(".modal-content-close");
var form = popup.querySelector("form");
var nameField = popup.querySelector("#name");
var emailField = popup.querySelector("#email");
var feedbackField = popup.querySelector("#feedback");
var overlay = document.querySelector(".map .overlay");
var footer = document.querySelector(".main-footer");
var formElements = form.querySelectorAll('[name]');

//    MODAL WINDOW

if (link && close) {
    link.addEventListener("click", function(event) {
        event.preventDefault();
        popup.classList.add("modal-content-show");
        nameField.focus();
    });


    close.addEventListener("click", function(event) {           event.preventDefault();
        popup.classList.remove("modal-content-show");
        content.classList.remove("modal-content-error");
    });

    window.addEventListener("keydown", function(event) {
        if ((event.keyCode === 27) && popup.classList.contains("modal-content-show")) {
            popup.classList.remove("modal-content-show");
            content.classList.remove("modal-content-error");
        }
    });
}

//    FORM VALIDATION

if (form) {
    form.addEventListener("submit", function(event) {
        if (!(nameField.value && emailField.value && feedbackField.value)) {
            event.preventDefault();
            content.classList.remove("modal-content-error");
            nameField.focus();
                content.classList.add("modal-content-error");
        } else {
            for (var i = 0, length = formElements.length; i < length; i++) {
                var name = formElements[i].getAttribute('name');
                localStorage.removeItem(name);
            }
        }
    });
    
    if (form) {
    form.addEventListener("reset", function() {
        for (var i = 0, length = formElements.length; i < length; i++) {
            var name = formElements[i].getAttribute('name');
            localStorage.removeItem(name);
            nameField.focus();
        }
    });
}
}

//    LOCAL STORARE

if (window.localStorage) {
    for (var i = 0, length = formElements.length; i < length; i++) {
        (function(element) {
            var name = element.getAttribute('name');

            element.value = localStorage.getItem(name) || '';

            element.onkeyup = function() {
                localStorage.setItem(name, element.value);
                };
            })(formElements[i]);
        }
}

//MAP

if (overlay) {
    overlay.addEventListener("click", function(event) {
        overlay.style.pointerEvents = 'none';
    });
    
    window.addEventListener("mousemove", function(event) {
        if (overlay.style.pointerEvents === 'none') {
            if ((event.offsetX > overlay.offsetWidth) || (event.offsetY > overlay.offsetHeight) ) {
            overlay.style.pointerEvents = 'auto';            
            }
        }
    });
    
    footer.addEventListener("mouseover", function() {
        overlay.style.pointerEvents = 'auto';    
    });
    
}