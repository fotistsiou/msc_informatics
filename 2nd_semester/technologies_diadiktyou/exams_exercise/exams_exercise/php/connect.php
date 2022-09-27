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
        $pass=$_POST['pass'];
        $sql = "INSERT INTO fotis_airlines(name_customer, address, country, zip_code, email_customer, tel_customer, card_number, card_type, pass_customer) VALUES ('".$name."','".$address."','".$country."','".$zip."','".$email."','".$tel."','".$card_number."','".$card_type."','".$pass."') ";
        $insert_data = pg_query($dbconn, $sql);
        if($insert_data) {
            echo"DATA SAVED!";
        } else{
            echo"DATA NOT SAVED... <br>";
            die('Query failed: ' . pg_last_error());
        }
    } 

    // Select a row from the db and create table with these
    if (isset($_GET['button_search']) && $_GET['button_search']==='Search') {
        $email_user=$_GET['email_user'];
        $pass_user=$_GET['pass_user'];
        $sql_2 = "SELECT * FROM fotis_airlines WHERE email_customer='".$email_user."' AND pass_customer='".$pass_user."'";
        $select = pg_query($dbconn, $sql_2);
        if (pg_fetch_row($select) != 0) {
            echo "<table style='border:1px solid black'>";
            echo "<tr>
                    <th>Email</th>
                    <th>Username</th>
                    <th>Address</th>
                    <th>Country</th>
                    <th>Zip Code</th>
                    <th>Telephone</th>
                    <th>Card Number</th>
                    <th>Card Type</th>
                 </tr>";
            $select = pg_query($dbconn, $sql_2);
            while($row = pg_fetch_array($select)) {
                echo "<tr>
                        <td>".$row['email_customer']."</td>"."
                        <td>".$row['name_customer']."</td>"."
                        <td>".$row['address']."</td>"."
                        <td>".$row['country']."</td>"."
                        <td>".$row['zip_code']."</td>"."
                        <td>".$row['tel_customer']."</td>"."
                        <td>".$row['card_number']."</td>"."
                        <td>".$row['card_type']."</td>
                     </tr>";
            }
            echo "</table>";
        } else {
            echo "<div class='error_creds'>";
            echo "Your credentials are not exist or are wrong. Please try again.";
            echo "</div>";
        }
    }

    // Disconnect from db
    pg_close($dbconn);
?>