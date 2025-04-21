package custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayTestMainV1 {

	public static void main(String[] args) {
		int[] intArray = {1,3,5,7,2,4,6};
		System.out.println("----int 배열 오름차순----");
		Arrays.sort(intArray);
		for (int i : intArray) {
			System.out.print(i + " ");
		}
		System.out.println();

		Integer[] tmp = Arrays.stream(intArray).boxed().toArray(Integer[]::new);
		Arrays.sort(tmp, Collections.reverseOrder());
		for (int i : tmp) {
			System.out.print(i + " ");
		}

		List<Integer> list = Arrays.stream(intArray).boxed().toList();

		int[] arr2 = list.stream().mapToInt(i -> i).toArray();
	}
}
