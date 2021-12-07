package gr.codehub.advecommerce.repository.impl;

import gr.codehub.advecommerce.model.Customer;
import gr.codehub.advecommerce.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//just for testing of th development
public class CustomerRepositoryImpl implements CustomerRepository {

    private static final List<Customer> customers = new ArrayList<>();
    private static int customerCounter ;

    @Override
    public Customer save(Customer customer) {
        customerCounter++;
        customer.setId(customerCounter);
        customers.add(customer);
          return customer;
    }

    @Override
    public Optional<Customer> findById(int customerId) {
         for (Customer customer:customers)
            if (customer.getId()==customerId)
                return   Optional.of(customer);
        return Optional.empty();
    }

    @Override
    public Optional<List<Customer>> findAll() {
        return Optional.of(customers);
    }

    @Override
    public Customer update(int customerId, Customer customer) {
        return null;
    }

    @Override
    public boolean delete(int customerId) {
        return false;
    }
}
