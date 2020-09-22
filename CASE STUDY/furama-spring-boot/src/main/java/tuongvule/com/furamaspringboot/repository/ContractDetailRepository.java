package tuongvule.com.furamaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tuongvule.com.furamaspringboot.model.ContractDetail;

@Repository
public interface ContractDetailRepository extends JpaRepository<ContractDetail, Long> {
}
