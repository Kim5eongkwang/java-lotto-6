package lotto.domain;


import java.util.Arrays;
import org.junit.jupiter.api.Test;

class JudgmentTest {

    @Test
    void 일등상_당첨() {
        //given
        Lotto myLotto = new Lotto(Arrays.asList(0, 1, 2, 3, 4, 5));
        WinningNumber winningNumber = new WinningNumber(
                Arrays.asList(0, 1, 2, 3, 4, 5), 7);
        Judgment judgment = new Judgment();
        //when

        Score testScore = judgment.getScore(winningNumber, myLotto);

        //then
        org.assertj.core.api.Assertions.assertThat(testScore).isEqualTo(Score.FIRST);
    }

    @Test
    void 이등상_당첨() {
        Lotto myLotto = new Lotto(Arrays.asList(0, 1, 2, 3, 4, 5));
        WinningNumber winningNumber = new WinningNumber(
                Arrays.asList(0, 1, 2, 3, 4, 7), 5);
        Judgment judgment = new Judgment();
        //when

        Score testScore = judgment.getScore(winningNumber, myLotto);

        //then
        org.assertj.core.api.Assertions.assertThat(testScore).isEqualTo(Score.SECOND);
    }

    @Test
    void 삼등상_당첨() {
        Lotto myLotto = new Lotto(Arrays.asList(0, 1, 2, 3, 4, 5));
        WinningNumber winningNumber = new WinningNumber(
                Arrays.asList(0, 1, 2, 3, 4, 9), 7);
        Judgment judgment = new Judgment();
        //when

        Score testScore = judgment.getScore(winningNumber, myLotto);

        //then
        org.assertj.core.api.Assertions.assertThat(testScore).isEqualTo(Score.THIRD);
    }

    @Test
    void 사등상_당첨() {
        Lotto myLotto = new Lotto(Arrays.asList(0, 1, 2, 3, 4, 5));
        WinningNumber winningNumber = new WinningNumber(
                Arrays.asList(0, 1, 2, 4, 9, 10), 7);
        Judgment judgment = new Judgment();
        //when

        Score testScore = judgment.getScore(winningNumber, myLotto);

        //then
        org.assertj.core.api.Assertions.assertThat(testScore).isEqualTo(Score.FORTH);
    }

    @Test
    void 오등상_당첨() {
        Lotto myLotto = new Lotto(Arrays.asList(0, 1, 2, 3, 4, 5));
        WinningNumber winningNumber = new WinningNumber(
                Arrays.asList(0, 1, 2, 8, 9, 10), 7);
        Judgment judgment = new Judgment();
        //when

        Score testScore = judgment.getScore(winningNumber, myLotto);

        //then
        org.assertj.core.api.Assertions.assertThat(testScore).isEqualTo(Score.FIFTH);
    }

    @Test
    void 당첨이_안된_경우() {
        Lotto myLotto = new Lotto(Arrays.asList(0, 1, 2, 3, 4, 5));
        WinningNumber winningNumber = new WinningNumber(
                Arrays.asList(0, 1, 7, 8, 9, 10), 5);
        Judgment judgment = new Judgment();
        //when

        Score testScore = judgment.getScore(winningNumber, myLotto);

        //then
        org.assertj.core.api.Assertions.assertThat(testScore).isEqualTo(Score.NO);
    }

}