package 알고스터디.week8.F_연산자끼워넣기;

import java.util.Scanner;

public class Main {

    static int n;
    static int minV = (int) 1e9;
    static int maxV = (int) -1e9;
    static int arr[];
    static int operator[] = new int[4];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            operator[i] = sc.nextInt();
        }

        operation(0, arr[0]);

        System.out.println(maxV);
        System.out.println(minV);
    }

    public static int cal(int total, int n, int o){
        if (o == 0) {
            total += n;
        } else if (o == 1) {
            total -= n;
        } else if (o == 2) {
            total *= n;
        } else {
            total /= n;
        }
        return total;
    }

    public static void operation(int k, int total) {
        if (k == n-1) {
            if (total > maxV) {
                maxV = total;
            }
            if (total < minV) {
                minV = total;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                if (i == 3 && arr[k+1] == 0) {
                    return;

                }
                operator[i] -= 1;
                operation(k+1, cal(total, arr[k+1], i));
                operator[i] += 1;
            }
        }
    }
}