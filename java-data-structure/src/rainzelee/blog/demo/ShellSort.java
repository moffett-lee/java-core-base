package rainzelee.blog.demo;

/**
 * @description: 希尔排序
 * @productName: java-core-base
 * @author: LYZ
 * @date: 2021/1/8 13:35
 */
public class ShellSort extends BaseSort {



    /**
     * 思路：
     *
     * 把数组分割成若干(h)个小组(一般数组长度length/2)，然后对每一个小组分别进行插入排序。每一
     * 轮分割的数组的个数逐步缩小，h/2->h/4->h/8，并且进行排序，保证有序。当h=1时，则数组排序完成。
     */


    @Override
    protected void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int length = nums.length;
        int temp;
        //步长
        int gap = length / 2;
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                temp = nums[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && nums[preIndex] > temp) {
                    nums[preIndex + gap] = nums[preIndex];
                    preIndex -= gap;
                }
                nums[preIndex + gap] = temp;
            }
            gap /= 2;
        }
    }


    public static void main(String[] args) {
        ShellSort sort = new ShellSort();
        sort.printNums();
        /**
         * 平均时间复杂度：O(nlog2n)
         *
         * 算法空间复杂度：O(1)
         *
         * 算法稳定性：稳定
         */
    }
}
