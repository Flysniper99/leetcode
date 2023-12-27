import java.util.ArrayList;
import java.util.List;

class Solution_1276 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if (tomatoSlices % 2 != 0 || tomatoSlices < cheeseSlices * 2 || cheeseSlices * 4 < tomatoSlices) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        res.add(tomatoSlices / 2 - cheeseSlices);
        res.add(cheeseSlices * 2 - tomatoSlices / 2);
        return res;
    }
}
