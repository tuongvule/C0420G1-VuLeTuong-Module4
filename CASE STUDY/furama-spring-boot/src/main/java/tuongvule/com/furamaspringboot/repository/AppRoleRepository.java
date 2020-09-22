package tuongvule.com.furamaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tuongvule.com.furamaspringboot.entity.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName (String role_name);
}
