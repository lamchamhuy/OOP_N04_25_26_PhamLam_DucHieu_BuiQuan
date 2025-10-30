package vn.lampham.laptopshop.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import vn.lampham.laptopshop.domain.Order;
import vn.lampham.laptopshop.service.OrderService;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //  Danh sách tất cả Order
    @GetMapping("/admin/order")
    public String getDashboard(Model model) {
        List<Order> orders = this.orderService.fetchAllOrders();
        model.addAttribute("orders", orders);
        return "admin/order/show";
    }

    //  Chi tiết một Order
    @GetMapping("/admin/order/{id}")
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

    //  Trang tạo Order (thêm mới)
    @GetMapping("/admin/order/create")
    public String getCreateOrderPage(Model model) {
        model.addAttribute("newOrder", new Order());
        return "admin/order/create";
    }

    //  Xử lý khi nhấn nút “Create”
    @PostMapping("/admin/order/create")
    public String handleCreateOrder(@ModelAttribute("newOrder") Order order) {
        this.orderService.saveOrder(order);
        return "redirect:/admin/order";
    }

    //  Trang cập nhật Order
    @GetMapping("/admin/order/update/{id}")
    public String getUpdateOrderPage(Model model, @PathVariable long id) {
        Optional<Order> optionalOrder = this.orderService.fetchOrderById(id);
        if (optionalOrder.isEmpty()) {
            return "redirect:/admin/order";
        }
        model.addAttribute("newOrder", optionalOrder.get());
        return "admin/order/update";
    }

    //  Xử lý cập nhật Order
    @PostMapping("/admin/order/update")
    public String handleUpdateOrder(@ModelAttribute("newOrder") Order order) {
        this.orderService.updateOrder(order);
        return "redirect:/admin/order";
    }

    //  Trang xác nhận xóa
    @GetMapping("/admin/order/delete/{id}")
    public String getDeleteOrderPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("newOrder", new Order());
        return "admin/order/delete";
    }

    //  Xử lý xóa
    @PostMapping("/admin/order/delete")
    public String postDeleteOrder(@ModelAttribute("newOrder") Order order) {
        this.orderService.deleteOrderById(order.getId());
        return "redirect:/admin/order";
    }
}
