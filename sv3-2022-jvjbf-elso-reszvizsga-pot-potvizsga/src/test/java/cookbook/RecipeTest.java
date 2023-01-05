package cookbook;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    Recipe recipe = new Recipe("Gulash soup",
            Difficulty.MEDIUM,
            Arrays.asList("Onion","Tomato","Pepper","Meat","Potato","Carrot"),
            "Description of Gulash...");

    @Test
    void createRecipeTest(){
        assertEquals("Gulash soup",recipe.getName());
        assertEquals(Difficulty.MEDIUM, recipe.getDifficulty());
        assertEquals(6, recipe.getIngredients().size());
        assertEquals("Description of Gulash...", recipe.getDescription());
    }

    @Test
    void testContainsIngredient(){
        assertTrue(recipe.containsIngredient("Potato"));
    }

    @Test
    void testNotContainsIngredient(){
        assertFalse(recipe.containsIngredient("Milk"));
    }
}