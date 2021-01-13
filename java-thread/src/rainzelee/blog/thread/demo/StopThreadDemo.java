package rainzelee.blog.thread.demo;

/**
 * @description:
 * @productName: java-core-base
 * @author: LYZ
 * @date: 2021/1/13 9:43
 */
public class StopThreadDemo implements Runnable {

    //标识
    public volatile boolean exit = false;
    @Override
    public void run() {

        while (!exit);

    }

    public static void main(String[] args) throws InterruptedException {
        StopThreadDemo thread = new StopThreadDemo();
        Thread thread1 = new Thread(thread);
        thread1.start();
        System.out.println("线程已经启动");
        Thread.sleep(5000); // 主线程延迟5秒
        thread.exit = true;  // 终止线程thread
        System.out.println("线程退出!");
    }



}
