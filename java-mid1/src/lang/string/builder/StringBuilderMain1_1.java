package lang.string.builder;

public class StringBuilderMain1_1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append("!");

        System.out.println("sb = " + sb);

        sb.insert(5, " java");
        System.out.println("sb = " + sb);

        sb.delete(5, 10);
        System.out.println("sb = " + sb);

        sb.reverse();
        System.out.println("sb = " + sb);

        String string = sb.toString();
        System.out.println("string = " + string);
    }
}
