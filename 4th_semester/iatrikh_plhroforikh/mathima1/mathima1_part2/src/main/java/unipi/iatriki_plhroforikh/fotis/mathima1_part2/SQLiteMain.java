package unipi.iatriki_plhroforikh.fotis.mathima1_part2;

import java.sql.*;

public class SQLiteMain {
    public static void main(String[] args) {
        createTableAndInsertData();
    }

    // Connect with SQLite DB with use Maven Build System
    private static Connection connect(){
        String connectionString = "jdbc:sqlite:unipi.db";
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
                            "student_id TEXT primary key," +
                            "username TEXT UNIQUE," +
                            "password TEXT" +
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


    // Select Students Ids with Use Form
    public static StringBuilder selectStudentIds(){
        StringBuilder students = new StringBuilder();
        try {
            Connection connection = connect();
            Statement statement = connection.createStatement();
            String selectSQL = "SELECT student_id FROM Students";
            ResultSet resultSet = statement.executeQuery(selectSQL);
            while (resultSet.next()){
                students.append(resultSet.getString("student_id") + " | ");
            }
            statement.close();
            connection.close();
            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Login with Use Form
    public static boolean login(String username,String password){
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
