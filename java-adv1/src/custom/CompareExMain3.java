package custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompareExMain3 {
	public static void main(String[] args) {
		Map<String, Person> people = new HashMap<>();
		people.put("a", new Person("a", 123));
		people.put("b", new Person("b", 322));
		people.put("c", new Person("c", 321));

		List<Map.Entry<String, Person>> list = new ArrayList<>(people.entrySet());
		list.sort(((o1, o2) -> o1.getValue().age - o2.getValue().age));

		System.out.println(list);
	}


	static class Person {
		public String name;
		public int age;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
		}
	}
}
