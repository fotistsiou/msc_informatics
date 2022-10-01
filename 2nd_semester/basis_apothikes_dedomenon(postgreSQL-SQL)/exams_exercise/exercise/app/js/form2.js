window.addEventListener('load', (event) => {
    // Search
    const date_user = document.getElementById("date_user");
    const search_btn = document.getElementById("search_btn");
    const data_search = document.getElementById('data_search');
    document.getElementById("search_btn").addEventListener("click",function(){
        var date_user_val = date_user.value.trim();
        var search_btn_val = search_btn.value;
        $.ajax({    
            data: {date_user:date_user_val,search_btn:search_btn_val},
            type: "GET",
            url: "./php/form2.php",
            dataType: 'html',            
            success: function(data){                 
                data_search.innerHTML = data;
            }
        })
    });
});