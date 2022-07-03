package cc.robotdreams.my;

import cc.robortdreams.my.Student;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by asvidersky on 7/1/2022.
 */

public class DataProviders {
    @DataProvider(name = "students % test data")
    public static Object[][] getTestData() {
        return new Object[][]{
                {new Student("Maria", "Kornienko", 50, "student_1"), "Graduated"},
//                {5, "Daycare"},
//                {20, "Student"},
        };
    }


    @DataProvider(name = "student data from CSV")
    public static Object[][] getStudentDataFromCsv() {
        URL fileUrl = DataProviders.class.getClassLoader().getResource("student_data.csv");
        if (fileUrl == null) {
            System.out.println("Failed to find resource");
            return new Object[0][];
        }

        try (CSVReader csvReader = new CSVReader(new FileReader(fileUrl.getPath()))) {
            List<String[]> r = csvReader.readAll();
            return r.toArray(new Object[r.size()][]);
        } catch (FileNotFoundException fileNotFoundEx) {
            System.out.println("Failed to find file " + fileNotFoundEx.getMessage());
        } catch (CsvException csvEx) {
            System.out.println("Failed to read CSV " + csvEx.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Object[0][];
    }
}
