package tuongvule.com.furamaspringboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tuongvule.com.furamaspringboot.model.Contract;
import tuongvule.com.furamaspringboot.model.Customer;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    @Query(value = "select * from contracts where id like %:keyword% or deposit like %:keyword% or end_date like %:keyword% " +
            "or start_date like %:keyword% or total_money like %:keyword% or id_customer like %:keyword% or id_service like %:keyword% ",nativeQuery = true)
    Page<Contract> findContractByAll(@Param("keyword") String keyword, Pageable pageable);

    @Query(value = "select customers.id, customers.name, services.name_service, services.cost, attach_service.name_attach_service , attach_service.cost, contract_detail.quantity,contracts.total_money,\n" +
            "services.cost + attach_service.cost* contract_detail.quantity as \"total\"\n" +
            "from contracts\n" +
            "join services on contracts.id_service = services.id\n" +
            "join customers on contracts.id_customer = customers.id\n" +
            "join contract_detail on contracts.id = contract_detail.id_contract\n" +
            "join attach_service on attach_service.id = contract_detail.id_attach_service;", nativeQuery = true)
    Page<Contract> findCustomerAndTotal(Pageable pageable);
}
