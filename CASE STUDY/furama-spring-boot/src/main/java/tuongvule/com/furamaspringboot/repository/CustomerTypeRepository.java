package tuongvule.com.furamaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tuongvule.com.furamaspringboot.model.CustomerType;

@Repository
public interface CustomerTypeRepository extends JpaRepository<CustomerType, Long> {
}
