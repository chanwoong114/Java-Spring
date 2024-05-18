package nested.anonymous.ex;

public class Ex0RefMain {

    public static void helloPrint(String s) {
        System.out.println("프로그램 시작");
        System.out.println("Hello " + s);
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        helloPrint("Java");
        helloPrint("Spring");
    }
}
