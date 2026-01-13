package com.sparta.northwindapi.controllers;

import com.sparta.northwindapi.dtos.CustomerDTO;
import com.sparta.northwindapi.entities.Customer;
import com.sparta.northwindapi.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;
    public CustomerController(CustomerService service){
        this.service = service;
    }
    @Operation(summary = "Get all customers", description = "Retrieve list of all customers")
    @GetMapping( "/")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        List<CustomerDTO> customers = service.getAllCustomers();
        return  ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a customer by ID", description = "Retrieve a customer from the database using their unique ID")
    public ResponseEntity<Customer> getCustomerById(@PathVariable  String id){

        try{
            Customer customer = service.getCustomerByID(id);
            return ResponseEntity.ok(customer);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/")
    @Operation(summary = "Add a new customer", description = "Create a new customer in the database")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer savedCustomer = service.saveCustomer(customer);
        return ResponseEntity.status(201).body(savedCustomer);
    }

    @Operation(summary = "Update a customer", description = "Modify an existing customer's details in the database")
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
        customer.setCustomerID(id);
        try {
            Customer updatedCustomer = service.updateCustomer(customer);
            return ResponseEntity.ok(updatedCustomer);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete a customer", description = "Remove a customer from the database using their unique ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {
        boolean deleted = service.deleteCustomer(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
