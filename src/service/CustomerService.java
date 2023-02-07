package service;

import model.Customer;

import java.util.Collection;

public class CustomerService {

    private static final CustomerService CUSTOMER_SERVICE = new CustomerService();

    private CustomerService(){
    }

    public void addCustomer(String email, String firstName, String lastName){

    }

    public Customer getCustomer(String customerEmail){
        return null;
    }

    public Collection<Customer> getAllCustomers(){
        return null;
    }

    public static CustomerService getCustomerService(){
        return CUSTOMER_SERVICE;
    }
}
