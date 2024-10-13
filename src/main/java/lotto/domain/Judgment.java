package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Judgment {

    public HashMap<Score, Integer> calculateResult(WinningNumber winningNumber, List<Lotto> lottos) {
        HashMap<Score, Integer> map = makeResultTable();
        for (Lotto lotto : lottos) {
            Score score = getScore(winningNumber, lotto);
            int value = map.get(score);
            map.replace(score, ++value);
        }
        return map;
    }

    private HashMap<Score, Integer> makeResultTable() {
        HashMap<Score, Integer> map = new HashMap<>();
        Stream.of(Score.values())
                .forEach(score -> map.put(score, 0));
        return map;
    }

    public Score getScore(WinningNumber winningNumber, Lotto myLotto) {
        int correct = getCorrect(winningNumber, myLotto);
        if (correct == 3) {
            return Score.FIFTH;
        }
        if (correct == 4) {
            return Score.FORTH;
        }
        if (correct == 5) {
            return compareWithBonusNumber(winningNumber, myLotto);
        }
        if (correct == 6) {
            return Score.FIRST;
        }
        return Score.NO;
    }

    /**
     * 2등 당첨 조건을 검사함
     *
     * @param winningNumber
     * @param myLotto
     * @return 조건 만족 시 SECOND 만족하지 않다면 THIRD 반환
     */
    private Score compareWithBonusNumber(WinningNumber winningNumber, Lotto myLotto) {
        List<Integer> myList = myLotto.getLottoNumbers();
        if (myList.contains(winningNumber.getBonusNumber())) {
            return Score.SECOND;
        }
        return Score.THIRD;
    }

    private int getCorrect(WinningNumber winningNumber, Lotto myLotto) {
        int correct = 0;

        List<Integer> myNumbers = myLotto.getLottoNumbers();
        List<Integer> winningNumbers = winningNumber.getNumbers();
        for (Integer number : myNumbers) {
            if (winningNumbers.contains(number)) {
                correct++;
            }
        }

        return correct;
    }


}
