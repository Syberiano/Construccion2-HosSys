package APP.domain.validators;

/**
 * Base class for validators that provides common validation methods.
 */
public abstract class SimpleValidator {
    
    protected static void validateNotNull(Object obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message);
        }
    }
    
    protected static void validateNotEmpty(String value, String message) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }
    
    protected static void validatePositive(double number, String message) {
        if (number < 0) {
            throw new IllegalArgumentException(message);
        }
    }
    
    protected static void validateNotZero(int number, String message) {
        if (number == 0) {
            throw new IllegalArgumentException(message);
        }
    }
    
    protected static void validateNotZero(double number, String message) {
        if (number == 0.0) {
            throw new IllegalArgumentException(message);
        }
    }
}
