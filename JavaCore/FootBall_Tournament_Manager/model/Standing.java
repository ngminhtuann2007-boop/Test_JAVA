package FootBall_Tournament_Manager.model;

import java.util.Objects;

public class Standing {
    private final Team team;
    private int played;
    private int wins;
    private int draws;
    private int losses;
    private int points;
    private int goalsFor;
    private int goalsAgainst;
    
    public Standing(Team team) {
        if (team == null) {
            throw new IllegalArgumentException("Team không được để trống!");
        }
        this.team = team;
        this.played = 0;
        this.wins = 0;
        this.draws = 0;
        this.losses = 0;
        this.points = 0;
        this.goalsFor = 0;
        this.goalsAgainst = 0;
    }

    public Standing(Team team, int played, int wins,int draws, int losses, int points, int goalsFor, int goalsAgainst) {
        this(team);
        setPlayed(played);
        setWins(wins);
        setDraws(draws);
        setLosses(losses);
        setPoints(points);
        setGoalsFor(goalsFor);
        setGoalsAgainst(goalsAgainst);
    }

    public Team getTeam() { return team; }

    public int getPlayed() { return played; }
    public void setPlayed(int played) {
        if(played < 0) throw new IllegalArgumentException("Số trận không được âm");
        this.played = played;
    }

    public int getWins() { return wins; }
    public void setWins(int wins) {
        if(wins < 0) throw new IllegalArgumentException("Số trận thắng không được âm");
        this.wins = wins;
    }

    public int getDraws() { return draws; }
    public void setDraws(int draws) {
        if(draws < 0) throw new IllegalArgumentException("Số trận hòa không được âm");
        this.draws = draws;
    }

    public int getLosses() { return losses; }
    public void setLosses(int losses) {
        if(losses < 0) throw new IllegalArgumentException("Số trận thua không được âm");
        this.losses = losses;
    }

    public int getPoints() { return points; }
    public void setPoints(int points) {
        if(points < 0) throw new IllegalArgumentException("Điểm không được âm");
        this.points = points;
    }

    public int getGoalsFor() { return goalsFor; }
    public void setGoalsFor(int goalsFor) {
        if(goalsFor < 0) throw new IllegalArgumentException("Số bàn thắng không được âm");
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgainst() {return goalsAgainst;}
    public void setGoalsAgainst(int goalsAgainst) {
        if(goalsAgainst < 0) throw new IllegalArgumentException("Số bàn thua không được âm");
        this.goalsAgainst = goalsAgainst;
    }

    public void recordWin(int goalsFor, int goalsAgainst) {
        this.played++;
        this.wins++;
        this.points += 3;
        this.goalsFor += goalsFor;
        this.goalsAgainst += goalsAgainst;
    }

    public void recordDraw(int goalsFor, int goalsAgainst) {
        this.played++;
        this.draws++;
        this.points += 1;
        this.goalsFor += goalsFor;
        this.goalsAgainst += goalsAgainst;
    }

    public void recordLoss(int goalsFor, int goalsAgainst) {
        this.played++;
        this.losses++;
        this.goalsFor += goalsFor;
        this.goalsAgainst += goalsAgainst;
    }
    
    public int getGoalDifference() {
        return goalsFor - goalsAgainst;
    }

    @Override 
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || getClass() == o.getClass()) return false;
        Standing standing = (Standing) o;
        return Objects.equals(this.team, standing.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(team);
    }

    @Override
    public String toString() {
        return "Standing{" +
                "team=" + team.getName() +
                ", played=" + played +
                ", wins=" + wins +
                ", draws=" + draws +
                ", losses=" + losses +
                ", points=" + points +
                ", goalsFor=" + goalsFor +
                ", goalsAgainst=" + goalsAgainst +
                '}';
    }
}
