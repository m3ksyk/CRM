package pl.coderslab.crm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.crm.entity.Activity;
import pl.coderslab.crm.entity.Project;
import pl.coderslab.crm.repository.ActivityRepository;
import pl.coderslab.crm.repository.ProjectRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Transactional
@Controller
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ActivityRepository activityRepository;

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
        project.setCreated(Date.valueOf(LocalDate.now()));
        Activity activity = new Activity();
        activity.setType("new project created");
        activity.setDescription("name: " + project.getProjectName() + ", created: " + project.getCreated() +
                ", assigned To: " + project.getAssignedUsers().toString());

        projectRepository.save(project);
        activityRepository.save(activity);
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
