package com.sparta.northwindapi.web;

import com.sparta.northwindapi.dtos.CustomerDTO;
import com.sparta.northwindapi.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerWebController {

    private final CustomerService customerService;

    public CustomerWebController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // GET /customers
    @GetMapping
    public String list(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers/index";
    }

    // GET /customers/{id}
    @GetMapping("/{id}")
    public String detail(@PathVariable String id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customers/detail";
    }

    // GET /customers/new
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("customer", new CustomerDTO());
        return "customers/form";
    }

    // POST /customers
    @PostMapping
    public String create(@Valid @ModelAttribute("customer") CustomerDTO dto,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customers/form";
        }
        customerService.saveCustomer(dto);
        return "redirect:/customers";
    }

    // GET /customers/{id}/edit
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable String id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customers/form";
    }

    // POST /customers/{id}
    @PostMapping("/{id}")
    public String update(@PathVariable String id,
                         @Valid @ModelAttribute("customer") CustomerDTO dto,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customers/form";
        }
        dto.setCustomerID(id); // ensure ID is set
        customerService.updateCustomer(dto);
        return "redirect:/customers/" + id;
    }

    // POST /customers/{id}/delete
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }
}
