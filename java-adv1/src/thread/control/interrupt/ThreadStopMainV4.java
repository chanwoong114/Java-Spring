package thread.control.interrupt;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class ThreadStopMainV4 {

	public static void main(String[] args) {
		MyTask task = new MyTask();
		Thread thread = new Thread(task);
		thread.start();

		sleep(100);
		log("작업 중단 지시 runFlag=false");
		thread.interrupt();
		log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
	}

	static class MyTask implements Runnable {

		@Override
		public void run() {
			while (!Thread.interrupted()) {
				log("작업 중");
			}
			log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());

			try {
				log("자원 정리 시도");
				Thread.sleep(1000);
				log("자원 정리 완료");
			} catch (InterruptedException e) {
				log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
				log("work 스레드 인터럽트 상태3 = " + Thread.currentThread().isInterrupted());
			}
			log("자원 종료");
		}
	}
}