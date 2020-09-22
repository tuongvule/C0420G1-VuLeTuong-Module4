package tuongvule.com.furamaspringboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tuongvule.com.furamaspringboot.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * from customers where name like %:keyword% or address like %:keyword% or phone_number like %:keyword%",nativeQuery = true)
    Page<Customer> findCustomerByAll(@Param("keyword") String keyword, Pageable pageable);
//    Page<Customer> findAllByNameContaining (String name, Pageable pageable);
}
