package thread.sync.test;

import static util.MyLogger.*;

public class SyncTest2MainTest {
    public static void main(String[] args) throws InterruptedException {
        MyCounter myCounter = new MyCounter(0);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                myCounter.count();
            }
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();
    }

    static class MyCounter {
        private int value = 0;

        public MyCounter(int value) {
            this.value = value;
        }

        public void count() {
            for (int i = 0; i < 1000; i++) {
                value = value + 1;
            }
            log("결과: " + value);
        }
    }

}