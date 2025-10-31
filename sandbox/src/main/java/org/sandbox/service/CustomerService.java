package org.sandbox.service;

import java.util.ArrayList;
import java.util.List;

import org.sandbox.model.Customer;
import org.springframework.stereotype.Service;


import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class CustomerService {

    public List<Customer> getAllCustomers() {
        List<Customer> entities = new ArrayList<>();
        entities.add(
            Customer.builder()
                .id(1)
                .name("abc")
                .emailAddress("abc@something.com")
                .build()
            );
        
        log.info("Get All Customers");

        return entities;
    }
}

