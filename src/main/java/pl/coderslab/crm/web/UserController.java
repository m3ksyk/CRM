package pl.coderslab.crm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.crm.entity.User;
import pl.coderslab.crm.repository.UserRepository;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    //change to service after implementing service and serviceIMpl logic

    @GetMapping("/user/form")
    public String userForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "userForm";
    }
    @PostMapping("/user/form")
    public String saveForm(@Valid @ModelAttribute User user, BindingResult result){
//        if(result.hasErrors()){
//            return "userForm";
//        }
        userRepository.save(user);
        return "redirect:/";
    }

    @RequestMapping("/user/all")
    public String readAll(Model model){
        model.addAttribute("users", userRepository.findAll());

        return "userList";
    }

}
