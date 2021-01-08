package rainzelee.blog.demo;

/**
 * @description: 插入排序
 * @productName: java-core-base
 * @author: LYZ
 * @date: 2021/1/8 11:30
 */
public class InsertSort extends BaseSort {
    /**
     * 思路：
     *
     * 1 从第一个元素开始，该元素可以认为已经被排序；
     *
     * 2 取出下一个元素，在前面已排序的元素序列中，从后向前扫描；
     *
     * 3 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     *
     * 4 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     *
     * 5 将新元素插入到该位置后；
     *
     * 6 重复步骤2~5。
     */

    @Override
    protected void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 0; i < nums.length - 1 ; i++) {
            //当前值
            int curr = nums[i + 1];
            //上一个数的指针
            int preIndex = i;
            //在数组中找到一个比当前遍历的数小的第一个数
            while (preIndex >= 0 && curr < nums[preIndex]) {
                //把比当前遍历的数大的数字往后移动
                nums[preIndex + 1] = nums[preIndex];
                //需要插入的数的下标往前移动
                preIndex--;
            }
            //插入到这个数的后面
            nums[preIndex + 1] = curr;
        }
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        insertSort.printNums();


        /**
         * 平均时间复杂度：O(n²)
         *
         * 空间复杂度：O(1)
         *
         * 算法稳定性：稳定
         */
    }

}
