package cc.robotdreams.my.hw;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by asvidersky on 7/2/2022.
 */

public class BaseTest {


    private static final Logger log = LogManager.getLogger(BaseTest.class);

    protected Connection getConnection(String dbAddress, String dbUser, String dbPassword) throws SQLException {
        return DBConnection.getInstance(dbAddress,dbUser,dbPassword).getConnection();
    }

    @AfterSuite
    public void tearDown() {
        try {
            DBConnection.closeConnection();
        } catch (SQLException e) {
            log.error("Failed to close connection {}", e.getMessage());
        }
    }

}
