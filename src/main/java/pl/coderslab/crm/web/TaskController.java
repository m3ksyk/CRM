package pl.coderslab.crm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.crm.entity.Project;
import pl.coderslab.crm.entity.Task;
import pl.coderslab.crm.repository.ProjectRepository;
import pl.coderslab.crm.repository.TaskRepository;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ProjectRepository projectRepository;

    //change to service after implementing service and serviceIMpl logic

    @GetMapping("/task/form")
    public String taskForm(Model model){
        Task task = new Task();
        model.addAttribute("task", task);
        return "TaskForm";
    }
    @PostMapping("/task/form")
    public String saveForm(@Valid @ModelAttribute Task task, BindingResult result){
        if(result.hasErrors()){
            return "TaskForm";
        }
        taskRepository.save(task);
        return "redirect:/";
    }

    @GetMapping("/task/edit/{id}")
    public String taskUpdateForm(@PathVariable long id, Model model){
        Optional<Task> task = taskRepository.findById(id);

        model.addAttribute("task", task);
        return "TaskEdit";
    }
    @PostMapping("/task/edit/{id}")
    public String saveUpdateForm(@Valid @ModelAttribute Task task, BindingResult result){
        if(result.hasErrors()){
            return "TaskEdit";
        }
        taskRepository.save(task);
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

        return "TaskDetails";
    }



}
