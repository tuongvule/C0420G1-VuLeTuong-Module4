package levunguyen.com.customermanagerspringboot.repository;

import levunguyen.com.customermanagerspringboot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
