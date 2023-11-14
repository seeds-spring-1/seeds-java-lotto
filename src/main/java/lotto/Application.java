package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Lotto winningLotto = null;
        try {
            // get input
            Input.run();
            winningLotto = new Lotto(Input.getWinningLottoNumber());

            // generate player's lotto game by input
            LottoGenerator lottoGenerator = new LottoGenerator();
            List<Lotto> playerLottoList = lottoGenerator.generateRandomLotto(Input.getPlayerCash());

            // decide award
            LottoAwardDecider lottoAwardDecider = new LottoAwardDecider();
            LottoAward lottoAward = lottoAwardDecider.decideAward(
                    winningLotto,
                    playerLottoList
            );

            // print award and profit rate
            LottoAwardPresenter.printAwardAndProfitRate(lottoAward);
        }
        catch(IllegalArgumentException exception) {
            System.out.println("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
        }
    }
}
