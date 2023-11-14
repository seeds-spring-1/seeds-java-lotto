package lotto;

public class LottoScore {
    private int score;
    private boolean bonus;

    public LottoScore() {
        score = 0;
        bonus = false;
    }

    public void increaseScore() {
        score++;
    }

    public void earnBonus() {
        bonus = true;
    }

    public int getScore() {
        return score;
    }

    public boolean hasBonus() {
        return bonus;
    }
}
