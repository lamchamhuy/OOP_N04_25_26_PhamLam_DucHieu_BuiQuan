package vn.hoidanit.laptopshop.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired private ProductRepository repo;
    public List<Product> findAll(){ return repo.findAll(); }
    public Product findById(Long id){ return repo.findById(id).orElse(null); }
    public Product save(Product p){ return repo.save(p); }
    public void delete(Long id){ repo.deleteById(id); }
}
