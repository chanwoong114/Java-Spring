import java.util.Arrays;

public class Main {
    public static void main(String args[]){
        int[] lst = {1,2,3,4,5};
        int[] lst2 = lst;

        lst[1] = 9;

        System.out.println(Arrays.toString(lst2));
    }

    static void copy(int[] arr, int[] arr2) {
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
    }
}