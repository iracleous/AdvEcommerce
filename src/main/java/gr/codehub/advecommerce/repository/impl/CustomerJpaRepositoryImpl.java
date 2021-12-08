package gr.codehub.advecommerce.repository.impl;

import gr.codehub.advecommerce.model.Customer;

import javax.persistence.EntityManager;

public class CustomerJpaRepositoryImpl extends RepositoryImpl<Customer, Integer>{

    public CustomerJpaRepositoryImpl(EntityManager entityManager){
        super(entityManager);
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }

    @Override
    public String getEntityClassName() {
        return Customer.class.getName();
    }
}
