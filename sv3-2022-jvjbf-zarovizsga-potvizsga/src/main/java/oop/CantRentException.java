package oop;

public class CantRentException extends RuntimeException {
    public CantRentException(String message) {
        super(message);
    }
}
