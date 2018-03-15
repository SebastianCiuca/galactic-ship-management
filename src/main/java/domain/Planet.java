package domain;

public class Planet {

    long id;
    String name;
    long distance;

    public Planet(long id, String name, long distance) {
        this.id = id;
        this.name = name;
        this.distance = distance;
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

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Planet planet = (Planet) o;

        if (id != planet.id) return false;
        if (distance != planet.distance) return false;
        return name != null ? name.equals(planet.name) : planet.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) (distance ^ (distance >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                "}";
    }
}
