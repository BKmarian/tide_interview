package tide.demo.service.impl.converters;

import co.tide.diyfood.thirdparty.api.recipes.Ingredient;
import co.tide.diyfood.thirdparty.api.store.Order;
import co.tide.diyfood.thirdparty.api.store.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IngredientsToOrderConverter { //TODO make other direction also

    public Order toOrder(List<Ingredient> ingredients) {
        List<OrderItem> orderItems = ingredients.stream().map(ingredient ->
        {
            OrderItem orderItem = new OrderItem();
            orderItem.setName(ingredient.getName());
            return orderItem;
        }).collect(Collectors.toList());
        Order order = new Order();
        orderItems.forEach(order::addItem);
        return order;
    }
}
