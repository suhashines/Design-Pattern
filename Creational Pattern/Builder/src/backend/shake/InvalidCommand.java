package backend.shake;

public class InvalidCommand extends Exception {
    public InvalidCommand(String errorMessage) {
        super(errorMessage);
    }
}
