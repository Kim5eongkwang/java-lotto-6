package lotto.ui;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Score;
import lotto.global.constant.Config;

public class OutputView {
    public void printPurchaseMessage() {
        System.out.println(Config.PURCHASE_PRICE_MESSAGE);
    }

    public void printHowManyPurchase(int number) {
        println(number + Config.HOW_MANY_PURCHASE_MESSAGE);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            println("[" + lotto.getLottoNumbers()
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")) + "]");
        }
    }

    public void printReadWinningNumbersMessage() {
        println(Config.READ_WINNING_NUMBERS_MESSAGE);
    }

    public void printReadBonusNumberMessage() {
        println(Config.READ_BONUS_NUMBER_MESSAGE);
    }

    public void printWinningResult(HashMap<Score, Integer> result) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        int correct = 3;
        for (Entry<Score, Integer> entry : result.entrySet()) {
            println(correct++ + "개 일치 (" + formatter.format(entry.getKey().getPrize()) + ") - " + entry.getValue());
        }
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void print(String message) {
        System.out.println(message);
    }
}
