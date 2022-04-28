package tide.demo.service;

import co.tide.diyfood.thirdparty.api.recipes.Recipe;
import co.tide.diyfood.thirdparty.api.store.OrderQuote;

public interface StoreService {

    String acceptOrder(String orderQuoteId);

    OrderQuote createOrderQuote(Recipe recipe);
}
