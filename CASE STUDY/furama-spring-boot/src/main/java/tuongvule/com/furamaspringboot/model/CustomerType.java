package tuongvule.com.furamaspringboot.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="customer_types")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameCustomerType;

    @OneToMany
    List<Customer> customers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCustomerType() {
        return nameCustomerType;
    }

    public void setNameCustomerType(String nameCustomerType) {
        this.nameCustomerType = nameCustomerType;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
