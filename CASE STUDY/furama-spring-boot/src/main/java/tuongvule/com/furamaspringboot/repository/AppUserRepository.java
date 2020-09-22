package tuongvule.com.furamaspringboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tuongvule.com.furamaspringboot.entity.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String userName);
}
