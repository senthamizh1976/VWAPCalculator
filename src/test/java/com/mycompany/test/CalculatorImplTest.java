package com.mycompany.test;

import com.mycompany.test.domain.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class CalculatorImplTest {


    private Calculator calculator;

    private static MarketUpdateImpl getMarketUpdate(TwoWayPriceImpl twoWayPrice) {
        return new MarketUpdateImpl(Market.MARKET0, twoWayPrice);
    }

    @Test
    public void testMarketUpdatesForSingleInstrument() {

        Calculator calculator = new CalculatorImpl();
        MarketUpdate marketUpdate1 = getMarketUpdate(new TwoWayPriceImpl(Instrument.INSTRUMENT0, State.FIRM, 10, 12.1d, 20d, 23.1));
        TwoWayPrice twoWayPrice = calculator.applyMarketUpdate(marketUpdate1);
        assertTrue(compare(twoWayPrice.getBidPrice(), 12.1d));

        MarketUpdate marketUpdate2 = getMarketUpdate(new TwoWayPriceImpl(Instrument.INSTRUMENT0, State.FIRM, 10, 13.1d, 20d, 23.1));
        twoWayPrice = calculator.applyMarketUpdate(marketUpdate2);
        assertTrue(compare(twoWayPrice.getBidPrice(), 12.6d));

        MarketUpdate marketUpdate3 = getMarketUpdate(new TwoWayPriceImpl(Instrument.INSTRUMENT0, State.FIRM, 10, 14.1d, 20d, 23.1));
        twoWayPrice = calculator.applyMarketUpdate(marketUpdate3);
        assertTrue(compare(twoWayPrice.getBidPrice(), 13.1d));

    }

    private boolean compare(double actualValue, double expectedValue) {
        if (Math.abs(actualValue - expectedValue) > 0.01) {
            throw new RuntimeException("Expected value " + expectedValue + " is different from actual value " + actualValue);
        }
        ;
        return true;
    }

    @Test
    public void testMarketUpdatesForMultipleInstruments() {

        Calculator calculator = new CalculatorImpl();
        MarketUpdate marketUpdate1 = getMarketUpdate(new TwoWayPriceImpl(Instrument.INSTRUMENT0, State.FIRM, 10, 12.1d, 20d, 23.1));
        TwoWayPrice twoWayPrice = calculator.applyMarketUpdate(marketUpdate1);
        assertTrue(compare(twoWayPrice.getBidPrice(), 12.85d));

        MarketUpdate marketUpdate2 = getMarketUpdate(new TwoWayPriceImpl(Instrument.INSTRUMENT1, State.FIRM, 10, 13.1d, 20d, 23.1));
        twoWayPrice = calculator.applyMarketUpdate(marketUpdate2);
        assertTrue(compare(twoWayPrice.getBidPrice(), 13.1d));

        MarketUpdate marketUpdate3 = getMarketUpdate(new TwoWayPriceImpl(Instrument.INSTRUMENT2, State.FIRM, 10, 14.1d, 20d, 23.1));
        twoWayPrice = calculator.applyMarketUpdate(marketUpdate3);
        assertTrue(compare(twoWayPrice.getBidPrice(), 14.1d));

    }

}