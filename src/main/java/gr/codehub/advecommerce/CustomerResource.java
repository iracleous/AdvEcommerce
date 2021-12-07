package gr.codehub.advecommerce;

import gr.codehub.advecommerce.dto.CustomerDto;
import gr.codehub.advecommerce.exception.CustomerException;
import gr.codehub.advecommerce.repository.CustomerRepository;
import gr.codehub.advecommerce.repository.impl.CustomerRepositoryImpl;
import gr.codehub.advecommerce.service.BusinessService;
import gr.codehub.advecommerce.service.impl.BusinessServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.List;

@Path("/")
public class CustomerResource {

private CustomerRepository customerRepository= new CustomerRepositoryImpl();
private BusinessService businessService = new BusinessServiceImpl(customerRepository);




    @Path("/ping")
    @GET
    @Produces("text/plain")
    public String hello() {
        return "It works!";
    }

    @GET
    @Path("/customer/{customerId}")
    @Produces("text/json")
    public CustomerDto getCustomer(@PathParam("customerId") int customerId){

        return businessService.getCustomerById(customerId);
    }



    @GET
    @Path("/customers")
    @Produces("text/json")
    public List<CustomerDto> getCustomer( ){
        return businessService.getCustomerList();
    }




    @Path("/customer")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("text/json")
    public CustomerDto addCustomer(@FormParam("fullName") String fullName,
                                   @FormParam("email") String email,
                                   @FormParam("dateOfBirth") String dateOfBirth) throws CustomerException {


        CustomerDto customerDto = new CustomerDto();
        customerDto.setFullName(fullName);
        customerDto.setEmail(email);
        customerDto.setDateOfBirth(LocalDate.parse(dateOfBirth));

        return businessService.createCustomer(customerDto);
    }







}


