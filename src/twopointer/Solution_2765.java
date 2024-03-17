package twopointer;

class Solution_2765 {
    public int alternatingSubarray(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int r = i + 1;
            int pre = nums[r] - nums[i];
            if (pre != 1) continue;
            while (r + 1 < nums.length && nums[r + 1] - nums[r] == -pre) {
                pre = -pre;
                r++;
            }
            res = Math.max(res, r - i + 1);
            i = r - 1; //在for循环中i自增了
        }
        return res == 0? -1 : res;
    }
}
