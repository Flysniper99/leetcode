package dailyque;

class Solution_2660 {
    public int isWinner(int[] player1, int[] player2) {
        int score_1 = getScore(player1);
        int score_2 = getScore(player2);
        return score_1 > score_2? 1 : score_1 == score_2? 0 : 2;
    }

    public static int getScore(int[] player) {
        int sum = 0;
        for (int i = 0; i < player.length; i++) {
            if (i > 0 && player[i - 1] == 10 || i > 1 && player[i - 2] == 10) {
                sum += 2*player[i];
            }else {
                sum += player[i];
            }
        }
        return sum;
    }
}