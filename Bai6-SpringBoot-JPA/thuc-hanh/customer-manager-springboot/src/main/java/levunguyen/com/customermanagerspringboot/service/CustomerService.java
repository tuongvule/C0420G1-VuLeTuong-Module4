package levunguyen.com.customermanagerspringboot.service;



import levunguyen.com.customermanagerspringboot.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    Customer findById(Long id);
    void remove(Long id);
}
