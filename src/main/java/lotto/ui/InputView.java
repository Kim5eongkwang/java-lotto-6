package lotto.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.stream.Collectors;
import lotto.global.constant.Config;
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

    public List<Integer> readWinningNumbers() {
        String input = readLine();
        validateWinningNumbers(input);
        return getWinningNumberList(input);
    }

    public int readBonusNumber(List<Integer> winningNumbers) {
        String input = readLine();
        Validator.validateReadBonusNumber(winningNumbers, input);
        return Integer.parseInt(input);
    }

    private List<Integer> getWinningNumberList(String input) {
        List<String> list = List.of(input.split(Config.SEPARATOR));
        return list.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


    private void validateWinningNumbers(String input) {
        Validator.validateWinningNumber(input);
    }

}
