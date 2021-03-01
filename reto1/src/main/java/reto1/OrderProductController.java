package reto1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderProductController {
    
    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "No element found")
    public class ElementNotFoundException extends RuntimeException{
        
    }

    public static ArrayList<OrderProduct> orderProducts= new ArrayList<OrderProduct>(Arrays.asList(
        new OrderProduct(1,1,20),
        new OrderProduct(2,2,20),
        new OrderProduct(1,2,40),
        new OrderProduct(2,2,40)
        
    ));

    

    

    @GetMapping("/orderProducts")
    public List<OrderProduct> orderProducts(){
        return new ArrayList<OrderProduct>(orderProducts);
    }

    @PostMapping("/orderProducts")
    public int Add(@RequestBody OrderProduct orderProduct){
        orderProducts.add(orderProduct);
        return orderProduct.getOrderProductId();
    } 

    @PutMapping("/orderProducts/{id}")
    public OrderProduct Update(@RequestBody OrderProduct update, @PathVariable("id") int id)
    {
        for(OrderProduct orderProduct : orderProducts)
        {
            if(orderProduct.getOrderProductId()==id){
                orderProduct.setQuantity(update.getQuantity());
                return orderProduct;
            }

        }
        throw new ElementNotFoundException();
    }

}
