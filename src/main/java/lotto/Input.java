package lotto;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static List<Integer> winningLottoNumbers;
    private static int playerCash;

    public static void inputPlayerCash() {
        System.out.println("구입금액을 입력해 주세요.");

        Input.playerCash = Integer.parseInt(Console.readLine());
    }

    public static void inputWinningLottoNumber() {
        System.out.println("당첨 번호를 입력해주세요.");

        Input.winningLottoNumbers = new Vector<Integer>();
        String numbers = Console.readLine();
        for(String ch : numbers.split(",")) {
            Input.winningLottoNumbers.add(Integer.parseInt(ch));
        }
    }

    public static int getPlayerCash() {
        return Input.playerCash;
    }

    public static List<Integer> getWinningLottoNumbers() {
        return Input.winningLottoNumbers;
    }
}
