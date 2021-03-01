package reto1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelandViewProducts {
    
    @GetMapping("/productList")
    public ModelAndView Product()
    {
        ModelAndView mv = new ModelAndView("productList");
        mv.addObject("products", ProductController.products);
        return mv;
    }
}
