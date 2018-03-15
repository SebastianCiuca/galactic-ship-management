package repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import domain.Ship;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ShipRepository implements Repository<Ship>{
    private String fileName;
    private ArrayList<Ship> objects;

    public ShipRepository(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.objects = new ArrayList<>();
        this.load();
    }

    public ArrayList<Ship> getAll() {
        return objects;
    }

    public void load() throws FileNotFoundException {
        final Type TYPE = new TypeToken<ArrayList<Ship>>(){}.getType();

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(this.fileName));
        objects = gson.fromJson(reader,TYPE);

    }

    /**
     * Get all the ships that are of a suitable type.
     * @param types - array list of strings representing ship types that we are searching for
     * @return - list of ships that are of one of the given types
     */
    public List<Ship> getAllByTypeArray(ArrayList<String> types){
        ArrayList<Ship> filteredShips = new ArrayList<>();

        for(Ship ship : this.getAll()){
            if (types.contains(ship.getType()))
                filteredShips.add(ship);
        }

        return filteredShips;
    }
}
