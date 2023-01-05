package cookbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CookBookTest {


    CookBook cookBook = new CookBook();


    @BeforeEach
    void init(){
        Recipe gulashSoup = new Recipe("Gulash soup",
                Difficulty.MEDIUM,
                Arrays.asList("Onion","Tomato","Pepper","Meat","Potato","Carrot"),
                "Description of Gulash...");

        Recipe steak = new Recipe("Steak",
                Difficulty.MEDIUM,
                Arrays.asList("Meat","Butter","Seasoning"),
                "Description of Steak...");

        Recipe peanutButterSandwich = new Recipe("Peanut Butter Sandwich",
                Difficulty.EASY,
                Arrays.asList("Bread", "Peanut butter", "Jelly"),
                "Description of Sandwich...");

        cookBook.addRecipe(gulashSoup);
        cookBook.addRecipe(steak);
        cookBook.addRecipe(peanutButterSandwich);

    }

    @Test
    void testAddRecipeAdded(){
        CookBook cookBook = new CookBook();
        cookBook.addRecipe(new Recipe("Steak",
                Difficulty.MEDIUM,
                Arrays.asList("Meat","Butter","Seasoning"),
                "Description of Steak..."));

        assertEquals(1, cookBook.getRecipes().size());
    }

    @Test
    void testAddRecipeReturnValue(){
        CookBook cookBook = new CookBook();
        assertTrue(cookBook.addRecipe(new Recipe("Steak",
                Difficulty.MEDIUM,
                Arrays.asList("Meat","Butter","Seasoning"),
                "Description of Steak...")));
    }

    @Test
    void testAddRecipeNotAdded(){
        CookBook cookBook = new CookBook();
        cookBook.addRecipe(new Recipe("Stew",
                Difficulty.MEDIUM,
                Arrays.asList("Onion","Tomato","Pepper","Meat","Red Wine","Salt","Pepper","Paprika","Chili","Garlic","Potato"),
                "Description of Stew.."));

        assertEquals(0, cookBook.getRecipes().size());
    }

    @Test
    void testAddRecipeNotAddedReturnValue(){
        CookBook cookBook = new CookBook();
        assertFalse(cookBook.addRecipe(new Recipe("Stew",
                Difficulty.EASY,
                Arrays.asList("Onion","Tomato","Pepper","Meat","Red Wine","Salt","Pepper","Paprika","Chili","Garlic","Potato"),
                        "Description of Stew..")));
    }

    @Test
    void testIsRecipeInCookbookWithDifficulty(){
        assertTrue(cookBook.isRecipeInCookbookWithDifficulty(Difficulty.EASY));
    }

    @Test
    void testIsNotRecipeInCookbookWithDifficulty(){
        assertFalse(cookBook.isRecipeInCookbookWithDifficulty(Difficulty.HARD));
    }

    @Test
    void testFindMaxNumberOfIngredients(){
        assertEquals(6, cookBook.findNumberOfMaxIngredients());
    }

    @Test
    void testFindMaxNumberOfIngredientsEmptyCookBook(){
        CookBook cookBook = new CookBook();
        assertEquals(0, cookBook.findNumberOfMaxIngredients());
    }

    @Test
    void testCountRecipeWithIngredient(){
        assertEquals(2, cookBook.countRecipeWithIngredient("Meat"));
        assertEquals(1, cookBook.countRecipeWithIngredient("Jelly"));
    }
}