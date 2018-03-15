package domain;

import java.util.ArrayList;

public class Character {
    long id;
    String name;
    ArrayList<String> shipsType;

    public Character(long id, String name, ArrayList<String> shipsType) {
        this.id = id;
        this.name = name;
        this.shipsType = shipsType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getShipsType() {
        return shipsType;
    }

    public void setShipsType(ArrayList<String> shipsType) {
        this.shipsType = shipsType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Character character = (Character) o;

        if (id != character.id) return false;
        if (name != null ? !name.equals(character.name) : character.name != null) return false;
        return shipsType != null ? shipsType.equals(character.shipsType) : character.shipsType == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (shipsType != null ? shipsType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shipsType=" + shipsType +
                "}";
    }
}
