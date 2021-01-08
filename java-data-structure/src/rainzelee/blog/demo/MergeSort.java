package rainzelee.blog.demo;

/**
 * @description: 归并排序
 * @productName: java-core-base
 * @author: LYZ
 * @date: 2021/1/8 13:41
 */
public class MergeSort extends BaseSort {



    /**
     * 归并排序是采用分治法的典型应用，而且是一种稳定的排序方式，不过需要使用到额外的空间。
     *
     * 思路：
     *
     * 把数组不断划分成子序列，划成长度只有2或者1的子序列。
     * 然后利用临时数组，对子序列进行排序，合并，再把临时数组的值复制回原数组。
     * 反复操作1~2步骤，直到排序完成。
     */
    @Override
    protected void sort(int[] nums) {
        //归并排序
        mergeSort(0, nums.length - 1, nums, new int[nums.length]);
    }
    private void mergeSort(int star, int end, int[] nums, int[] temp) {
        //递归终止条件
        if (star >= end) {
            return;
        }
        int mid = star + (end - star) / 2;
        //左边进行归并排序
        mergeSort(star, mid, nums, temp);
        //右边进行归并排序
        mergeSort(mid + 1, end, nums, temp);
        //合并左右
        merge(star, end, mid, nums, temp);
    }
    private void merge(int star, int end, int mid, int[] nums, int[] temp) {
        int index = 0;
        int i = star;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (nums[i] > nums[j]) {
                temp[index++] = nums[j++];
            } else {
                temp[index++] = nums[i++];
            }
        }
        while (i <= mid) {
            temp[index++] = nums[i++];
        }
        while (j <= end) {
            temp[index++] = nums[j++];
        }
        //把临时数组中已排序的数复制到nums数组中
        if (index >= 0) System.arraycopy(temp, 0, nums, star, index);
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        sort.printNums();
    }

    /**
     * 平均时间复杂度：O(nlogn)
     *
     * 算法空间复杂度：O(n)
     *
     * 算法稳定性：稳定
     */
}
