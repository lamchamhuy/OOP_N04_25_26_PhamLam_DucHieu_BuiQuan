package vn.lampham.laptopshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import vn.lampham.laptopshop.domain.Role;
import vn.lampham.laptopshop.domain.User;
import vn.lampham.laptopshop.domain.dto.RegisterDTO;
import vn.lampham.laptopshop.repository.RoleRepository;
import vn.lampham.laptopshop.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserService(UserRepository userRepository,RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User getUserByEmail(String email) {
    return this.userRepository.findByEmail(email).orElse(null);
    }


    public User handleSaveUser(User user) {
        User eric = this.userRepository.save(user);
        System.out.println(eric);
        return eric;
    }

    public User getUserById(long id) {
    return this.userRepository.findById(id).orElse(null);
}


    public void deleteAUser(long id) {
        // Xóa user theo ID
        this.userRepository.deleteById(id);

        jdbcTemplate.execute("SET @count = 0;");
        jdbcTemplate.execute("UPDATE users SET id = @count:=@count+1;");
        jdbcTemplate.execute("ALTER TABLE users AUTO_INCREMENT = 1;");
    }

    public Role getRoleByName(String name){
        return this.roleRepository.findByName(name);
    }

    public User registerDTOtoUser(RegisterDTO registerDTO ){
        User user = new User();
        user.setFullName(registerDTO.getFirstName() + " " + registerDTO.getLastName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());
        return user;
        
    }
    public boolean checkEmailExist(String email){
        return this.userRepository.existsByEmail(email);
    }

    public User getUserByEmail(String email) {
    return this.userRepository.findByEmail(email).orElse(null);
}

    @PostConstruct
    public void initAdmin() {
    if (!userRepository.existsByEmail("admin@gmail.com")) {
        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setPassword(new BCryptPasswordEncoder().encode("123456"));
        admin.setFullName("Admin Test");
        admin.setRole(roleRepository.findByName("ADMIN"));
        userRepository.save(admin);
    }
}

}
