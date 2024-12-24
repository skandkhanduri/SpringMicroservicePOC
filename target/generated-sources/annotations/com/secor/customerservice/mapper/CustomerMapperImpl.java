package com.secor.customerservice.mapper;

import com.secor.customerservice.dto.CustomerDto;
import com.secor.customerservice.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-21T13:45:52+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto toDTO(Customer entity) {
        if ( entity == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerId( entity.getCustomerId() );
        customerDto.setFirstName( entity.getFirstName() );
        customerDto.setLastName( entity.getLastName() );
        customerDto.setEmail( entity.getEmail() );
        customerDto.setPhoneNumber( entity.getPhoneNumber() );
        customerDto.setAddress( entity.getAddress() );
        customerDto.setCreatedAt( entity.getCreatedAt() );
        customerDto.setUpdatedAt( entity.getUpdatedAt() );

        return customerDto;
    }

    @Override
    public List<CustomerDto> toDTOList(List<Customer> entity) {
        if ( entity == null ) {
            return null;
        }

        List<CustomerDto> list = new ArrayList<CustomerDto>( entity.size() );
        for ( Customer customer : entity ) {
            list.add( toDTO( customer ) );
        }

        return list;
    }

    @Override
    public Customer toEntity(CustomerDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setCustomerId( productDto.getCustomerId() );
        customer.setFirstName( productDto.getFirstName() );
        customer.setLastName( productDto.getLastName() );
        customer.setEmail( productDto.getEmail() );
        customer.setPhoneNumber( productDto.getPhoneNumber() );
        customer.setAddress( productDto.getAddress() );
        customer.setCreatedAt( productDto.getCreatedAt() );
        customer.setUpdatedAt( productDto.getUpdatedAt() );

        return customer;
    }
}
