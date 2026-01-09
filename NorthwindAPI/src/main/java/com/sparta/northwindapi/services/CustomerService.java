package com.sparta.northwindapi.services;

import com.sparta.northwindapi.models.entities.Customer;
import com.sparta.northwindapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    /**
     * Constructor-based dependency injection for CustomerRepository.
     *
     * @param customerRepository the repository for Customer entities
     */

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    /**
     * Retrieves all customers from the database.
     *
     * @return a list of all customers
     */
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    /**
     * Retrieves a customer by their ID.
     *
     * @param id the ID of the customer
     * @return the customer if found, or null if not found
     */
    public Customer getCustomerByID(String id) {
        if (id.length() > 5) {
            throw new IllegalArgumentException("Can't have ID longer than 5 characters");
        } else {
            return customerRepository.findById(id).orElse(null);
        }

        // Optional<Customer>
    }
        /**
         * Saves a new customer or updates an existing customer in the database.
         *
         * @param customer the customer to save
         * @return the saved customer
         */
        public Customer saveCustomer(Customer customer) {
            return customerRepository.save(customer);
        }

}