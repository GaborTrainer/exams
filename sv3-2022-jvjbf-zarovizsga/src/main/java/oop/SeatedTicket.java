package oop;

import java.util.Objects;

public class SeatedTicket implements Ticket {

    private static int BASIC_PRICE = 2_000;

    private BasicTicket basicTicket;

    private int row;

    private int seat;

    public SeatedTicket(BasicTicket basicTicket, int row, int seat) {
        this.basicTicket = basicTicket;
        this.row = row;
        this.seat = seat;
    }

    @Override
    public BasicTicket getBasicTicket() {
        return basicTicket;
    }

    @Override
    public double getPrice() {
        int percent = (row / 10) * 10;
        double calculatedPrice = basicTicket.getPrice() * (100 - percent) / 100.0;
        return Math.max(calculatedPrice, BASIC_PRICE);
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatedTicket that = (SeatedTicket) o;
        if (row != that.row) return false;
        if (seat != that.seat) return false;
        return Objects.equals(basicTicket, that.basicTicket);
    }

    @Override
    public int hashCode() {
        int result = basicTicket != null ? basicTicket.hashCode() : 0;
        result = 31 * result + row;
        result = 31 * result + seat;
        return result;
    }
}
