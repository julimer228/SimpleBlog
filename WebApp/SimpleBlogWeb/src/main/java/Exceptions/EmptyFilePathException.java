package Exceptions;
/**
 * @Author Julia Merta
 * @Version %I%
 */
/**
 * Exceptions.EmptyFilePathException the exception is thrown when the file path is incorrect
 */
public class EmptyFilePathException extends Exception{

    /**
     * The default constructor
     */
    public EmptyFilePathException() {
        super();
    }

    /**
     * The constructor
     * @param message the message
     */
    public EmptyFilePathException(String message) {
        super(message);
    }

}
