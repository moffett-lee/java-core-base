package rainzelee.blog.demo;

/**
 * @description: 桶排序
 * @productName: java-core-base
 * @author: LYZ
 * @date: 2021/1/8 13:45
 */
public class BucketSort extends BaseSort {
    /**
     * 思路：
     *
     * 找出最大值，最小值。
     * 根据数组的长度，创建出若干个桶。
     * 遍历数组的元素，根据元素的值放入到对应的桶中。
     * 对每个桶的元素进行排序(可使用快排，插入排序等)。
     * 按顺序合并每个桶的元素，排序完成。
     * 对于数组中的元素分布均匀的情况，排序效率较高。相反的，如果分布不均匀，则会导致大部分的数落入到同一个桶中，使效率降低。
     * @param nums
     */
    @Override
    protected void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        bucketSort(nums);
    }

    public void bucketSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        //找出最大值，最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int length = nums.length;
        //桶的数量
        int bucketCount = (max - min) / length + 1;
        int[][] bucketArrays = new int[bucketCount][];
        //遍历数组，放入桶内
        for (int i = 0; i < length; i++) {
            //找到桶的下标
            int index = (nums[i] - min) / length;
            //添加到指定下标的桶里，并且使用插入排序排序
            bucketArrays[index] = insertSortArrays(bucketArrays[index], nums[i]);
        }
        int k = 0;
        //合并全部桶的
        for (int[] bucketArray : bucketArrays) {
            if (bucketArray == null || bucketArray.length == 0) {
                continue;
            }
            for (int i : bucketArray) {
                //把值放回到nums数组中
                nums[k++] = i;
            }
        }
    }

    //每个桶使用插入排序进行排序
    private int[] insertSortArrays(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return new int[]{num};
        }
        //创建一个temp数组，长度是arr数组的长度+1
        int[] temp = new int[arr.length + 1];
        //把传进来的arr数组，复制到temp数组
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        //找到一个位置，插入，形成新的有序的数组
        int i;
        for (i = temp.length - 2; i >= 0 && temp[i] > num; i--) {
            temp[i + 1] = temp[i];
        }
        //插入需要添加的值
        temp[i + 1] = num;
        //返回
        return temp;
    }

    public static void main(String[] args) {
        BucketSort sort = new BucketSort();
        sort.printNums();
    }

    /**
     * 平均时间复杂度：O(M+N)
     *
     * 算法空间复杂度：O(M+N)
     *
     * 算法稳定性：稳定(取决于桶内的排序算法，这里使用的是插入排序所以是稳定的)。
     */
}
