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
            Application.printPlayerCashAndLottoList(Input.getPlayerCash());

            // input winning lotto
            Input.inputWinningLottoNumberAndSpecialNumber();
            WinningLotto winningLotto = new WinningLotto(Input.getWinningLottoNumbers(), Input.getSpecialLottoNumber());

            // decide award
            LottoAwardDecider lottoAwardDecider = new LottoAwardDecider();
            LottoAward lottoAward = lottoAwardDecider.decideAward(
                    winningLotto,
                    Application.playerLottoList
            );

            // print award and profit rate
            LottoAwardPresenter lottoAwardPresenter = new LottoAwardPresenter();
            lottoAwardPresenter.printAwardAndProfitRate(lottoAward, Input.getPlayerCash());
        }
        catch(IllegalArgumentException exception) {
            System.out.println("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
        }
    }

    public static void printPlayerCashAndLottoList(int playerCash) {
        playerCash /= 1000;
        System.out.printf("%d개를 구매했습니다.\n", playerCash);
        for(Lotto lotto : Application.playerLottoList) {
            System.out.println(lotto);
        }
    }
}
