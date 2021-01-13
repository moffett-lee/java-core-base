package rainzelee.blog.thread.demo;

/**
 * @description:
 * @productName: java-core-base
 * @author: LYZ
 * @date: 2021/1/13 9:15
 */
public class ThreadStatusDemo implements Runnable {


    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {

            System.out.println("测试线程状态");

        }
    }

    public static void main(String[] args) {
        ThreadStatusDemo demo = new ThreadStatusDemo();
        Thread thread = new Thread(demo);

        //启动前 new
        Thread.State state = thread.getState();
        System.out.println(state);
        //启动线程
        thread.start();
        try {
            //睡眠测试阻塞
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //阻塞状态
        Thread.State threadState = thread.getState();
        System.out.println(threadState);

        //终止线程，方法过时，不推荐这样使用，为了测试本案例我使用stop方法
        thread.stop();

        Thread.State stopState = thread.getState();
        System.out.println(stopState);

        //当线程死亡后启动线程会失败，也就是说 线程run()、main() 方法执行结束，或者因异常退出了run()方法，则该线程结束生命周期。死亡的线程**不可再次复生**。
        thread.start();

    }
}
