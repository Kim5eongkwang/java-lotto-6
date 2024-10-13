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
            if (entry.getKey() == Score.NO) {
                continue;
            }
            if (entry.getKey() == Score.THIRD) {
                println(correct + "개 일치 (" + formatter.format(entry.getKey().getPrize()) + "원) - " + entry.getValue()
                        + "개");
                continue;
            }
            if (entry.getKey() == Score.SECOND) {
                println(correct++ + "개 일치, 보너스 볼 일치 (" + formatter.format(entry.getKey().getPrize()) + "원) - "
                        + entry.getValue() + "개");
                continue;
            }

            println(correct++ + "개 일치 (" + formatter.format(entry.getKey().getPrize()) + "원) - " + entry.getValue()
                    + "개");
        }
    }

    private void println(String message) {
        System.out.println(message);
    }

    public void printEarningRate(String rate) {
        println("총 수익률은 " + rate + "%입니다.");
    }
}
