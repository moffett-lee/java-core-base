package rainzelee.blog.thread.demo;

import java.io.IOException;

/**
 * @description:
 * @productName: java-core-base
 * @author: LYZ
 * @date: 2021/1/13 9:53
 */
public class StopThreadDemo2 extends Thread {

    public void run() {
        try {
            sleep(50000);  // 延迟50秒
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Thread thread = new StopThreadDemo2();
        thread.start();
        System.out.println("在50秒之内按任意键中断线程!");
        System.in.read();
        thread.interrupt();
        thread.join();
        System.out.println("线程已经退出!");
    }

}