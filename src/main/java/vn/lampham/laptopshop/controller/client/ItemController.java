package vn.lampham.laptopshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.lampham.laptopshop.domain.Product;
import vn.lampham.laptopshop.service.ProductService;

@Controller
public class ItemController {  // ✅ Class viết hoa chữ cái đầu

    private final ProductService productService;

    public ItemController(ProductService productService) {  // ✅ Constructor trùng tên class
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public String getProductPage(Model model, @PathVariable long id) {
        Product pr = this.productService.fetchProductById(id).orElse(null);
        if (pr == null) {
            return "redirect:/";
        }
        model.addAttribute("product", pr);
        model.addAttribute("id", id);
        return "client/product/detail"; // ✅ file: /WEB-INF/view/client/product/detail.jsp
    }
}
