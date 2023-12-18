package BinarySearch;

import java.util.Arrays;

class Solution_2300 {
    public static void main(String[] args) {
        int[] spells = new int[]{5, 1, 3};
        int[] potions = new int[]{1, 2, 3, 4, 5};
        int[] res = successfulPairs(spells, potions, 7);
        System.out.println(Arrays.toString(res));
    }
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            long tar = 0;
            if (success % spells[i] == 0) tar = success / spells[i];
            else tar = success / spells[i] + 1;
            //二分
            int left = 0;
            int right = potions.length - 1;
            int find = potions.length;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (potions[mid] >= tar) {
                    find = mid;
                    right = mid - 1;
                }
                else left = mid + 1;
            }
            res[i] = m - find;
        }
        return res;
    }
}