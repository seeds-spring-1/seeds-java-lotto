package lotto;

import java.util.List;

public class LottoAwardDecider {
    private LottoScore lottoScore;

    public LottoAwardDecider() {
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

        for(Integer number : playerLotto.get()) {
            boolean isEqualNumberExist = false;

            for(Integer winningNumber : winningLotto.get()) {
                if (number.equals(winningNumber)) {
                    isEqualNumberExist = true;
                    break;
                }
            }

            if(isEqualNumberExist) {
                lottoScore.increaseScore();
            }

            if (number.equals(winningLotto.getSpecialNumber())){
                lottoScore.earnBonus();
            }
        }
    }
}
