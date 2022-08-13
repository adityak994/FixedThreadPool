import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class MyThread implements Runnable {
    private int i, j;

    MyThread(int x, int y) {
        i = x;
        j = y;
    }

    public void run() {
        System.out.print(i + " " + j + " ");
    }
}

public class FixedThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        for (int i = 1; i < 10; i = i + 2) {
            MyThread t = new MyThread(i, i + 1);
            executor.execute(t);
        }
        executor.shutdown();
    }
}