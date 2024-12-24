package com.secor.customerservice.mapper;

import com.secor.customerservice.dto.CustomerDto;
import com.secor.customerservice.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerDto toDTO(Customer entity);
    List<CustomerDto> toDTOList(List<Customer> entity);
    Customer toEntity(CustomerDto productDto);
}
