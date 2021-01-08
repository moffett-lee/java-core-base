package rainzelee.blog.demo;

/**
 * @description: 大顶堆排序
 * @productName: java-core-base
 * @author: LYZ
 * @date: 2021/1/8 13:44
 */
public class HeapSort extends BaseSort {


    /**
     * 大顶堆概念：每个节点的值都大于或者等于它的左右子节点的值，所以顶点的数就是最大值
     * 思路：
     *
     * 对原数组构建成大顶堆。
     * 交换头尾值，尾指针索引减一，固定最大值。
     * 重新构建大顶堆。
     * 重复步骤2~3，直到最后一个元素，排序完成。
     */
    @Override
    protected void sort(int[] nums) {

    }

    private void heapSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        //构建大根堆
        createTopHeap(nums);
        int size = nums.length;
        while (size > 1) {
            //大根堆的交换头尾值，固定最大值在末尾
            swap(nums, 0, size - 1);
            //末尾的索引值往左减1
            size--;
            //重新构建大根堆
            updateHeap(nums, size);
        }
    }

    private void createTopHeap(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //当前插入的索引
            int currIndex = i;
            //父节点的索引
            int parentIndex = (currIndex - 1) / 2;
            //如果当前遍历的值比父节点大的话，就交换值。然后继续往上层比较
            while (nums[currIndex] > nums[parentIndex]) {
                //交换当前遍历的值与父节点的值
                swap(nums, currIndex, parentIndex);
                //把父节点的索引指向当前遍历的索引
                currIndex = parentIndex;
                //往上计算父节点索引
                parentIndex = (currIndex - 1) / 2;
            }
        }
    }

    private void updateHeap(int[] nums, int size) {
        int index = 0;
        //左节点索引
        int left = 2 * index + 1;
        //右节点索引
        int right = 2 * index + 2;
        while (left < size) {
            //最大值的索引
            int largestIndex;
            //如果右节点大于左节点，则最大值索引指向右子节点索引
            if (right < size && nums[left] < nums[right]) {
                largestIndex = right;
            } else {
                largestIndex = left;
            }
            //如果父节点大于最大值，则把父节点索引指向最大值索引
            if (nums[index] > nums[largestIndex]) {
                largestIndex = index;
            }
            //如果父节点索引指向最大值索引，证明已经是大根堆，退出循环
            if (largestIndex == index) {
                break;
            }
            //如果不是大根堆，则交换父节点的值
            swap(nums, largestIndex, index);
            //把最大值的索引变成父节点索引
            index = largestIndex;
            //重新计算左节点索引
            left = 2 * index + 1;
            //重新计算右节点索引
            right = 2 * index + 2;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        sort.printNums();
    }


    /**
     * 平均时间复杂度：O(nlogn)
     *
     * 算法空间复杂度：O(1)
     *
     * 算法稳定性：不稳定
     */
}
