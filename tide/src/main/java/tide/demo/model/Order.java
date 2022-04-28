package tide.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

//TODO create a table and a database connection
//@Entity("ORDERS")
@Data
public class Order implements Serializable {

    //@Id
    private Long id;

    private List<OrderItem> orderedItems;

    private StatusEnum status;
}
