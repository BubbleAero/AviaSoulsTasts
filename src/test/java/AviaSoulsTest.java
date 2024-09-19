package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {
    AviaSouls manager = new AviaSouls();
    TicketTimeComparator ticketComparator = new TicketTimeComparator();

    Ticket ticket1 = new Ticket("Antalya", "Istanbul", 5_000, 10, 12);
    Ticket ticket2 = new Ticket("Istanbul", "Trabzon", 7_500, 14, 16);
    Ticket ticket3 = new Ticket("Trabzon", "Sydney", 11_000, 18, 23);
    Ticket ticket4 = new Ticket("Istanbul", "Perth", 6_000, 15, 18);
    Ticket ticket5 = new Ticket("Istanbul", "Perth", 8_500, 11, 13);
    Ticket ticket6 = new Ticket("Istanbul", "Perth", 7_000, 16, 18);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
    }

    @Test
    public void shouldCompareWithMin() {
        int expected = -1;
        int actual = ticket4.compareTo(ticket5);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareTwoIdentical() {
        int expected = 0;
        int actual = ticket6.compareTo(ticket6);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareWithMax() {
        int expected = 1;
        int actual = ticket3.compareTo(ticket1);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldComparatorWithMin() {
        int expected = 0;
        int actual = ticketComparator.compare(ticket5, ticket6);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldTheComparatorTwoIdentical() {
        int expected = 1;
        int actual = ticketComparator.compare(ticket4, ticket6);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldComparatorWithMax() {
        int expected = 1;
        int actual = ticketComparator.compare(ticket3, ticket2);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindAllTickets() {
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareToOrderingAll() {
        Ticket[] expected = {ticket4, ticket6, ticket5};
        Ticket[] actual = manager.search("Istanbul", "Perth");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWithOneTicket() {
        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.search("Antalya", "Istanbul");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWithNoTicket() {
        Ticket[] expected = {};
        Ticket[] actual = manager.search("Antalya", "Sydney");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSort() {
        Ticket[] expected = {ticket5, ticket6, ticket4};
        Ticket[] actual = manager.searchAndSort("Istanbul", "Perth", ticketComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortWithOneTicket() {
        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.searchAndSort("Trabzon", "Sydney", ticketComparator);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortWithNoTicket() {
        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSort("Istanbul", "Sydney", ticketComparator);
        assertArrayEquals(expected, actual);
    }
}
