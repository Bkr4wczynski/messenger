package com.bartek.messenger.database;

import com.bartek.messenger.dataRepresentation.Gender;
import com.bartek.messenger.dataRepresentation.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MessengerDatabaseDAO implements AutoCloseable{
    Connection connection;

    public void openConnection(){
        try {
            connection = DataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void closeConnection(){
        try {
            DataSource.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void getUsers(){
        String query = "SELECT * FROM users";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                // here you have to get them out
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean addNewUserToDatabase(String username, String password, Gender gender){
        String query = "INSERT INTO users (username, password, gender) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, gender.name());
            int result;
            try {
                result = preparedStatement.executeUpdate();
            }
            catch (Exception e){
                System.out.println("There was an error: "+e);
                return false;
            }
            if (result == 1){
                System.out.println("Successfully added new user to database!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
    public boolean loginUser(String username, String password){
        String query = "SELECT COUNT(*) = 1 AND a.password = ? FROM (SELECT username, password FROM users WHERE username = ?) AS a;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            boolean result = resultSet.getBoolean(1);
            resultSet.close();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public User getUser(String username){
        String query = "SELECT * FROM users WHERE username = ?";
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user = new User(resultSet.getInt(1),
                    resultSet.getString(2), Gender.valueOf(resultSet.getString(4)),
                    LocalDate.now());
            // implement datetime
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public void close() throws Exception {
        closeConnection();
    }
}
