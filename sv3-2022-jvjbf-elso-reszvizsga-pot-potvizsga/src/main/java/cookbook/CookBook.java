package cookbook;

import java.util.ArrayList;
import java.util.List;

public class CookBook {

    private List<Recipe> recipes = new ArrayList<>();

    public boolean addRecipe(Recipe recipe) {
        if (recipe.getDifficulty() != Difficulty.HARD && recipe.getIngredients().size() < 11) {
            recipes.add(recipe);
            return true;
        }
        return false;
    }

    public boolean isRecipeInCookbookWithDifficulty(Difficulty difficulty) {
        return recipes.stream()
                .anyMatch(recipe -> recipe.getDifficulty().equals(difficulty));
    }

    public int findNumberOfMaxIngredients() {
        return recipes.stream()
                .mapToInt(r->r.getIngredients().size())
                .max()
                .orElse(0);
    }

    public int countRecipeWithIngredient(String ingredient) {
        return (int) recipes.stream()
                .filter(recipe -> recipe.containsIngredient(ingredient))
                .count();
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
}
