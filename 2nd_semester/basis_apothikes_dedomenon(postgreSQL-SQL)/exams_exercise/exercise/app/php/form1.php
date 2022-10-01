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
        $date = strtotime($date_user  .' -1 day');
        $pre_date = date('d/m/Y', $date);
        $sql = "SELECT 
                    tf.t_pass_fname, tf.t_pass_lname, cast(b.book_date AS DATE) 
                FROM 
                    ticket_flight AS tf
                INNER JOIN 
                    ticket AS ti 
                ON
                    tf.t_no = ti.t_no
                INNER JOIN 
                    book AS b 
                ON
                    ti.book_ref = b.book_ref
                WHERE 
                    tf.fl_code = '16aghzXbPp' AND tf.t_fl_date ='".$pre_date."'";
        $select = pg_query($dbconn, $sql);
        if (pg_fetch_row($select) != 0) {
            echo "<table style='border:1px solid black'>";
            echo "<tr>
                    <th>Όνομα</th>
                    <th>Επίθετο</th>
                    <th>Book Date</th>
                 </tr>";
            $select = pg_query($dbconn, $sql);
            while($row = pg_fetch_array($select)) {
                echo "<tr>
                        <td>".$row['t_pass_fname']."</td>"."
                        <td>".$row['t_pass_lname']."</td>"."
                        <td>".$row['book_date']."</td>
                     </tr>";
            }
            echo "</table>";
        } else {
            echo "<div class='error_creds'>";
            echo "Κανείς δεν ταξίδεψε την προηγούμενη αυτής της ημερομηνίας. Παρακαλώ εισήγαγε άλλη ημερομηνία.";
            echo "</div>";
        }
    }

    // Disconnect from db
    pg_close($dbconn);
?>