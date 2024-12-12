package thread.executor;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class RunnableTask implements Runnable {

	private final String name;
	private int sleepMs;

	public RunnableTask(String name) {
		this.name = name;
	}

	public RunnableTask(String name, int sleepMs) {
		this.name = name;
		this.sleepMs = sleepMs;
	}

	@Override
	public void run() {
		log(name + " 시작");
		sleep(sleepMs); // 작업 시간 시뮬레이션
		log(name + " 완료");
	}
}
