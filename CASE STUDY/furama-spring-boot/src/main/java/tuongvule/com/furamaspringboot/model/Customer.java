package tuongvule.com.furamaspringboot.model;


import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import tuongvule.com.furamaspringboot.validation.PhoneNumber;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;


@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_code", columnDefinition = "VARCHAR",length = 50)

    @Pattern(regexp = "(KH)-[0-9]{4}", message = "Not match with pattern <KH-XXXX> (with X: number between 0-9.")
    private String customerCode;

    private String name;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private String birthday;

    @Pattern(regexp = "[0-9]{9}||[0-9]{12}",message = "IdCard must have 9 or 12 number.")
    private String idCard;

    @PhoneNumber
    private String phoneNumber;

    @Pattern(regexp = "^[a-zA-Z0-9]+(@)[a-zA-Z0-9]+(.)[a-zA-Z0-9]+$", message = "Email must be follow pattern: abc@abc.com")
    private String email;

    private String address;

    @ManyToOne
    @JoinColumn(name="id_customer_type")
    private CustomerType customerType;

    @OneToMany
    List<Contract> contracts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
