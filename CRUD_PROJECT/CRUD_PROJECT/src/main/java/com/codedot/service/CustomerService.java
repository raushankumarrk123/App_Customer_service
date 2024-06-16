package com.codedot.service;

import com.codedot.entity.Customer;
import com.codedot.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    public Customer postCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteAllById(Collections.singleton(id));
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElse(null);
    }
    public Customer updateCustomer(Long id,Customer customer){
        Optional<Customer> optionalCustomer=customerRepository.findById(id);

        if(optionalCustomer.isPresent()){
            Customer existingCustomer=optionalCustomer.get();
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setName(customer.getName());
            existingCustomer.setPhone(customer.getPhone());
            return customerRepository.save(existingCustomer);
        }
        return  null;
    }
}

