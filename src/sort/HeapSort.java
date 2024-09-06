package sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 下沉函数，如果i是最大的，就不需要继续堆化了，否则继续下沉
     * @param nums 输入数组
     * @param n 数组长度
     * @param i 从节点i开始堆化
     */
    public static void siftDown(int[] nums, int n, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < n && nums[left] > nums[max]) {
            max = left;
        }
        if (right < n && nums[right] > nums[max]) {
            max = right;
        }
        if (max != i) {
            swap(nums, max, i);
            siftDown(nums, n, max);
        }
    }
    public static void heapSort(int[] nums) {
        //配合下沉函数构建大顶堆
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            siftDown(nums, nums.length, i);
        }
        //交换堆顶和堆底元素，交换完成之后从堆顶重新堆化，并且堆的长度减一
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            siftDown(nums, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,5,65,213};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
