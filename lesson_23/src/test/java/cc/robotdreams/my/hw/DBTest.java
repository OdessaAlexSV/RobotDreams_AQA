package cc.robotdreams.my.hw;

import cc.robotdreams.my.hw.dataproviders.LoadDataFromCSV;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;

/**
 * Created by asvidersky on 7/3/2022.
 */

public class DBTest extends BaseTest {
    private PreparedStatement preparedStatement;
    private String sqlPattern;
    private ResultSet rs;
    private static final Logger log = LogManager.getLogger(DBTest.class);

    @Test
    public void testCreateDB() throws SQLException {
        sqlPattern = "CREATE DATABASE r_d_students";
        preparedStatement = getConnectionServer().prepareStatement(sqlPattern);
        try {
            preparedStatement.executeUpdate();
            log.info("DataBase 'r_d_students' has been created successfully...");
        } catch (SQLException e) {
            log.warn("DataBase 'r_d_students' already exist...");
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testCreateTable() throws SQLException {
        sqlPattern = "CREATE TABLE IF NOT EXISTS students" +
                "(user_id serial PRIMARY KEY," +
                "first_name VARCHAR ( 50 ) NOT NULL," +
                "last_name  VARCHAR ( 50 ) NOT NULL," +
                "email VARCHAR ( 255 ) UNIQUE NOT NULL);";
        preparedStatement = getConnectionDB().prepareStatement(sqlPattern);
        try {
            preparedStatement.executeUpdate();
            log.info("Table 'students' has been created successfully...");
        } catch (SQLException e) {
            log.error("Table 'students' has not been created...");
            e.printStackTrace();
        }
    }

    @Test(dataProvider = "Load test data", dataProviderClass = LoadDataFromCSV.class)
    public void testInsertDataIntoTable(String data, int countRec) throws SQLException {
        sqlPattern = "INSERT INTO students(user_id,first_name,last_name,email) VALUES (" + data + ")";
        preparedStatement = getConnectionDB().prepareStatement(sqlPattern);
        try {
            preparedStatement.executeUpdate();
            log.info("Student " + data + "has been added successfully...");
        } catch (SQLException e) {
            log.error("Student " + data + "has not been added...");
            e.printStackTrace();
        }

        sqlPattern = "SELECT count(*) FROM students";
        preparedStatement = getConnectionDB().prepareStatement(sqlPattern);
        rs = preparedStatement.executeQuery();
        rs.next();
        Assert.assertEquals(rs.getInt(1), countRec);
    }

    @Test
    public void testSelectDataFromTable() throws SQLException {
        sqlPattern = "SELECT * FROM students";
        preparedStatement = getConnectionDB().prepareStatement(sqlPattern);
        rs = preparedStatement.executeQuery();

        while (rs.next()) {
            System.out.printf("Student is : %d %s %s  \n", rs.getInt("user_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"));
        }
    }

    @Test
    public void testUpdateDataIntoTable() throws SQLException {
        sqlPattern = "UPDATE students SET first_name = 'ChangedName' WHERE user_id > 2";
        preparedStatement = getConnectionDB().prepareStatement(sqlPattern);

        try {
            preparedStatement.executeUpdate();
            log.info("First student with greater ID than 2 has been changed his First_Name successfully...");
        } catch (SQLException e) {
            log.error("First student with ID greater than 2 has not been changed his First_Name...");
            e.printStackTrace();
        }

        sqlPattern = "SELECT * FROM students";
        preparedStatement = getConnectionDB().prepareStatement(sqlPattern);
        rs = preparedStatement.executeQuery();
        while (rs.next()) {
            System.out.printf("Student is : %d %s %s  \n", rs.getInt("user_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"));
        }
    }

    @Test
    public void testUpdateDataIntoTableViaResultSet() throws SQLException {
        sqlPattern = "SELECT * FROM students WHERE user_id <?";
        preparedStatement = getConnectionDB().prepareStatement(
                sqlPattern,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_UPDATABLE);
        preparedStatement.setInt(1, 3);

        try {
            rs = preparedStatement.executeQuery();
            log.info("All students with ID less ID than 3 have been changed their Last_Name successfully...");

            while (rs.next()) {
                rs.updateString(3, "ChangedLastName");
                rs.updateRow();
            }
        } catch (SQLException e) {
            log.error("All students with ID less ID than 3 have not been changed their Last_Name...");
            e.printStackTrace();
        }

        sqlPattern = "SELECT * FROM students ORDER BY user_id ASC";
        preparedStatement = getConnectionDB().prepareStatement(sqlPattern);
        rs = preparedStatement.executeQuery();
        while (rs.next()) {
            System.out.printf("Student is : %d %s %s  \n", rs.getInt("user_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"));
        }
    }

    @Test(priority = 1)
    public void testDeleteRecordIntoTable() throws SQLException {
        sqlPattern = "DELETE FROM students WHERE user_id >?;";
        preparedStatement = getConnectionDB().prepareStatement(sqlPattern);
        preparedStatement.setInt(1, 2);
        preparedStatement.executeUpdate();

        sqlPattern = "SELECT count(*) FROM students";
        preparedStatement = getConnectionDB().prepareStatement(sqlPattern);
        rs = preparedStatement.executeQuery();
        rs.next();
        Assert.assertEquals(rs.getInt(1), 2);
    }

    @Test(priority = 2)
    public void testDropTable() throws SQLException {
        sqlPattern = "DROP TABLE IF EXISTS students";
        preparedStatement = getConnectionDB().prepareStatement(sqlPattern);

        try {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}