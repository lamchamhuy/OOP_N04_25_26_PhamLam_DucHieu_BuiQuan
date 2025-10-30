package vn.lampham.laptopshop.controller.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import vn.lampham.laptopshop.domain.Cart;
import vn.lampham.laptopshop.domain.CartDetail;
import vn.lampham.laptopshop.domain.Product;
import vn.lampham.laptopshop.domain.User;
import vn.lampham.laptopshop.service.ProductService;

@Controller
public class ItemController {

    private final ProductService productService;

    public ItemController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public String getProductPage(Model model, @PathVariable long id) {
        Product pr = this.productService.fetchProductById(id).orElse(null);
        if (pr == null) return "redirect:/";
        model.addAttribute("product", pr);
        model.addAttribute("id", id);
        return "client/product/detail";
    }

    @PostMapping("/add-product-to-cart/{id}")
    public String addProductToCart(@PathVariable long id, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = (String) session.getAttribute("email");
        this.productService.handleAddProductToCart(email, id, session);
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String getCartPage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        long id = (long) session.getAttribute("id");
        User currentUser = new User();
        currentUser.setId(id);

        Cart cart = this.productService.fetchByUser(currentUser);
        List<CartDetail> cartDetails = cart == null ? new ArrayList<>() : cart.getCartDetails();

        double totalPrice = 0;
        for (CartDetail cd : cartDetails) {
            totalPrice += cd.getPrice() * cd.getQuantity();
        }

        model.addAttribute("cartDetails", cartDetails);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("cart", cart);
        return "client/cart/show";
    }

    @PostMapping("/delete-cart-product/{id}")
    public String deleteCartDetail(@PathVariable long id, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        this.productService.handleRemoveCartDetail(id, session);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String getCheckOutPage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        long id = (long) session.getAttribute("id");
        User currentUser = new User();
        currentUser.setId(id);

        Cart cart = this.productService.fetchByUser(currentUser);
        // đảm bảo tồn tại cart object để form:form bind
        if (cart == null) {
            cart = new Cart();
        }

        List<CartDetail> cartDetails = cart.getCartDetails() == null ? new ArrayList<>() : cart.getCartDetails();

        double totalPrice = 0;
        for (CartDetail cd : cartDetails) {
            totalPrice += cd.getPrice() * cd.getQuantity();
        }

        model.addAttribute("cartDetails", cartDetails);
        model.addAttribute("totalPrice", totalPrice);
        // thêm cart vào model để <form:form modelAttribute="cart"> hoạt động
        model.addAttribute("cart", cart);

        return "client/cart/checkout";
    }

    @PostMapping("/confirm-checkout")
    public String postConfirmCheckout(@ModelAttribute("cart") Cart cart) {
    List<CartDetail> cartDetails =
        (cart != null && cart.getCartDetails() != null) ? cart.getCartDetails() : new ArrayList<>();

    if (!cartDetails.isEmpty()) {
        this.productService.handleUpdateCartBeforeCheckout(cartDetails);
    }

    System.out.println("ReceiverName: " + cart.getReceiverName());
    System.out.println("ReceiverAddress: " + cart.getReceiverAddress());
    System.out.println("ReceiverPhone: " + cart.getReceiverPhone());

    return "redirect:/checkout";
}



   @PostMapping("/place-order")
    public String handlePlaceOrder(HttpServletRequest request,
    @RequestParam("receiverName") String receiverName,
    @RequestParam("receiverAddress") String receiverAddress,
    @RequestParam("receiverPhone") String receiverPhone) {
   
    HttpSession session = request.getSession(false);
    long id = (long) session.getAttribute("id");
    User currentUser = new User();
    currentUser.setId(id);
    
    this.productService.handlePlaceOrder(currentUser, session, receiverName, receiverAddress, receiverPhone);

    // chuyển sang trang cảm ơn
    return "redirect:/thanks";
}


    @GetMapping("/thanks")
    public String getThankYouPage(Model model) {

        return "client/cart/thanks";
    }
    
}
