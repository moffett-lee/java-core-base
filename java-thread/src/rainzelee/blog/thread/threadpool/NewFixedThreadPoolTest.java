package rainzelee.blog.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 固定个数的线程池
 * @productName: java-core-base
 * @author: LYZ
 * @date: 2021/1/1016:47
 */
public class NewFixedThreadPoolTest {
    public static void main(String[] args) {
        // 创建一个可重用固定个数的线程池

        int i1 = Runtime.getRuntime().availableProcessors();
        System.out.println(i1);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 打印正在执行的缓存线程信息
                        System.out.println(Thread.currentThread().getName()
                                + "正在被执行");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


    }
}
