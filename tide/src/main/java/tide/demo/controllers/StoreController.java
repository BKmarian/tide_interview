package tide.demo.controllers;

import co.tide.diyfood.thirdparty.api.recipes.Recipe;
import co.tide.diyfood.thirdparty.api.store.OrderQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tide.demo.exceptions.StoresApiException;
import tide.demo.service.impl.StoreServiceImpl;

@RestController
@RequestMapping("/tide/store")
public class StoreController {

    @ExceptionHandler(StoresApiException.class)
    public ResponseEntity<String> handleExceptions(StoresApiException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }

    @Autowired
    private StoreServiceImpl storeServiceImpl;

    @PutMapping("/createOrder")
    public ResponseEntity<OrderQuote> createOrderQuote(@RequestBody Recipe recipe) {
        return new ResponseEntity<>(storeServiceImpl.createOrderQuote(recipe), HttpStatus.OK);
    }

    @PostMapping("/acceptOrder/{id}")
    public ResponseEntity<Boolean> acceptOrder(@PathVariable String orderQuoteId) {
        return new ResponseEntity<>(storeServiceImpl.acceptOrder(orderQuoteId), HttpStatus.OK);
    }
}
