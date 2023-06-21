package com.example.recipe;

import com.example.recipe.RecipeRepository;
import com.example.recipe.Recipe;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

// Don't modify the below code

public class RecipeService implements RecipeRepository {

        private static HashMap<Integer, Recipe> recipeBook = new HashMap<>();

        public RecipeService() {
                recipeBook.put(1,new Recipe(1, "Pasta", "veg",  Arrays.asList("pasta", "tomatoes", "olive oil", "garlic", "basil")));
                recipeBook.put(2,new Recipe(2, "Chicken Curry", "non-veg", Arrays.asList("chicken", "onion", "tomato", "ginger", "garlic", "spices")));
                recipeBook.put(3,new Recipe(3, "Sushi", "non-veg", Arrays.asList("sushi rice", "tuna fish", "seaweed", "wasabi", "ginger")));
                recipeBook.put(4,new Recipe(4, "Mushroom Risotto", "veg", Arrays.asList("rice", "mushrooms", "onion", "garlic", "butter", "parmesan")));
                recipeBook.put(5,new Recipe(5, "Fish and Chips", "non-veg", Arrays.asList("fish", "potatoes", "flour", "oil", "spices")));
        }

        // Don't modify the above code

        // Write your code here
        int uniqueRecipeId = 6;
        @Override
        public Recipe addRecipe(Recipe recipe) {
                recipe.setRecipeId(uniqueRecipeId);
                recipeBook.put(uniqueRecipeId,recipe);
                uniqueRecipeId += 1;
                return recipe;
        }

        @Override
        public List<Recipe> getRecipes() {
                Collection<Recipe> recipeCollection = recipeBook.values();
                List<Recipe> recipes = new ArrayList<>(recipeCollection);
                return recipes;
        }

        @Override
        public Recipe getRecipeByRecipeId(int recipeId) {
                Recipe recipe = recipeBook.get(recipeId);

                if (recipe == null) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
                return recipe;
        }
        @Override
        public Recipe updateRecipe(int recipeId,Recipe recipe) {
                Recipe existingRecipe = recipeBook.get(recipeId);
                
                if (existingRecipe == null) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }

                if (recipe.getRecipeName() != null) {
                        existingRecipe.setRecipeName(recipe.getRecipeName());
                }

                if (recipe.getRecipeType() != null) {
                        existingRecipe.setRecipeType(recipe.getRecipeType());
                }

                if (recipe.getIngredients() != null) {
                existingRecipe.setIngredients(recipe.getIngredients());
                }

                recipeBook.put(recipeId,existingRecipe);
                return existingRecipe;
        }

        @Override
        public void deleteRecipe(int recipeId) {
                Recipe recipe = recipeBook.get(recipeId);

                if (recipe == null) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                } else {
                        recipeBook.remove(recipeId);
                        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
                }

        }
}