package vn.hoidanit.laptopshop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired private UserService userService;
    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("user", new User());
        return "user/create";
    }
    @PostMapping("/create")
    public String createUser(@ModelAttribute User user){
        userService.save(user);
        return "redirect:/";
    }
}
