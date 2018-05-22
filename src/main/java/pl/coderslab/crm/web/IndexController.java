package pl.coderslab.crm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.crm.repository.ActivityRepository;
import pl.coderslab.crm.repository.ProjectRepository;

@Controller
public class IndexController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ActivityRepository activityRepository;


    @RequestMapping("/")
    public String showRecentProjectsAndActivities(Model model){
        model.addAttribute("projects", projectRepository.findRecentFive());
        model.addAttribute("activities", activityRepository.findRecent());
        return "index";
    }
    //TODO actions for viewing projects and activities in index page
    //add activity STUFF within operations of adding tasks etc.


}
