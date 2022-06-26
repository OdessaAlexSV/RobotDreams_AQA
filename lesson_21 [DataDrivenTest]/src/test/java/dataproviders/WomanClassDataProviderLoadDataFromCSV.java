package dataproviders;

import cc.robotdreams.my.hw.Man;
import cc.robotdreams.my.hw.Woman;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by asvidersky on 6/24/2022.
 */

public class WomanClassDataProviderLoadDataFromCSV {

    static String pathToCSV = "D:\\Personal\\Devel\\RobotDreams_AQA\\lesson_21 [DataDrivenTest]\\src\\main\\resources\\WomenTestData.csv";

    @DataProvider(name = "Constructor Method test data")
    public static Object[][] getTestDataConstructor() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(pathToCSV));
        Object[][] data = new Object[lines.size() - 1][1];
        for (int i = 0; i < lines.size() - 1; i++) {
            String[] splitLine = lines.get(i + 1).split(",");
            data[i][0] = new Woman(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2]), splitLine[3]);
        }
        return data;
    }

    @DataProvider(name = "Getter First Name test data")
    public static Object[][] getTestDataFirstName() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(pathToCSV));
        Object[][] data = new Object[lines.size() - 1][2];
        for (int i = 0; i < lines.size() - 1; i++) {
            String[] splitLine = lines.get(i + 1).split(",");
            Woman woman = new Woman(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2]), splitLine[3]);
            String firstName = splitLine[0];
            data[i][0] = woman;
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
            Woman woman = new Woman(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2]), splitLine[3]);
            String lastName = splitLine[1];
            data[i][0] = woman;
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
            Woman woman = new Woman(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2]), splitLine[3]);
            int age = Integer.parseInt(splitLine[2]);
            data[i][0] = woman;
            data[i][1] = age;
        }
        return data;
    }

    @DataProvider(name = "Getter Maiden Name test data")
    public static Object[][] getTestDataMaidenName() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(pathToCSV));
        Object[][] data = new Object[lines.size() - 1][2];
        for (int i = 0; i < lines.size() - 1; i++) {
            String[] splitLine = lines.get(i + 1).split(",");
            Woman woman = new Woman(splitLine[0],splitLine[1],Integer.parseInt(splitLine[2]),splitLine[3]);
            String maidenName = splitLine[3];
            data[i][0] = woman;
            data[i][1] = maidenName;
        }
        return data;
    }

    @DataProvider(name = "IsRetried test data")
    public static Object[][] IsRetried() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(pathToCSV));
        Object[][] data = new Object[lines.size() - 1][2];
        for (int i = 0; i < lines.size() - 1; i++) {
            String[] splitLine = lines.get(i + 1).split(",");
            Woman woman = new Woman(splitLine[0],splitLine[1],Integer.parseInt(splitLine[2]),splitLine[3]);
            data[i][0] = woman;
            if (Integer.parseInt(splitLine[2]) > 60) {
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
            Woman woman = new Woman(splitLine[0],splitLine[1],Integer.parseInt(splitLine[2]),splitLine[3]);
            Man man = new Man("Vlad", "Chub", 64, true);
            data[i][0] = man;
            data[i][1] = woman;
        }
        return data;
    }

    @DataProvider(name = "RegisterPartnershipTwoMarriage")
    public static Object[][] RegisterPartnershipTwoMarriage() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(pathToCSV));
        Object[][] data = new Object[lines.size() - 1][3];
        for (int i = 0; i < lines.size() - 1; i++) {
            String[] splitLine = lines.get(i + 1).split(",");
            Woman woman = new Woman(splitLine[0],splitLine[1],Integer.parseInt(splitLine[2]),splitLine[3]);
            Man man1 = new Man("Vlad", "Chub", 64, true);
            Man man2 = new Man("Petro", "Shur", 65, false);
            data[i][0] = man1;
            data[i][1] = man2;
            data[i][2] = woman;
        }
        return data;
    }

    @DataProvider(name = "RegisterPartnershipShouldTrowException")
    public static Object[][] RegisterPartnershipShouldTrowException() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(pathToCSV));
        Object[][] data = new Object[lines.size() - 1][3];
        for (int i = 0; i < lines.size() - 1; i++) {
            String[] splitLine = lines.get(i + 1).split(",");
            Man man = new Man("Vlad", "Chub", 64, true);
            Woman woman = new Woman(splitLine[0],splitLine[1],Integer.parseInt(splitLine[2]),splitLine[3]);
            Woman woman1 = new Woman("Aida", "Hell", 40, "Zlo");
            data[i][0] = man;
            data[i][1] = woman;
            data[i][2] = woman1;
        }
        return data;
    }

    @DataProvider(name = "DeregisterPartnership")
    public static Object[][] DeregisterPartnership() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(pathToCSV));
        Object[][] data = new Object[lines.size() - 1][3];
        for (int i = 0; i < lines.size() - 1; i++) {
            String[] splitLine = lines.get(i + 1).split(",");
            Man man = new Man("Vlad", "Chub", 64, true);
            Woman woman = new Woman(splitLine[0],splitLine[1],Integer.parseInt(splitLine[2]),splitLine[3]);
            boolean isDeregister = ThreadLocalRandom.current().nextBoolean();
            data[i][0] = man;
            data[i][1] = woman;
            data[i][2] = isDeregister;
        }
        return data;
    }
}