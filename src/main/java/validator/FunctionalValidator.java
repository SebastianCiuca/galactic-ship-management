package validator;

@FunctionalInterface
public interface FunctionalValidator {
    boolean isValid(String input);
}
