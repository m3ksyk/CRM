package pl.coderslab.crm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.crm.entity.Status;
import pl.coderslab.crm.repository.StatusRepository;

import javax.validation.Valid;

@Controller
public class StatusController {
    @Autowired
    StatusRepository statusRepository;

    //change to service after implementing service and serviceIMpl logic

    @GetMapping("/status/form")
    public String statusForm(Model model){
        Status status = new Status();
        model.addAttribute("status", status);
        return "statusForm";
    }
    @PostMapping("/status/form")
    public String saveForm(@Valid @ModelAttribute Status status, BindingResult result){
        if(result.hasErrors()){
            return "statusForm";
        }
        statusRepository.save(status);
        return "redirect:/";
    }

    @RequestMapping("/status/all")
    public String readAll(Model model){
        model.addAttribute("statuses", statusRepository.findAll());

        return "statusList";
    }

}
