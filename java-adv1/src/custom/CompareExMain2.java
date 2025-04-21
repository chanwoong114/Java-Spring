package custom;

import java.util.ArrayList;
import java.util.List;

public class CompareExMain2 {
	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person("a", 123));
		people.add(new Person("B", 322));
		people.add(new Person("c", 321));

		people.sort((o1, o2) -> o2.name.toLowerCase().compareTo(o1.name.toLowerCase()));

		System.out.println(people);
		System.out.println("B".compareTo("a"));
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
