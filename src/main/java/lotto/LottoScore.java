/**
 * 당첨 번호와 일치하는 로또 번호 개수를 저장하는 클래스다.
 */

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
