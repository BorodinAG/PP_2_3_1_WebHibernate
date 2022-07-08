package webHibernateEntityManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import webHibernateEntityManager.model.User;
import webHibernateEntityManager.service.UserServiceImpl;

import javax.validation.Valid;

@Controller
@RequestMapping("client")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String users(Model model) {
        model.addAttribute("client", userService.getAll());
        return "client/users";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "client/show";
    }
    @GetMapping("/new")
    public String createUserForm(@ModelAttribute("user") User user) {
        return "client/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "client/new";
        userService.add(user);
        return "redirect:/client";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/client";
    }

    @GetMapping("edit/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "client/edit";
    }

    @PostMapping("update")
    public String updateUser(User user) {
        userService.edit(user);
        return "redirect:/client";
    }
}
