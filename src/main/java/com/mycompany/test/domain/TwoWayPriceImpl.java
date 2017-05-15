package com.mycompany.test.domain;

/**
 * User: catchsri
 * Date: 13/05/2017
 * Time: 17:04
 */
public class TwoWayPriceImpl implements TwoWayPrice {


    protected double bidVolume = 0;
    protected double bidQuantity = 0;
    protected double vwapBidPrice = 0;
    protected double offerVolume = 0;
    protected double offerQuantity = 0;
    protected double vwapOfferPrice = 0;
    private Instrument instrument;
    private State state;
    private double bidPrice = 0;
    private double offerAmount = 0;
    private double offerPrice = 0;
    private double bidAmount = 0;

    public TwoWayPriceImpl(Instrument instrument, State state, double bidAmount, double bidPrice, double offerAmount, double offerPrice) {
        this.instrument = instrument;
        this.state = state;
        this.bidAmount = bidAmount;
        this.bidPrice = bidPrice;
        this.offerAmount = offerAmount;
        this.offerPrice = offerPrice;

        this.bidVolume += (bidAmount * bidPrice);
        this.bidQuantity += bidAmount;
        this.vwapBidPrice = this.bidVolume / this.bidQuantity;

        this.offerVolume += (offerAmount * offerPrice);
        this.offerQuantity += offerAmount;
        this.vwapOfferPrice = this.offerVolume / this.offerQuantity;
    }


    public Instrument getInstrument() {
        return this.instrument;
    }

    public State getState() {
        return this.state;
    }

    public double getBidPrice() {
        return vwapBidPrice;
    }

    public double getOfferAmount() {
        return this.offerAmount;
    }

    public double getOfferPrice() {
        return this.vwapOfferPrice;
    }

    public double getBidAmount() {
        return this.bidAmount;
    }

    @Override
    public String toString() {
        return "TwoWayPriceImpl{" +
                "instrument=" + instrument +
                ", state=" + state +
                ", bidAmount=" + bidAmount +
                ", bidPrice=" + bidPrice +
                ", offerAmount=" + offerAmount +
                ", offerPrice=" + offerPrice +
                ", bidVolume=" + bidVolume +
                ", bidQuantity=" + bidQuantity +
                ", vwapBidPrice=" + vwapBidPrice +
                ", offerVolume=" + offerVolume +
                ", offerQuantity=" + offerQuantity +
                ", vwapOfferPrice=" + vwapOfferPrice +
                '}';
    }
}