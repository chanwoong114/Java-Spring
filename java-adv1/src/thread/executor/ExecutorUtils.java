package thread.executor;

import static util.MyLogger.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class ExecutorUtils {

	public static void printState(ExecutorService executorService) {
		if (executorService instanceof ThreadPoolExecutor poolExecutor) {
			int pool = poolExecutor.getPoolSize();
			int active = poolExecutor.getActiveCount();
			int queueTasks = poolExecutor.getQueue().size();
			long completedTasks = poolExecutor.getCompletedTaskCount();
			log("[pool=" + pool + ", active=" + active + ", queuedTasks=" + queueTasks + ", completedTask=" + completedTasks + "]");
		} else {
			log(executorService);
		}
	}

	// 추가
}
