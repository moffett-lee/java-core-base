package rainzelee.blog.thread.demo;

/**
 * @description: **实现Runnable接口创建线程**
 * @productName: java-core-base
 * @author: LYZ
 * @date: 2021/1/10 10:46
 */
 class RunnableDemo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}


//类2
class RunnableDemo2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }

    }


    public static void main(String[] args) {
        //对两个实现类分别启动一个线程
        RunnableDemo runnableDemo = new RunnableDemo();
        Thread thread = new Thread(runnableDemo);
        thread.setName("我是实现runnable接口创建的线程");
        thread.start();

        RunnableDemo2 myRunnable2 = new RunnableDemo2();
        Thread thread2 = new Thread(myRunnable2);
        thread2.setName("我是实现runnable接口创建的线程二");
        thread2.start();
        //对一个实现类启动两个线程
        RunnableDemo myRunnable3 = new RunnableDemo();
        Thread thread3 = new Thread(myRunnable3);
        thread3.setName("我是实现runnable接口创建的线程三");
        Thread thread4 = new Thread(myRunnable3);
        thread4.setName("我是实现runnable接口创建的线程四");
        thread3.start();
        thread4.start();

        //用匿名内部类的形式实现多线程
        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + i);
                }
            }
        },"我是实现runnable接口创建的线程五");
        thread5.start();


        //用lambada表达式形式实现的多线程
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        },"我是实现runnable接口创建的线程六").start();

    }




}