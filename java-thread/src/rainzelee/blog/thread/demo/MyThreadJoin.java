package rainzelee.blog.thread.demo;

/**
 * @description:
 * @productName: java-core-base
 * @author: LYZ
 * @date: 2021/1/13 10:07
 */
public class MyThreadJoin extends Thread {
    Thread main = null;

    public MyThreadJoin(Thread main){
        this.main = main;
    }
    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {
            if(i == 10) {
                try {
                    main.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "执行， i = " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread(); // 获得主线程对象

        MyThreadJoin thread8 = new MyThreadJoin(mainThread);
        thread8.start();
        for(int i = 0; i < 20; i++) {
            Thread.sleep(1000); // 延缓程序执行速度
            System.out.println(Thread.currentThread().getName() + "执行， i = " + i);
        }
    }




}
