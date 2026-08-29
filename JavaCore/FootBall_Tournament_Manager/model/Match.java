package model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import model.enums.MatchStatus;

public class Match {
    private final UUID id;
    private Team teamA;
    private Team teamB;
    private Round round; 
    private MatchStatus status;
    private MatchResult result;
    private LocalDateTime scheduledAt;

    public Match() {
        this.id = UUID.randomUUID();
        this.status = MatchStatus.SCHEDULED;  
        this.result = null;                   
    }

    public Match(Team teamA, Team teamB, Round round, LocalDateTime scheduledAt) {
        this();
        setTeamA(teamA);
        setTeamB(teamB);
        setRound(round);
        setScheduledAt(scheduledAt);
        validateTeamsAreDifferent();
    }

    public UUID getId() { return id; }

    public Team getTeamA() { return teamA; }
    public void setTeamA(Team teamA) {
        if (teamA == null) {
            throw new IllegalArgumentException("Team A không được để trống!");
        }
        this.teamA = teamA;
    }

    public Team getTeamB() { return teamB; }
    public void setTeamB(Team teamB) {
        if (teamB == null) {
            throw new IllegalArgumentException("Team B không được để trống!");
        }
        this.teamB = teamB;
    }

    public Round getRound() { return round; }
    public void setRound(Round round) {
        if (round == null) {
            throw new IllegalArgumentException("Vòng đấu không được để trống!");
        }
        this.round = round;
    }

    public MatchStatus getStatus() { return status; }
    public void setStatus(MatchStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Trạng thái không được để trống!");
        }
        this.status = status;
    }

    public MatchResult getResult() { return result; }
    public void setResult(MatchResult result) {
        if (result == null) {
            throw new IllegalArgumentException("Kết quả không được để trống!");
        }
        this.result = result;
    }

    public LocalDateTime getScheduledAt() { return scheduledAt; }
    public void setScheduledAt(LocalDateTime scheduledAt) {
        if (scheduledAt == null) {
            throw new IllegalArgumentException("Thời gian thi đấu không được để trống!");
        }
        this.scheduledAt = scheduledAt;
    }

    // Đảm bảo 1 đội không đấu với chính mình
    private void validateTeamsAreDifferent() {
        if (teamA != null && teamB != null && teamA.equals(teamB)) {
            throw new IllegalArgumentException("Team A và Team B không được trùng nhau!");
        }
    }

    public void completeMatch(MatchResult result) {
        setResult(result);
        setStatus(MatchStatus.COMPLETED);
    }

    // ─── equals / hashCode / toString ────────────────────

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(id, match.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", teamA=" + (teamA != null ? teamA.getName() : "null") +
                ", teamB=" + (teamB != null ? teamB.getName() : "null") +
                ", round=" + round +
                ", status=" + status +
                ", result='" + result + '\'' +
                ", scheduledAt=" + scheduledAt +
                '}';
    }
}