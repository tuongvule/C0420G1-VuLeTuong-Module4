package tuongvule.com.furamaspringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tuongvule.com.furamaspringboot.model.Service;
import tuongvule.com.furamaspringboot.repository.ServiceRepository;
import tuongvule.com.furamaspringboot.service.ServiceService;


import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Page <Service> findAllService(String keyword, Pageable pageable) {
        return serviceRepository.findServiceByAll(keyword, pageable);
    }

    @Override
    public Service findById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(Long id) {
        serviceRepository.deleteById(id);
    }
}
