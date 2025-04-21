package custom;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExMain {
	public static void main(String[] args) {
		Deque<Integer> deque = new ArrayDeque<>();
		deque.offer(1);
		deque.offer(2);
		deque.offer(3);
		deque.offerFirst(0);

		System.out.println(deque);

		deque.poll();
		deque.pollFirst();

		System.out.println(deque);
	}
}
