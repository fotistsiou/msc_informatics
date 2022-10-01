window.addEventListener('load', (event) => {
    // Insert
    const airc_code_i = document.getElementById("airc_code_i");
    const airc_name_i = document.getElementById("airc_name_i");
    const airc_capacity_i = document.getElementById("airc_capacity_i");
    const airc_range_i = document.getElementById("airc_range_i");
    const airp_code_i = document.getElementById("airp_code_i");
    const insert_btn = document.getElementById("insert_btn");
    document.getElementById("insert_btn").addEventListener("click",function(){
        var airc_code_i_val = airc_code_i.value.trim();
        var airc_name_i_val = airc_name_i.value.trim();
        var airc_capacity_i_val = airc_capacity_i.value.trim();
        var airc_range_i_val = airc_range_i.value.trim();
        var airp_code_i_val = airp_code_i.value.trim();
        var insert_btn_val = insert_btn.value;
        $.ajax({    
            data: {airc_code_i:airc_code_i_val,airc_name_i:airc_name_i_val,airc_capacity_i:airc_capacity_i_val,airc_range_i:airc_range_i_val,airp_code_i:airp_code_i_val,insert_btn:insert_btn_val},
            type: "GET",
            url: "./php/form3.php",
            dataType: 'html',            
            success: function(data){                 
                alert(data);
                window.location.reload();
            }
        })
    });

    // Delete
    const airc_code_d = document.getElementById("airc_code_d");
    const delete_btn = document.getElementById("delete_btn");
    document.getElementById("delete_btn").addEventListener("click",function(){
        var airc_code_d_val = airc_code_d.value.trim();
        var delete_btn_val = delete_btn.value;
        $.ajax({    
            data: {airc_code_d:airc_code_d_val,delete_btn:delete_btn_val},
            type: "GET",
            url: "./php/form3.php",
            dataType: 'html',            
            success: function(data){                 
                alert(data);
            }
        })
    });

    // Search
    const airc_code_s = document.getElementById("airc_code_s");
    const search_btn = document.getElementById("search_btn");
    const data_search = document.getElementById('data_search');
    document.getElementById("search_btn").addEventListener("click",function(){
        var airc_code_s_val = airc_code_s.value.trim();
        var search_btn_val = search_btn.value;
        $.ajax({    
            data: {airc_code_s:airc_code_s_val,search_btn:search_btn_val},
            type: "GET",
            url: "./php/form3.php",
            dataType: 'html',            
            success: function(data){                 
                data_search.innerHTML = data;
            }
        })
    });

    // Edit
    const airc_code_e = document.getElementById("airc_code_e");
    const airc_name_e = document.getElementById("airc_name_e");
    const airc_capacity_e = document.getElementById("airc_capacity_e");
    const airc_range_e = document.getElementById("airc_range_e");
    const airp_code_e = document.getElementById("airp_code_e");
    const edit_btn = document.getElementById("edit_btn");
    document.getElementById("edit_btn").addEventListener("click",function(){
        var airc_code_e_val = airc_code_e.value.trim();
        var airc_name_e_val = airc_name_e.value.trim();
        var airc_capacity_e_val = airc_capacity_e.value.trim();
        var airc_range_e_val = airc_range_e.value.trim();
        var airp_code_e_val = airp_code_e.value.trim();
        var edit_btn_val = edit_btn.value;
        $.ajax({    
            data: {airc_code_e:airc_code_e_val,airc_name_e:airc_name_e_val,airc_capacity_e:airc_capacity_e_val,airc_range_e:airc_range_e_val,airp_code_e:airp_code_e_val,edit_btn:edit_btn_val},
            type: "GET",
            url: "./php/form3.php",
            dataType: 'html',            
            success: function(data){                 
                alert(data);
            }
        })
    });
});