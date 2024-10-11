package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.global.constant.Config;

public class RandomLottoGenerator implements LottoGenerator {

    @Override
    public Lotto getLotto() {
        return new Lotto(makeNumber());
    }

    private List<Integer> makeNumber() {
        return Randoms.pickUniqueNumbersInRange(Config.MIN_LOTTO_NUMBER, Config.MAX_LOTTO_NUMBER, Config.LOTTO_SIZE);
    }
}
