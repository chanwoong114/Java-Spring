package thread.volatile1;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class VolatileFlagMain {
	public static void main(String[] args) {
		MyTask task = new MyTask();
		Thread t1 = new Thread(task, "work");
		log("runFlag = " + task.runFlag);
		t1.start();

		sleep(1000);
		log("runFlag를 false로 변경 시도");
		task.runFlag = false;
		log("runFlag = " + task.runFlag);
		log("main 종료");
	}


	static class MyTask implements Runnable {

		volatile boolean runFlag = true;
		@Override
		public void run() {
			log("task 시작");
			while (runFlag) {
				// RunFlag가 false로 변하면 탈출
			}
			log("task 종료");
		}
	}
}