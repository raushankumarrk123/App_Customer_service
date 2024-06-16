package com.codedot.controller;

import com.codedot.entity.Customer;
import com.codedot.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CustomerController {


    private final CustomerService customerService;

    @PostMapping("/customer")

    public Customer postCustomer(@RequestBody Customer customer){

        return customerService.postCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){

        return customerService.getAllCustomers();
    }

    @DeleteMapping("customer/{id}")
    public void deleteCustomer(@PathVariable Long id ){
        customerService.deleteCustomer(id);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
       Customer customer= customerService.getCustomerById(id);
       if(customer==null) return ResponseEntity.notFound().build();
       return ResponseEntity.ok(customer);
    }

    @PutMapping("customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        Customer updatedCustomer= customerService.updateCustomer(id,customer);
        if(updatedCustomer ==null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(updatedCustomer);
    }

}
