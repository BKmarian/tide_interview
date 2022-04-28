package tide.demo.service;

import co.tide.diyfood.thirdparty.api.recipes.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipesService {
    List<Recipe> getAllRecipes();
    Optional<Recipe> getRecipeByName(String name);

}
