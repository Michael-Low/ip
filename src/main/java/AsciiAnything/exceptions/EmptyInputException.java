package AsciiAnything.exceptions;

public class EmptyInputException extends Exception {
    private static final String EMPTY_INPUT_EXCEPTION_MESSAGE = "Your input is empty. What am I supposed to do with this!?";

    @Override
    public String getMessage() {
        return EMPTY_INPUT_EXCEPTION_MESSAGE;
    }
}
