package AsciiAnything.exceptions;

public class WrongFormatException extends Exception {
    private static final String WRONG_FORMAT_EXCEPTION_MESSAGE = "Wrong format, dumbass!";

    @Override
    public String getMessage() {
        return WRONG_FORMAT_EXCEPTION_MESSAGE;
    }
}
