package model;

import java.util.Objects;

public class MatchResult {
    private final int scoreA;
    private final int scoreB;

    public MatchResult(int scoreA, int scoreB) {
        if (scoreA < 0 || scoreB < 0) {
            throw new IllegalArgumentException("Tỷ số không được âm!");
        }
        this.scoreA = scoreA;
        this.scoreB = scoreB;
    }

    public int getScoreA() { return scoreA; }
    public int getScoreB() { return scoreB; }

    // Logic xác định kết quả — đặt ở đây vì chỉ cần dữ liệu nội bộ (đúng nguyên tắc mình bàn ở câu trước)
    public boolean isDraw() {
        return scoreA == scoreB;
    }

    public boolean isTeamAWinner() {
        return scoreA > scoreB;
    }

    public boolean isTeamBWinner() {
        return scoreB > scoreA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchResult that = (MatchResult) o;
        return scoreA == that.scoreA && scoreB == that.scoreB;
    }

    @Override
    public int hashCode() {
        return Objects.hash(scoreA, scoreB);
    }

    @Override
    public String toString() {
        return scoreA + " : " + scoreB;
    }
}