package vn.hoidanit.laptopshop.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.hoidanit.laptopshop.domain.Category;
public interface CategoryRepository extends JpaRepository<Category, Long> {}
