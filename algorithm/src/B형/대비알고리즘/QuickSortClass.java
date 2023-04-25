package B형.대비알고리즘;

import java.util.Arrays;

public class QuickSortClass {

    static int[] a;
    static int[] tmp;
    public static void main(String[] args) {

        a = new int[]{8, 2, 6, 4, 7, 3, 9, 5};
        tmp = new int[a.length];

        mergeSort(0, a.length-1);
        System.out.println(Arrays.toString(a));

    }

    public static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);

            int p = start;
            int q = mid + 1;
            int idx = p;

            while (p <= mid || q <= end) {
                if (q > end || (p <= mid && a[p] <= a[q])) {
                    tmp[idx++] = a[p++];
                } else {
                    tmp[idx++] = a[q++];
                }
            }

            for (int i=start; i<=end; i++) {
                a[i] = tmp[i];
            }
        }
    }
}
