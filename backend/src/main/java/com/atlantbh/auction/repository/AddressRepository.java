package com.atlantbh.auction.repository;

import com.atlantbh.auction.model.Address;
import com.atlantbh.auction.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Repository
public class AddressRepository extends BaseRepositoryImpl<Address, Long> {

    @Transactional
    public List<Address> findAll() {
        Query query = entityManager.createQuery("SELECT a FROM Address a");
        return query.getResultList();
    }
}
