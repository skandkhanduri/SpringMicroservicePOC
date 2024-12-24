package com.secor.customerservice.service;

import com.secor.customerservice.entity.Customer;
import com.secor.customerservice.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServices {
    CustomerRepository customerRepository;
    CustomerServices(CustomerRepository customerRepository)
    {
     this.customerRepository=customerRepository;
    }
    public List<Customer> getAllCustomer()

    {

        return customerRepository.findAll();
    }

    public Optional <Customer> getCustomerById(Long id)

    {
        Optional<Customer> customer=customerRepository.findById(id);
        if (customer.isPresent())
        {
            return customer;
        }
        else {
            throw new EntityNotFoundException("Customer with id " + id + " not found");
        }
    }

    public Customer createCustomer(Customer customer)
    {
        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());
        Customer savedCustomer= customerRepository.save(customer);
       return savedCustomer;
    }
    public Customer updateCustomer(Customer customerDetails)
    {
        Optional<Customer> optionalProduct=customerRepository.findById(customerDetails.getCustomerId());
        if (optionalProduct.isPresent())
        {
            customerDetails.setCreatedAt(optionalProduct.get().getCreatedAt());
            customerDetails.setUpdatedAt(LocalDateTime.now());
            return customerRepository.save(customerDetails);
        }
        else {
            throw new EntityNotFoundException("Product with id " + customerDetails.getCustomerId() + " not found");
        }
    }
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
