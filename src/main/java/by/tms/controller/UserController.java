package by.tms.controller;

import by.tms.entity.User;
import by.tms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/reg")
    public String registration(){
        return "reg";
    }

    @PostMapping("/reg")
    public String registration(User user,Model model){
        if(userService.save(user)){
            return "redirect:/user/auth";
        }else {
            model.addAttribute("message","The user is already registered!");
            return "req";
        }
    }

    @GetMapping("/auth")
    public String authorization(){
        return "auth";
    }

    @PostMapping("/auth")
    public String authorization(String username, String password, Model model, HttpSession httpSession){
        if(userService.findByUsername(username)!=null){
            if (userService.findByUsername(username).getPassword().equals(password)) {
                httpSession.setAttribute("user", userService.findByUsername(username));
                return "redirect:/";
            }else {
                model.addAttribute("message", "Wrong password!");
                return "auth";
            }
        }else {
            model.addAttribute("message", "User not found!");
            return "auth";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }
}
