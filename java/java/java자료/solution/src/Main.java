import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 1;
        for (int i=0; i<n; i++) {
            m = m*2;
        }

        System.out.println(m-1);
        Main.hanoi(n, 1, 3, 2);
    }

    public static void hanoi(int n, int start, int end, int middle) {

        if (n == 1) {
            System.out.println(start +" "+ end);
            return;
        }

        hanoi(n - 1, start, middle, end);
        System.out.println(start +" "+ end);
        hanoi(n - 1, middle, end, start);

    }

}
