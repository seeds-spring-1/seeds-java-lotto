package lotto;


import java.util.List;
import java.util.Vector;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {
    public LottoGenerator() {
    }

    public List<Lotto> generateRandomLottoListByCash(int cash) {
        Vector<Lotto> lottoList = new Vector<>();

        cash /= 1000;

        while (cash-- > 0) {
            lottoList.add(this.generateRandomLotto());
        }

        return lottoList;
    }

    private Lotto generateRandomLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
