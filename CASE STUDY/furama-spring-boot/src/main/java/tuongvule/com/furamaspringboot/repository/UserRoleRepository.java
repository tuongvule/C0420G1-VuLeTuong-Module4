package tuongvule.com.furamaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tuongvule.com.furamaspringboot.entity.AppUser;
import tuongvule.com.furamaspringboot.entity.UserRole;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
