package dailyque;

class Solution_458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int n = minutesToTest / minutesToDie;
        return (int)Math.ceil(Math.log(buckets) / Math.log(n + 1) - 1e-5);
    }
}