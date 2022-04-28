package tide.demo.service;

import tide.demo.model.Order;
import tide.demo.model.StatusEnum;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrdersByStatus(StatusEnum status);
}
