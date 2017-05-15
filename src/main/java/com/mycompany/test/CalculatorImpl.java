package com.mycompany.test;

import com.mycompany.test.domain.*;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class CalculatorImpl implements Calculator {

    private static final Map<Instrument, Map<Market, TwoWayPriceMerge>> VMAP_MAP = new ConcurrentHashMap<Instrument, Map<Market, TwoWayPriceMerge>>();
    private static final Map<Instrument, Map<Market, AtomicLong>> INSTRUMENT_COUNTER_MAP = new ConcurrentHashMap<Instrument, Map<Market, AtomicLong>>();


    public TwoWayPrice applyMarketUpdate(MarketUpdate twoWayMarketPrice) {

        Market market = twoWayMarketPrice.getMarket();
        TwoWayPrice twoWayPrice = twoWayMarketPrice.getTwoWayPrice();
        BigDecimal bidAmount = BigDecimal.valueOf(twoWayPrice.getBidAmount());
        BigDecimal offerAmount = BigDecimal.valueOf(twoWayPrice.getOfferAmount());
        BigDecimal bidVolume = bidAmount.multiply(BigDecimal.valueOf(twoWayPrice.getBidPrice()));
        BigDecimal offerVolume = offerAmount.multiply(BigDecimal.valueOf(twoWayPrice.getOfferPrice()));

        Map<Market, TwoWayPriceMerge> marketTwoWayPriceMap = VMAP_MAP.get(twoWayPrice.getInstrument());

        if (marketTwoWayPriceMap == null) {
            marketTwoWayPriceMap = new ConcurrentHashMap<Market, TwoWayPriceMerge>();
        }


        TwoWayPriceMerge vwapPrice = marketTwoWayPriceMap.get(market);

        if (vwapPrice == null) {
            vwapPrice = new TwoWayPriceMergeImpl(new TwoWayPriceBuilder(twoWayPrice).build());
        } else {
            vwapPrice.merge(bidVolume.doubleValue(), bidAmount.doubleValue(), offerVolume.doubleValue(), offerAmount.doubleValue());
        }
        marketTwoWayPriceMap.put(market, vwapPrice);

        VMAP_MAP.put(twoWayPrice.getInstrument(), marketTwoWayPriceMap);


        return vwapPrice;
    }


}

