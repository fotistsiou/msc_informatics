window.addEventListener('load', (event) => {
    // Select button
    var mybutton = document.getElementById("topBtn");

    // Display button when the user scrolls down 1500px
    function scrollFunction() {
        if (document.body.scrollTop > 1500 || document.documentElement.scrollTop > 1500) {
            mybutton.style.display = "block";
        } else {
            mybutton.style.display = "none";
        }
    }
    window.onscroll = function() {
        scrollFunction()
    };

    // When the user clicks on the button, scroll to the top of the document
    mybutton.addEventListener("click", function() {
        document.body.scrollTop = 0;
        document.documentElement.scrollTop = 0;
    })
})