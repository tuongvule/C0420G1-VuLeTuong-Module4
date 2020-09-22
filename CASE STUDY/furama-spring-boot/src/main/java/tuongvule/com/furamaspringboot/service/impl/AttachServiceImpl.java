package tuongvule.com.furamaspringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuongvule.com.furamaspringboot.model.AttachService;
import tuongvule.com.furamaspringboot.repository.AttachServiceRepository;
import tuongvule.com.furamaspringboot.service.AttachServiceService;

import java.util.List;

@Service
public class AttachServiceImpl implements AttachServiceService {
    @Autowired
    AttachServiceRepository attachServiceRepository;
    @Override
    public List<AttachService> findAllAttachService() {
        return attachServiceRepository.findAll();
    }
}
