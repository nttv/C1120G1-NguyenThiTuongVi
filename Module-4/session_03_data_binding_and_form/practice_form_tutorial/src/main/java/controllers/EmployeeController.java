package controllers;

import models.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @GetMapping("showForm")
    public ModelAndView showForm() {
        return new ModelAndView("employee/create", "employee", new Employee());
    }

    @PostMapping("addEmployee")
    public ModelAndView addEmployee(@ModelAttribute Employee employee) {
        return new ModelAndView("employee/info", "employee", employee);
    }
}
