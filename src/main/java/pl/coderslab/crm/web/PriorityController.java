package pl.coderslab.crm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.crm.entity.Priority;
import pl.coderslab.crm.repository.PriorityRepository;

import javax.validation.Valid;

@Controller
public class PriorityController {

    @Autowired
    PriorityRepository priorityRepository;

    //change to service after implementing service and serviceIMpl logic

    @GetMapping("/priority/form")
    public String priorityForm(Model model){
        Priority priority = new Priority();
        model.addAttribute("priority", priority);
        return "PriorityForm";
    }
    @PostMapping("/priority/form")
    public String saveForm(@Valid @ModelAttribute Priority priority, BindingResult result){
        if(result.hasErrors()){
            return "PriorityForm";
        }
        priorityRepository.save(priority);
        return "redirect:/";
    }

    @RequestMapping("/priority/all")
    public String readAll(Model model){
        model.addAttribute("prioritys", priorityRepository.findAll());

        return "priorityList";
    }

}
