package my.robotdreams.cc.preparation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by asvidersky on 6/16/2022.
 */

public class ReplaceEmailOfficeLog {
    public static void main(String[] arg) {
        String path = arg[0];
        String fileOrigin = arg[1];

        Path filePath = Paths.get(path);
        File file = new File(filePath + "\\" + fileOrigin);

        if (!(file.exists())) {
            throw new RuntimeException("File with name " + file.getName() + " does not exist!");
        }

        File fileNew = new File(filePath + "\\" + "NEW_" + file.getName());

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileNew))) {
            List<String> lines = Files.readAllLines(file.toPath());
            int i = 0;
            for (String line : lines) {
                String newEmail = "test" + i + "@test.com";
                String replacedStr = line.replaceAll("(app@sharepoint)|(\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)", newEmail);
                bufferedWriter.write(replacedStr + "\n");
                i++;
            }
            System.out.println("DONE");

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
