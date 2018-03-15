package domain;

public class Ship {
    long id;
    String name;
    long speed;
    String type;
    long maxCargoWeight;

    public Ship(long id, String name, long speed, String shiptype, long maxCargoWeight) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.type = shiptype;
        this.maxCargoWeight = maxCargoWeight;
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

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getMaxCargoWeight() {
        return maxCargoWeight;
    }

    public void setMaxCargoWeight(long maxCargoWeight) {
        this.maxCargoWeight = maxCargoWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ship ship = (Ship) o;

        if (id != ship.id) return false;
        if (speed != ship.speed) return false;
        if (maxCargoWeight != ship.maxCargoWeight) return false;
        if (name != null ? !name.equals(ship.name) : ship.name != null) return false;
        return type == ship.type;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) (speed ^ (speed >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (int) (maxCargoWeight ^ (maxCargoWeight >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                ", type=" + type +
                ", maxCargoWeight=" + maxCargoWeight +
                "}";
    }
}
