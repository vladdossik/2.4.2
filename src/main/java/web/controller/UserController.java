
package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public String showUser(Model model, Authentication authentication) {
        model.addAttribute("user", userService.getUserByName(authentication.getName()));
        return "us";
    }
}