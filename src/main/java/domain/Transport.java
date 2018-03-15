package domain;

public class Transport {
    Double time;
    Long trips;
    String shipName;

    public Transport(Double time, Long trips, String shipName) {
        this.time = time;
        this.trips = trips;
        this.shipName = shipName;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Long getTrips() {
        return trips;
    }

    public void setTrips(Long trips) {
        this.trips = trips;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transport transport = (Transport) o;

        if (time != null ? !time.equals(transport.time) : transport.time != null) return false;
        if (trips != null ? !trips.equals(transport.trips) : transport.trips != null) return false;
        return shipName != null ? shipName.equals(transport.shipName) : transport.shipName == null;
    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + (trips != null ? trips.hashCode() : 0);
        result = 31 * result + (shipName != null ? shipName.hashCode() : 0);
        return result;
    }
}
