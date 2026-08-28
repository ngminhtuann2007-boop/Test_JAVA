package FootBall_Tournament_Manager.model;

import java.time.LocalDate;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Tournament {
    private final UUID id;
    private String name;
    //private  status;
    //private  format;
    private final List<Team> teams;
    private final List<Match> matches;
    private LocalDate createdAt;
    
    public Tournament() {
        this.id = UUID.randomUUID();
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
        this.createdAt = LocalDate.now();
    }

    public Tournament(String name){
        this();
        setName(name);
    }

   

    public boolean isEmpty() { return teams.isEmpty(); }

    public UUID getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên trận đấu không được để trống!");
        }
        this.name = name.trim();
    }

    public List<Team> getTeams() { return Collections.unmodifiableList(teams); }

    public List<Match> getMatches() { return Collections.unmodifiableList(matches); }

    public LocalDate getCreatedAt() { return createdAt; }
    

    public void addTeam(Team team){
        if(team == null || team.getId() == null){
            throw new IllegalArgumentException("Team không hợp lê!");
        }
        boolean exists = this.teams.stream()
                .anyMatch(m -> m.getId().equals(team.getId()));
        if(exists){
            throw new IllegalStateException("Team đã có trong đội!");
        }
        this.teams.add(team);
    }

    public void removeTeamById(UUID teamId){
        if(teamId == null){
            throw new IllegalArgumentException( "Team ID không được null");
        }
        Team teamToRemove = this.teams.stream()
                .filter(t -> t.getId().equals(teamId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy Team với ID:" + teamId));
        this.teams.remove(teamToRemove);
    } 

    public void addMatch(Match match){
        if(match == null || match.getId() == null){
            throw new IllegalArgumentException("match không hợp lê!");
        }
        boolean exists = this.matches.stream()
                .anyMatch(m -> m.getId().equals(match.getId()));
        if(exists){
            throw new IllegalStateException("match đã có!");
        }
        this.matches.add(match);
    }

    public void removeMatchById(UUID matchId){
        if(matchId == null){
            throw new IllegalArgumentException( "match ID không được null");
        }
        Match matchToRemove = this.matches.stream()
                .filter(t -> t.getId().equals(matchId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy match với ID:" + matchId));
        this.matches.remove(matchToRemove);
    } 

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Tournament tournament = (Tournament) o; //Ép kiểu
        return Objects.equals(this.id, tournament.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teamCount=" + teams.size() +
                ", matchCount=" + matches.size() +
                ", createdAt=" + createdAt +
                '}';
    }
}
