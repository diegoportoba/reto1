package reto1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {
    
    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "No element found")
    public class ElementNotFoundException extends RuntimeException{
        
    }

    public static ArrayList<Order> orders= new ArrayList<Order>(Arrays.asList(
        new Order("2020","Pepe","Entregado"),
        new Order("2020","Paco","Entregado"),
        new Order("2020","Papo","Entregado")
        
    ));

    



    static Order findById(int orderId){
        for(Order order : orders){
            if(order.getOrderId() == orderId){
                return order;
            }
        }
        return null;
    }

    public static ArrayList<OrderProduct> findByIdOrderProduct(int id){
        ArrayList<OrderProduct> list = new ArrayList<OrderProduct>();
        for(OrderProduct x : OrderProductController.orderProducts){
            if(x.getOrderId() == id){
                list.add(x);
            }
        }
        return list;
    }

    @GetMapping("/order/{orderId}")
    public Order OrderById(@PathVariable("orderId")int orderId){
        return  findById(orderId);
    } 

    @GetMapping("/order/{orderId}/details")
    public ArrayList<OrderProduct> Cart(@PathVariable("orderId")int orderId){
        Order order =  findById(orderId);
        int i= order.getOrderId();
        return findByIdOrderProduct(i);
    } 

    
    @GetMapping("/orders")
    public List<Order> orders() {
        return new ArrayList<Order>(orders);
    }

    @DeleteMapping("/orders/{id}")
    public void Delete(@PathVariable("id") int id){

        Order order = null;

        for(int i=orders.size()-1;i>=0;i--){
            
            if(orders.get(i).getOrderId()==id){
                order = orders.get(i);  
            
                orders.remove(order);     
                break;       
            }
           
        }

        if(order==null){
            throw new ElementNotFoundException();
        }

        for(int i=OrderProductController.orderProducts.size()-1;i>=0;i--){
            
            OrderProduct orderProduct = OrderProductController.orderProducts.get(i);
            if(orderProduct.getOrderId()==id){
                OrderProductController.orderProducts.remove(orderProduct);              
            }
        }

       
    }

    





}
