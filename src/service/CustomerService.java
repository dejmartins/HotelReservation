package service;

import model.Customer;
import repositories.CustomerRepository;

import java.util.Collection;

public class CustomerService {

    private static final CustomerService CUSTOMER_SERVICE = new CustomerService();
    private final CustomerRepository customerRepository = CustomerRepository.getCustomerRepository();

    private CustomerService(){
    }

    public void addCustomer(String email, String firstName, String lastName){
        Customer customer = new Customer(firstName, lastName, email);
        customerRepository.createCustomer(email, customer);
    }

    public Customer getCustomer(String customerEmail){
        return customerRepository.retrieveCustomer(customerEmail);
    }

    public Collection<Customer> getAllCustomers(){
        return customerRepository.retrieveAllCustomers();
    }

    public void deleteCustomerAccount(String email){
        customerRepository.deleteCustomer(email);
    }
    public static CustomerService getCustomerService(){
        return CUSTOMER_SERVICE;
    }
}
