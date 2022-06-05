window.addEventListener('load', (event) => {
    
    var name = document.getElementById("name_customer");
    function name_dest(){
        if (!(/^[a-z]+$/.test(name))) {
            name.style = "border:2px solid red";
            name.value = "Only english lower characters";
        }
    }
    document.getElementById("submit").addEventListener("mouseup", name_dest);
    

});