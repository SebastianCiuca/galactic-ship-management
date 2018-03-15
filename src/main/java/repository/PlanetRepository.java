package repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import domain.Planet;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class PlanetRepository implements Repository<Planet>{
    private String fileName;
    private ArrayList<Planet> objects;

    public PlanetRepository(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.objects = new ArrayList<>();
        this.load();
    }

    public ArrayList<Planet> getAll() {
        return objects;
    }

    public void load() throws FileNotFoundException {
        final Type TYPE = new TypeToken<ArrayList<Planet>>(){}.getType();

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(this.fileName));
        objects = gson.fromJson(reader,TYPE);

    }
}
