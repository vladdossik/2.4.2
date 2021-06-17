package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public String getUser(Model model) {
        model.addAttribute("list", userService.listUsers());
        return "admin";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable(name = "id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable(name = "id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/createForm")
    public String createForm(Model model) {
        model.addAttribute("user", new User());
        return "createForm";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @GetMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.updateUser(id, user);
        return "redirect:/admin";
    }
}
