package Greedy;

/**
 * 加油站
 * 如果remain累加 gas[i]−cost[i]后小于0，则出发点到站i都不是起点。
 * total大于等于0，一定有解
 */
class Solution_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int totalSum = 0;
        int remainSum = 0;
        for (int i = 0; i < gas.length; i++) {
            totalSum += gas[i] - cost[i];
            remainSum += gas[i] - cost[i];
            if (remainSum < 0) {
                start = i + 1;
                remainSum = 0;
            }
        }
        if (totalSum < 0) return -1;
        return start;
    }
}
