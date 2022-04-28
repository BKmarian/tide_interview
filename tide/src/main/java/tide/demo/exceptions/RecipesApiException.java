package tide.demo.exceptions;

public class RecipesApiException extends RuntimeException{
    public RecipesApiException(String message) {
        super(message);
    }
}
