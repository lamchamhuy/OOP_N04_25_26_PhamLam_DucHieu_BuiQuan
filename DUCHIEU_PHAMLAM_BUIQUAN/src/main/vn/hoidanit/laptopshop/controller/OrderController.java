package vn.hoidanit.laptopshop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.hoidanit.laptopshop.domain.*;
import vn.hoidanit.laptopshop.service.*;
import java.math.BigDecimal;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired private ProductService productService;
    @Autowired private UserService userService;
    @Autowired private OrderService orderService;

    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("users", userService.findAll());
        model.addAttribute("products", productService.findAll());
        model.addAttribute("order", new CustomerOrder());
        return "order/create";
    }

    @PostMapping("/create")
    public String createOrder(@ModelAttribute CustomerOrder order){
        // ensure product loaded and compute total
        Product p = productService.findById(order.getProduct().getId());
        order.setProduct(p);
        BigDecimal price = p.getPrice()!=null ? p.getPrice() : BigDecimal.ZERO;
        order.setTotalPrice(price.multiply(new BigDecimal(order.getQuantity())));
        orderService.save(order);
        return "redirect:/";
    }
}
