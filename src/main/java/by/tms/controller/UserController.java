package by.tms.controller;

import by.tms.entity.User;
import by.tms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @PostMapping("/req")
    public String registration(String name, String username, String password ){
        System.out.println(name+" "+username+" "+password);
        if(userService.save(name, username, password)){
            return "redirect:/user/auth";
        }else {
            //model.addAttribute("message","The user is already registered!");
            return "req";
        }
    }

    @GetMapping("/auth")
    public String authorization(){
        return "auth";
    }

    @PostMapping("/auth")
    public String authorization(String username, String password){
        System.out.println(username+" "+password);
        return "redirect:/";
    }
}
