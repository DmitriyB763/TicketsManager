package ru.netology.domaine.data.manager;

import ru.netology.domaine.data.DataTicket;
import ru.netology.domaine.data.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {

    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public DataTicket[] findAll(String departureAirport, String arrivalAirport) { //принимает на вход 2 параметра , аэропорт вылета и прилета
        DataTicket[] result = new DataTicket[0];
        for (DataTicket ticket : repo.ticketList) {
            if (ticket.getDepartureAirport().equals(departureAirport) && ticket.getArrivalAirport().equals(arrivalAirport)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = ticket;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
