package dataproviders;

import cc.robotdreams.my.hw.Man;
import cc.robotdreams.my.hw.Woman;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by asvidersky on 6/24/2022.
 */

public class ManClassDataProviderLoadDataFromCSV {

    static String pathToCSV = "D:\\Personal\\Devel\\RobotDreams_AQA\\lesson_21 [DataDrivenTest]\\src\\main\\resources\\MenTestData.csv";

    @DataProvider(name = "Constructor Method test data")
    public static Object[][] getTestDataConstructor() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(pathToCSV));
        Object[][] data = new Object[lines.size() - 1][1];
        for (int i = 0; i < lines.size() - 1; i++) {
            String[] splitLine = lines.get(i + 1).split(",");
            data[i][0] = new Man(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2].trim()), Boolean.parseBoolean(splitLine[3]));
        }
        return data;
    }

    @DataProvider(name = "Getter First Name test data")
    public static Object[][] getTestDataFirstName() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(pathToCSV));
        Object[][] data = new Object[lines.size() - 1][2];
        for (int i = 0; i < lines.size() - 1; i++) {
            String[] splitLine = lines.get(i + 1).split(",");
            Man man = new Man(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2].trim()), Boolean.parseBoolean(splitLine[3]));
            String firstName = splitLine[0];
            data[i][0] = man;
            data[i][1] = firstName;
        }
        return data;
    }

    @DataProvider(name = "Getter Last Name test data")
    public static Object[][] getTestDataLastName() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(pathToCSV));
        Object[][] data = new Object[lines.size() - 1][2];
        for (int i = 0; i < lines.size() - 1; i++) {
            String[] splitLine = lines.get(i + 1).split(",");
            Man man = new Man(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2].trim()), Boolean.parseBoolean(splitLine[3]));
            String lastName = splitLine[1];
            data[i][0] = man;
            data[i][1] = lastName;
        }
        return data;
    }

    @DataProvider(name = "Getter Age test data")
    public static Object[][] getTestDataAge() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(pathToCSV));
        Object[][] data = new Object[lines.size() - 1][2];
        for (int i = 0; i < lines.size() - 1; i++) {
            String[] splitLine = lines.get(i + 1).split(",");
            Man man = new Man(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2].trim()), Boolean.parseBoolean(splitLine[3]));
            int age = Integer.parseInt(splitLine[2].trim());
            data[i][0] = man;
            data[i][1] = age;
        }
        return data;
    }

    @DataProvider(name = "Getter IsServedArmy test data")
    public static Object[][] IsServedArmy() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(pathToCSV));
        Object[][] data = new Object[lines.size() - 1][2];
        for (int i = 0; i < lines.size() - 1; i++) {
            String[] splitLine = lines.get(i + 1).split(",");
            Man man = new Man(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2].trim()), Boolean.parseBoolean(splitLine[3]));
            boolean isServedArmy = Boolean.parseBoolean(splitLine[3]);
            data[i][0] = man;
            data[i][1] = isServedArmy;
        }
        return data;
    }

    @DataProvider(name = "IsRetried test data")
    public static Object[][] IsRetried() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(pathToCSV));
        Object[][] data = new Object[lines.size() - 1][2];
        for (int i = 0; i < lines.size() - 1; i++) {
            String[] splitLine = lines.get(i + 1).split(",");
            Man man = new Man(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2].trim()), Boolean.parseBoolean(splitLine[3]));
            data[i][0] = man;
            if (Integer.parseInt(splitLine[2].trim()) > 65) {
                data[i][1] = true;
            } else {
                data[i][1] = false;
            }
        }
        return data;
    }

    @DataProvider(name = "RegisterPartnership")
    public static Object[][] RegisterPartnership() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(pathToCSV));
        Object[][] data = new Object[lines.size() - 1][2];
        for (int i = 0; i < lines.size() - 1; i++) {
            String[] splitLine = lines.get(i + 1).split(",");
            Man man = new Man(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2].trim()), Boolean.parseBoolean(splitLine[3]));
            data[i][0] = man;
            data[i][1] = new Woman("Mary", "Petrova", 31, "Petrova");
        }
        return data;
    }
}

