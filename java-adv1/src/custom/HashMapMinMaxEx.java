package custom;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HashMapMinMaxEx {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("Apple", 50);
		map.put("Banana", 20);
		map.put("Cherry", 30);
		map.put("Mango", 40);

		System.out.println(map.get("Apple"));
		map.remove("Apple");
		System.out.println(map.get("Apple"));

		int max = Collections.max(map.values());
		int min = Collections.min(map.values());

		System.out.println(min + " " + max);
	}
}
