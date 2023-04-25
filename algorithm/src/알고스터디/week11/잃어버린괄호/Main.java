package 알고스터디.week11.잃어버린괄호;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        String[] arr = s.split("-");

        String[] first = arr[0].split("\\+");
        int total = 0;
        for (String st : first) {
            total += Integer.parseInt(st);
        }

        for (int i = 1; i < arr.length; i++) {
            String[] ss = arr[i].split("\\+");
            for (String st : ss) {
                total -= Integer.parseInt(st);
            }
        }

        System.out.println(total);

    }
}