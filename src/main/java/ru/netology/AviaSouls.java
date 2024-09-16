package ru.netology;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AviaSouls {
    private Ticket[] tickets = new Ticket[0];

    private Ticket[] addToArray(Ticket[] current, Ticket ticket) {
        Ticket[] tmp = new Ticket[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = ticket;
        return tmp;
    }

    public void add(Ticket ticket) {
        tickets = addToArray(tickets, ticket);
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public Ticket[] search(String from, String to) {
        Ticket[] result = new Ticket[0]; // массив для ответа
        for (Ticket ticket : tickets) { // перебираем все билеты
            if (ticket.getFrom().equals(from) && ticket.getTo().equals(to)) { // совпадает аэропорт вылета и прилёта
                result = addToArray(result, ticket); // добавляем его в массив ответа
            }
        }
        Arrays.sort(result); // сортируем массив найденных билетов
        return result; // возвращаем отсортированный массив
    }

    public Ticket[] searchAndSortBy(String from, String to, Comparator<Ticket> comparator) {
        List<Ticket> result = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getFrom().equals(from) && ticket.getTo().equals(to)) {
                result.add(ticket);
            }
        }
        result.sort(comparator);
        return result.toArray(new Ticket[0]);
    }
}


