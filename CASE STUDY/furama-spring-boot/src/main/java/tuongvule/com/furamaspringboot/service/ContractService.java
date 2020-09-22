package tuongvule.com.furamaspringboot.service;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tuongvule.com.furamaspringboot.model.Contract;



public interface ContractService {
    Page<Contract> findContractByAll(String keyword, Pageable pageable);
    Contract findById(Long id);
    void save(Contract contract);
    void remove(Long id);
    Page<Contract> findCustomerAndTotal(Pageable pageable);
}
