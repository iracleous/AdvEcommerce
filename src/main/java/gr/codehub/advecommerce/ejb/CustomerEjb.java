package gr.codehub.advecommerce.ejb;


import gr.codehub.advecommerce.model.Customer;
import gr.codehub.advecommerce.model.Employee;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.*;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@Stateless
public class CustomerEjb {





    @PersistenceContext(unitName = "Persistence")
    private EntityManager entityManager;

//    @Resource
//    private UserTransaction userTransaction;


    public int doAction() throws Exception{
        //SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {

        int id =0;
        Employee employee = new Employee();
        employee.setDepartment("ddd3");
        employee.setName("gg3");


      //  userTransaction.begin();
        entityManager.persist(employee);
    //    userTransaction.commit();





        id = employee.getId();

        return id;

    }


}
