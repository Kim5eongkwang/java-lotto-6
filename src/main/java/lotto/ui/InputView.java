package lotto.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.global.util.Validator;

public class InputView {

    private final OutputView outputView;


    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public int readPurchasePrice() {
        outputView.printPurchaseMessage();

        String input = readLine();
        validateReadPurchasePrice(input);

        return Integer.parseInt(input);
    }

    private void validateReadPurchasePrice(String input) {
        Validator.validatePurchasePrice(input);
    }

}
