package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static List<Integer> winningLottoNumbers;
    private static int specialLottoNumber;
    private static int playerCash;

    public static void inputPlayerCash() {
        System.out.println("구입금액을 입력해 주세요.");

        Input.playerCash = Integer.parseInt(Console.readLine());
    }

    public static void inputWinningLottoNumberAndSpecialNumber() {
        System.out.println("당첨 번호를 입력해주세요.");

        Input.winningLottoNumbers = new ArrayList<>();
        String[] numbers = Console.readLine().split(",");

        // sort string. this means lotto number also sorted.
        Arrays.sort(numbers);

        for(String number : numbers) {
            Input.winningLottoNumbers.add(Integer.parseInt(number));
        }

        System.out.println("보너스 번호를 입력해주세요.");
        Input.specialLottoNumber = Integer.parseInt(Console.readLine());
    }

    public static int getPlayerCash() {
        return Input.playerCash;
    }

    public static List<Integer> getWinningLottoNumbers() {
        return Input.winningLottoNumbers;
    }

    public static int getSpecialLottoNumber() {
        return Input.specialLottoNumber;
    }
}
