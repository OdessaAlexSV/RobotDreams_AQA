package cc.robotdreams.my.hw;

import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by asvidersky on 7/2/2022.
 */

public class DBTest extends BaseTest {

    @Test
    public void testCreateDB() {
        String dbAddress = "jdbc:postgresql://localhost:4567/";
        String dbUser = "postgres";
        String dbPassword = "alex";

        String sqlPattern = "CREATE DATABASE STUDENTS";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = getConnection(dbAddress, dbUser, dbPassword).prepareStatement(
                    sqlPattern
            );
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testCreateTable() throws SQLException {
        String dbAddress = "jdbc:postgresql://localhost:4567/students";
        String dbUser = "postgres";
        String dbPassword = "alex";

        Statement sqlStatement = getConnection(dbAddress, dbUser, dbPassword).createStatement();

        int resultSet = sqlStatement.executeUpdate("CREATE TABLE IF NOT EXISTS accounts " +
                "(user_id serial PRIMARY KEY," +
                "username VARCHAR ( 50 ) UNIQUE NOT NULL," +
                "password VARCHAR ( 50 ) NOT NULL," +
                "email VARCHAR ( 255 ) UNIQUE NOT NULL);"
        );

        System.out.println(resultSet);

        ResultSet resultSet2 = sqlStatement.executeQuery("SELECT * FROM accounts;");
        //    ResultSet resultSet3 = sqlStatement.executeQuery("SELECT count(*) FROM student;");


        while (resultSet2.next()) {
            System.out.printf("%s %s %s \n", resultSet2.getInt("user_id"), resultSet2.getString(2), resultSet2.getString(3));
        }


        /*
        resultSet2.next();
        System.out.println(resultSet2.getInt(1));

        String sqlPattern = "SELECT * FROM student WHERE first_name=? AND last_name=?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sqlPattern);
        preparedStatement.setString(1, "Stepan");
        preparedStatement.setString(2, "Petrenko");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.printf("Student's name is %s \n", resultSet.getString("first_name"));
        }

        preparedStatement.setString(1, "Mykola");
        preparedStatement.setString(2, "Sydorenko");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.printf("Student's name is %s %s\n", resultSet.getString("first_name"), resultSet.getString("id"));
        }
   */

//        String sqlPattern = "SELECT * FROM student WHERE id <?";
//        PreparedStatement preparedStatement = getConnection().prepareStatement(
//                sqlPattern,
//                ResultSet.TYPE_FORWARD_ONLY,
//                ResultSet.CONCUR_UPDATABLE
//        );
//        preparedStatement.setInt(1, 10);
//
//        ResultSet rs = preparedStatement.executeQuery();
//
//        rs.next();
//        rs.updateString(3, "Blah");
//        rs.updateRow();

    }

}