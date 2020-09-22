package tuongvule.com.furamaspringboot.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "(DV-)[0-9]{4}", message = "serviceCode must follow this pattern: <DV-XXXX> (X: 0-9)")
    private String serviceCode;
    private String nameService;

    @Pattern(regexp = "^[1-9][0-9]*$", message = "number must be >0")
    private String area;

    @Pattern(regexp = "^[1-9][0-9]*$", message = "number must be >0")
    private String floor;

    @Pattern(regexp = "^[1-9][0-9]*$", message = "number must be >0")
    private String numberOfPeople;

    @Pattern(regexp = "^[1-9][0-9]*$", message = "number must be >0")
    private String cost;
    private String status;

    @ManyToOne
    @JoinColumn(name="id_rent_type")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "id_service_type")
    private ServiceType serviceType;

    @OneToMany
    List<Contract> contracts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(String numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
