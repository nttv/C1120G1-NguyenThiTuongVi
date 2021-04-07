package com.example.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "First name must not be empty. ")
    @Size(min = 5, max = 45, message = "Length must be between 5 and 45 characters. ")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty. ")
    @Size(min = 5, max = 45, message = "Length must be between 5 and 45 characters. ")
    private String lastName;

    @Pattern(regexp = "^0[0-9]{9}$", message = "Phone number must be number, start with 0, and have length of 10. ")
    private String phoneNumber;

    @Min(value = 18, message = "Age must be equal or greater than 18. ")
    private Integer age;

    @Pattern(regexp = "^[A-Za-z0-9]+(([_.])?[A-Za-z0-9]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+){1,3}$",
            message = "Email is not in correct format. ")
    private String email;

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
