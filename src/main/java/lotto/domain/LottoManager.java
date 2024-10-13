package lotto.domain;

import java.util.ArrayList;
import java.util.List;
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
        return purchasePrice / Config.LOTTO_SIZE;
    }

    private void makeLottos() {
        for (int i = 0; i < getPurchaseSize(); i++) {
            lottos.add(lottoGenerator.getLotto());
        }
    }


}
