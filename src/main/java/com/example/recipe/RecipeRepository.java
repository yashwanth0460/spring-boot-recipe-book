// Write your code here
package com.example.recipe;

import java.util.*;
import com.example.recipe.Recipe;

public interface RecipeRepository {
    List<Recipe> getRecipes();
    Recipe getRecipeByRecipeId(int recipeId);
    Recipe addRecipe(Recipe recipe);
    Recipe updateRecipe(int recipeId,Recipe recipe);
    void deleteRecipe(int recipeId);
}