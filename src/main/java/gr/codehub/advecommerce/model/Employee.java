package gr.codehub.advecommerce.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private String department;
    private String speciality;

    @OneToMany(mappedBy = "employee")
    private List<Customer> customers;
}
