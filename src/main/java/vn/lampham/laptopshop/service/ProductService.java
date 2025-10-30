package vn.lampham.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import vn.lampham.laptopshop.domain.Cart;
import vn.lampham.laptopshop.domain.CartDetail;
import vn.lampham.laptopshop.domain.Order;
import vn.lampham.laptopshop.domain.OrderDetail;
import vn.lampham.laptopshop.domain.Product;
import vn.lampham.laptopshop.domain.User;
import vn.lampham.laptopshop.repository.CartDetailRepository;
import vn.lampham.laptopshop.repository.CartRepository;
import vn.lampham.laptopshop.repository.OrderDetailRepository;
import vn.lampham.laptopshop.repository.OrderRepository;
import vn.lampham.laptopshop.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;
    private final UserService userService;
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    public ProductService(ProductRepository productRepository,
                          CartRepository cartRepository,
                          CartDetailRepository cartDetailRepository,
                          UserService userService,
                          OrderRepository orderRepository,
                          OrderDetailRepository orderDetailRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.cartDetailRepository = cartDetailRepository;
        this.userService = userService;
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    public Product createProduct(Product pr) {
        return this.productRepository.save(pr);
    }

    public List<Product> fetchProducts() {
        return this.productRepository.findAll();
    }

    public Optional<Product> fetchProductById(long id) {
        return this.productRepository.findById(id);
    }

    public void deleteProduct(long id) {
        this.productRepository.deleteById(id);
    }

    public void handleAddProductToCart(String email, long productId, HttpSession session) {
        User user = this.userService.getUserByEmail(email);
        if (user == null) return;

        Cart cart = this.cartRepository.findByUser(user);
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            cart.setSum(0);
            cart = this.cartRepository.save(cart);
        }

        Optional<Product> productOptional = this.productRepository.findById(productId);
        if (productOptional.isPresent()) {
            Product realProduct = productOptional.get();
            CartDetail oldDetail = this.cartDetailRepository.findByCartAndProduct(cart, realProduct);
            if (oldDetail == null) {
                CartDetail cd = new CartDetail();
                cd.setCart(cart);
                cd.setProduct(realProduct);
                cd.setPrice(realProduct.getPrice());
                cd.setQuantity(1);
                this.cartDetailRepository.save(cd);
                cart.setSum(cart.getSum() + 1);
                this.cartRepository.save(cart);
                session.setAttribute("sum", cart.getSum());
            } else {
                oldDetail.setQuantity(oldDetail.getQuantity() + 1);
                this.cartDetailRepository.save(oldDetail);
            }
        }
    }

    public Cart fetchByUser(User user) {
        return this.cartRepository.findByUser(user);
    }

    public void handleRemoveCartDetail(long cartDetailId, HttpSession session) {
        Optional<CartDetail> cartDetailOptional = this.cartDetailRepository.findById(cartDetailId);
        if (cartDetailOptional.isPresent()) {
            CartDetail cartDetail = cartDetailOptional.get();
            Cart currentCart = cartDetail.getCart();
            this.cartDetailRepository.deleteById(cartDetailId);

            if (currentCart.getSum() > 1) {
                currentCart.setSum(currentCart.getSum() - 1);
                session.setAttribute("sum", currentCart.getSum());
                this.cartRepository.save(currentCart);
            } else {
                this.cartRepository.deleteById(currentCart.getId());
                session.setAttribute("sum", 0);
            }
        }
    }

    public void handleUpdateCartBeforeCheckout(List<CartDetail> cartDetails) {
    if (cartDetails == null || cartDetails.isEmpty()) {
        return;
    }
    for (CartDetail cartDetail : cartDetails) {
        Optional<CartDetail> cdOptional = this.cartDetailRepository.findById(cartDetail.getId());
        if (cdOptional.isPresent()) {
            CartDetail currentCartDetail = cdOptional.get();
            currentCartDetail.setQuantity(cartDetail.getQuantity());
            this.cartDetailRepository.save(currentCartDetail);
        }
    }
}

    public void handlePlaceOrder(
        User user, HttpSession session,
        String receiverName,String receiverAddress,String receiverPhone ){

            //step 1: get cart by user
            Cart cart = this.cartRepository.findByUser(user);
            if(cart != null){
                List<CartDetail> cartDetails = cart.getCartDetails();

                if(cartDetails != null){

                    // create order 
                    Order order = new Order();
                    order.setUser(user);
                    order.setReceiverName(receiverName);
                    order.setReceiverAddress(receiverAddress);
                    order.setReceiverPhone(receiverPhone);
                    order.setStatus("PENDING");

                    double sum = 0;
                    for (CartDetail cd : cartDetails){
                        sum += cd.getPrice();
                    }
                    order.setTotalPrice(sum);
                    order = this.orderRepository.save(order);

                    // create orderDetail

                
                    for (CartDetail cd : cartDetails) {
                        OrderDetail orderDetail = new OrderDetail();
                        orderDetail.setOrder(order);
                        orderDetail.setProduct(cd.getProduct());
                        orderDetail.setPrice(cd.getPrice());
                        orderDetail.setQuantity(cd.getQuantity());
                        
                        this.orderDetailRepository.save(orderDetail);
                    }

                    // step 2 delete cart_detail and cart
                    for(CartDetail cd : cartDetails){
                        this.cartDetailRepository.deleteById(cd.getId());
                    }

                    this.cartRepository.deleteById(cart.getId());

                    // step 3 update
                    session.setAttribute("sum", 0);
                }
            }

    }
}
