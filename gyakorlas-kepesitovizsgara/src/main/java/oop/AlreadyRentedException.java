package oop;

public class AlreadyRentedException extends IllegalStateException{

    public AlreadyRentedException(String message) {
        super(message);
    }
}
