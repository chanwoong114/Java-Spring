package custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListExMain2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g", "h"));

		String[] arr = list.toArray(new String[0]);

		Arrays.sort(arr, Collections.reverseOrder());

		List<String> list2 = new ArrayList<>(Arrays.asList(arr));
		list2.sort(Collections.reverseOrder());

		System.out.println(Arrays.toString(arr));
		System.out.println(list2);
		System.out.println(Collections.max(list2));
	}
}
