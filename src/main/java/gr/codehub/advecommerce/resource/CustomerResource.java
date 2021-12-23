package gr.codehub.advecommerce.resource;

import gr.codehub.advecommerce.dto.CustomerDto;
import gr.codehub.advecommerce.ejb.CustomerEjb;
import gr.codehub.advecommerce.exception.CustomerException;
import gr.codehub.advecommerce.model.Employee;
import gr.codehub.advecommerce.repository.CustomerRepository;
import gr.codehub.advecommerce.repository.impl.CustomerRepositoryImpl;
import gr.codehub.advecommerce.service.BusinessService;
import gr.codehub.advecommerce.service.impl.BusinessServiceImpl;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;
import javax.transaction.NotSupportedException;
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
    @Path("/customer")
    @Produces("text/json")
    public List<CustomerDto> getCustomer( ){
        return businessService.getCustomerList();
    }

    @Path("/customerhtml")
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

    @POST
    @Path("/customer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/json")
    public CustomerDto addCustomer(CustomerDto customerDto) throws CustomerException {
        return businessService.createCustomer(customerDto);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/json")
    @Path("/customer")
    public CustomerDto updateCustomer(  CustomerDto customerDto) throws CustomerException {
        return businessService.updateCustomer(customerDto.getCustomerId(),customerDto);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/json")
    @Path("/customer/{customerId}")
    public boolean deleteCustomer( @PathParam("customerId") int customerId) throws CustomerException {

        return businessService.deleteCustomer(customerId);
    }


    @EJB
    private CustomerEjb ejb;



    @GET
    @Path("test")
    public int createCust(){
        int x= 0;

        try {
            x=ejb.doAction();
        } catch (Exception e) {
            e.printStackTrace();
        }
        x++;
        return x;
}


//    @PersistenceContext(unitName = "Persistence")
//    private EntityManager entityManager;
//
//    @Resource
//    private UserTransaction userTransaction;
//
//
//    public int doAction() throws Exception{
//            //SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
//
//        int id =0;
//        Employee employee = new Employee();
//        employee.setDepartment("ddd3");
//        employee.setName("gg3");
//
//
//        userTransaction.begin();
//        entityManager.persist(employee);
//        userTransaction.commit();
//
//
//
//
//
//        id = employee.getId();
//
//        return id;
//
//    }



}


