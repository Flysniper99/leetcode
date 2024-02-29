package DailyQue;

class Solution_2645 {
    public int addMinimum(String word) {
        int cnt = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) <= word.charAt(i - 1)) {
                cnt++;
            }
        }
        return cnt * 3 - word.length();
    }
}