package com.furamavietnam.controllers;

import com.furamavietnam.models.*;
import com.furamavietnam.services.*;
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
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private EducationDegreeService educationDegreeService;
    @Autowired
    private DivisionService divisionService;

    @ModelAttribute("educationDegrees")
    private List<EducationDegree> getEducationDegrees() {
        return educationDegreeService.findAll();
    }

    @ModelAttribute("positions")
    private List<Position> getPositions() {
        return positionService.findAll();
    }

    @ModelAttribute("divisions")
    private List<Division> getDivisions() {
        return divisionService.findAll();
    }

    @GetMapping("list")
    @ResponseBody
    public Page<Employee> getList(@RequestParam Optional<String> key,
                                                  @PageableDefault(value = 4) Pageable pageable) {
        Page<Employee> employees;
        if (key.isPresent() && !key.get().trim().equals("")) {
            employees = employeeService.findAllByKey(key.get(), pageable);
        } else {
            employees = employeeService.findAll(pageable);
        }
        return employees;
    }

    @GetMapping("")
    public String showEmployeePage() {
        return "employee/list";
    }

    @GetMapping("create")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/form";
    }

    @PostMapping("save")
    public String saveEmployee(@ModelAttribute Employee employee, RedirectAttributes redirect) {
        employeeService.save(employee);
        redirect.addFlashAttribute("message", "Added employee successfully!");
        return "redirect:/employee";
    }

    @GetMapping("{id}/edit")
    public String editEmployee(@PathVariable Integer id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/form";
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
        return "employee/form";
    }

}
