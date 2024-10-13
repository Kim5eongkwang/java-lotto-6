package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import lotto.global.constant.Config;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoManager {
    private final List<Lotto> lottos;
    private final InputView inputView;
    private final OutputView outputView;
    private int purchasePrice;
    private final LottoGenerator lottoGenerator;
    private final Judgment judgment;
    private WinningNumber winningNumber;

    public LottoManager() {
        lottos = new ArrayList<>();
        outputView = new OutputView();
        inputView = new InputView(outputView);
        judgment = new Judgment();
        lottoGenerator = new RandomLottoGenerator();
    }

    public void startLottoProgram() {
        readPurchasePrice();
        makeLottos();
        printLottos();
        readWinningNumbers();
        printWinningResult();
        printEarningRate();
    }

    private void printWinningResult() {
        outputView.printWinningResult(judgment.calculateResult(winningNumber, lottos));
    }

    private void readWinningNumbers() {
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber(winningNumbers);

        winningNumber = new WinningNumber(winningNumbers, bonusNumber);
    }

    private void readPurchasePrice() {
        purchasePrice = inputView.readPurchasePrice();
    }

    private void printLottos() {
        outputView.printHowManyPurchase(getPurchaseSize());
        outputView.printLottos(lottos);
    }

    private int getPurchaseSize() {
        return purchasePrice / Config.LOTTO_COST;
    }

    private void makeLottos() {
        for (int i = 0; i < getPurchaseSize(); i++) {
            lottos.add(lottoGenerator.getLotto());
        }
    }

    private void printEarningRate() {
        HashMap<Score, Integer> result = judgment.calculateResult(winningNumber, lottos);
        int earningPrice = 0;
        for (Entry<Score, Integer> entry : result.entrySet()) {
            earningPrice += entry.getValue() * entry.getKey().getPrize();
        }

        String earningRate = String.format("%.1f", (double) earningPrice / purchasePrice * 100);
        outputView.printEarningRate(earningRate);
    }

}
