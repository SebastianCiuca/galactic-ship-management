package utils;

public class InterstellarUtils {

    /**
     * Computes the number of trips necessary to transport cargo from one planet to another.
     * @param cargoWeight - long number representing the transported cargo
     * @param maxWeight - long number representing the maximum capacity of the transporter
     * @return - long value representing number of trips
     */
    public static long computeTrips(long cargoWeight, long maxWeight){
        return cargoWeight % maxWeight == 0 ? cargoWeight / maxWeight : cargoWeight / maxWeight + 1;
        //if the values don't divide exactly, then an extra trip is needed for the remainder of the cargo
    }

    /**
     * Computes the time needed to travel given distance at given speed multiplied by
     * the number of needed trips.
     * @param speed - long number representing travelling speed
     * @param distance - long number representing distance to be travelled
     * @param trips - long number representing number of travels
     * @return - double value representing time
     */
    public static double computeTime(long speed, long distance, long trips){
        return (double) distance/speed * (2*trips - 1);
        //formula for the time, multiplied by the number of trips - keeping in mind that we also have to account for
        //the return trip (multiplication by 2). The "-1" comes from the fact that we suppose we stay on the target
        //planet once the delivery was completed
    }
}
