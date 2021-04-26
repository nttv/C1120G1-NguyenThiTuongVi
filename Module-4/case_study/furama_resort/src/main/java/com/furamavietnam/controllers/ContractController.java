package com.furamavietnam.controllers;

import com.furamavietnam.models.Contract;
import com.furamavietnam.models.ContractDetail;
import com.furamavietnam.services.contract.AttachServiceService;
import com.furamavietnam.services.contract.ContractDetailService;
import com.furamavietnam.services.contract.ContractService;
import com.furamavietnam.services.customer.CustomerService;
import com.furamavietnam.services.employee.*;
import com.furamavietnam.services.service.ResortServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("appUser")
@RequestMapping("contract")
public class ContractController {

    @Autowired
    private ContractService contractService;
    @Autowired
    private ContractDetailService contractDetailService;
    @Autowired
    private AttachServiceService attachServiceService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ResortServiceService resortServiceService;

    @GetMapping("")
    public String getList(@PageableDefault(value = 4) Pageable pageable, Model model) {
        model.addAttribute("contracts", contractService.findAll(pageable));
        return "contract/list";
    }

    @GetMapping("create")
    public String addContract(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("services", resortServiceService.findAll());
        model.addAttribute("contract", new Contract());
        return "contract/create";
    }

    @PostMapping("save")
    public String saveContract(@Validated @ModelAttribute Contract contract, BindingResult bindingResult,
                               Model model, RedirectAttributes redirect) {
        new Contract().validate(contract, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("employees", employeeService.findAll());
            model.addAttribute("customers", customerService.findAll());
            model.addAttribute("services", resortServiceService.findAll());
            return "contract/create";
        } else {
            contractService.save(contract);
            redirect.addFlashAttribute("message", "Added contract successfully!");
            return "redirect:/contract";
        }
    }

    @GetMapping("{id}/edit")
    public String editContract(@PathVariable Integer id, Model model) {
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("services", resortServiceService.findAll());
        model.addAttribute("contract", contractService.findById(id));
        return "contract/edit";
    }

    @PostMapping("update")
    public String updateContract(@Validated @ModelAttribute Contract contract, BindingResult bindingResult,
                                 Model model, RedirectAttributes redirect) {
        new Contract().validate(contract, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("employees", employeeService.findAll());
            model.addAttribute("customers", customerService.findAll());
            model.addAttribute("services", resortServiceService.findAll());
            return "contract/create";
        } else {
            contractService.save(contract);
            redirect.addFlashAttribute("message", "Updated contract successfully!");
            return "redirect:/contract";
        }
    }

    @GetMapping("{id}/delete")
    public String deleteContract(@PathVariable Integer id, RedirectAttributes redirect) {
        contractService.delete(id);
        redirect.addFlashAttribute("message", "Removed contract successfully!");
        return "redirect:/contract";
    }

    @GetMapping("{id}")
    public String viewContract(@PathVariable Integer id, Model model) {
        model.addAttribute("contract", contractService.findById(id));
        return "contract/list-detail";
    }

    @GetMapping("{id}/create-detail")
    public String addContractDetail(@PathVariable Integer id, Model model) {
        Contract contract = contractService.findById(id);
        ContractDetail contractDetail = new ContractDetail(contract);
        model.addAttribute("attachServices", attachServiceService.findAll());
        model.addAttribute("contractDetail", contractDetail);
        return "contract/create-detail";
    }

    @PostMapping("save-detail")
    public String saveContractDetail(@ModelAttribute ContractDetail contractDetail, RedirectAttributes redirect) {
        contractDetailService.save(contractDetail);
        redirect.addFlashAttribute("message", "Added attach service successfully!");
        return "redirect:/contract";
    }

}
