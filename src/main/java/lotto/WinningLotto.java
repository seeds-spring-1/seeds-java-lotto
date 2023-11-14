package lotto;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int specialNumber;
    public WinningLotto(List<Integer> lottoNumber, int specialNumber) {
        super(lottoNumber);
        this.specialNumber = specialNumber;
    }

    public int getSpecialNumber() {
        return specialNumber;
    }
}
