package dailyque;

class Solution_2697 {
    public String makeSmallestPalindrome(String s) {
        char[] ch = s.toCharArray();
        int left = 0;
        int right = ch.length - 1;
        while (left < right) {
            if (ch[left] != ch[right]) {
                ch[left] = ch[right] = (char) Math.min(ch[left], ch[right]);
            }
            ++left;
            --right;
        }
        return new String(ch);
    }
}