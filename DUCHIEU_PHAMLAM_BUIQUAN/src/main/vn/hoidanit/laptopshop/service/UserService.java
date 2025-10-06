package vn.hoidanit.laptopshop.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Service
public class UserService {
    @Autowired private UserRepository repo;
    public List<User> findAll(){ return repo.findAll(); }
    public User findById(Long id){ return repo.findById(id).orElse(null); }
    public User save(User u){ return repo.save(u); }
}
