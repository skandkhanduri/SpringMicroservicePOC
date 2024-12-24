package com.secor.customerservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.secor.customerservice.dto.CustomerDto;
import com.secor.customerservice.entity.Customer;
import com.secor.customerservice.service.CustomerServices;
import com.secor.customerservice.mapper.CustomerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer/v1")
public class CustomerController {


    private CustomerServices customerServices;
    CustomerController(CustomerServices customerServices)
    {
        this.customerServices=customerServices;
    }
    @GetMapping("/all")
    public ResponseEntity<Object> getAllCustomers()
    {
  List<Customer> customer=customerServices.getAllCustomer();
        List<CustomerDto> responseDto= CustomerMapper.INSTANCE.toDTOList(customer);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/getCustomer")
    public ResponseEntity<Object> getCustomerByID(@RequestParam("customerId") Long customerId
                                             ) throws JsonProcessingException {
      Customer customer=  customerServices.getCustomerById(customerId).get();
      CustomerDto responseDto= CustomerMapper.INSTANCE.toDTO(customer);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PostMapping("/createCustomer")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerServices.createCustomer(customer);
        CustomerDto responseDto= CustomerMapper.INSTANCE.toDTO(createdCustomer);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<Object> updateCustomer( @RequestBody Customer customer) {
        Customer updatedPayment = customerServices.updateCustomer(customer);
        CustomerDto responseDto= CustomerMapper.INSTANCE.toDTO(updatedPayment);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCustomer")
    public ResponseEntity<Void> deletePayment(@RequestParam("customerId") Long customerId) {
        customerServices.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }

}
