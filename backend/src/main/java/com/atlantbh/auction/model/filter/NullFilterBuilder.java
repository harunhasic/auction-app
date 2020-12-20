package com.atlantbh.auction.model.filter;

import org.hibernate.Criteria;

/**
 * Empty filter builder used with generic models that dont implement any filters.
 *
 * @author Harun Hasic
 */
public class NullFilterBuilder extends BaseFilterBuilder<NullFilterBuilder.NullSort, NullFilterBuilder> {

    public enum NullSort {};

    @Override
    protected Criteria addConditions(Criteria rootCriteria, boolean isCountCriteria) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Criteria buildCriteria(Criteria rootCriteria) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Criteria buildCountCriteria(Criteria rootCriteria) {
        throw new UnsupportedOperationException();
    }
}
