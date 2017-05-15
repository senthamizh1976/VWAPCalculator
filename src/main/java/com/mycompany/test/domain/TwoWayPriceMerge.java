package com.mycompany.test.domain;

/**
 * User: catchsri
 * Date: 14/05/2017
 * Time: 14:26
 */
public interface TwoWayPriceMerge extends TwoWayPrice {
    void merge(double bidVolume, double bidQuantity, double offerVolume, double offerQuantity);

}
