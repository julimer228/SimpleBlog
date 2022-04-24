package Exceptions;

/**
 * @author Julia Merta
 * @version %I%, %G%
 * The exception informs about invalid grade value
 */
public class InvalidGradeException extends Exception{

    /**
     * The constructor
     * @param message the information about the exception
     */
    public InvalidGradeException(String message) {
        super(message);
    }

}
