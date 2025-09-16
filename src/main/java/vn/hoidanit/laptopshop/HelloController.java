package vn.hoidanit.laptopshop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {
	@GetMapping("/")
	public String index() {
		return "Hello World lam dep zai ";
	}

	@GetMapping("/user")
	public String userPage() {
		return "Only user can access this page ";
	}

	@GetMapping("/admim")
	public String adimPage() {
		return "Only adim can access this page ";
	}
}
