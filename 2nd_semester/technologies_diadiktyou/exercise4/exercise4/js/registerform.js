window.addEventListener('load', (event) => {
    /* Submit Section */
    // Select elements
    var count = 0;
    const name_customer = document.getElementById("name_customer");
    const address = document.getElementById("address");
    const country = document.getElementById("country");
    const zip_code = document.getElementById("zip_code");
    const email_customer = document.getElementById("email_customer");
    const tel_customer = document.getElementById("tel_customer");
    const card_number = document.getElementById("card_number");
    const card_type = document.getElementById("card_type");
    const button_submit = document.getElementById("submit_btn");
    // Create functions about validations of input elements
    function checkNameCustomer() {
        const name_customer_value = name_customer.value.trim(); 
        if (/^[a-zA-Z]+$/.test(name_customer_value)) {
            name_customer.className = "success";
            document.getElementById("errors_name").innerText="";
            count++;
        } else {
            name_customer.className = "error";
            document.getElementById("errors_name").innerText="Only english characters without spaces.";
        }
    }
    function checkAddress() {
        const address_value = address.value.trim(); 
        if (/^[a-zA-Z]+$/.test(address_value)) {
            address.className = "success";
            document.getElementById("errors_address").innerText="";
            count++;
        } else {
            address.className = "error";
            document.getElementById("errors_address").innerText="Only english characters without spaces.";
        }
    }
    function checkZipCode() {
        const zip_code_value = zip_code.value.trim(); 
        if (/^[0-9]+$/.test(zip_code_value)) {
            zip_code.className = "success";
            document.getElementById("errors_zip").innerText="";
            count++;
        } else {
            zip_code.className = "error";
            document.getElementById("errors_zip").innerText="Only digits and until 5.";
        }
    }
    function checkEmailCustomer() {
        const email_customer_value = email_customer.value.trim(); 
        if (/^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/.test(email_customer_value)) {
            email_customer.className = "success";
            document.getElementById("errors_email").innerText="";
            count++;
        } else {
            email_customer.className = "error";
            document.getElementById("errors_email").innerText="ex: test@test.com";
        }
    }
    function checkTelCustomer() {
        const tel_customer_value = tel_customer.value.trim(); 
        if (/^\+[0-9]{2}\-[0-9]{10}$/.test(tel_customer_value)) {
            tel_customer.className = "success";
            document.getElementById("errors_tel").innerText="";
            count++;
        } else {
            tel_customer.className = "error";
            document.getElementById("errors_tel").innerText="Start with '+' and the 2 digits of your country code, \nthen enter '-' and finally 10 digits. \nEx. '+30-2101234567'.";
        }
    }
    function checkCardNumber() {
        const card_number_value = card_number.value.trim(); 
        if (/^[0-9]{16}$/.test(card_number_value)) {
            card_number.className = "success";
            document.getElementById("errors_card").innerText="";
            count++;
        } else {
            card_number.className = "error";
            document.getElementById("errors_card").innerText="Only digits and exactly 16 digits.";
        }
    }
    // Run validation functions and send the data to connect.php
    document.getElementById("submit_btn").addEventListener("click",function(){
        checkNameCustomer();
        checkAddress();
        checkZipCode();
        checkEmailCustomer();
        checkTelCustomer();
        checkCardNumber();
        var name_val = name_customer.value.trim();
        var address_val = address.value.trim();
        var country_val = country.value.trim();
        var zip_val = zip_code.value.trim();
        var email_val = email_customer.value.trim();
        var tel_val = tel_customer.value.trim();
        var card_number_val = card_number.value.trim();
        var card_type_val = card_type.value.trim();
        var button_submit_val = button_submit.value;
        setTimeout(() => {
            if (count >= 6) {
                $.ajax({
                    data: {name:name_val,address:address_val,country:country_val,zip:zip_val,email:email_val,tel:tel_val,card_number:card_number_val,card_type:card_type_val,button_submit:button_submit_val},
                    type: "POST",
                    url:"./connect.php",
                    dataType: 'html',
                    success: function(data){
                        alert("Data Submited!!");
                    }
                });
            }
        }, 1000);
    });

    /* Search Section */
    // Select elements
    const email_user = document.getElementById("email_user");
    const data_search = document.getElementById('data_search');
    const button_search = document.getElementById("search_btn");
    // Send and fetch data from connect.php
    document.getElementById("search_btn").addEventListener("click",function(){
        var email_user_val = email_user.value.trim();
        var button_search_val = button_search.value;
        $.ajax({    
            data: {email_user:email_user_val,button_search:button_search_val},
            type: "GET",
            url: "./connect.php",
            dataType: 'html',            
            success: function(data){                 
                data_search.innerHTML = data;
            }
        })
    });

});