package ru.netology.domaine.data.manager;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.domaine.data.DataTicket;
import ru.netology.domaine.data.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    DataTicket ticket = new DataTicket(1, 10000000, "LED", "GOJ", 90);
    DataTicket ticket1 = new DataTicket(2, 700, "KUF", "OGZ", 150);
    DataTicket ticket2 = new DataTicket(3, 1500, "LED", "GOJ", 180);
    DataTicket ticket3 = new DataTicket(4, 1500, "MMK", "GOJ", 180);


    @Test
    void shouldfindAllAndSort() { //проверяем метод findAll  и сортировку билетов

        repo.addTicket(ticket);
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);

        DataTicket[] expected = {ticket2, ticket};
        DataTicket[] actual = manager.findAll("LED", "GOJ");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchNoValues() {

        repo.addTicket(ticket);
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);

        DataTicket[] expected = {};
        DataTicket[] actual = manager.findAll("", "");

        assertArrayEquals(expected, actual);

    }

}