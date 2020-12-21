package com.atlantbh.auction.model.filter;

import org.hibernate.Criteria;
import org.hibernate.NullPrecedence;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.internal.CriteriaImpl;

/**
 * Generic base filter builder that will be used in extending classes as a basis.
 * Extending classes will only need to add conditions by which to filter by and the filter will be built.
 * Main purpose of filter classes will be the filtering of related models.
 * Implementation is based on builder pattern.
 *
 * @author Harun Hasic
 */
public abstract class BaseFilterBuilder<S extends Enum<S>, T extends BaseFilterBuilder<S, T>> {

    protected boolean useDefaultSort = true;
    private int pageNumber;
    private int pageSize;
    private S sortKey;
    private Boolean sortAsc;

    protected abstract Criteria addConditions(Criteria rootCriteria, boolean isCountCriteria);

    public Criteria buildCriteria(Criteria rootCriteria) {
        rootCriteria = addConditions(rootCriteria, false);
        if (rootCriteria instanceof CriteriaImpl && ((CriteriaImpl) rootCriteria).getMaxResults() == null &&
                ((CriteriaImpl) rootCriteria).getFirstResult() == null) {
            addLimitAndOffset(rootCriteria);
        }
        addOrderBy(rootCriteria);
        return rootCriteria;
    }

    public Criteria buildCountCriteria(Criteria rootCriteria) {
        rootCriteria = addConditions(rootCriteria, true);
        rootCriteria.setProjection(Projections.rowCount());
        return rootCriteria;
    }

    protected void addOrderBy(Criteria rootCriteria) {
        if (sortKey != null && sortAsc != null) {
            if (sortAsc) {
                rootCriteria.addOrder(Order.asc(sortKey.toString()));
            } else {
                rootCriteria.addOrder(Order.desc(sortKey.toString()).nulls(NullPrecedence.LAST));
            }
        }
        if (useDefaultSort) {
            rootCriteria.addOrder(Order.desc("id"));
        }
    }

    protected void addLimitAndOffset(Criteria rootCriteria) {
        if (getPageSize() != 0) {
            rootCriteria.setMaxResults(getPageSize());
            rootCriteria.setFirstResult((getPageNumber() - 1) * getPageSize());
        }
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public T setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
        return (T) this;
    }

    public int getPageSize() {
        return pageSize;
    }

    @SuppressWarnings("unchecked")
    public T setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return (T) this;
    }

    public S getSortKey() {
        return sortKey;
    }

    public T setSortKey(S sortKey) {
        this.sortKey = sortKey;
        return (T) this;
    }

    public Boolean getSortAsc() {
        return sortAsc;
    }

    public T setSortAsc(Boolean sortAsc) {
        this.sortAsc = sortAsc;
        return (T) this;
    }

    public boolean isUseDefaultSort() {
        return useDefaultSort;
    }

    public T setUseDefaultSort(boolean useDefaultSort) {
        this.useDefaultSort = useDefaultSort;
        return (T) this;
    }
}