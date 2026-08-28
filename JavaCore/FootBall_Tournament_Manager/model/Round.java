package FootBall_Tournament_Manager.model;

import java.util.Objects;
import FootBall_Tournament_Manager.model.enums.RoundType;

public class Round {
    private final RoundType type;
    private final int number;

    public Round(RoundType type, int number) {
        if (type == null) {
            throw new IllegalArgumentException("Type không được để trống");
        }
        if (number <= 0) {
            throw new IllegalArgumentException("Số vòng đấu phải lớn hơn 0!");
        }
        this.type = type;
        this.number = number;
    }

    public RoundType getType() { return type; }
    public int getNumber() { return number; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return number == round.number && type == round.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, number);
    }

    @Override
    public String toString() {
        return type + " " + number;
    }
}