package gr.codehub.advecommerce.testing;

import gr.codehub.advecommerce.jpautil.JpaUtil;
import gr.codehub.advecommerce.model.Customer;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class TestingMain {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        Customer customer = new Customer();
        customer.setName("George");
        customer.setDateOfBirth(LocalDate.of(2000,1,1));


        System.out.println("Id = "+customer.getId());
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
        System.out.println("Id = "+customer.getId());

        //////////////////////////////////////

        Customer customerFromDb = em.find(Customer.class, 1);
        System.out.println(customerFromDb);




        em.close();
        JpaUtil.shutdown();
        System.out.println("end");

    }
}
