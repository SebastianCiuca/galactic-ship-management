package controller;

import domain.Character;
import domain.Planet;
import domain.Ship;
import domain.Transport;
import repository.*;
import utils.InterstellarUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GalacticController {
    private CharacterRepository characterRepo;
    private ShipRepository shipRepo;
    private PlanetRepository planetRepo;

    public GalacticController(String characterFile, String shipFile, String planetFile) throws FileNotFoundException {
        characterRepo = new CharacterRepository(characterFile);
        shipRepo = new ShipRepository(shipFile);
        planetRepo = new PlanetRepository(planetFile);
    }

    /**
     * For a given character, planet, and cargo, get the statistics based on time and trips of the ships owned by
     * the character.
     * @param characterIndex - index of the character in the character repository array
     * @param planetIndex - index of the planet in the planet repository array
     * @param cargoWeight - weight value of the cargo to be transported
     * @return - list of pairs with time and trips as values, each representing a statistic for a ship that could
     * transport the given cargo weight.
     */
    public List<Transport> getShipStatistics(int characterIndex, int planetIndex, long cargoWeight){
        ArrayList<String> availableCharacterShips = this.getAllCharacters().
                get(characterIndex).getShipsType();
        Planet planet = planetRepo.getAll().get(planetIndex);

        ArrayList<Ship> availableShips =  (ArrayList<Ship>) this.getAvailableShips(availableCharacterShips);

        ArrayList<Transport> shipsStatistics = new ArrayList<>();

        for (Ship s : availableShips){
            long trips = InterstellarUtils.computeTrips(cargoWeight,s.getMaxCargoWeight());
            double time = InterstellarUtils.computeTime(s.getSpeed(),planet.getDistance(),trips);

            shipsStatistics.add(new Transport(time,trips,s.getName()));
        }

        return shipsStatistics;
    }

    /**
     * Sorts a list of pairs such that the first element of the pair has priority over the second one.
     * The elements of the pair are Long numbers and compared as such.
     * @param statistics - list of pair of long numbers
     * @return the sorted list
     */
    public List<Transport> sortStatistics(List<Transport> statistics){
        Collections.sort(statistics,
                //using a lambda expression for providing values for comparing two transport objects
                (Transport p1, Transport p2) -> {
                     if (Objects.equals(p1.getTime(), p2.getTime()))
                         return p1.getTrips() < p2.getTrips() ? -1 : 1;
                     return p1.getTime() < p2.getTime() ? -1 : 1;
                });

        return statistics;
    }

    public List<Ship> getAvailableShips(ArrayList<String> shiptypes) {return shipRepo.getAllByTypeArray(shiptypes);}

    public List<Character> getAllCharacters(){
        return characterRepo.getAll();
    }

    public List<Ship> getAllShips(){
        return shipRepo.getAll();
    }

    public List<Planet> getAllPlanets(){
        return planetRepo.getAll();
    }

    public void listStats(ArrayList<Transport> transports){
        for (Transport stat : transports){
            System.out.printf( "Ship: " + stat.getShipName() +
                    "\nTime to transport: %3.2f"+
                    " hours \nTrips taken: " + stat.getTrips() + "\n~~~\n", stat.getTime());
        }
    }

    public <T> void listObjects(ArrayList<T> objects){
        int index = 0;
        for(T o : objects)
            System.out.println(String.valueOf(index++) + " --> " + o + ",");
    }
}
