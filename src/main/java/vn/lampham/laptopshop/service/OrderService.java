package vn.lampham.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import vn.lampham.laptopshop.domain.Order;
import vn.lampham.laptopshop.domain.OrderDetail;
import vn.lampham.laptopshop.domain.User;
import vn.lampham.laptopshop.repository.OrderDetailRepository;
import vn.lampham.laptopshop.repository.OrderRepository;
import vn.lampham.laptopshop.repository.UserRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository,
                        OrderDetailRepository orderDetailRepository,
                        UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.userRepository = userRepository;
    }

    public List<Order> fetchAllOrders() {
        return this.orderRepository.findAll();
    }

    public Optional<Order> fetchOrderById(long id) {
        return this.orderRepository.findById(id);
    }

    public void deleteOrderById(long id) {
        Optional<Order> orderOptional = this.fetchOrderById(id);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            List<OrderDetail> orderDetails = order.getOrderDetails();
            if (orderDetails != null) {
                for (OrderDetail orderDetail : orderDetails) {
                    this.orderDetailRepository.deleteById(orderDetail.getId());
                }
            }
        }
        this.orderRepository.deleteById(id);
    }

    public void updateOrder(Order order) {
        Optional<Order> orderOptional = this.fetchOrderById(order.getId());
        if (orderOptional.isPresent()) {
            Order currentOrder = orderOptional.get();
            currentOrder.setStatus(order.getStatus());
            currentOrder.setReceiverName(order.getReceiverName());
            currentOrder.setReceiverAddress(order.getReceiverAddress());
            currentOrder.setReceiverPhone(order.getReceiverPhone());
            // không thay đổi user ở đây (giữ nguyên currentOrder.getUser())
            this.orderRepository.save(currentOrder);
        }
    }

    /**
     * Save order: đảm bảo order.user là user managed (nạp từ DB) trước khi save.
     * - Nếu order.getUser() có id và tồn tại -> dùng nó
     * - Ngược lại, thử lấy user từ SecurityContext (username/email)
     * - Nếu không có, fallback sang user id = 1 (nếu tồn tại)
     * - Nếu vẫn không, ném RuntimeException để dev biết phải có user
     */
    public void saveOrder(Order order) {
        User userToSet = null;

        // 1) Nếu client gởi user với id hợp lệ, thử lấy từ DB
        if (order.getUser() != null && order.getUser().getId() != 0) {
            long uid = order.getUser().getId();
            Optional<User> userOptional = this.userRepository.findById(uid);
            if (userOptional.isPresent()) {
                userToSet = userOptional.get();
            } // nếu không tìm thấy, ta tiếp tục các bước sau
        }

        // 2) Nếu chưa có user hợp lệ, thử lấy user đang đăng nhập
        if (userToSet == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null && auth.isAuthenticated()) {
                Object principal = auth.getPrincipal();
                String username = null;
                if (principal instanceof org.springframework.security.core.userdetails.UserDetails) {
                    username = ((org.springframework.security.core.userdetails.UserDetails) principal).getUsername();
                } else if (principal instanceof String) {
                    username = (String) principal;
                }

                if (username != null && !username.isEmpty()) {
                    Optional<User> userByEmail = this.userRepository.findByEmail(username);
                    if (userByEmail.isPresent()) {
                        userToSet = userByEmail.get();
                    }
                }
            }
        }

        // 3) Nếu vẫn null, fallback id = 1 (nếu có)
        if (userToSet == null) {
            Optional<User> fallback = this.userRepository.findById(1L);
            if (fallback.isPresent()) {
                userToSet = fallback.get();
            }
        }

        // 4) Nếu vẫn null -> không thể lưu order an toàn -> ném exception rõ ràng
        if (userToSet == null) {
            throw new RuntimeException("Không tìm thấy User hợp lệ để gán cho Order. " +
                    "Hãy đảm bảo có user trong DB hoặc người dùng đã đăng nhập.");
        }

        // Gán user được quản lý (managed entity) cho order trước khi save
        order.setUser(userToSet);

        // Lưu order (cùng với orderDetails nếu có cascade)
        this.orderRepository.save(order);
    }
}
