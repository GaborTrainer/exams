package oop;

import java.time.LocalDateTime;
import java.util.Objects;

public class BasicTicket {

    private String event;

    private LocalDateTime date;

    private int price;

    public BasicTicket(String event, LocalDateTime date, int price) {
        this.event = event;
        this.date = date;
        this.price = price;
    }

    public String getEvent() {
        return event;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasicTicket that = (BasicTicket) o;

        if (price != that.price) return false;
        if (!Objects.equals(event, that.event)) return false;
        return Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        int result = event != null ? event.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }
}
