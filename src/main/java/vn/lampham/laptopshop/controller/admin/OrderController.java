package vn.lampham.laptopshop.controller.admin;

import java.beans.PropertyEditorSupport;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.lampham.laptopshop.domain.Order;
import vn.lampham.laptopshop.domain.User;
import vn.lampham.laptopshop.service.OrderService;

@Controller
@RequestMapping("/admin/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Double.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                if (text == null || text.trim().isEmpty()) {
                    setValue(null);
                } else {
                    String normalized = text.replace(".", "").replace(",", ".");
                    setValue(Double.parseDouble(normalized));
                }
            }
        });
        binder.registerCustomEditor(double.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                if (text == null || text.trim().isEmpty()) {
                    setValue(0.0d);
                } else {
                    String normalized = text.replace(".", "").replace(",", ".");
                    setValue(Double.parseDouble(normalized));
                }
            }
        });
    }

    // ====== LIST ======
    @GetMapping
    public String getDashboard(Model model) {
        List<Order> orders = orderService.fetchAllOrders();
        model.addAttribute("orders", orders);
        return "admin/order/show";
    }

    // ====== DETAIL ======
    @GetMapping("/{id}")
    public String getOrderDetailPage(Model model, @PathVariable long id) {
        Optional<Order> optionalOrder = this.orderService.fetchOrderById(id);
        if (optionalOrder.isEmpty()) {
            return "redirect:/admin/order";
        }
        Order order = optionalOrder.get();
        model.addAttribute("order", order);
        model.addAttribute("orderDetails", order.getOrderDetails());
        return "admin/order/detail";
    }

    // ====== CREATE ======
    @GetMapping("/create")
    public String getCreateOrderPage(Model model) {
        model.addAttribute("newOrder", new Order());
        return "admin/order/create";
    }

    @PostMapping("/create")
    public String handleCreateOrder(@ModelAttribute("newOrder") Order order) {
        // Bạn có thể để như cũ; OrderService.saveOrder sẽ xử lý tìm user hợp lệ
        User defaultUser = new User();
        defaultUser.setId(1L);
        order.setUser(defaultUser);

        this.orderService.saveOrder(order);
        return "redirect:/admin/order";
    }

    // ====== UPDATE ======
    @GetMapping("/update/{id}")
    public String getUpdateOrderPage(Model model, @PathVariable long id) {
        Optional<Order> optionalOrder = this.orderService.fetchOrderById(id);
        if (optionalOrder.isEmpty()) {
            return "redirect:/admin/order";
        }
        model.addAttribute("newOrder", optionalOrder.get());
        return "admin/order/update";
    }

    @PostMapping("/update")
    public String handleUpdateOrder(@ModelAttribute("newOrder") Order order) {
        this.orderService.updateOrder(order);
        return "redirect:/admin/order";
    }

    // ====== DELETE ======
    @GetMapping("/delete/{id}")
    public String getDeleteOrderPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("newOrder", new Order());
        return "admin/order/delete";
    }

    @PostMapping("/delete")
    public String postDeleteOrder(@ModelAttribute("newOrder") Order order) {
        this.orderService.deleteOrderById(order.getId());
        return "redirect:/admin/order";
    }
}
