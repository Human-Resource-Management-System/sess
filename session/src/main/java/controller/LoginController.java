package controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("email") String email, @RequestParam("password") String password) {
        // Perform any additional validation or processing as needed
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    // Other controller methods

}
