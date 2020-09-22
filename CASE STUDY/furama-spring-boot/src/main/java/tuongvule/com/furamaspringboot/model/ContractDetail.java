package tuongvule.com.furamaspringboot.model;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue
    private Long id;

    private String quantity;

    @ManyToOne
    @JoinColumn(name="id_attach_service")
    private AttachService attachService;

    @ManyToOne
    @JoinColumn(name = "id_contract")
    private Contract contract;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    @Override
    public String toString() {
        return "ContractDetail{" +
                "id=" + id +
                ", quantity='" + quantity + '\'' +
                ", attachService=" + attachService +
                ", contract=" + contract +
                '}';
    }
}
