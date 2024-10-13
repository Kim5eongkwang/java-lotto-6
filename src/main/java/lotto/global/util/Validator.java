package lotto.global.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    public static void validatePurchasePrice(String price) {
        validateNumberFormat(price);
        validateDivisionByCost(Integer.parseInt(price));
    }

    public static void validateDivisionByCost(int number) {
        if (number % Config.LOTTO_COST != 0) {
            throw new IllegalArgumentException(Config.DIVISION_BY_COST_ERROR_MESSAGE);
        }
    }

    public static void validateWinningNumber(String winningNumbers) {
        List<String> list = List.of(winningNumbers.split(Config.SEPARATOR));
        validateWinningNumberSize(list.size());
        validateWinningNumberFormat(list);
        validateWinningNumberBoundary(list);
        validateNumberDuplicate(list);
    }

    private static void validateWinningNumberFormat(List<String> winningNumbers) {
        for (String winningNumber : winningNumbers) {
            try {
                validateNumberFormat(winningNumber);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(Config.WINNING_NUMBER_FORMAT_ERROR_MESSAGE);
            }
        }
    }

    private static void validateWinningNumberSize(int size) {
        if (size != Config.WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException(Config.WINNING_NUMBER_SIZE_ERROR_MESSAGE);
        }
    }

    private static void validateWinningNumberBoundary(List<String> winningNumbers) {
        for (String winningNumber : winningNumbers) {
            int number = Integer.parseInt(winningNumber);
            validateLottoNumberBoundary(number);
        }
    }

    private static void validateLottoNumberBoundary(int number) {
        if (number < Config.MIN_LOTTO_NUMBER || number > Config.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(Config.WINNING_NUMBER_BOUNDARY_ERROR_MESSAGE);
        }
    }

    private static void validateNumberDuplicate(List<String> winningNumbers) {
        Set<String> winningNumberSet = new HashSet<>(winningNumbers);
        if (winningNumberSet.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(Config.WINNING_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void validateReadBonusNumber(List<Integer> winningNumbers, String input) {
        validateNumberFormat(input);
        validateLottoNumberBoundary(Integer.parseInt(input));
        List<String> list = new java.util.ArrayList<>(winningNumbers.stream()
                .map(String::valueOf)
                .toList());
        list.add(input);
        validateNumberDuplicate(list);
    }


}
