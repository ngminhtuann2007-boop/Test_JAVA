package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Team {
    private final UUID id;
    private String name;
    private final List<Player> players;

    public Team() {
        this.id = UUID.randomUUID();
        this.players = new ArrayList<>();
    }

    public Team(String name) {
        this();
        setName(name);
    }

    public void addPlayer(Player player) {
        if (player == null || player.getId() == null) {
            throw new IllegalArgumentException("Cầu thủ không hợp lệ!");
        }
        boolean exists = this.players.stream()
                .anyMatch(p -> p.getId().equals(player.getId()));
        if (exists) {
            throw new IllegalStateException("Cầu thủ đã có trong đội!");
        }
        this.players.add(player);
    }

    public void removePlayerById(UUID playerId) {
        if (playerId == null) {
            throw new IllegalArgumentException("Player ID không được null!");
        }
        Player playerToRemove = this.players.stream()
                .filter(p -> p.getId().equals(playerId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy cầu thủ với ID: " + playerId));

        this.players.remove(playerToRemove);
    }

    public boolean isEmpty() { return players.isEmpty(); }

    public UUID getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên đội không được để trống!");
        }
        this.name = name.trim();
    }

    public List<Player> getPlayers() { return Collections.unmodifiableList(players); }

    // 5. So sánh đối tượng chuẩn dựa trên ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Team team = (Team) o; //Ép kiểu
        return Objects.equals(this.id, team.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", playerCount=" + players.size() +
                '}';
    }
}