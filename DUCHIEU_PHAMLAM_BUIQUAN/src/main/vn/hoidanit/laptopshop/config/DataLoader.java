package vn.hoidanit.laptopshop.config;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import vn.hoidanit.laptopshop.domain.*;
import vn.hoidanit.laptopshop.repository.*;
import java.math.BigDecimal;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired private CategoryRepository catRepo;
    @Autowired private ProductRepository prodRepo;
    @Autowired private UserRepository userRepo;

    @Override
    public void run(String... args) throws Exception {
        Category c = new Category(); c.setName("Laptop"); c = catRepo.save(c);
        Product p1 = new Product(); p1.setName("Laptop A"); p1.setDescription("Core i5, 8GB"); p1.setPrice(new BigDecimal("15000000")); p1.setCategory(c); prodRepo.save(p1);
        Product p2 = new Product(); p2.setName("Laptop B"); p2.setDescription("Core i3, 4GB"); p2.setPrice(new BigDecimal("9000000")); p2.setCategory(c); prodRepo.save(p2);
        User u = new User(); u.setEmail("test@example.com"); u.setFullName("Test User"); u.setPassword("123456"); userRepo.save(u);
    }
}
