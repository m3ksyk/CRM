package pl.coderslab.crm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.crm.repository.ProjectRepository;

@Controller
public class IndexController {

    @Autowired
    ProjectRepository projectRepository;

    //activity!!

    @RequestMapping("/")
    public String showRecentProjectsAndActivities(Model model){
        model.addAttribute("projects", projectRepository.findAll());
//activity!!
        return "index";
    }
    //TODO actions for viewing projects and activities in index page
    //add new activity entity and repository and service for it. add activity within operations of adding tasks etc.

//    Strona ta ma wyświetlać listę ostatnich aktywności użytkowników systemu od najnowszej do
//    najstarszej.
//    Limit listy aktywności na stronie głównej to 25.
//    Operacje, które mają się pojawiać na liście aktywności, to:
//    utworzenie projektu – informacja kto i kiedy to zrobił,
//    dodanie zadania do projektu – informacja kto, kiedy i do jakiego projektu dodał zadanie;
//    dodatkowo powinien się pojawić link do szczegółów danego zagadnienia.
//    zmiana statusu zadania – informacja kto i kiedy to zrobił oraz z jakiego projektu pochodziło
//            zadanie; dodatkowo powinien się pojawić link do szczegółów danego zagadnienia.

}
