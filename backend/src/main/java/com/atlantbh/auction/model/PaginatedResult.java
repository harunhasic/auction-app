package com.atlantbh.auction.model;


import java.util.List;

/**
* Generic base model used for pagination.
 *
 * @author Harun Hasic
 */
public class PaginatedResult<M> {

    private Integer pageNumber;
    private Integer pageSize;
    private List<M> data;
    private Integer available;

    public PaginatedResult() {
    }

    public PaginatedResult(int pageSize, int pageNumber, List<M> data, int available) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.data = data;
        this.available = available;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<M> getData() {
        return data;
    }

    public void setData(List<M> data) {
        this.data = data;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }
}