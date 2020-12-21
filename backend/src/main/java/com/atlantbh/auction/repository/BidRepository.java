package com.atlantbh.auction.repository;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.model.Bid;
import com.atlantbh.auction.model.filter.NullFilterBuilder;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BidRepository extends BaseRepositoryImpl<Bid, Long, NullFilterBuilder> {

    public List<Bid> getAll() throws RepositoryException {
        try {
            return getBaseCriteria().list();
        } catch (Exception e) {
            throw new RepositoryException("There was issues with returning all the bids");
        }
    }

    public List<Bid> getBidsByProductId(Long id) throws RepositoryException {
        try {
            return getBaseCriteria()
                    .createAlias("product", "p")
                    .add(Restrictions.eq("p.id", id))
                    .list();
        } catch (Exception e) {
            throw new RepositoryException("There were issues with returning bids for the product with id " + id, e);
        }
    }

    public double getMaxBidForProduct(Long id) throws RepositoryException {
        try {
            return getBidsByProductId(id).stream().mapToDouble(theBid -> theBid.getAmount()).max().orElse(0);
        } catch (Exception e) {
            throw new RepositoryException("There were issues with returning the maximum bid for the product with id " + id, e);
        }
    }
}
