package com.furamavietnam.controllers;

import com.furamavietnam.models.AppUser;
import com.furamavietnam.models.Employee;
import com.furamavietnam.services.employee.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("employee")
public class ContractController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private EducationDegreeService educationDegreeService;
    @Autowired
    private DivisionService divisionService;
    @Autowired
    private AppUserService appUserService;

    @GetMapping("getUsers")
    @ResponseBody
    public List<AppUser> getUserList() {
        return appUserService.findAll();
    }

    @GetMapping("")
    public String getList(@RequestParam Optional<String> key, @PageableDefault(value = 4) Pageable pageable, Model model) {
        Page<Employee> employees;
        if (key.isPresent() && !key.get().trim().equals("")) {
            model.addAttribute("key", key.get());
            employees = employeeService.findAllByKey(key.get(), pageable);
        } else {
            employees = employeeService.findAll(pageable);
        }
        model.addAttribute("employees", employees);
        return "employee/list";
    }

    @GetMapping("create")
    public String addEmployee(Model model) {
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("divisions", divisionService.findAll());
        model.addAttribute("users", appUserService.findAll());
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping("save")
    public String saveEmployee(@ModelAttribute Employee employee, RedirectAttributes redirect) {
        employeeService.save(employee);
        redirect.addFlashAttribute("message", "Added employee successfully!");
        return "redirect:/employee";
    }

    @GetMapping("{id}/edit")
    public String editEmployee(@PathVariable Integer id, Model model) {
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("divisions", divisionService.findAll());
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/edit";
    }

    @PostMapping("update")
    public String updateEmployee(@ModelAttribute Employee employee, RedirectAttributes redirect) {
        employeeService.save(employee);
        redirect.addFlashAttribute("message", "Updated employee successfully!");
        return "redirect:/employee";
    }

    @GetMapping("{id}/delete")
    public String deleteEmployee(@PathVariable Integer id, RedirectAttributes redirect) {
        employeeService.delete(id);
        redirect.addFlashAttribute("message", "Removed employee successfully!");
        return "redirect:/employee";
    }

    @GetMapping("{id}")
    public String viewEmployee(@PathVariable Integer id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/view";
    }

}
