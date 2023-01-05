package cookbook;

import java.util.List;

public class Recipe {

    private String name;

    private Difficulty difficulty;

    private List<String> ingredients;

    private String description;

    public Recipe(String name, Difficulty difficulty, List<String> ingredients, String description) {
        this.name = name;
        this.difficulty = difficulty;
        this.ingredients = ingredients;
        this.description = description;
    }

    public boolean containsIngredient(String ingredient) {
        return ingredients.contains(ingredient);
    }

    public String getName() {
        return name;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getDescription() {
        return description;
    }
}
