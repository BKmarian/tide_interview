package tide.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tide.demo.model.Order;

//TODO After adding database create proper repository
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
