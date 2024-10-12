package lotto.global.util;

import java.util.ArrayList;
import java.util.Arrays;
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
        int cost = Config.LOTTO_COST + 1;

        //when

        //then
        Assertions.assertThatThrownBy(() -> Validator.validateDivisionByCost(cost))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Config.DIVISION_BY_COST_ERROR_MESSAGE);
    }

}