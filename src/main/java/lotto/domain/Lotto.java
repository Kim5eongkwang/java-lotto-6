package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.global.util.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // validate 클래스로 따로 빼두기
    private void validate(List<Integer> numbers) {
        Validator.validateLottoNumber(numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList()));
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
