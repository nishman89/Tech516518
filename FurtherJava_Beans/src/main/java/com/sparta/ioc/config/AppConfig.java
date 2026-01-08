package com.sparta.ioc.config;

import com.sparta.ioc.Person;
import com.sparta.ioc.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // Marks AppConfig as a rouce of bean definitions - Spring will look inside AppConfig for any methods that reutrn beans
@ComponentScan(basePackages = "com.sparta.ioc.beans") // for additional beans in the beans pacakge
public class AppConfig {
    @Bean
    public Vehicle audiA3(){
        return new Vehicle("Audi", "A3");
    }

    @Bean
    public Vehicle fordFiesta(){
        return new Vehicle("Ford", "Fiesta");
    }

    @Bean
    public Person janeDoe(){
        Person person = new Person();
        person.setFirstName("Jane");
        person.setLastName("Doe");
        return person;
    }

//    @Bean
//    public Person johnDoe(){
//        Person person = new Person();
//        person.setFirstName("John");
//        person.setLastName("Doe");
//        return person;
//    }
}
