package Exceptions;
/**
 * @Author Julia Merta
 * @Version %I%
 */
/**
 * Model.InvalidSizeException the exception is thrown when the image size or position parameter is incorrect.
 */
public class InvalidImageParamException extends Exception{
    /**
     * The constructor
     * @param message the message
     */
    public InvalidImageParamException(String message) {
        super(message);
    }


}