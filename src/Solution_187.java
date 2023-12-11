import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution_187 {
    public List<String> findRepeatedDnaSequences(String s) {

        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            int temp = map.getOrDefault(s.substring(i, i + 10), 0);
            map.put(s.substring(i, i + 10), ++temp);
            if (map.get(s.substring(i, i + 10)) >= 2 && !res.contains(s.substring(i, i + 10))) {
                res.add(s.substring(i, i + 10));
            }
        }
        return res;
    }
}