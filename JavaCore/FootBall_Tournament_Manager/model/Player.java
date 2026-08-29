package model;

import java.util.Objects;
import java.util.UUID;

import model.enums.Position;
public class Player {
    private final UUID id;
    private String name;
    private int age;
    private Position position;

    public Player(String name, int age, Position position) {
        this.id= UUID.randomUUID();
        setName(name);
        setAge(age);
        setPosition(position);
    }
    public UUID getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên cầu thủ không được để trống!");
        }
        this.name = name.trim();
    }

    public int getAge() { return age; }

    public void setAge(int age) {
        if (age <= 0 || age > 60) {   
            throw new IllegalArgumentException("Tuổi cầu thủ không hợp lệ!");
        }
        this.age = age;
    }

    public Position getPosition() { return position; }
    public void setPosition(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Vị trí thi đấu không được để trống!");
        }
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position=" + position +
                '}';
    }
}
