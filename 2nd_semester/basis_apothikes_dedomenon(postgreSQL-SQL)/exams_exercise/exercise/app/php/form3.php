<?php
    // Import credentials
    require_once 'credent.php'; 

    // Connect with db
    $connecionstr="host=".DB_SERVER." port=5432 dbname=".DB_BASE." user=".DB_USER." password=".DB_PASS." options='--client_encoding=UTF8'";
    $dbconn = pg_connect($connecionstr);
    if (!$dbconn) {
        die("Connection failed!");
    } 

    // Insert
    if (isset($_GET['insert_btn']) && $_GET['insert_btn']==='Εισαγωγή') {
        $airc_code_i=$_GET['airc_code_i'];
        $airc_name_i=$_GET['airc_name_i'];
        $airc_capacity_i=$_GET['airc_capacity_i'];
        $airc_range_i=$_GET['airc_range_i'];
        $airp_code_i=$_GET['airp_code_i'];
        $sql = "INSERT INTO aircraft(airc_code, airc_name, airc_capacity, airc_range, airp_code) VALUES ('".$airc_code_i."','".$airc_name_i."','".$airc_capacity_i."','".$airc_range_i."','".$airp_code_i."') ";
        $insert_data = pg_query($dbconn, $sql);
        if($insert_data) {
            echo"Το αεροσκάφος αποθηκεύτηκε!";
        } else{
            echo"Το αεροσκάφος δεν αποθηκεύτηκε... <br>";
            die('Query failed: ' . pg_last_error());
        }
    }

    // Delete
    if (isset($_GET['delete_btn']) && $_GET['delete_btn']==='Διαγραφή') {
        $airc_code_d=$_GET['airc_code_d'];
        $sql = "DELETE FROM aircraft WHERE airc_code='".$airc_code_d."'";
        $insert_data = pg_query($dbconn, $sql);
        if($insert_data) {
            echo"Το αεροσκάφος έχει διαγραφεί!";
        } else{
            echo"Το αεροσκάφος δεν έχει διαγραφεί... <br>";
            die('Query failed: ' . pg_last_error());
        }
    }

    // Search
    if (isset($_GET['search_btn']) && $_GET['search_btn']==='Αναζήτηση') {
        $airc_code_s=$_GET['airc_code_s'];
        $sql_2 = "SELECT * FROM aircraft WHERE airc_code='".$airc_code_s."'";
        $select = pg_query($dbconn, $sql_2);
        if (pg_fetch_row($select) != 0) {
            echo "<table style='border:1px solid black'>";
            echo "<tr>
                    <th>Aircraft Code</th>
                    <th>Aircraft Name</th>
                    <th>Aircraft Capacity</th>
                    <th>Aircraft Range</th>
                    <th>Airport Code</th>
                 </tr>";
            $select = pg_query($dbconn, $sql_2);
            while($row = pg_fetch_array($select)) {
                echo "<tr>
                        <td>".$row['airc_code']."</td>"."
                        <td>".$row['airc_name']."</td>"."
                        <td>".$row['airc_capacity']."</td>"."
                        <td>".$row['airc_range']."</td>"."
                        <td>".$row['airp_code']."</td>
                     </tr>";
            }
            echo "</table>";
        } else {
            echo "<div class='error_creds'>";
            echo "Λάθος κωδικός αεροσκάφους. Παρακαλώ δοκιμάστε ξανα.";
            echo "</div>";
        }
    }

    // Edit
    if (isset($_GET['edit_btn']) && $_GET['edit_btn']==='Επεξεργασία') {
        $airc_code_e=$_GET['airc_code_e'];
        $airc_name_e=$_GET['airc_name_e'];
        $airc_capacity_e=$_GET['airc_capacity_e'];
        $airc_range_e=$_GET['airc_range_e'];
        $airp_code_e=$_GET['airp_code_e'];
        $sql = "UPDATE aircraft SET airc_code='".$airc_code_e."', airc_name='".$airc_name_e."', airc_capacity='".$airc_capacity_e."', airc_range='".$airc_range_e."', airp_code='".$airp_code_e."' WHERE airc_code='".$airc_code_e."'";
        $insert_data = pg_query($dbconn, $sql);
        if($insert_data) {
            echo"Το αεροσκάφος έχει ενημερωθεί!";
        } else{
            echo"Το αεροσκάφος δεν έχει ενημερωθεί... <br>";
            die('Query failed: ' . pg_last_error());
        }
    }

    // Disconnect from db
    pg_close($dbconn);
?>