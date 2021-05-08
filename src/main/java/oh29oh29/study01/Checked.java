package oh29oh29.study01;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 해당 클래스는 checked exception 에 대해서 확인하기 위해 작성되었다.
 * */
public class Checked {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader file = new FileReader("/test/study.txt");
    }
}
