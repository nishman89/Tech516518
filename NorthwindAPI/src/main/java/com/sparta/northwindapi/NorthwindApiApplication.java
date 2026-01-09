package com.sparta.northwindapi;

import com.sparta.northwindapi.models.entities.Customer;
import com.sparta.northwindapi.repository.CustomerRepository;
import com.sparta.northwindapi.services.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class NorthwindApiApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(NorthwindApiApplication.class,args);
//        CustomerRepository customerRepository = context.getBean(CustomerRepository.class);
//        List<Customer> customers = customerRepository.findAll();
//        for(Customer customer : customers){
//            System.out.println(customer);
//        }
        CustomerService customerService = context.getBean(CustomerService.class);

        Customer newCustomer = new Customer();
        newCustomer.setCustomerID("MANDA");
        newCustomer.setCity("Birmingham");
        newCustomer.setCompanyName("Sparta Global");
        newCustomer.setContactName("Nish Mandal");
        customerService.saveCustomer(newCustomer);
        System.out.println(customerService.getCustomerByID("MANDA"));
//        List<Customer> customers = customerService.getAllCustomers();
//        for(Customer customer : customers){
//            System.out.println(customer);
//        }



    }

}
