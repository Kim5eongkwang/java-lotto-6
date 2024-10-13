package lotto.domain;

public enum Score {

    NO(0),
    FIFTH(5000),
    FORTH(50000),
    THIRD(1500000),
    SECOND(30000000),
    FIRST(2000000000);


    private final int prize;

    Score(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}
