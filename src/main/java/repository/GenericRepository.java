package repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GenericRepository<T> implements Repository<T> {

    private String fileName;
    private ArrayList<T> objects;

    public GenericRepository(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.objects = new ArrayList<>();
        this.load();
    }

    @Override
    public List<T> getAll() {
        return objects;
    }

    @Override
    public void load() throws FileNotFoundException {
        final Type TYPE = new TypeToken<List<T>>(){}.getType();

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(this.fileName));
        objects = gson.fromJson(reader,TYPE);

    }
}
