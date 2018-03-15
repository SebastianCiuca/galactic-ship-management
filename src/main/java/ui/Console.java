package ui;

import controller.GalacticController;
import domain.Character;
import domain.Planet;
import domain.Transport;
import validator.FunctionalValidator;
import validator.InputValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Console {
    private GalacticController galacticController;

    public Console(GalacticController galacticController) {
        this.galacticController = galacticController;
    }

    public void run() throws IOException {
        System.out.println("\t ~~~Starting Journey~~~\n");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String characterIndex, cargoWeight;

        while(true){
            System.out.println("\t ~~~Preparing for transport~~~\n");

            /*
                First we pick a character
             */
            galacticController.listObjects((ArrayList<Character>) galacticController.getAllCharacters());
            System.out.print("\nPick a character: ");

            characterIndex = br.readLine();
            System.out.println();

            characterIndex = loopValidator(characterIndex, "Invalid option! Please try again.\n Character:",
                    InputValidator::validateIndex);

            System.out.println("You chose " +
                    galacticController.getAllCharacters().get(Integer.valueOf(characterIndex)).getName() + "!\n");


            /*
                Then we insert the cargo weight
             */
            System.out.print("Cargo weight: ");
            cargoWeight = br.readLine();
            System.out.println();

            cargoWeight = loopValidator(cargoWeight, "Invalid cargo weight! Please try again.\n " +
                            "Cargo weight:", InputValidator::validateCargo);

            /*
                Then we pick a planet to ship it to
             */
            galacticController.listObjects((ArrayList<Planet>) galacticController.getAllPlanets());
            System.out.print("\nPick a planet: ");

            String planetIndex = br.readLine();
            System.out.println();

            planetIndex = loopValidator(planetIndex, "Invalid option! Please try again.\n Planet:",
                    InputValidator::validateIndex);

            System.out.println("You chose " +
                    galacticController.getAllPlanets().get(Integer.valueOf(planetIndex)).getName() + "!\n");


            /*
                Prepare the list of ships that can accomplish the task and the related data (time & #trips)
            */
            List<Transport> statistics =  galacticController.getShipStatistics(Integer.valueOf(characterIndex),
                    Integer.valueOf(planetIndex),Long.valueOf(cargoWeight));

            System.out.println("Ship statistics:\n");
            galacticController.listStats((ArrayList<Transport>) galacticController.sortStatistics(statistics));
            System.out.println();

            System.out.println("Plan another transport? (yes/no)");
            String anotherTrip = br.readLine();
            System.out.println();

            anotherTrip = loopValidator(anotherTrip, "Invalid option! (yes/no)",
                    InputValidator::validateContinue);

            if(Objects.equals(anotherTrip, "no")) {
                System.out.println("\n\t~~~May the force be with you!~~~");
                break;
            }
        }
    }

    /**
     * Asks user for input until it passes validation.
     * @param option - String representing option inserted by user to be validated
     * @param errorMessage - String representing what to display in case of invalid option
     * @param checker - functional interface providing validator function
     * @return correct option
     * @throws IOException
     */
    private String loopValidator(String option, String errorMessage, FunctionalValidator checker) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (!checker.isValid(option)){
            System.out.print(errorMessage);
            option = br.readLine();
            System.out.println();
        }

        return option;
    }


}
