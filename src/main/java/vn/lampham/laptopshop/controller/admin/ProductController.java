package vn.lampham.laptopshop.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import vn.lampham.laptopshop.domain.Product;
import vn.lampham.laptopshop.service.ProductService;
import vn.lampham.laptopshop.service.UploadService;

@Controller
public class ProductController {

    private final UploadService uploadService;
    private final ProductService productService;

    public ProductController(UploadService uploadService, ProductService productService) {
        this.uploadService = uploadService;
        this.productService = productService;
    }

    // Hiển thị danh sách sản phẩm
    @GetMapping("/admin/product")
    public String getProduct(Model model) {
        List<Product> prs = this.productService.fetchProducts();
        model.addAttribute("products", prs);
        return "admin/product/show";
    }

    // Trang tạo sản phẩm
    @GetMapping("/admin/product/create")
    public String getCreateProductPage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }

    // Xử lý tạo sản phẩm
    @PostMapping("/admin/product/create")
    public String handleCreateProduct(
            @ModelAttribute("newProduct") @Valid Product pr,
            BindingResult newProductBindingResult,
            @RequestParam("hoidanitFile") MultipartFile file,
            Model model) {

        if (newProductBindingResult.hasErrors()) {
            return "admin/product/create";
        }

        // Lưu ảnh nếu có upload
        if (!file.isEmpty()) {
            String image = this.uploadService.handleSaveUploadFile(file, "product");
            pr.setImage(image);
        }

        // Lưu DB
        this.productService.createProduct(pr);
        return "redirect:/admin/product";
    }

    // Trang xác nhận xóa
    @GetMapping("/admin/product/delete/{id}")
    public String getDeleteProductPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("newProduct", new Product());
        return "admin/product/delete";
    }

    // Xử lý xóa
    @PostMapping("/admin/product/delete")
    public String postDeleteProduct(@ModelAttribute("newProduct") Product pr) {
        this.productService.deleteProduct(pr.getId());
        return "redirect:/admin/product";
    }

    // ✅ Xem chi tiết sản phẩm — Dùng giao diện của CLIENT
    @GetMapping("/admin/product/{id}")
    public String getProductDetailPage(Model model, @PathVariable long id) {
        Optional<Product> pr = this.productService.fetchProductById(id);
        if (pr.isPresent()) {
            model.addAttribute("product", pr.get());
            return "client/product/detail"; // 👉 dùng lại giao diện client
        }
        return "redirect:/admin/product";
    }

    // Trang cập nhật
    @GetMapping("/admin/product/update/{id}")
    public String getUpdateProductPage(Model model, @PathVariable long id) {
        Optional<Product> currentProduct = this.productService.fetchProductById(id);
        if (currentProduct.isPresent()) {
            model.addAttribute("newProduct", currentProduct.get());
            return "admin/product/update";
        }
        return "redirect:/admin/product";
    }

    // Xử lý cập nhật
    @PostMapping("/admin/product/update")
    public String handleUpdateProduct(
            @ModelAttribute("newProduct") @Valid Product pr,
            BindingResult newProductBindingResult,
            @RequestParam("hoidanitFile") MultipartFile file,
            Model model) {

        if (newProductBindingResult.hasErrors()) {
            model.addAttribute("newProduct", pr);
            return "admin/product/update";
        }

        Product currentProduct = this.productService.fetchProductById(pr.getId()).orElse(null);
        if (currentProduct != null) {
            if (!file.isEmpty()) {
                String img = this.uploadService.handleSaveUploadFile(file, "product");
                currentProduct.setImage(img);
            }

            currentProduct.setName(pr.getName());
            currentProduct.setPrice(pr.getPrice());
            currentProduct.setQuantity(pr.getQuantity());
            currentProduct.setDetailDesc(pr.getDetailDesc());
            currentProduct.setShortDesc(pr.getShortDesc());
            currentProduct.setFactory(pr.getFactory());
            currentProduct.setTarget(pr.getTarget());

            this.productService.createProduct(currentProduct);
        }

        return "redirect:/admin/product";
    }
}
