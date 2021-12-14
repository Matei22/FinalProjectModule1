package JCaltech.Module1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FinalProject {


    public static void main(String[] args){
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try(isr; br){
            String line;
            String[] input;
            Path path = Paths.get("./");

            while(true){
                line = br.readLine();
                input = line.split("\\s+");
                switch (input[0].toUpperCase()) {
                    case "CD" -> {
                        Path p1 = Paths.get(input[1]);
                        path = path.resolve(p1);
                    }
                    case "MKDIR" -> {
                        Path p2 = Paths.get(input[1]);
                        Path p21 = path.resolve(p2);
                        Files.createDirectories(p21);
                    }
                    case "TOUCH" -> {
                        Path p3 = Paths.get(input[1]);
                        Path p31 = path.resolve(p3);
                        Files.createFile(p31);
                    }
                    case "RM" -> {
                        Path p41 = path.resolve(input[1]);
                        Files.deleteIfExists(p41);
                    }
                    case "LS" -> Files.list(path).forEach(System.out::println);
                    case "EXIT" -> System.exit(0);
                    case "HIDE" -> {
                        Path p51 = path.resolve(input[1]);
                        Files.setAttribute(p51, "dos:hidden", true);
                    }
                    case "READONLY" -> {
                        Path p61 = path.resolve(input[1]);
                        Files.setAttribute(p61, "dos:readonly", true);
                    }
                    case "RENAME" -> {
                        Path src = path.resolve(input[1]);
                        Path dest = path.resolve(input[2]);
                        Files.move(src, dest, StandardCopyOption.REPLACE_EXISTING);
                    }
                    case "CAT" -> {
                        Path p71 = path.resolve(input[1]);
                        Files.lines(p71).forEach(System.out::println);
                    }
                    default -> System.err.println("Invalid command");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}