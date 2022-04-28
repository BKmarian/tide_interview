package tide.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tide.demo.model.Order;
import tide.demo.model.StatusEnum;
import tide.demo.repository.OrderRepository;
import tide.demo.service.OrderService;

import java.util.Collections;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

//    @Autowired
//    private OrderRepository orderRepository; //TODO add a jpa repository

    @Override
    public List<Order> getAllOrdersByStatus(StatusEnum status) {
        return Collections.emptyList(); //TODO or better use jpql
        //.stream().filter(o -> o.getStatus() == status).collect(...)
    }
}
