package oop;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TicketOffice {

    private Set<Ticket> tickets = new HashSet<>();

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public Ticket sellTicket(String event, int maxPrice) {
        Ticket result = tickets.stream()
                .filter(t -> t.getBasicTicket().getEvent().equals(event))
                .sorted(Comparator.comparing(Ticket::getPrice).reversed())
                .filter(t -> t.getPrice() <= maxPrice)
                .findFirst().orElseThrow(() -> new NoTicketWithTheseParametersException("No ticket!"));
        tickets.remove(result);
        return result;
    }


    public Map<BasicTicket, Integer> collectTicketCountByEvent() {
        Map<BasicTicket, Integer> result = new HashMap<>();
        for (Ticket t : tickets) {
            if (!result.containsKey(t.getBasicTicket())) {
                result.put(t.getBasicTicket(), 0);
            }
            result.put(t.getBasicTicket(), result.get(t.getBasicTicket()) + 1);
        }
        return result;
    }

    public Set<String> getEventsByDate(LocalDate date) {
        return tickets.stream()
                .filter(t -> t.getBasicTicket().getDate().toLocalDate().equals(date))
                .map(t -> t.getBasicTicket().getEvent())
                .collect(Collectors.toSet());
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }
}