package com.atlantbh.auction.controller;

import com.atlantbh.auction.exceptions.ServiceException;
import com.atlantbh.auction.model.Bid;
import com.atlantbh.auction.model.dto.BidRequest;
import com.atlantbh.auction.service.BidService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@ApiOperation(value = "/bid", tags = "Bid model controller")
@RestController
@CrossOrigin
@RequestMapping(value = "/bid")
public class BidController extends BaseController<Bid, Long, BidService> {

    @ApiOperation(value = "Add a new bit to a product")
    @PostMapping
    @RequestMapping(value = "/add")
    @Valid
    public ResponseEntity add(@Valid @RequestBody BidRequest bid) {
        try {
            service.add(bid);
            return ResponseEntity.noContent().build();
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ApiOperation(value = "Return all of the bids of a product")
    @GetMapping("/{id}")
    public ResponseEntity getBidsByProductId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getByProductId(id));
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
