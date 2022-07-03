package cc.robotdreams.my.hw;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by asvidersky on 7/3/2022.
 */

public class DBConnection {
    private static DBConnection instance;
    private final Connection dbConnection;
    private final String dbUrl;
    private final String dbUser;
    private static final Logger log = LogManager.getLogger(DBConnection.class);

    private DBConnection(String url, String dbUser, String dbPassword) throws SQLException {
        this.dbConnection = DriverManager.getConnection(url, dbUser, dbPassword);
        this.dbUrl = url;
        this.dbUser = dbUser;
    }

    public static DBConnection getInstance(String url, String dbUser, String dbPassword) throws SQLException {
        if (instance == null) {
            instance = new DBConnection(url, dbUser, dbPassword);
        } else if (!instance.dbUrl.equals(url)) {
            instance = new DBConnection(url, dbUser, dbPassword);
        } else if (!instance.dbUser.equals(dbUser)) {
            log.warn("Connection is open with different credentials");
        }
        return instance;
    }

    public static void closeConnection() throws SQLException {
        if (instance != null) {
            instance.getConnection().close();
        }
    }

    public Connection getConnection() {
        return this.dbConnection;
    }
}

