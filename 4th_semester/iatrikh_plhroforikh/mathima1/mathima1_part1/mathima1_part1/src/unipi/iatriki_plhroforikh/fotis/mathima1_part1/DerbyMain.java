package unipi.iatriki_plhroforikh.fotis.mathima1_part1;

import java.sql.*;

public class DerbyMain {
    public static void main(String[] args) {
        createTableAndInsertData();
        selectAll();
        System.out.println(login("fotis_21003","12345"));
    }

    // Connect with Derby DB with Use External Library
    private static Connection connect(){
        String connectionString = "jdbc:derby:unipi;create=true";
        try {
            Connection connection = DriverManager.getConnection(connectionString);
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // Create Table and Insert Data
    private static void createTableAndInsertData(){
        try {
            // Create Connection and Statement
            Connection connection = connect();
            Statement statement = connection.createStatement();

            // Create Table
            String createTable =
                    "Create Table Students (" +
                    "student_id Varchar(30) primary key," +
                    "username Varchar(30) UNIQUE," +
                    "password Varchar(30)" +
                    ")";
            statement.execute(createTable);

            // Insert Data
            String insertStudent_1 = "Insert into Students Values('mppl21001','rafailia_21001','12345')";
            String insertStudent_2 = "Insert into Students Values('mppl21002','aspa_21002','12345')";
            String insertStudent_3 = "Insert into Students Values('mppl21003','fotis_21003','12345')";
            statement.executeUpdate(insertStudent_1);
            statement.executeUpdate(insertStudent_2);
            statement.executeUpdate(insertStudent_3);

            // Close Statement and Connection
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // Select All Data
    private static void selectAll(){
        try {
            Connection connection = connect();
            Statement statement = connection.createStatement();
            String selectSQL = "SELECT * FROM Students";
            ResultSet resultSet = statement.executeQuery(selectSQL);
            while (resultSet.next()){
                System.out.println(resultSet.getString("student_id"));
                System.out.println(resultSet.getString("username")+"\n");
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Login
    private static boolean login(String username,String password){
        try {
            Connection connection = connect();
            String selectSQL = "SELECT * FROM Students WHERE username=? AND password=?";
            PreparedStatement preparedStatement = connect().prepareStatement(selectSQL);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                preparedStatement.close();
                connection.close();
                return true;
            }else {
                preparedStatement.close();
                connection.close();
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}