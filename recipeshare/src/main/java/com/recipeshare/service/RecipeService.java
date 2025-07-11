package com.recipeshare.service;

import com.recipeshare.entity.Recipe;
import com.recipeshare.entity.Tag;
import com.recipeshare.repository.RecipeRepository;
import com.recipeshare.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private TagRepository tagRepository;

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Optional<Recipe> getRecipeById(Long id) {
        return recipeRepository.findById(id);
    }

    public Recipe createRecipe(Recipe recipe) {
        // Save tags first (to handle join table correctly)
        Set<Tag> processedTags = new HashSet<>();
        for (Tag tag : recipe.getTags()) {
            Tag existingTag = tagRepository.findByName(tag.getName());
            if (existingTag != null) {
                processedTags.add(existingTag);
            } else {
                processedTags.add(tagRepository.save(tag));
            }
        }
        recipe.setTags(processedTags);

        return recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(Long id, Recipe recipeDetails) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow();

        recipe.setTitle(recipeDetails.getTitle());
        recipe.setDescription(recipeDetails.getDescription());
        recipe.setIngredients(recipeDetails.getIngredients());
        recipe.setInstructions(recipeDetails.getInstructions());
        recipe.setUser(recipeDetails.getUser());

        // Handle tags update
        Set<Tag> processedTags = new HashSet<>();
        for (Tag tag : recipeDetails.getTags()) {
            Tag existingTag = tagRepository.findByName(tag.getName());
            if (existingTag != null) {
                processedTags.add(existingTag);
            } else {
                processedTags.add(tagRepository.save(tag));
            }
        }
        recipe.setTags(processedTags);

        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }
}
