package lang.string.test;

public class TestString4 {
    public static void main(String[] args) {
        String str = "hello.txt";
        String filename = str.substring(0, str.lastIndexOf("."));
        System.out.println(filename);
    }
}
