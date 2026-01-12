package com.sparta.northwindapi.controllers;

import com.sparta.northwindapi.entities.Customer;
import com.sparta.northwindapi.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;
    public CustomerController(CustomerService service){
        this.service = service;
    }
    @Operation(summary = "Get all customers", description = "Retrieve list of all customers")
    @GetMapping( "/")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = service.getAllCustomers();
        return  ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a customer by ID", description = "Retrieve a customer from the database using their unique ID")
    public ResponseEntity<Customer> getCustomerById(@PathVariable  String id){

        Customer customer = service.getCustomerByID(id);
        if(customer != null){
            return ResponseEntity.ok(customer);
        } else{
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/")
    @Operation(summary = "Add a new customer", description = "Create a new customer in the database")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer savedCustomer = service.saveCustomer(customer);
        return ResponseEntity.status(201).body(savedCustomer);
    }

}
