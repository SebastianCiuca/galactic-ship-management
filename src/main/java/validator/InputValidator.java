package validator;

public class InputValidator {

    /**
     * Checks if the given string can be converted to an integer value.
     * @param s - String value
     * @return true if s can be converted, false otherwise or if null value provided
     */
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }

        return true;
    }

    public static boolean validateIndex(String input){
        if (!isInteger(input))
            return false;

        int value = Integer.parseInt(input);

        return value >= 0 && value <= 6;
    }

    public static boolean validateContinue(String input){
        return input.equals("yes") || input.equals("no");
    }

    public static boolean validateCargo(String input){
        if (!isInteger(input))
            return false;

        long value = Long.parseLong(input);

        return value > 0;
    }
}
