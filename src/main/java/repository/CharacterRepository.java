package repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import domain.Character;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class CharacterRepository implements Repository<Character>{
    private String fileName;
    private ArrayList<Character> objects;

    public CharacterRepository(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.objects = new ArrayList<>();
        this.load();
    }

    public ArrayList<Character> getAll() {
        return objects;
    }

    public void load() throws FileNotFoundException {
        final Type TYPE = new TypeToken<ArrayList<Character>>(){}.getType();

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(this.fileName));
        objects = gson.fromJson(reader,TYPE);
    }
}
