package tuongvule.com.furamaspringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuongvule.com.furamaspringboot.model.CustomerType;
import tuongvule.com.furamaspringboot.repository.CustomerRepository;
import tuongvule.com.furamaspringboot.repository.CustomerTypeRepository;
import tuongvule.com.furamaspringboot.service.CustomerTypeService;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    CustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerTypeRepository.findAll();
    }
}
