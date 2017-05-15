package com.mycompany.test;


import com.mycompany.test.domain.MarketUpdate;
import com.mycompany.test.domain.TwoWayPrice;

public interface Calculator {

    TwoWayPrice applyMarketUpdate(final MarketUpdate twoWayMarketPrice);
}
