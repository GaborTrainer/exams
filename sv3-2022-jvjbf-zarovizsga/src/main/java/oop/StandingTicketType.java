package oop;

public enum StandingTicketType {

    FRONT_OF_STAGE(20), NORMAL(0);

    int percent;

    StandingTicketType(int percent) {
        this.percent = percent;
    }

    public int getPercent() {
        return percent;
    }
}
