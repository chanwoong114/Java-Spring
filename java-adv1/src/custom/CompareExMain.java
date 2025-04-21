package custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareExMain {
	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person("a", 123));
		people.add(new Person("b", 322));
		people.add(new Person("c", 321));

		people.sort((o1, o2) -> o2.age - o1.age);

		System.out.println(people);
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
