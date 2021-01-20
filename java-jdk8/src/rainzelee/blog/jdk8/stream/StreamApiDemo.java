package rainzelee.blog.jdk8.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @description:
 * @productName: java-core-base
 * @author: LYZ
 * @date: 2021/1/20 9:42
 */
public class StreamApiDemo {

    public static void main(String[] args) {


        //生成流
        System.out.println("---------------------------------生成流--------------------------------");
        /**
         * stream() − 为集合创建串行流。
         *
         * parallelStream() − 为集合创建并行流。
         **/


        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

        List<String> filter = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        for (String s : filter) {
            System.out.println(s);
        }


        System.out.println("---------------------------------forEach--------------------------------");
        //forEach 以下代码片段使用 forEach 输出了10个随机数：
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::print);


        System.out.println("---------------------------------map--------------------------------");
        //map map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数：
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());




        System.out.println("---------------------------------filter--------------------------------");
       // filter filter 方法用于通过设置的条件过滤出元素。以下代码片段使用 filter 方法过滤出空字符串：

        List<String> stringList = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long count = stringList.stream().filter( s -> s.isEmpty()).count();




        System.out.println("---------------------------------limit--------------------------------");
        //limit limit 方法用于获取指定数量的流。 以下代码片段使用 limit 方法打印出 10 条数据：





        random.ints().limit(10).forEach(System.out::println);
        System.out.println("---------------------------------sorted--------------------------------");
        // sorted sorted 方法用于对流进行排序。以下代码片段使用 sorted 方法对输出的 10 个随机数进行排序：
        random.ints().limit(10).sorted().forEach(System.out::println);



       // 并行（parallel）程序 parallelStream 是流并行处理程序的代替方法。以下实例我们使用 parallelStream 来输出空字符串的数量：
        System.out.println("---------------------------------parallel--------------------------------");
        List<String> s = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long a = s.parallelStream().filter(string -> string.isEmpty()).count();


        System.out.println("----------------------------Collectors------------------------------------------");

        //Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串：

        List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表: " + filtered);

        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

        //统计

        System.out.println("----------------------------统计------------------------------------------");

        List<Integer> numberss = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numberss.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());

















    }







}
