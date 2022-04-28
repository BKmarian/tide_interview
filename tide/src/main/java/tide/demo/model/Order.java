package tide.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

//TODO create a table and a database connection
//@Entity("ORDERS")
@Getter
@Setter
public class Order implements Serializable {

    //@Id
    private Long id;

    private List<OrderItem> orderedItems;

    private StatusEnum status;
}
