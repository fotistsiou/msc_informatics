<?php
    // Import credentials
    require_once 'credent.php'; 

    // Connect with db
    $connecionstr="host=".DB_SERVER." port=5432 dbname=".DB_BASE." user=".DB_USER." password=".DB_PASS." options='--client_encoding=UTF8'";
    $dbconn = pg_connect($connecionstr);
    if (!$dbconn) {
        die("Connection failed: ");
    } 

    // Check if the request is POST from 'button_submit' or GET from 'button_search'
    if (isset($_POST['button_submit']) && $_POST['button_submit']==='Submit') {
        // Insert a row on the db
        $name=$_POST['name'];
        $address=$_POST['address'];
        $country=$_POST['country'];
        $zip=$_POST['zip'];
        $email=$_POST['email'];
        $tel=$_POST['tel'];
        $card_number=$_POST['card_number'];
        $card_type=$_POST['card_type'];
        $sql = "INSERT INTO fotis_airlines(name_customer, address, country, zip_code, email_customer, tel_customer, card_number, card_type) VALUES ('".$name."','".$address."','".$country."','".$zip."','".$email."','".$tel."','".$card_number."','".$card_type."') ";
        $insert_data = pg_query($dbconn, $sql);
        if($insert_data) {
            echo"DATA SAVED!";
        } else{
            echo"DATA NOT SAVED... <br>";
            die('Query failed: ' . pg_last_error());
        }
    } elseif (isset($_GET['button_search']) && $_GET['button_search']==='Search') {
        // Select a row from the db and create table with these
        $email_user=$_GET['email_user'];
        $sql_2 = "SELECT * FROM fotis_airlines WHERE email_customer='".$email_user."'";
        $select = pg_query($dbconn, $sql_2);
        echo "<table style='border:1px solid black'>";
        echo "<tr><th>Username</th><th>Address</th><th>Country</th><th>Zip Code</th><th>Email</th><th>Telephone</th><th>Card Number</th><th>Card Type</th></tr>";
        while($row = pg_fetch_array($select)) {
            echo "<tr><td>".$row['name_customer']."</td>"."<td>".$row['address']."</td>"."<td>".$row['country']."</td>"."<td>".$row['zip_code']."</td>"."<td>".$row['email_customer']."</td>"."<td>".$row['tel_customer']."</td>"."<td>".$row['card_number']."</td>"."<td>".$row['card_type']."</td></tr>";
        }
        echo "</table>";
    }

    // Disconnect from db
    pg_close($dbconn);
?>