package tide.demo.model;

import lombok.Data;

//Using our own model in case we need given change in future not to depend on library implementation
//Also we can add db constrains

@Data
public class OrderItem {
    private String name;
}
