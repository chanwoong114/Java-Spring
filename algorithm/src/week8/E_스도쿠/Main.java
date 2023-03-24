package week8.E_스도쿠;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int arr[][] = new int[9][9];
    static ArrayList<int[]> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 0){
                    list.add(new int[]{i, j});
                }
            }
        }

        sudoku(0);
        System.out.println(sb);

    }

    public static boolean rowCheck(int row) {
        int lst[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < 9; i++) {
            lst[arr[row][i]-1] += 1;
        }
        for (int i = 1; i < 10; i++) {
            if (lst[i] > 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean colCheck(int col) {
        int lst[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < 9; i++) {
            lst[arr[i][col]-1] += 1;
        }
        for (int i = 1; i < 10; i++) {
            if (lst[i] > 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean boxCheck(int row, int col) {
        int lst[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                lst[arr[row/3+3+i][col/3*3+j]] += 1;
            }
        }
        for (int i = 1; i < 10; i++) {
            if (lst[i] > 1) {
                return false;
            }
        }
        return true;
    }

    public static void sudoku(int k) {
        if (sb.length() != 0) {
            return;
        }

        if (k == list.size()) {
            if ((rowCheck(list.get(k)[0])) && colCheck(list.get(k)[1]) && boxCheck(list.get(k)[0], list.get(k)[1])) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        sb.append(arr[i][k] + " ");
                    }
                    sb.append("\n");
                }
            }
            return;
        }

        for (int i = 0; i < 9; i++) {
            arr[list.get(k)[0]][list.get(k)[1]] = i;
            sudoku(k+1);
            arr[list.get(k)[0]][list.get(k)[1]] = 0;
        }
    }

}
