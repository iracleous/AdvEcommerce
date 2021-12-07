package gr.codehub.advecommerce.service.impl;

import gr.codehub.advecommerce.dto.CustomerDto;
import gr.codehub.advecommerce.exception.CustomerException;
import gr.codehub.advecommerce.model.Customer;
import gr.codehub.advecommerce.repository.CustomerRepository;
import gr.codehub.advecommerce.service.BusinessService;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BusinessServiceImpl implements BusinessService {
    private CustomerRepository customerRepository;


    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) throws CustomerException {
        if (customerDto == null   )
            throw new CustomerException("No customer data were given");
        if (customerDto.getEmail()== null || customerDto.getEmail().trim().equals(""))
            throw new CustomerException("No email was given");
        if (customerDto.getEmail().contains("@gmail.com"))
            throw new CustomerException("No gmail customers allowed");

       Customer customer =  customerRepository.save(customerDto.obtainCustomer());
        return new CustomerDto(customer);
    }

    @Override
    public List<CustomerDto> getCustomerList() {

       List<Customer> customers =  customerRepository.findAll().orElse( new ArrayList<>());
       return customers.stream().map(CustomerDto::new).collect(Collectors.toList());

    }

    @Override
    public CustomerDto getCustomerById(int customerId) {


        return new CustomerDto( customerRepository.findById(customerId).orElse( new Customer()) );
    }
}
