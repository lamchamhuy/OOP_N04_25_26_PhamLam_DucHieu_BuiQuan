package vn.hoidanit.laptopshop.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hoidanit.laptopshop.domain.CustomerOrder;
import vn.hoidanit.laptopshop.repository.OrderRepository;
import java.util.List;

@Service
public class OrderService {
    @Autowired private OrderRepository repo;
    public CustomerOrder save(CustomerOrder o){ return repo.save(o); }
    public List<CustomerOrder> findAll(){ return repo.findAll(); }
}
