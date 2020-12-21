package com.atlantbh.auction.repository;

import com.atlantbh.auction.model.Address;
import com.atlantbh.auction.model.filter.NullFilterBuilder;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AddressRepository extends BaseRepositoryImpl<Address, Long, NullFilterBuilder> {

    @Transactional
    public Address findByStreet(String street) {
        return (Address) getBaseCriteria()
                .add(Restrictions.eq("street", street))
                .uniqueResult();
    }
}
