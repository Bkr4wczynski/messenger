package com.bartek.messenger.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
                System.out.println(resultSet.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        closeConnection();
    }
}