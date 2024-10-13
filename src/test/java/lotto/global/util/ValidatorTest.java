package lotto.global.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.global.constant.Config;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void 로또_번호_입력중_숫자가_아닌_값_입력시_예외_처리() {
        //given
        ArrayList<String> lottoList = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f"));
        //when

        //then
        Assertions.assertThatThrownBy(() -> Validator.validateLottoNumber(lottoList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Config.NUMBER_FORMAT_ERROR_MESSAGE);
    }

    @Test
    void 로또_금액으로_나눠떨어지지_않을때_예외처리() {
        //given
        String cost = Integer.toString(Config.LOTTO_COST + 1);

        //when

        //then
        Assertions.assertThatThrownBy(() -> Validator.validatePurchasePrice(cost))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Config.DIVISION_BY_COST_ERROR_MESSAGE);
    }

    @Test
    void 당첨_번호_크기_이상_예외처리() {
        //given
        String string = "";

        //when

        //then
        Assertions.assertThatThrownBy(() -> Validator.validateWinningNumber(string))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Config.WINNING_NUMBER_SIZE_ERROR_MESSAGE);
    }

    @Test
    void 당첨_번호_경계값_예외처리() {
        //given
        String input = makeOutBoundaryWinningNumber();
        //when

        //then
        Assertions.assertThatThrownBy(() -> Validator.validateWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Config.WINNING_NUMBER_BOUNDARY_ERROR_MESSAGE);
    }

    @Test
    void 당첨_번호_중복_예외처리() {
        //given
        String input = makeDuplicateWinningNumber();
        //when

        //then
        Assertions.assertThatThrownBy(() -> Validator.validateWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Config.WINNING_NUMBER_DUPLICATE_ERROR_MESSAGE);

    }

    @Test
    void 보너스_번호_중복_예외처리() {
        //given
        String input = "1";
        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(1);
        //when

        //then
        Assertions.assertThatThrownBy(() -> Validator.validateReadBonusNumber(winningNumbers, input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Config.WINNING_NUMBER_DUPLICATE_ERROR_MESSAGE);
    }

    private String makeOutBoundaryWinningNumber() {
        int outBoundary = Config.MAX_LOTTO_NUMBER;
        List<String> list = new ArrayList<>();

        for (int i = 0; i < Config.LOTTO_SIZE; i++) {
            list.add(Integer.toString(outBoundary++));
        }
        return String.join(",", list);
    }

    private String makeDuplicateWinningNumber() {
        int value = Config.MIN_LOTTO_NUMBER;
        List<String> list = new ArrayList<>();

        for (int i = 0; i < Config.LOTTO_SIZE; i++) {
            list.add(Integer.toString(value));
        }

        return String.join(",", list);
    }

}