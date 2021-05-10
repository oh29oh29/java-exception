package oh29oh29.study02;

/**
 * 해당 클래스는 throw 키워드에 대해 확인하기 위해 작성되었다.
 * */
public class Main {
    public static void main(String[] args) {
        try {
            throwNullPointerException();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException catch");
        }
    }

    private static void throwNullPointerException() {
        throw new NullPointerException();
    }
}
