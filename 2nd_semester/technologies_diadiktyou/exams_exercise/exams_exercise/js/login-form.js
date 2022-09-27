window.addEventListener('load', (event) => {
    /* Search Section */
    // Select elements
    const email_user = document.getElementById("email_user");
    const pass_user = document.getElementById("pass_user");
    const data_search = document.getElementById('data_search');
    const button_search = document.getElementById("search_btn");
    // Send and fetch data from connect.php
    document.getElementById("search_btn").addEventListener("click",function(){
        var email_user_val = email_user.value.trim();
        var pass_user_val = pass_user.value.trim();
        var button_search_val = button_search.value;
        $.ajax({    
            data: {email_user:email_user_val,pass_user:pass_user_val,button_search:button_search_val},
            type: "GET",
            url: "./php/connect.php",
            dataType: 'html',            
            success: function(data){                 
                data_search.innerHTML = data;
            }
        })
    });
});