package reto1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController{

    public static ArrayList<Product> products= new ArrayList<Product>(Arrays.asList(
        new Product("P1",12,"https://image.freepik.com/foto-gratis/fondo-papel-negro-textura-lienzo_88281-4113.jpg"),
        new Product("P2",13,"https://image.freepik.com/foto-gratis/fondo-papel-negro-textura-lienzo_88281-4113.jpg"),
        new Product("P3",14,"https://image.freepik.com/foto-gratis/fondo-papel-negro-textura-lienzo_88281-4113.jpg"),
        new Product("P4",15,"https://image.freepik.com/foto-gratis/fondo-papel-negro-textura-lienzo_88281-4113.jpg")   
    ));

    
    @GetMapping("/products")
    public List<Product> products() {
        return new ArrayList<Product>(products);
    }

}