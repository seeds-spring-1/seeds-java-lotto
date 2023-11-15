/**
 * 로또 당첨 번호를 의미한다.
 */

package lotto;

import java.util.List;
import java.util.ListIterator;

public class WinningLotto extends Lotto {
    private final int specialNumber;

    public WinningLotto(List<Integer> lottoNumber, int specialNumber) {
        super(lottoNumber);
        this.specialNumber = specialNumber;
    }

    public int getSpecialNumber() {
        return specialNumber;
    }

    public boolean hasNumber(Integer number) {
        ListIterator<Integer> iter = getListIterator();
        while (iter.hasNext()) {
            Integer winningNumber = iter.next();
            if (winningNumber.equals(number)) {
                return true;
            }
        }
        return false;
    }
}
