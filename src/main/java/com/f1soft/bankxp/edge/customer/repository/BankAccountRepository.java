package com.f1soft.bankxp.edge.customer.repository;

import com.flsoft.bankxp.edge.entities.model.BankAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountRepository extends BaseRepository<BankAccount> {

    @Query("select t from BankAccount t where t.accountNumber = :accountNumber and t.active= 'Y' and t.isPrimary = 'Y'")
    Optional<BankAccount> findByAccountNumber(String accountNumber);
}
