package tuongvule.com.furamaspringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tuongvule.com.furamaspringboot.model.Customer;
import tuongvule.com.furamaspringboot.repository.CustomerRepository;
import tuongvule.com.furamaspringboot.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Page<Customer> findAll(String keyword, Pageable pageable) {
        return customerRepository.findCustomerByAll(keyword, pageable);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}
