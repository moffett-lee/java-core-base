package rainzelee.blog.jdk8.lambda;

import java.util.*;

/**
 * @description:
 * @productName: java-core-base
 * @author: LYZ
 * @date: 2021/1/20 10:20
 */
public class LambdaDemo {


    public static void main(String[] args) {
        //对Map 的遍历
        Map<String, String> map = new HashMap<>();
        map.put("ka", "va");
        map.put("kb", "vb");
        map.put("kc", "vc");
        map.put("kd", "vd");

        System.out.println("-------------------map普通方式遍历--------------------");
        for (String key : map.keySet()) {
            System.out.println("k=" + key + "，v=" + map.get(key));
        }

        System.out.println("-------------------使用Lambda进行遍历--------------------");
        map.forEach((k,v) -> {
            System.out.println(k+"==="+v);
        });


        //List遍历
        List<String> list = new ArrayList<String>();
        list.add("li");
        list.add("liyu");
        list.add("liyuze");
        list.add("LYZ");

        System.out.println("-------------------list拉姆达表达式遍历--------------------");
        list.forEach(s -> {
            System.out.println(s);
        });

        System.out.println("-------------------list双冒号运算符遍历--------------------");
        list.forEach(System.out::println);




        //Lambda代替匿名的内部类

        //线程创建
        System.out.println("-------------------使用普通的方式创建--------------------");
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("普通方式创建!");
            }
        };

        System.out.println("-------------------使用拉姆达方式创建--------------------");


        /**
         *注: 这个例子中使用Lambda表达式的时候，编译器会自动推断：根据线程类的构造函数签名 Runnable r { }，将该 Lambda 表达式赋Runnable 接口。
         */
        Runnable r2 = ()-> System.out.println("拉姆达方式创建!");





    }






}
