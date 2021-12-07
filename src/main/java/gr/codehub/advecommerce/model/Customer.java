package gr.codehub.advecommerce.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Customer {
    private int id;
    private String name;
    private String email;
    private String password;
    private LocalDate dateOfBirth;


}
