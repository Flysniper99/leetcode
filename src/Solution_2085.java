import java.util.HashMap;
import java.util.Map;

class Solution_2085 {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> Map_1 = new HashMap<>();
        Map<String, Integer> Map_2 = new HashMap<>();
        getWordsFreq(words1, Map_1);
        getWordsFreq(words2, Map_2);

        int res = 0;
        for (String i : Map_1.keySet()) {
            if (Map_1.get(i) == 1 && Map_2.getOrDefault(i, 0) == 1) {
                res++;
            }
        }
        return res;
    }

    public void getWordsFreq(String[] word , Map<String, Integer> Map) {
        for (String i : word) {
            Map.put(i, Map.getOrDefault(i, 0) + 1);
        }
    }
}