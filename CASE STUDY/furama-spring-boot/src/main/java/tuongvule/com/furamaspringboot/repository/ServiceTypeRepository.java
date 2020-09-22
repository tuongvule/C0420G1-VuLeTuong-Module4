package tuongvule.com.furamaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tuongvule.com.furamaspringboot.model.ServiceType;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {
}
