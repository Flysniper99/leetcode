package sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int pointer = left;
        for (int i = left; i < right; i++) {
        if (nums[i] <= pivot) {
            swap(nums, i, pointer);
            pointer++;
            System.out.println(Arrays.toString(nums));
        }
    }
        swap(nums, pointer, right);
        return pointer;
    }
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pointer = partition(nums, left, right);
        quickSort(nums, left, pointer - 1);
        quickSort(nums, pointer + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
