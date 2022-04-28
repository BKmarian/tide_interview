package tide.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tide.demo.exceptions.StoresApiException;
import tide.demo.model.Order;
import tide.demo.model.StatusEnum;
import tide.demo.service.impl.OrderServiceImpl;

import java.util.List;

//TODO replaced with Kafka probably and NoSql Database

@RestController
@RequestMapping("/tide/analytics")
public class AnalyticsController {

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @ExceptionHandler(StoresApiException.class)
    public ResponseEntity<String> handleExceptions(RuntimeException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/orders/created")
    public ResponseEntity<List<Order>> getCreatedOrders() {
        return new ResponseEntity<>(orderServiceImpl.getAllOrdersByStatus(StatusEnum.CREATED), HttpStatus.OK);
    }

    @GetMapping("/orders/acceoted")
    public ResponseEntity<List<Order>> getAcceptedOrders() {
        return new ResponseEntity<>(orderServiceImpl.getAllOrdersByStatus(StatusEnum.ACCEPTED), HttpStatus.OK);
    }

}
