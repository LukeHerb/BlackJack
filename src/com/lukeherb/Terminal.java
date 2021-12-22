package com.lukeherb;

import java.util.Scanner;

public class Terminal {
    private Card card;
    private Scanner scanner;

    public Terminal(Card card) {
        this.card = card;
        this.scanner = new Scanner(System.in);
    }

    public int setUserDeposit() {
        int userDeposit = getIntValueFromUser("Enter Amount for Deposit in dollars: ");
        card.setBalance(card.getBalance() + userDeposit);
        int tickets = userDeposit * 2;
        card.setNumberTickets(card.getNumberTickets() + tickets);
        System.out.println("Your Card Info: " + card.toString());
        return tickets;
    }

    public int getIntValueFromUser(String question) {
        System.out.println(question);
        return scanner.nextInt();
    }
}
