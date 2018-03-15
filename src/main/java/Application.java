import controller.GalacticController;
import ui.Console;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {

    public static void main(String[] args) {
        Console galacticConsole = null;
        try {
            galacticConsole = new Console(
                    new GalacticController(
                            "characters.json",
                            "ships.json",
                            "planets.json"
                    )
            );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            galacticConsole.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
