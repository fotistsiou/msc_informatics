window.addEventListener('load', (event) => {
    var count = 0;
    
    const name_customer = document.getElementById("name_customer");
    const address = document.getElementById("address");
    const zip_code = document.getElementById("zip_code");
    const email_customer = document.getElementById("email_customer");
    const tel_customer = document.getElementById("tel_customer");
    const card_number = document.getElementById("card_number");

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

    document.getElementById("submit").addEventListener("click",function(){
        checkNameCustomer();
        checkAddress();
        checkZipCode();
        checkEmailCustomer();
        checkTelCustomer();
        checkCardNumber();
        setTimeout(() => {
            if (count >= 6) {
                confirm("Congratulations for your registration! Now, you will redirect to home page!")
                document.location.href="index.html";
            }
        }, 1000);
    });

});