package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.entities.User;
import project.services.UserService;

@Controller
public class MyController {

    private UserService userService;

    @Autowired
    public MyController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/update")
    public String wantToUpdateUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteUser(@ModelAttribute("user") User user) {
        userService.removeUser(user);
        return "redirect:/";
    }

    @GetMapping("/new")
    public String wantToCreateUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }
}
