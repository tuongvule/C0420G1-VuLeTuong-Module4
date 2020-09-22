package tuongvule.com.furamaspringboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tuongvule.com.furamaspringboot.model.Customer;
import tuongvule.com.furamaspringboot.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    @Query(value = "select * from services where name_service like %:keyword% or service_code like %:keyword% or floor like %:keyword%",nativeQuery = true)
    Page<Service> findServiceByAll(@Param("keyword") String keyword, Pageable pageable);
}
