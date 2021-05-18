package oh29oh29.study03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IncorrectFileNameCheckedException {

        try (Scanner file = new Scanner(new File("fileName"))) {
            if (file.hasNextLine()) {
                file.nextLine();
            }
        } catch (FileNotFoundException e) {
            throw new IncorrectFileNameCheckedException("Incorrect filename", e);
        }
    }

}


