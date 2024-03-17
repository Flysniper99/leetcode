package dailyque;

import java.util.List;

class Solution_2828 {
    public boolean isAcronym(List<String> words, String s) {
        StringBuilder res = new StringBuilder();
        for (String str : words) {
            res.append(str.charAt(0));
        }
        return res.toString().equals(s);
    }
}