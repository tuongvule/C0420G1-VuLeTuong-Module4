package tuongvule.com.furamaspringboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tuongvule.com.furamaspringboot.model.Service;


public interface ServiceService {
    Page<Service> findAllService(String keyword, Pageable pageable);
    Service findById(Long id);
    void save(Service service);
    void remove(Long id);
}
