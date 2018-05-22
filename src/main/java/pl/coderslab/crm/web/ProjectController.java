package pl.coderslab.crm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.crm.entity.Project;
import pl.coderslab.crm.repository.ProjectRepository;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    //change to service after implementing service and serviceIMpl logic

    @GetMapping("/project/form")
    public String projectForm(Model model){
        Project project = new Project();
        model.addAttribute("project", project);
        return "ProjectForm";
    }
    @PostMapping("/project/form")
    public String saveForm(@Valid @ModelAttribute Project project, BindingResult result){
        if(result.hasErrors()){
            return "ProjectForm";
        }
        projectRepository.save(project);
        return "redirect:/";
    }

    @GetMapping("/project/edit/{id}")
    public String projectUpdateForm(@PathVariable long id, Model model){
        Optional<Project> project = projectRepository.findById(id);

        model.addAttribute("project", project);
        return "ProjectEdit";
    }
    @PostMapping("/project/edit/{id}")
    public String saveUpdateForm(@Valid @ModelAttribute Project project, BindingResult result){
        if(result.hasErrors()){
            return "ProjectEdit";
        }
        projectRepository.save(project);
      return "redirect:/";
    }

    @RequestMapping("/project/all")
    public String readAll(Model model){
        model.addAttribute("projects", projectRepository.findAll());

        return "projectList";
    }

    @RequestMapping("/project/details/{id}")
    public String readProjectDetails(@PathVariable long id, Model model){
        model.addAttribute("project", projectRepository.findById(id));

        return "ProjectDetails";
    }

}
