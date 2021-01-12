package rainzelee.blog.thread.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @description: 定长线程池，支持定时及周期性任务执行——延迟执行
 * @productName: java-core-base
 * @author: LYZ
 * @date: 2021/1/10 16:52
 */
public class NewScheduledThreadPoolTest {
    public static void main(String[] args) {
        //定长线程池，支持定时及周期性任务执行——延迟执行
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        //延迟1秒执行
                 /*scheduledThreadPool.schedule(new Runnable() {
                     public void run() {
                        System.out.println("延迟1秒执行");
                     }
                 }, 1, TimeUnit.SECONDS);*/
        //延迟1秒后每3秒执行一次
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {

                System.out.println("延迟1秒后每3秒执行一次");
            }
        },1,3, TimeUnit.SECONDS);
    }
}
