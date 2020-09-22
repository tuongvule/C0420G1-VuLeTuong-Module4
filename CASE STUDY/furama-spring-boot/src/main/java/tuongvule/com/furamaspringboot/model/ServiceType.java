package tuongvule.com.furamaspringboot.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nameServiceType;

    @OneToMany(mappedBy = "serviceType")
    private List<Service> services;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNameServiceType() {
        return nameServiceType;
    }

    public void setNameServiceType(String nameServiceType) {
        this.nameServiceType = nameServiceType;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
