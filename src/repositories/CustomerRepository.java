package repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import model.Customer;

public class CustomerRepository {

  private final Map<String, Customer> customers = new HashMap<>();

  private static final CustomerRepository CUSTOMER_REPOSITORY = new CustomerRepository();

  private CustomerRepository() {}

  public void createCustomer(String email, Customer customer) {
    customers.put(email, customer);
  }

  public Customer retrieveCustomer(String email) {
    return customers.get(email);
  }

  public Collection<Customer> retrieveAllCustomers() {
    return new ArrayList<>(customers.values());
  }

  public void deleteCustomer(String email) {
    customers.remove(email);
  }

  public static CustomerRepository getCustomerRepository() {
    return CUSTOMER_REPOSITORY;
  }
}
