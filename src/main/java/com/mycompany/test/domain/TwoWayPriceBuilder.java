package com.mycompany.test.domain;


public final class TwoWayPriceBuilder {

    private Instrument instrument;
    private State state;
    private double bidPrice;
    private double bidAmount;
    private double offerPrice;
    private double offerAmount;


    public TwoWayPriceBuilder() {
    }

    public TwoWayPriceBuilder(TwoWayPrice twoWayPrice) {
        this.instrument = twoWayPrice.getInstrument();
        this.state = twoWayPrice.getState();
        this.bidAmount = twoWayPrice.getBidAmount();
        this.bidPrice = twoWayPrice.getBidPrice();
        this.offerAmount = twoWayPrice.getOfferAmount();
        this.offerPrice = twoWayPrice.getOfferPrice();

    }

    public TwoWayPriceBuilder(TwoWayPrice twoWayPrice, TwoWayPrice existingTwoWayPrice) {
        this.instrument = twoWayPrice.getInstrument();
        this.state = twoWayPrice.getState();
        this.bidAmount = twoWayPrice.getBidAmount();
        this.bidPrice = twoWayPrice.getBidPrice();
        this.offerAmount = twoWayPrice.getOfferAmount();
        this.offerPrice = twoWayPrice.getOfferPrice();

    }

    public TwoWayPriceBuilder instrument(Instrument instrument) {
        this.instrument = instrument;
        return this;
    }

    public TwoWayPriceBuilder state(State state) {
        this.state = state;
        return this;
    }

    public TwoWayPriceBuilder bidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
        return this;
    }

    public TwoWayPriceBuilder bidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
        return this;
    }

    public TwoWayPriceBuilder offerPrice(double offerPrice) {
        this.offerPrice = offerPrice;
        return this;
    }

    public TwoWayPriceBuilder offerAmount(double offerAmount) {
        this.offerAmount = offerAmount;
        return this;
    }

    public TwoWayPrice build() {
        return new TwoWayPriceImpl(instrument, state, bidAmount, bidPrice, offerAmount, offerPrice);
    }


}

