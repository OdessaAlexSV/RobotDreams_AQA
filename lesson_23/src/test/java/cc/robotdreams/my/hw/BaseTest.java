package cc.robotdreams.my.hw;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by asvidersky on 7/2/2022.
 */

public class BaseTest {
    String dbAddressServ = "jdbc:postgresql://localhost:4567/";
    String dbAddressDB = "jdbc:postgresql://localhost:4567/r_d_students";
    String dbUser = "postgres";
    String dbPassword = "alex";

    private static final Logger log = LogManager.getLogger(BaseTest.class);

    protected Connection getConnectionServer()  {
        try {
            return DBConnection.getInstance(dbAddressServ,dbUser,dbPassword).getConnection();
        } catch (SQLException e) {
            log.error("Failed to get connection {}", e.getMessage());
        }
        return null;
    }

    protected Connection getConnectionDB() throws SQLException {
        return DBConnection.getInstance(dbAddressDB,dbUser,dbPassword).getConnection();
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
