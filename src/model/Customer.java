package model;

import java.util.regex.Pattern;

public class Customer {

    private final String firstName;
    private final String lastName;
    private final String email;

    public Customer(String firstName, String lastName, String email){
        if(Pattern.compile("^(.+)@(.+).(.+)$").matcher(email).matches()){
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid Email Address");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmail(){
        return email;
    }

    @Override
    public String toString() {
        return "CustomerClass{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
