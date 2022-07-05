package cc.robotdreams.my.hw.dataproviders;

import cc.robotdreams.my.hw.DBTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by asvidersky on 6/24/2022.
 */

public class LoadDataFromCSV {
    private static final Logger log = LogManager.getLogger(DBTest.class);

    @DataProvider(name = "Load test data")
    public static Object[][] getTestData() throws IOException, URISyntaxException {
        URL fileUrl = DataProvider.class.getClassLoader().getResource("TestData.csv");
        if (fileUrl == null) {
            System.out.println("Failed to find resource: TestData.csv");
            log.error("Failed to find resource: TestData.csv");
            return new Object[0][];
        }

        List<String> lines = Files.readAllLines(Paths.get(fileUrl.toURI()));
        Object[][] data = new Object[lines.size() - 1][2];
        String resultString;
        for (int i = 0; i < lines.size() - 1; i++) {
            String[] splitLine = lines.get(i + 1).split(",");
            resultString = splitLine[0].trim() + ",'" + splitLine[1].trim() + "','" + splitLine[2].trim() + "','" + splitLine[3].trim() + "'";
            data[i][0] = resultString;
            data[i][1] = Integer.parseInt(splitLine[0].trim());
        }
        return data;
    }
}