package thread.cas;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CasMainV3 {

	private static final int THREAD_COUNT = 3;

	public static void main(String[] args) throws InterruptedException {
		AtomicInteger atomicInteger = new AtomicInteger(0);
		System.out.println("start value = " + atomicInteger.get());

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				incrementAndGet(atomicInteger);
			}
		};

		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < THREAD_COUNT; i++) {
			Thread thread = new Thread(runnable);
			threads.add(thread);
			thread.start();
		}

		for (Thread thread : threads) {
			thread.join();
		}

		int result = atomicInteger.get();
		System.out.println(atomicInteger.getClass().getSimpleName() + " resultValue: " + result);
	}

	public static void incrementAndGet(AtomicInteger atomicInteger) {
		int getValue;
		boolean result;

		do {
			getValue = atomicInteger.get();
			sleep(100); // 스레드 동시 실행을 위한 대기
			log("getValue = " + getValue);
			result = atomicInteger.compareAndSet(getValue, getValue + 1);
			log("result = " + result);
		} while (!result);
	}
}