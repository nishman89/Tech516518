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

    /**
     * Retrieves a customer by their ID.
     *
     * @param id the ID of the customer
     * @return the customer if found, or null if not found
     */
    public Customer getCustomerByID(String id) {

            return customerRepository.findById(id) //findById to return an emptpty optional (Optional<Customer>) Customer = null
                    .orElseThrow(() -> new NoSuchElementException("Customer not found"));

    }
        /**
         * Saves a new customer or updates an existing customer in the database.
         *
         * @param customer the customer to save
         * @return the saved customer
         */
        public Customer saveCustomer(Customer customer) {
            if(customer == null){
                throw new IllegalArgumentException("Customer cannot be null");
            }
            return customerRepository.save(customer);
        }

    public boolean deleteCustomer(String id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Customer updateCustomer(Customer customer) {
        if (customerRepository.existsById(customer.getCustomerID())) {

            return customerRepository.save(customer);
        } else {
            throw new IllegalArgumentException("Customer with ID " + customer.getCustomerID() + " does not exist.");
        }
    }

}