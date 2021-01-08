package rainzelee.blog.demo;

/**
 * @description: 冒泡排序
 * @productName: java-core-base
 * @author: LYZ
 * @date: 2021/1/8 11:08
 */
public class BubbleSort extends BaseSort {

    /**
     * 思路：
     *
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素就是最大的数；
     * 排除最大的数，接着下一轮继续相同的操作，确定第二大的数...
     * 重复步骤1-3，直到排序完成。
     */


    public static void main(String[] args) {

        BubbleSort sort = new BubbleSort();
        sort.printNums();


        /**
         * 平均时间复杂度：O(n²)
         *
         * 空间复杂度：O(1)
         *
         * 算法稳定性：稳定
         */
    }


    @Override
    protected void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
