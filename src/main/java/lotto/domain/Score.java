package lotto.domain;

public enum Score {
    FIRST (2000000000),
    SECOND (30000000),
    THIRD (1500000),
    FORTH (50000),
    FIFTH (5000),
    NO (0);

    private final int prize;

    Score(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}
