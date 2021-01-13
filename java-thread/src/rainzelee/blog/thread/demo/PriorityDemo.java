package rainzelee.blog.thread.demo;

/**
 * @description:
 * @productName: java-core-base
 * @author: LYZ
 * @date: 2021/1/13 9:32
 */
public class PriorityDemo extends Thread {


    public PriorityDemo(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i < 4; i++) {
            System.out.println(this.getName() + "循环了：" + i + "次");

        }

    }

    public static void main(String[] args) {

        //默认优先级 5
        System.out.println("当前线程位：" + Thread.currentThread().getName() + "，优先级为：" + Thread.currentThread().getPriority());
        PriorityDemo thread1 = new PriorityDemo("thread1");
        PriorityDemo thread2 = new PriorityDemo("thread2");
        PriorityDemo thread3 = new PriorityDemo("thread3");
        //设置线程优先级
        thread1.setPriority(MIN_PRIORITY);    // 最小  1
        thread3.setPriority(MAX_PRIORITY);   //最大 10
        thread1.start();
        thread2.start();
        thread3.start();

    }
}