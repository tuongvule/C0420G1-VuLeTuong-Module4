package tuongvule.com.furamaspringboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tuongvule.com.furamaspringboot.model.Customer;

public interface CustomerService {
    Page<Customer> findAll(String name, Pageable pageable);
    Customer findById(Long id);
    void save(Customer customer);
    void remove(Long id);

}
