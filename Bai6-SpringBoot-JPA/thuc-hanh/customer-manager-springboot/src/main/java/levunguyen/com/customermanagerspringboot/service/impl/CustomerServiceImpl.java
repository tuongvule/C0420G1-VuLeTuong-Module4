package levunguyen.com.customermanagerspringboot.service.impl;

import levunguyen.com.customermanagerspringboot.model.Customer;
import levunguyen.com.customermanagerspringboot.repository.CustomerRepository;
import levunguyen.com.customermanagerspringboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
       customerRepository.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }


    @Override
    public void remove(Long id) {
       customerRepository.deleteById(id);
    }
}
