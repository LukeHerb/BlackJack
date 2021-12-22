package com.lukeherb;

public class Card {
    private int number;
    private int balance;
    private int numberTickets;
    private int ticketsEarned;



    public Card(int number) { this.number = number; }

    public int getNumber() { return number; }

    public int getBalance() {
        return balance;
    }

    public int getNumberTickets() {
        return numberTickets;
    }

    public void setNumberTickets(int numberTickets) {
        this.numberTickets = numberTickets;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getTicketsEarned() {
        return ticketsEarned;
    }

    public void setTicketsEarned(int ticketsEarned) {
        this.ticketsEarned = ticketsEarned;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", balance=" + balance +
                ", numberTickets=" + numberTickets +
                '}';
    }
}


