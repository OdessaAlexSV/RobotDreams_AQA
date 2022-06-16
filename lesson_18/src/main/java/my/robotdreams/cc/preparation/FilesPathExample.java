package my.robotdreams.cc.preparation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by asvidersky on 6/15/2022.
 */

public class FilesPathExample {
    static String basePath = "D:\\Personal\\Devel\\RobotDreams_AQA\\lesson_18\\resources\\";

    public static void main(String[] args) {
        Path filePath = Paths.get(basePath + "AuditLog_1.csv");
        System.out.println(filePath.getFileName());
        System.out.println("Is " + filePath.getFileName() + " file exists    : " + Files.exists(filePath));
        System.out.println("Is " + filePath.getFileName() + " file a dir     : " + Files.isDirectory(filePath));
        System.out.println("Is " + filePath.getFileName() + " file a regular : " + Files.isRegularFile(filePath));

        try {
            Path dirPath = Paths.get(basePath + "\\src\\examples\\files");
            for (int i = 0; i < 2; i++) {
                File file = new File("test" + i + ".txt");
                try {
                    checkIfFileAvailable(dirPath, file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Files.list(dirPath).toList());
            List<Path> path = Files.list(dirPath).toList();
            for (Path p : path) {
                System.out.printf("%s %s \n", p, Files.isRegularFile(p));
            }

            String fileContent = Files.readString(Paths.get(dirPath + "\\test0.txt"));
            System.out.println(fileContent);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void checkIfFileAvailable(Path dirPath, File file) throws IOException {
        Path filePath = Path.of(dirPath + "\\" + file.getName());
        if (!Files.exists(filePath)) {
            Files.createDirectories(dirPath);
            try {
                Files.createFile(Paths.get(dirPath + "\\" + file.getName()));
                System.out.println("File with name " + file.getName() + " is created");
            } catch (IOException e) {
                System.err.println("File with name " + file.getName() + " does not exist");
            }
        }
    }
}
