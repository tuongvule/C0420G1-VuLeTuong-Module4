package tuongvule.com.furamaspringboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tuongvule.com.furamaspringboot.model.RentType;

@Repository
public interface RentTypeRepository extends JpaRepository<RentType, Long> {
}
