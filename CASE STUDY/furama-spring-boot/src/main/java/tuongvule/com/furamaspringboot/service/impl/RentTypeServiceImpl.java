package tuongvule.com.furamaspringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuongvule.com.furamaspringboot.model.RentType;
import tuongvule.com.furamaspringboot.repository.RentTypeRepository;
import tuongvule.com.furamaspringboot.service.RentTypeService;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    RentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> findAllRentType() {
        return rentTypeRepository.findAll();
    }
}
