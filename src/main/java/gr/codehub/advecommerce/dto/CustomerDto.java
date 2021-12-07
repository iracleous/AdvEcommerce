package gr.codehub.advecommerce.dto;

import gr.codehub.advecommerce.model.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CustomerDto {

    private int customerId;
    private String fullName;
    private String email;
    private LocalDate dateOfBirth;


    public CustomerDto(Customer customer){
        customerId = customer.getId();
        fullName = customer.getName();
        email = customer.getEmail();
        dateOfBirth = customer.getDateOfBirth();
    }

    public Customer getCustomer(){
        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setName(fullName);
        customer.setEmail(email);
        customer.setDateOfBirth(dateOfBirth);
        return customer;
    }

}
