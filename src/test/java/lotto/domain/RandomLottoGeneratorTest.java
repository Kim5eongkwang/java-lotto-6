package lotto.domain;


import java.util.List;
import lotto.global.constant.Config;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomLottoGeneratorTest {

    @Test
    void 생성된_로또번호_크기_확인() {
        //given
        LottoGenerator generator = new RandomLottoGenerator();

        //when
        Lotto lotto = generator.getLotto();

        //then
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(Config.LOTTO_SIZE);
    }

}