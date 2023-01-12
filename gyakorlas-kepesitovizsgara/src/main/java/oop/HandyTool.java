package oop;

public class HandyTool extends RentableTool {

    private static final double priceMultiplier = 1.0;

    protected HandyTool(String id, String name) {
        super(id, name, priceMultiplier);
    }
}
