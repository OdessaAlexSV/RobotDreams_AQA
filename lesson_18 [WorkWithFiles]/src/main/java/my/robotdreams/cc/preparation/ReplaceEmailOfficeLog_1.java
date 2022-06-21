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

public class ReplaceEmailOfficeLog_1 {
    public static void main(String[] arg) {
        String path = "D:\\Personal\\Devel\\RobotDreams_AQA\\lesson_18 [WorkWithFiles]\\src\\main\\resources";
        String fileOrigin = "AuditLog_2022-05-31_2022-06-13.csv";

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

            /*
            String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
            Pattern pattern = Pattern.compile(regex);

             for (int i = 1; i < strings.size(); i++) {
                String[] parts = strings.get(i).strip().split(",");
                for (String p : parts) {
                    Matcher matcher = pattern.matcher(p);
                    if (matcher.matches()) {
                        bufferedWriter.write("user" + i + "@test.com");
                        //bufferedWriter.write("Hello World\nHow are you today?");
                        System.out.println(p + " : " + matcher.matches());
                        //break;
                    } else {
                        bufferedWriter.write(p + ",");
                    }
                }
            }
           */

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
