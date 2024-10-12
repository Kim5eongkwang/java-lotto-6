package lotto.global.util;

import java.util.List;
import lotto.global.constant.Config;

public class Validator {
    public static void validateLottoNumber(List<String> lottoNumbers) {
        for (String lottoNumber : lottoNumbers) {
            validateNumberFormat(lottoNumber);
        }
    }

    private static void validateNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Config.NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }


}
