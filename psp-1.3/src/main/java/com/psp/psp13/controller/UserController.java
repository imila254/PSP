package com.psp.psp13.controller;

import com.psp.psp13.model.User;
import com.psp.psp13.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserService service;

    public UserController(){}

    public UserController(UserService service){
        super();
        this.service = service;
    }

    @GetMapping("/list-users")
    public String showAll(ModelMap modelMap){
        modelMap.put("users", service.findAll());
        return "list-users"; // list-users.jpa
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.GET)
    public String showAddUserView(ModelMap modelMap){
        modelMap.addAttribute("user", new User(service.findMaxId() + 1L, "", "", "", "", "", ""));
        return "user";
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public String addUser(ModelMap modelMap, @ModelAttribute("user") User user, BindingResult result){
        if (result.hasErrors()) return "user";
        service.add(user);
        return  "redirect:/list-users";
    }

    @RequestMapping(value = "/update-user/{userId}", method = RequestMethod.GET)
    public String showUpdatePage(ModelMap modelMap, @PathVariable Long userId){
        modelMap.addAttribute("user", service.findUserById(userId));
        return "user";
    }

    @RequestMapping(value = "/update-user/{userId}", method = RequestMethod.POST)
    public String update(ModelMap modelMap, @ModelAttribute("user") User user, BindingResult result){
        if (result.hasErrors()){
            return "user";
        }
        service.update(user);
        return "redirect:/list-users";
    }

    @GetMapping("/delete-user/{userId}")
    public String delete(@PathVariable Long userId){
        service.deleteById(userId);
        return "redirect:/list-users";
    }


}
