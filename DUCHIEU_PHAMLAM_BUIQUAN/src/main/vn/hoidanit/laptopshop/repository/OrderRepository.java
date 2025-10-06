package vn.hoidanit.laptopshop.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.hoidanit.laptopshop.domain.CustomerOrder;
public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {}
