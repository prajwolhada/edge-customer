package com.f1soft.bankxp.edge.customer.repository;

import com.flsoft.bankxp.edge.entities.model.CustomerLogin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerLoginRepository extends BaseRepository<CustomerLogin> {

    @Query("select t from CustomerLogin t where t.id = :id and (t.customerDelete IS NULL OR t.customerDelete != 'Y')")
    Optional<CustomerLogin> findById(@Param("id") Long id);

    @Query("select t from CustomerLogin t where t.username = :username and t.active = 'Y' and (t.customerDelete IS NULL OR t.customerDelete != 'Y') ")
    Optional<CustomerLogin> findCustomerLoginByUsername(@Param("username") String username);
}
