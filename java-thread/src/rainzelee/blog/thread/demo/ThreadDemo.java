package rainzelee.blog.thread.demo;

/**
 * @description: 继承Thread类创建线程
 * @productName: java-core-base
 * @author: LYZ
 * @date: 2021/1/12 10:39
 */
class ThreadDem {


    /**
     * 类1
     */
    public static class MyThread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println(this.getName()+i);
                try {
                    MyThread1.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //类2
    public static class MyThread2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println(this.getName()+i);
                try {
                    MyThread2.sleep(1000);
                    System.out.println("睡了一秒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    /**
     * 主线程启动
     * @param args
     */
    public static void main(String[] args) {
        MyThread1 myThread = new MyThread1();
        myThread.setName("我是继承了Thread类的线程");
        myThread.start();
        MyThread2 myThread2 = new MyThread2();
        myThread2.setName("我是继承了Thread类的线程二");
        myThread2.start();
        System.out.println("主线程结束"+ Thread.currentThread() );
    }

}
