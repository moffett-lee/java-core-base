package rainzelee.blog.demo;

/**
 * @description: 选择排序
 * @productName: java-core-base
 * @author: LYZ
 * @date: 2021/1/8 11:44
 */
public class SelectSort extends BaseSort {


    /**
     * 思路：
     *
     * 第一轮，找到最小的元素，和数组第一个数交换位置。
     *
     * 第二轮，找到第二小的元素，和数组第二个数交换位置...以此类推，
     *
     * 直到最后一个元素，排序完成。
     *
     */
    @Override
    protected void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = nums[i];
                nums[minIndex] = temp;
                nums[i] = nums[minIndex];
            }
        }
    }

        public static void main(String[] args) {
            SelectSort sort = new SelectSort();
            sort.printNums();
        }

    /**
     * 平均时间复杂度：O(n²)
     *
     * 算法空间复杂度：O(1)
     *
     * 算法稳定性：不稳定
     */
}
