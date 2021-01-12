package rainzelee.blog.thread.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @productName: java-core-base
 * @author: LYZ
 * @date: 2021/1/10 11:11
 */
public class MyCallable implements Callable {

    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
        return "实现Callable接口的实现类完成多线程执行完毕";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        // 1.执行Callable方式，需要FutureTask实现类的支持，用于接收运算结果
        FutureTask<String> result = new FutureTask<String>(myCallable);
        Thread thread = new Thread(result);
        thread.setName("实现Callable接口实现多线程");
        thread.start();
        //等所有线程执行完，获取值
        //等所有线程执行完，获取值，因此FutureTask 可用于 闭锁
        String s = result.get();
        System.out.println("s = " + s);
        //返回值：s = 实现Callable接口的实现类完成多线程执行完毕
    }
}
