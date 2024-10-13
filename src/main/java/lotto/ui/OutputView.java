package lotto.ui;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
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

    private void println(String message) {
        System.out.println(message);
    }

    private void print(String message) {
        System.out.println(message);
    }
}
