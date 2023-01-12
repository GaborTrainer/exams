package oop;

public class BrandedHandyTool extends RentableTool {

    private static final double priceMultiplier = 1.5;

    protected BrandedHandyTool(String id, String name) {
        super(id, name, priceMultiplier);
    }
}
