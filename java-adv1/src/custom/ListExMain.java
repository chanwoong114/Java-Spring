package custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListExMain {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4));

		int[] arr = list.stream().mapToInt(i -> i).toArray();


		List<Integer> list2 = Arrays.stream(arr).boxed().toList();
		Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);

		System.out.println(Arrays.toString(arr2));
		System.out.println(list2);

		List<String> list3 = new ArrayList<>(List.of("a", "B", "c", "D"));
		list3.sort(String::compareToIgnoreCase);

		System.out.println(list3);
	}
}
