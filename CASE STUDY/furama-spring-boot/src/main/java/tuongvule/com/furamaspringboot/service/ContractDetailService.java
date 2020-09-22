package tuongvule.com.furamaspringboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tuongvule.com.furamaspringboot.model.Contract;
import tuongvule.com.furamaspringboot.model.ContractDetail;
import tuongvule.com.furamaspringboot.model.Customer;

public interface ContractDetailService {
    Page<ContractDetail> findAll(String name, Pageable pageable);
    Contract findContractDetailById(Long id);
    void save(ContractDetail contractDetail);
    void remove(Long id);
}
