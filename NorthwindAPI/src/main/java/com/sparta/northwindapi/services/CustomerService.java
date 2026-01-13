package com.sparta.northwindapi.services;

import com.sparta.northwindapi.dtos.CustomerDTO;
import com.sparta.northwindapi.dtos.CustomerMapper;
import com.sparta.northwindapi.entities.Customer;
import com.sparta.northwindapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    /**
     * Constructor-based dependency injection for CustomerRepository.
     *
     * @param customerRepository the repository for Customer entities
     */

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        if(customerRepository == null || customerMapper == null){
            throw new IllegalArgumentException("Repository and Mapper cannot be null");
        }
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }



    /**
     * Retrieves all customers from the database.
     *
     * @return a list of all customers
     */
    public List<CustomerDTO> getAllCustomers() {
//        ArrayList<CustomerDTO> customerDtos = new ArrayList<>();
//        List<Customer> customers = customerRepository.findAll();
//
//        for(Customer customer :  customers){
//            CustomerDTO customerDto = customerMapper.toDTO(customer);
//            customerDtos.add(customerDto);
//        }
//        return customerDtos;

        return customerRepository.findAll().stream().map(customerMapper::toDTO).toList();
    }

    public CustomerDTO getCustomerById(String id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
        return customerMapper.toDTO(customer);
    }

    // Controller passes DTO; service maps + persists
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer entity = customerMapper.toEntity(customerDTO);
        Customer saved = customerRepository.save(entity);
        return customerMapper.toDTO(saved);
    }

    public boolean deleteCustomer(String id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        String id = customerDTO.getCustomerID();
        if (!customerRepository.existsById(id)) {
            throw new NoSuchElementException("Customer with ID " + id + " does not exist.");
        }
        Customer entity = customerMapper.toEntity(customerDTO);
        Customer saved = customerRepository.save(entity);
        return customerMapper.toDTO(saved);
    }

}