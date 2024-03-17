package greedy;

class Solution_670 {
    public int maximumSwap(int num) {
        char[] s = Integer.toString(num).toCharArray(); //字符数组与字符串的转换
        int maxIdx = s.length - 1;
        int p = -1, q = 0;
        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i] > s[maxIdx]) {
                maxIdx = i;
            }else if (s[i] < s[maxIdx]) {
                p = i;
                q = maxIdx;
            }
        }
        if (p == -1) return num;
        s[p] ^= s[q];
        s[q] ^= s[p];
        s[p] ^= s[q];  //位运算交换位置
        String res =  new String(s);
        return Integer.parseInt(res);  //字符串转换成int
    }
}
