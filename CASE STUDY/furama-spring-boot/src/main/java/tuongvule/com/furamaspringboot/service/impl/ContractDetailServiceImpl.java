package tuongvule.com.furamaspringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tuongvule.com.furamaspringboot.model.Contract;
import tuongvule.com.furamaspringboot.model.ContractDetail;
import tuongvule.com.furamaspringboot.repository.ContractDetailRepository;
import tuongvule.com.furamaspringboot.service.ContractDetailService;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    ContractDetailRepository contractDetailRepository;
    @Override
    public Page<ContractDetail> findAll(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Contract findContractDetailById(Long id) {
        return null;
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(Long id) {

    }
}
