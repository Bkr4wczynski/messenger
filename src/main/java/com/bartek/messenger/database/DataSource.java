package com.bartek.messenger.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {
    private static HikariConfig CONFIG = new HikariConfig();
    private static HikariDataSource DATA_SOURCE;

    static {
        CONFIG.setJdbcUrl("jdbc:mysql://localhost:3306/messengerDB");
        CONFIG.setUsername("root");
        CONFIG.setPassword("SepptillioN21_SQL");
        CONFIG.addDataSourceProperty("cachePrepStmts" , "true");
        CONFIG.addDataSourceProperty("prepStmtCacheSize" , "250");
        CONFIG.addDataSourceProperty("prepStmtCacheSqlLimit" , "2048");
        DATA_SOURCE = new HikariDataSource(CONFIG);
    }

    private DataSource() {}

    public static Connection getConnection() throws SQLException {
        return DATA_SOURCE.getConnection();
    }
    public static void closeConnection() throws SQLException {
        DATA_SOURCE.getConnection().close();
        DATA_SOURCE.close();
    }
}
