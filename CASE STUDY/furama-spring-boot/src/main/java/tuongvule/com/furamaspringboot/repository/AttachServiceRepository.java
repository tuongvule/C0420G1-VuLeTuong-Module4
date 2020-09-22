package tuongvule.com.furamaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tuongvule.com.furamaspringboot.model.AttachService;

@Repository
public interface AttachServiceRepository extends JpaRepository<AttachService, Long> {
}
