<?php
    // Import credentials
    require_once 'credent.php'; 

    // Connect with db
    $connecionstr="host=".DB_SERVER." port=5432 dbname=".DB_BASE." user=".DB_USER." password=".DB_PASS." options='--client_encoding=UTF8'";
    $dbconn = pg_connect($connecionstr);
    if (!$dbconn) {
        die("Connection failed!");
    } 

    // Search
    if (isset($_GET['search_btn']) && $_GET['search_btn']==='Αναζήτηση') {
        $date_user = $_GET['date_user'];
        $sql = "SELECT
                    airp.airp_city
                FROM 
                    flight_date AS fl_d
                INNER JOIN 
                    flight AS fl 
                ON
                    fl_d.fl_code = fl.fl_code
                INNER JOIN 
                    airport AS airp 
                ON
                    fl.arr_airp_code = airp.airp_code
                WHERE
                    (SELECT date_part('year', fl_d.fl_date)) = $date_user
                GROUP BY
                    airp.airp_city
                ORDER BY
                    COUNT(fl_d.fl_code) DESC
                LIMIT 
                    5";
        $select = pg_query($dbconn, $sql);
        if (pg_fetch_row($select) != 0) {
            echo "<table style='border:1px solid black'>";
            echo "<tr>
                    <th>Πόλη</th>
                 </tr>";
            $select = pg_query($dbconn, $sql);
            while($row = pg_fetch_array($select)) {
                echo "<tr>
                        <td>".$row['airp_city']."</td>
                     </tr>";
            }
            echo "</table>";
        } else {
            echo "<div class='error_creds'>";
            echo "Κανείς δεν ταξίδεψε αυτό το έτος. Παρακαλώ εισήγαγε άλλο έτος.";
            echo "</div>";
        }
    }

    // Disconnect from db
    pg_close($dbconn);
?>