package gr.codehub.advecommerce.repository;

import gr.codehub.advecommerce.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository   {
    //CRUD operations
    Customer save(Customer customer);
    Optional<Customer> findById(int customerId);
    Optional<List<Customer>> findAll();
    Customer update(int customerId, Customer customer);
    boolean delete(int customerId);

}
