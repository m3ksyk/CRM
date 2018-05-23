package pl.coderslab.crm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.crm.entity.Activity;
import pl.coderslab.crm.entity.Project;
import pl.coderslab.crm.entity.Task;
import pl.coderslab.crm.repository.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Transactional
@Controller
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    PriorityRepository priorityRepository;

    //change to service after implementing service and serviceIMpl logic

    @GetMapping("/task/form")
    public String taskForm(Model model){
        Task task = new Task();
        model.addAttribute("task", task);
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("priorities", priorityRepository.findAll());
        model.addAttribute("statuses", statusRepository.findAll());
        return "taskForm";
    }
    @PostMapping("/task/form")
    public String saveForm(@Valid @ModelAttribute Task task, BindingResult result){
//        if(result.hasErrors()){
//            return "taskForm";
//        }
        task.setCreated(Date.valueOf(LocalDate.now()));
        Activity activity = new Activity();
        activity.setType("new task created");
        activity.setDescription("name: " + task.getName() + ", created: " + task.getCreated() +
                ", in project: " + task.getProject().getProjectName() +
                ", assigned To: " + task.getAssignedUser().getLogin() +
                "<a th:href=@{'/task/details/"+task.getId()+"}'> details </a>");
        //change this later, add a field "link" or something

        taskRepository.save(task);
        activityRepository.save(activity);
        return "redirect:/admin";
    }

    @GetMapping("/task/edit/{id}")
    public String taskUpdateForm(@PathVariable long id, Model model){
        Optional<Task> task = taskRepository.findById(id);

        model.addAttribute("task", task);
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("priorities", priorityRepository.findAll());
        model.addAttribute("statuses", statusRepository.findAll());
        return "taskEdit";
    }
    @PostMapping("/task/edit/{id}")
    public String saveUpdateForm(@Valid @ModelAttribute Task task, BindingResult result){
        if(result.hasErrors()){
            return "taskEdit";
        }
        Activity activity = new Activity();
        activity.setType("task edited");
        activity.setDescription("name: " + task.getName() + ", edited: " + Date.valueOf(LocalDate.now()) +
                ", in project: " + task.getProject().getProjectName() +
                ", assigned To: " + task.getAssignedUser().getLogin() +
                ",current status: " + task.getStatus().getName() +
                "<a th:href=@{'/task/details/"+task.getId()+"}'> details </a>");
        //change this later, add a field "link" or something

        taskRepository.save(task);
        activityRepository.save(activity);
      return "redirect:/";
    }

    @RequestMapping("/task/all")
    public String readAll(Model model){
        model.addAttribute("tasks", taskRepository.findAll());

        return "taskList";
    }

    @RequestMapping("/task/project/{id}")
    public String readAllInProject(@PathVariable long id, Model model){
        Optional<Project> project = projectRepository.findById(id);
        model.addAttribute("tasks", taskRepository.findAllByProject(project));

        return "projectTaskList";
    }

    @RequestMapping("/task/details/{id}")
    public String readTaskDetails(@PathVariable long id, Model model){
        model.addAttribute("task", taskRepository.findById(id));

        return "taskDetails";
    }



}
