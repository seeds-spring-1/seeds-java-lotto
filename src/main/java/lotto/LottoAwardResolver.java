/**
 * 플레이어의 로또 번호들과 당첨 번호를 비교한 결과를 종합하여
 * LottoAward 타입으로 반환하는 책임을 갖는다.
 */

package lotto;

import java.util.List;
import java.util.ListIterator;

public class LottoAwardResolver {
    private LottoScore lottoScore;

    public LottoAwardResolver() {
    }

    public LottoAward decideAward(WinningLotto winningLotto, List<Lotto> playerLottoList) {
        LottoAward lottoAward = new LottoAward();

        for (Lotto playerLotto : playerLottoList) {
            // get count of equal number from winningLotto
            checkPlayerLottoScoreByWinningLotto(playerLotto, winningLotto);

            // if count is 5 and there is number which is bonus number,
            // award 2nd rank.
            lottoAward.updateAward(lottoScore);
        }
        return lottoAward;
    }

    public void checkPlayerLottoScoreByWinningLotto(Lotto playerLotto, WinningLotto winningLotto) {
        lottoScore = new LottoScore();

        ListIterator<Integer> iter = playerLotto.getListIterator();
        while (iter.hasNext()) {
            Integer number = iter.next();
            if (winningLotto.hasNumber(number)) {
                lottoScore.increaseScore();
            }

            if (number.equals(winningLotto.getSpecialNumber())) {
                lottoScore.earnBonus();
            }
        }
    }
}
