package tide.demo.service.impl;

import co.tide.diyfood.thirdparty.api.recipes.Ingredient;
import co.tide.diyfood.thirdparty.api.recipes.Recipe;
import co.tide.diyfood.thirdparty.api.store.Order;
import co.tide.diyfood.thirdparty.api.store.OrderQuote;
import co.tide.diyfood.thirdparty.api.store.StoreApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tide.demo.exceptions.RecipesApiException;
import tide.demo.service.StoreService;
import tide.demo.service.impl.converters.IngredientsToOrderConverter;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreApi storeApi;

    private final Logger logger = LoggerFactory.getLogger(RecipesServiceImpl.class);

    @Autowired
    private IngredientsToOrderConverter ingredientsToOrderConverter;

    public StoreServiceImpl() {
        storeApi = new StoreApi();
    }

    @Override
    public OrderQuote createOrderQuote(Recipe recipe) {
        List<Ingredient> ingredients = recipe.getIngredients();
        return createOrderQuote(ingredientsToOrderConverter.toOrder(ingredients));
    }

    @Override
    public boolean acceptOrder(String orderQuoteId) {
        logger.info("Acception order with id {}",orderQuoteId);
        try {
            storeApi.acceptOrderQuote(orderQuoteId);
            return true;
        }
        catch(Exception e) {
            logger.error(e.getMessage());
            return false;
        }
        //TODO async request to update order status with accepted status to our DB
    }

    private OrderQuote createOrderQuote(Order order) {
        logger.info("Creating new order");
        try {
            return storeApi.createOrderQuote(order);
        }
        catch(Exception e) {
            logger.error(e.getMessage());
            throw new RecipesApiException("Error accesing recipes API");
        }
        //TODO async request to add new order with created status to our DB
    }
}
