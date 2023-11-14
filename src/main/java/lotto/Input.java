package lotto;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Input {
    private static Scanner Scanner;
    private static List<Integer> winningLottoNumbers;
    private static int playerCash;

    public static void inputPlayerCash() {
        Input.createScanner();
        System.out.println("구입금액을 입력해 주세요.");

        Input.playerCash = Input.Scanner.nextInt();
    }

    public static void inputWinningLottoNumber() {
        Input.createScanner();
        System.out.println("당첨 번호를 입력해주세요.");

        Input.winningLottoNumbers = new Vector<Integer>();
        String numbers = Input.Scanner.nextLine();
        for(String ch : numbers.split(",")) {
            Input.winningLottoNumbers.add(Integer.parseInt(ch));
        }
    }

    private static void createScanner() {
        if(Input.Scanner == null) {
            Input.Scanner = new Scanner(System.in);
        }
    }

    public static int getPlayerCash() {
        return Input.playerCash;
    }

    public static List<Integer> getWinningLottoNumbers() {
        return Input.winningLottoNumbers;
    }
}
