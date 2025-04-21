package custom;

import java.util.Arrays;
import java.util.List;

public class ParallelExMain {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry", "Mango", "Orange");

		// list.stream().parallel().forEach(System.out::println);
		list.parallelStream().forEach(System.out::println);
	}
}
