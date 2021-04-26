package com.furamavietnam.controllers;

import com.furamavietnam.models.RentType;
import com.furamavietnam.models.ResortService;
import com.furamavietnam.models.ServiceType;
import com.furamavietnam.services.service.RentTypeService;
import com.furamavietnam.services.service.ResortServiceService;
import com.furamavietnam.services.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@SessionAttributes("appUser")
@RequestMapping("service")
public class ServiceController {

    @Autowired
    private ResortServiceService resortServiceService;
    @Autowired
    private RentTypeService rentTypeService;
    @Autowired
    private ServiceTypeService serviceTypeService;

    @ModelAttribute("roomStandards")
    private List<String> getRoomStandards() {
        return new ArrayList<>(Arrays.asList("Vip", "Business", "Normal"));
    }

    @ModelAttribute("rentTypes")
    private List<RentType> getRentTypes() {
        return rentTypeService.findAll();
    }

    @ModelAttribute("serviceTypes")
    private List<ServiceType> getServiceTypes() {
        return serviceTypeService.findAll();
    }

    @GetMapping("")
    public String getServicePage(@PageableDefault(value = 4) Pageable pageable, Model model) {
        model.addAttribute("services", resortServiceService.findAll(pageable));
        return "service/list";
    }

    @GetMapping("create")
    public String addService(Model model) {
        model.addAttribute("service", new ResortService());
        return "service/create";
    }

    @PostMapping("save")
    public String saveService(@Validated @ModelAttribute(name = "service") ResortService service,
                              BindingResult bindingResult, RedirectAttributes redirect) {
        resortServiceService.validateExistingId(service, bindingResult);
        if (bindingResult.hasErrors()) {
            return "service/create";
        } else {
            resortServiceService.save(service);
            redirect.addFlashAttribute("message", "Added service successfully!");
            return "redirect:/service";
        }
    }

    @GetMapping("{id}/edit")
    public String editService(@PathVariable String id, Model model) {
        model.addAttribute("service", resortServiceService.findById(id));
        return "service/edit";
    }

    @PostMapping("update")
    public String updateService(@Validated @ModelAttribute(name = "service") ResortService service,
                                BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "service/edit";
        } else {
            resortServiceService.save(service);
            redirect.addFlashAttribute("message", "Updated service successfully!");
            return "redirect:/service";
        }
    }

    @GetMapping("{id}/delete")
    public String deleteService(@PathVariable String id, RedirectAttributes redirect) {
        resortServiceService.delete(id);
        redirect.addFlashAttribute("message", "Removed service successfully!");
        return "redirect:/service";
    }

    @GetMapping("{id}")
    public String viewService(@PathVariable String id, Model model) {
        model.addAttribute("service", resortServiceService.findById(id));
        return "service/view";
    }

}
