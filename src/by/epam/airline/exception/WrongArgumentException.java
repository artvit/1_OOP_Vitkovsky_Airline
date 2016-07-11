package by.epam.airline.exception;

/**
 * Created by artvi on 21/05/2016.
 */
public class WrongArgumentException extends Exception {
    public WrongArgumentException() {
        super();
    }

    public WrongArgumentException(String message) {
        super(message);
    }

    public WrongArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongArgumentException(Throwable cause) {
        super(cause);
    }

    protected WrongArgumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
