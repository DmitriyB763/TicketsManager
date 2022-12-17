package ru.netology.domaine.data.repository;

import ru.netology.domaine.data.DataTicket;

import java.util.Arrays;

public class TicketRepository {

    public DataTicket[] ticketList = new DataTicket[0]; //создал массив для хранения билетов

    public void addTicket(DataTicket ticket) {//добавить билет
        DataTicket[] tmp = Arrays.copyOf(ticketList, ticketList.length + 1);
        int lastCell = tmp.length - 1;
        tmp[lastCell] = ticket;
        ticketList = tmp;
    }

    public void removeTicketById(int id) {
        int length = ticketList.length - 1;
        DataTicket[] tmp = new DataTicket[length];
        int lastCell = 0;
        for (DataTicket tickets : ticketList) {
            if (tickets.getId() != id) {
                tmp[lastCell] = tickets;
                lastCell++;
            }
        }
        ticketList = tmp;
    }

    public DataTicket[] getAll() { //получить все билете
        return ticketList;
    }
}
