package com.mycompany.test.domain;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class TwoWayPriceMergeImpl extends TwoWayPriceImpl implements TwoWayPriceMerge {

    private static final Map<Instrument, Map<Market, TwoWayPriceMergeImpl>> VMAP_MAP = new ConcurrentHashMap<Instrument, Map<Market, TwoWayPriceMergeImpl>>();


    public TwoWayPriceMergeImpl(TwoWayPrice twoWayPrice) {
        this(twoWayPrice.getInstrument(), twoWayPrice.getState(), twoWayPrice.getBidAmount(), twoWayPrice.getBidPrice(), twoWayPrice.getOfferAmount(), twoWayPrice.getOfferPrice());
    }

    private TwoWayPriceMergeImpl(Instrument instrument, State state, double bidAmount, double bidPrice, double offerAmount, double offerPrice) {
        super(instrument, state, bidAmount, bidPrice, offerAmount, offerPrice);
    }


    public void merge(double bidVolume, double bidQuantity, double offerVolume, double offerQuantity) {
        this.bidVolume += bidVolume;
        this.bidQuantity += bidQuantity;
        this.vwapBidPrice = this.bidVolume / this.bidQuantity;

        this.offerVolume += offerVolume;
        this.offerQuantity += offerQuantity;
        this.vwapOfferPrice = this.offerVolume / this.offerQuantity;

    }


}
