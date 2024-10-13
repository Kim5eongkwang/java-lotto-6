package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.global.constant.Config;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoManager {
    private List<Lotto> lottos;
    private InputView inputView;
    private OutputView outputView;
    private int purchasePrice;
    private LottoGenerator lottoGenerator;

    public LottoManager() {
        lottos = new ArrayList<>();
        outputView = new OutputView();
        inputView = new InputView(outputView);
        lottoGenerator = new RandomLottoGenerator();
    }

    public void startLottoProgram() {
        readPurchasePrice();
        makeLottos();
        printLottos(lottos);
    }

    private void readPurchasePrice() {
        purchasePrice = inputView.readPurchasePrice();
    }

    private void printLottos(List<Lotto> lottos) {
        int purchaseSize = purchasePrice / Config.LOTTO_SIZE;
        outputView.printHowManyPurchase(purchaseSize);
        outputView.printLottos(lottos);
    }

    private void makeLottos() {
        int purchaseSize = purchasePrice / Config.LOTTO_SIZE;
        for (int i = 0; i < purchaseSize; i++) {
            lottos.add(lottoGenerator.getLotto());
        }
    }


}
