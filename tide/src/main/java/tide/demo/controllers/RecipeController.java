package tide.demo.controllers;

import co.tide.diyfood.thirdparty.api.recipes.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tide.demo.exceptions.RecipesApiException;
import tide.demo.service.impl.RecipesServiceImpl;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/tide")
public class RecipeController {

    @Autowired
    private RecipesServiceImpl recipesServiceImpl;


    @ExceptionHandler(RecipesApiException.class)
    public ResponseEntity<List<Recipe>> handleExceptions(RecipesApiException exception) {
        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.SERVICE_UNAVAILABLE);
    }

    //TODO Add pagination in case we have many Recipes
//    @GetMapping("/recipes")
//    public PagedResponse<List<Recipe>> getAllRecipes(
//            @RequestParam(name = "page", required = false, defaultValue = 1) Integer page,
//            @RequestParam(name = "size", required = false, defaultValue = 50) Integer size) {
//
//        return new ResponseEntity<>(recipesService.getAllRecipes(page,size), HttpStatus.OK);
//    }

    @GetMapping("/recipes")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return new ResponseEntity<>(recipesServiceImpl.getAllRecipes(), HttpStatus.OK);
    }

    @GetMapping("/recipe/{name}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable(name = "name") String name) {
        return recipesServiceImpl.getRecipeByName(name).isPresent() ?
                new ResponseEntity<>(recipesServiceImpl.getRecipeByName(name).get(), HttpStatus.OK) :
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
