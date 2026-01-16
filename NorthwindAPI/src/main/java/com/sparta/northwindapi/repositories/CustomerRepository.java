package com.sparta.northwindapi.repositories;

import com.sparta.northwindapi.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(exported = false)
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
