package tuongvule.com.furamaspringboot.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuongvule.com.furamaspringboot.model.ServiceType;
import tuongvule.com.furamaspringboot.repository.ServiceTypeRepository;
import tuongvule.com.furamaspringboot.service.ServiceTypeService;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    ServiceTypeRepository serviceTypeRepository;
    @Override
    public List<ServiceType> findAllServiceType() {
        return serviceTypeRepository.findAll();
    }
}
