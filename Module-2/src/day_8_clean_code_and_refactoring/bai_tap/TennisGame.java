package day_8_clean_code_and_refactoring.bai_tap;

public class TennisGame {
    public static final int MARK_SCORE = 4;
    public static final String SCORE_0 = "Love";
    public static final String SCORE_1 = "Fifteen";
    public static final String SCORE_2 = "Thirty";
    public static final String SCORE_3 = "Forty";
    public static final String TIE = "Deuce";
    public static final String ADVANTAGE = "Advantage ";
    public static final String WIN_FOR = "Win for ";
    public static final String ALL = "All";

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String player1 = "player 1";
        String player2 = "player 2";
        String player1Score_string = getPlayerScore(player1Score);
        String player2Score_string = getPlayerScore(player2Score);
        String score = player1Score_string + "-";

        if (player1Score >= MARK_SCORE || player2Score >= MARK_SCORE) {
            int minusResult = player1Score - player2Score;
            boolean tie = minusResult == 0;
            boolean win1Point = minusResult == 1;
            boolean lose1Point = minusResult == -1;
            boolean winMorePoint = minusResult >= 2;

            if (tie) {
                score = TIE;
            } else if (win1Point) {
                score = ADVANTAGE + player1;
            } else if (lose1Point) {
                score = ADVANTAGE + player2;
            } else if (winMorePoint) {
                score = WIN_FOR + player1;
            } else {
                score = WIN_FOR + player2;
            }
        } else if (player1Score == player2Score) {
            score += ALL;
        } else {
            score += player2Score_string;
        }
        return score;
    }

    public static String getPlayerScore(int playerScore) {  // get Player score in String
        String score;
        switch (playerScore) {
            case 0:
                score = SCORE_0;
                break;
            case 1:
                score = SCORE_1;
                break;
            case 2:
                score = SCORE_2;
                break;
            case 3:
                score = SCORE_3;
                break;
            default:
                score = "";
        }
        return score;
    }
}
