package tuongvule.com.furamaspringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tuongvule.com.furamaspringboot.model.Contract;
import tuongvule.com.furamaspringboot.repository.ContractRepository;
import tuongvule.com.furamaspringboot.service.ContractService;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;


    @Override
    public Page<Contract> findContractByAll(String keyword, Pageable pageable) {
        return contractRepository.findContractByAll(keyword, pageable);
    }

    @Override
    public Contract findById(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> findCustomerAndTotal(Pageable pageable) {
        return contractRepository.findCustomerAndTotal(pageable);
    }
}
