package tide.demo.exceptions;

public class StoresApiException extends RuntimeException{
    public StoresApiException(String message) {
        super(message);
    }
}
