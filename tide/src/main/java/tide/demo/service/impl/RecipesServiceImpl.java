package tide.demo.service.impl;

import co.tide.diyfood.thirdparty.api.recipes.Recipe;
import co.tide.diyfood.thirdparty.api.recipes.RecipesApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tide.demo.exceptions.RecipesApiException;
import tide.demo.service.RecipesService;

import java.util.List;
import java.util.Optional;

@Service
public class RecipesServiceImpl implements RecipesService {

    private final Logger logger = LoggerFactory.getLogger(RecipesServiceImpl.class);

    private final RecipesApi recipesApI;

    public RecipesServiceImpl() {
        recipesApI = new RecipesApi();
    }

    //TODO Add Paging
    //    @Override
    //    public List<Recipe> getAllRecipes() {
    //      Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, CREATED_AT);
    //      Page<Recipe> albums =  recipesApI.listRecipes(pageable);

    @Override
    public List<Recipe> getAllRecipes() {
        logger.info("Getting all recipes...");
        try {
            return recipesApI.listRecipes();
        }
        catch(Exception e) {
            logger.error(e.getMessage()); //TODO add log4j with debug level
            throw new RecipesApiException("Error accesing recipes API");
        }
    }

    @Override
    public Optional<Recipe> getRecipeByName(String name) {
        logger.info("Gettubg recipe by name:{} ",name);
        try {
            return recipesApI.getRecipe(name);
        } catch(Exception e) {
            logger.error(e.getMessage()); //TODO add log4j with debug level
            throw new RecipesApiException("Error accesing recipes API");
        }
    }
}
