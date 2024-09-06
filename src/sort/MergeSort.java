package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(Arrays.toString(mergerSort(nums)));
    }

    public static int[] mergerSort(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums;
        int mid = n / 2;
        int[] nums_1 = Arrays.copyOfRange(nums, 0, mid);
        int[] nums_2 = Arrays.copyOfRange(nums, mid, n);
        return merge(mergerSort(nums_1), mergerSort(nums_2));
    }

    public static int[] merge(int[] nums_1, int[] nums_2) {
        int[] sortNums = new int[nums_1.length + nums_2.length];
        int index = 0, index_1 = 0, index_2 = 0;
        while (index_1 <= nums_1.length - 1 && index_2 <= nums_2.length - 1) {
            if (nums_1[index_1] <= nums_2[index_2]) {
                sortNums[index++] = nums_1[index_1++];
            } else {
                sortNums[index++] = nums_2[index_2++];
            }
        }
        if (index_1 <= nums_1.length - 1) {
            while (index_1 <= nums_1.length - 1) {
                sortNums[index++] = nums_1[index_1++];
            }
        }
        if (index_2 <= nums_2.length - 1) {
            while (index_2 <= nums_2.length - 1) {
                sortNums[index++] = nums_2[index_2++];
            }
        }
        return sortNums;
    }
}
