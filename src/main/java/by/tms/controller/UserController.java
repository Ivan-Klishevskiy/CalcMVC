package by.tms.controller;

import by.tms.dto.AuthorizationUserDto;
import by.tms.dto.RegistrationUserDto;
import by.tms.entity.User;
import by.tms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/reg")
    public String registration(Model model) {
        model.addAttribute("regUser", new RegistrationUserDto());
        return "reg";
    }

    @PostMapping("/reg")
    public String registration(@ModelAttribute("regUser") @Valid RegistrationUserDto registrationUserDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "reg";
        }
        if (userService.save(registrationUserDto.getName(), registrationUserDto.getUsername(), registrationUserDto.getPassword())) {
            return "redirect:/user/auth";
        } else {
            model.addAttribute("message", "The user is already registered!");
            return "reg";
        }
    }

    @GetMapping("/auth")
    public String authorization(Model model) {
        model.addAttribute("authUser", new RegistrationUserDto());
        return "auth";
    }

    @PostMapping("/auth")
    public String authorization(@ModelAttribute("authUser") @Valid AuthorizationUserDto authUserDto, BindingResult bindingResult, Model model, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "reg";
        }
        if (userService.findByUsername(authUserDto.getUsername()) != null) {
            if (userService.findByUsername(authUserDto.getUsername()).getPassword().equals(authUserDto.getPassword())) {
                httpSession.setAttribute("user", userService.findByUsername(authUserDto.getUsername()));
                return "redirect:/";
            } else {
                model.addAttribute("message", "Wrong password!");
                return "auth";
            }
        } else {
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
