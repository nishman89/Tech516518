package com.sparta.northwindapi.controllers;

import com.sparta.northwindapi.entities.Customer;
import com.sparta.northwindapi.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;
    public CustomerController(CustomerService service){
        this.service = service;
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = service.getAllCustomers();
        var response =  ResponseEntity.ok(customers);
        return response;
    }
}
