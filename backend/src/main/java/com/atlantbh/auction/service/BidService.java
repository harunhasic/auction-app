package com.atlantbh.auction.service;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.exceptions.ServiceException;
import com.atlantbh.auction.model.Bid;
import com.atlantbh.auction.model.Product;
import com.atlantbh.auction.model.User;
import com.atlantbh.auction.model.dto.BidRequest;
import com.atlantbh.auction.model.filter.NullFilterBuilder;
import com.atlantbh.auction.repository.BidRepository;
import com.atlantbh.auction.repository.ProductRepository;
import com.atlantbh.auction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BidService extends BaseService<Bid, Long, NullFilterBuilder, BidRepository> {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Bid> getByProductId(Long id) throws ServiceException {
        try {
            return repository.getBidsByProductId(id);
        } catch (RepositoryException e) {
            throw new ServiceException("There was issues with returning the bids for this id " + id, e);
        }
    }

    public List<Bid> getAll() throws ServiceException {
        try {
            return repository.getAll();
        } catch (RepositoryException e) {
            throw new ServiceException("There was issues with returning all the bids", e);
        }
    }

    public void add(BidRequest bid) throws ServiceException {
        Date currentDate = new Date();
        if (!validateBid(bid, currentDate)) {
            throw new ServiceException("Bid cannot be validated");
        }
        try {
            Product product = productRepository.get(bid.getProductId());
            Long userId = bid.getUserId();
            if (userId == null) {
                throw new ServiceException("Invalid token");
            }
            User user = userRepository.findById(userId);
            if (product.getUser().getId() == user.getId()) {
                throw new ServiceException("Bidding cannot be done on the product that you own.");
            }
            repository.save(new Bid(
                            currentDate,
                            user,
                            product,
                            bid.getPrice()
                    )
            );
        } catch (RepositoryException e) {
            throw new ServiceException("The bid could not be processed", e);
        }
    }

    public double getHighestBidForProduct(Long id) throws ServiceException {
        try {
            return repository.getMaxBidForProduct(id);
        } catch (RepositoryException e) {
            throw new ServiceException("There was a problem with returning the highest bid for product id " + id, e);
        }
    }

    private boolean validateBid(BidRequest bid, Date currentDate) throws ServiceException {
        try {
            Product product = productRepository.findById(bid.getProductId());
            double highestBid = repository.getMaxBidForProduct(product.getId());

            if (bid.getPrice() <= highestBid) {
                return false;
            }
            Date auctionStarts = product.getStartDate();
            Date auctionEnds = product.getEndDate();

            return !currentDate.before(auctionStarts) && !currentDate.after(auctionEnds);
        } catch (RepositoryException e) {
            throw new ServiceException("There were issues while validating the bid", e);
        }
    }
}
