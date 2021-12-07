package gr.codehub.advecommerce;

import gr.codehub.advecommerce.dto.CustomerDto;
import gr.codehub.advecommerce.exception.CustomerException;
import gr.codehub.advecommerce.model.Customer;
import gr.codehub.advecommerce.repository.CustomerRepository;
import gr.codehub.advecommerce.repository.impl.CustomerRepositoryImpl;
import gr.codehub.advecommerce.service.BusinessService;
import gr.codehub.advecommerce.service.impl.BusinessServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/")
public class HelloResource {

private CustomerRepository customerRepository= new CustomerRepositoryImpl();
private BusinessService businessService = new BusinessServiceImpl(customerRepository);




    @Path("/ping")
    @GET
    @Produces("text/plain")
    public String hello() {
        return "It works!";
    }

    @GET
    @Path("/customer")
    @Produces("text/json")
    public CustomerDto getCustomer(){
        int customerId = 7;
        return businessService.getCustomerById(customerId);
    }

}


