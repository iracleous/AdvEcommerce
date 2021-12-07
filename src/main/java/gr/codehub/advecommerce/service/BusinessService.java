package gr.codehub.advecommerce.service;

import gr.codehub.advecommerce.dto.CustomerDto;
import gr.codehub.advecommerce.exception.CustomerException;

import java.util.List;

public interface BusinessService {

    CustomerDto createCustomer (CustomerDto customerDto) throws CustomerException;

    List<CustomerDto> getCustomerList();

    CustomerDto getCustomerById(int customerId);



}
