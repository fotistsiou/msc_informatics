package unipi.iatriki_plhroforikh.fotis.mathima1_part4;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class DBController {

    public static void main(String[] args) {
        SpringApplication.run(DBController.class, args);
    }
    private static String url = "jdbc:sqlite:src/main/resources/DB/covid.db";

    @PostMapping("/newCase")
    public Map<String,String> createCase(@RequestBody Map<String,String> body){
        int id = Integer.parseInt(body.get("id"));
        String patientName = body.get("patientName");
        int age = Integer.parseInt(body.get("age"));
        String hospital = body.get("hospital");
        String description = body.get("description");
        String insertSQL = "INSERT INTO CovidCase values(?,?,?,?,?)";
        String result = null;
        try {
            Connection connection = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,patientName);
            preparedStatement.setInt(3,age);
            preparedStatement.setString(4,hospital);
            preparedStatement.setString(5,description);
            if(preparedStatement.executeUpdate()>0){
                result = "Success";
            }else {
                result = "Fail";
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Map<String,String> jsonMessage = new HashMap<>();
        jsonMessage.put("Message from DB",result);
        return jsonMessage;
    }

    @RequestMapping("/allCases")
    public String readAllCases(){
        String selectSQL = "SELECT * FROM CovidCase";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSQL);
            while (resultSet.next()){
                 stringBuilder
                        .append(resultSet.getInt("id"))
                        .append(",")
                        .append(resultSet.getString("patientName"))
                        .append(",")
                        .append(resultSet.getInt("age"))
                        .append(",")
                        .append(resultSet.getString("hospital"))
                        .append(",")
                        .append(resultSet.getString("description"))
                        .append(" | ");
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    @GetMapping("/case/{id}")
    public CovidCase readCase(@PathVariable Integer id){
        String selectSQL = "SELECT * FROM CovidCase WHERE id=?";
        CovidCase covidCase = new CovidCase();
        try {
            Connection connection = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                covidCase.setId(resultSet.getInt("id"));
                covidCase.setPatientName(resultSet.getString("patientName"));
                covidCase.setAge(resultSet.getInt("age"));
                covidCase.setHospital(resultSet.getString("hospital"));
                covidCase.setDescription(resultSet.getString("description"));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return covidCase;
    }

    @PostMapping("/updateCase")
    public Map<String,String> updateCase(@RequestBody Map<String,String> body) {
        int id = Integer.parseInt(body.get("id"));
        String patientName = body.get("patientName");
        int age = Integer.parseInt(body.get("age"));
        String hospital = body.get("hospital");
        String description = body.get("description");
        String updateSQL = "UPDATE CovidCase SET patientName=?, age=?, hospital=?, description=? WHERE id=?";
        String result = null;
        try {
            Connection connection = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setString(1,patientName);
            preparedStatement.setInt(2,age);
            preparedStatement.setString(3,hospital);
            preparedStatement.setString(4,description);
            preparedStatement.setInt(5,id);
            if(preparedStatement.executeUpdate()>0){
                result = "Success";
            }else {
                result = "Fail";
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Map<String,String> jsonMessage = new HashMap<>();
        jsonMessage.put("Update Patient",result);
        return jsonMessage;
    }

    @GetMapping("/deleteCase/{id}")
    public Map<String,String> deleteCase(@PathVariable Integer id){
        String selectSQL = "DELETE FROM CovidCase WHERE id=?";
        String result = null;
        try {
            Connection connection = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1,id);
            if(preparedStatement.executeUpdate()>0){
                result = "Success";
            }else {
                result = "Fail";
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Map<String,String> jsonMessage = new HashMap<>();
        jsonMessage.put("Delete Patient",result);
        return jsonMessage;
    }
}


