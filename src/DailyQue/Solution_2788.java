package DailyQue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_2788 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("one.two.three","four.five","six");
        System.out.println(Arrays.toString(splitWordsBySeparator(words, '.').toArray()));
    }
    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            for (int left = 0, i = 0; i <= word.length(); i++) {
                if (i != word.length() && word.charAt(i) != separator) continue;
                if (i > left) {
                    res.add(word.substring(left, i));
                }
                left = i + 1;
            }
        }
        return res;
    }
}