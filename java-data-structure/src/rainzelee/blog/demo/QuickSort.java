package rainzelee.blog.demo;

/**
 * @description: 快速排序
 * @productName: java-core-base
 * @author: LYZ
 * @date: 2021/1/8 13:38
 */
public class QuickSort extends BaseSort {

    /**
     * 快排，面试最喜欢问的排序算法。这是运用分治法的一种排序算法。
     *
     * 思路：
     *
     * 从数组中选一个数做为基准值，一般选第一个数，或者最后一个数。
     * 采用双指针(头尾两端)遍历，从左往右找到比基准值大的第一个数，从右往左找到比基准值小的第一个数，交换
     * 两数位置，直到头尾指针相等或头指针大于尾指针，把基准值与头指针的数交换。这样一轮之后，左边的数就比基准值小，右边的数就比基准值大。
     * 对左边的数列，重复上面1，2步骤。对右边重复1，2步骤。
     * 左右两边数列递归结束后，排序完成。
     */

    @Override
    protected void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int star, int end) {
        if (star > end) {
            return;
        }
        int i = star;
        int j = end;
        int key = nums[star];
        while (i < j) {
            while (i < j && nums[j] > key) {
                j--;
            }
            while (i < j && nums[i] <= key) {
                i++;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[star] = nums[i];
        nums[i] = key;
        quickSort(nums, star, i - 1);
        quickSort(nums, i + 1, end);
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        sort.printNums();
        /**
         * 平均时间复杂度：O(nlogn)
         *
         * 算法空间复杂度：O(1)
         *
         * 算法稳定性：不稳定
         */
    }
}
