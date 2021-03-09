package club.wadreamer.chandao.controller;

import club.wadreamer.chandao.entity.Project;
import club.wadreamer.chandao.entity.User;
import club.wadreamer.chandao.service.ProjectService;
import club.wadreamer.chandao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ClassName: RedirectController
 * Description:
 * date: 2021/3/5 15:46
 *
 * @author wadreamer
 * @since JDK 1.8
 */
@Controller
public class RedirectController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/report")
    public String redirect(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.getAllUser());
        return "worksummary";
    }

    @RequestMapping("/worksummary")
    public String toWorkSummary(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.getAllUser());
        return "worksummary";
    }

    @RequestMapping("/worksumsort")
    public String toWorkSumSort() {
        return "worksumsort";
    }

    @RequestMapping("/workload")
    public String toWorkLoad(ModelMap modelMap) {
        List<Project> projectList = projectService.getAllProject();
        List<User> userList = userService.getAllUser();
        modelMap.addAttribute("projects", projectList);
        modelMap.addAttribute("users", userList);
        return "workload";
    }

    @RequestMapping("/")
    public String toLogin() {
        return "redirect:/login";
    }

}

