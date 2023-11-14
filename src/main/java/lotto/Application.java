package lotto;

import java.util.List;

public class Application {
    private static List<Lotto> PlayerLottoList;

    public static void main(String[] args) {
        try {
            // generate player's lotto game by input
            Input.InputPlayerCash();
            LottoGenerator lottoGenerator = new LottoGenerator();
            Application.PlayerLottoList = lottoGenerator.generateRandomLotto(Input.getPlayerCash());

            // print player lotto list
            Application.PrintPlayerLottoList();

            // input winning lotto
            Input.inputWinningLottoNumber();
            Lotto winningLotto = new Lotto(Input.getWinningLottoNumber());

            // decide award
            LottoAwardDecider lottoAwardDecider = new LottoAwardDecider();
            LottoAward lottoAward = lottoAwardDecider.decideAward(
                    winningLotto,
                    Application.PlayerLottoList
            );

            // print award and profit rate
            LottoAwardPresenter.printAwardAndProfitRate(lottoAward);
        }
        catch(IllegalArgumentException exception) {
            System.out.println("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
        }
    }

    public static void PrintPlayerLottoList() {
        for(Lotto lotto : Application.PlayerLottoList) {
            System.out.println(lotto);
        }
    }
}
