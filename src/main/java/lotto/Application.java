package lotto;

import java.util.List;

public class Application {
    private static List<Lotto> playerLottoList;

    public static void main(String[] args) {
        try {
            // generate player's lotto game by input
            Input.inputPlayerCash();
            LottoGenerator lottoGenerator = new LottoGenerator();
            Application.playerLottoList = lottoGenerator.generateRandomLottoListByCash(Input.getPlayerCash());

            // print player lotto list
            Application.printPlayerLottoList();

            // input winning lotto
            Input.inputWinningLottoNumber();
            Lotto winningLotto = new Lotto(Input.getWinningLottoNumbers());

            // decide award
            LottoAwardDecider lottoAwardDecider = new LottoAwardDecider();
            LottoAward lottoAward = lottoAwardDecider.decideAward(
                    winningLotto,
                    Application.playerLottoList
            );

            // print award and profit rate
            LottoAwardPresenter.printAwardAndProfitRate(lottoAward);
        }
        catch(IllegalArgumentException exception) {
            System.out.println("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
        }
    }

    public static void printPlayerLottoList() {
        for(Lotto lotto : Application.playerLottoList) {
            System.out.println(lotto);
        }
    }
}
