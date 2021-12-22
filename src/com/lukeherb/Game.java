package com.lukeherb;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private Card card;
    private Random blackJackDealer;
    private Terminal terminal;
    private PrizeCategory prizeCategory;
    private boolean doesUserPlayBlackJack;
    private boolean userThirdHand;
    private int doesUserPlay;
    private int firstCardsDealt;
    private int secondCardDealt;
    private int thirdCardDealt;
    private int totalCardsDealt;
    private int dealerFirstHand;
    private int dealerSecondHand;
    private int dealer;
    Scanner blackJack = new Scanner(System.in);

    public Game(Card card, Terminal terminal) {
        this.card = card;
        this.terminal = terminal;
        this.blackJackDealer = new Random();
        this.prizeCategory = new PrizeCategory();
    }

    public boolean isUserPlaying() {
        checkPrize();
        System.out.println("Press 1 if you would like to play BlackJack for 3 Tickets: \n(or any other number to quit): ");
        doesUserPlay = blackJack.nextInt();
        if (doesUserPlay == 1) {
            doesUserPlayBlackJack = true;
            if (checkFunds()) {
                blackJack();
            } else {
                System.out.println("Would you like to make a deposit? 1 for yes 2 for no");
                if (blackJack.nextInt() == 1) {
                    terminal.setUserDeposit();
                    isUserPlaying();
                }
            }
        } else {
            System.out.println("Thanks for playing. Bye!");
            System.exit(0);
        }
        return doesUserPlayBlackJack;
    }

    public void blackJack() {
        while (doesUserPlayBlackJack = true) {
            firstCardsDealt = 2 + blackJackDealer.nextInt(14 - 2);
            System.out.println("Card 1 = " + firstCardsDealt);
            secondCardDealt = 2 + blackJackDealer.nextInt(14 - 2);
            System.out.println("Card 2 = " + secondCardDealt);
            totalCardsDealt = firstCardsDealt + secondCardDealt;
            System.out.println("Your Total is " + totalCardsDealt);
            if (totalCardsDealt == 21) {
                card.setNumberTickets(card.getNumberTickets() + 6);
                card.setTicketsEarned(card.getTicketsEarned() + 6);
                System.out.println("BlackJack! You Win! You Now Have " + card.getNumberTickets() + " Tickets. Card Info: " + card.toString());
                isUserPlaying();
            }
            else if (totalCardsDealt >= 22) {
                card.setNumberTickets(card.getNumberTickets() - 3);
                card.setTicketsEarned(card.getTicketsEarned() -3);
                System.out.println("Bust! You Now Have " + card.getNumberTickets());
                isUserPlaying();
                break;
            }
            else if (totalCardsDealt <= 20) {
                System.out.println("Enter 1 to hit, enter 2 to stay...");
                if (blackJack.nextInt() == 1) {
                    thirdHand();
                } else {
                    if (dealerHand() > totalCardsDealt) {
                        if(dealer > 21) {
                            System.out.println("Dealer Busted!");
                            card.setNumberTickets(card.getNumberTickets() + 6);
                            card.setTicketsEarned(card.getTicketsEarned() + 6);
                            System.out.println("You Beat The Dealer! You Now Have " + card.getNumberTickets() + " Tickets");
                            isUserPlaying();
                        }
                        card.setNumberTickets(card.getNumberTickets() - 3);
                        card.setTicketsEarned(card.getTicketsEarned() - 3);
                        System.out.println("You Lost to Dealer, You now have " + (card.getNumberTickets()) + " Tickets");
                        isUserPlaying();
                    }
                    else if (dealer == totalCardsDealt) {
                        System.out.println("You Tied the dealer. No tickets gained or lost. You still have: " + (card.getNumberTickets()) + " Tickets");
                        isUserPlaying();
                    }
                    else {
                        card.setNumberTickets(card.getNumberTickets() + 6);
                        card.setTicketsEarned(card.getTicketsEarned() + 6);
                        System.out.println("You Beat The Dealer! You Now Have " + card.getNumberTickets() + " Tickets");
                        isUserPlaying();
                    }
                }
            }
        }
    }

    public int dealerHand() {
        dealerFirstHand = 2 + blackJackDealer.nextInt(14 - 2);
        dealerSecondHand = 2 + blackJackDealer.nextInt(14 - 2);
        dealer = dealerFirstHand + dealerSecondHand;
        System.out.println("Dealer hand is: " + dealer);
        return dealer;
    }


    public void thirdHand() {
        while (userThirdHand = true) {
            thirdCardDealt = 2 + blackJackDealer.nextInt(14 - 2);
            System.out.println("Card 3 = " + thirdCardDealt);
            totalCardsDealt = thirdCardDealt + secondCardDealt + firstCardsDealt;
            System.out.println("Your Total is: " + totalCardsDealt);
            if (totalCardsDealt == 21) {
                card.setNumberTickets(card.getNumberTickets() + 6);
                card.setTicketsEarned(card.getTicketsEarned() + 6);
                System.out.println("BlackJack! You Win! You Now Have " + card.getNumberTickets() + " Tickets");
                isUserPlaying();
            }
            else if (totalCardsDealt >= 22) {
                card.setNumberTickets(card.getNumberTickets() - 3);
                card.setTicketsEarned(card.getTicketsEarned() -3);
                System.out.println("Bust! You Now Have " + card.getNumberTickets() + " Tickets");
                isUserPlaying();
            }
            else{
                dealerHand();
                if (dealer > 21) {
                    System.out.println("Dealer Busted!");
                    card.setNumberTickets(card.getNumberTickets() + 6);
                    card.setTicketsEarned(card.getTicketsEarned() + 6);
                    System.out.println("You Beat The Dealer! You Now Have " + card.getNumberTickets() + " Tickets");
                    isUserPlaying();
                }
                else if (dealer == totalCardsDealt) {
                    System.out.println("You Tied the dealer. No tickets gained or lost. You still have: " + (card.getNumberTickets()) + " Tickets");
                    isUserPlaying();
                }
                else if(totalCardsDealt > dealer) {
                    card.setNumberTickets(card.getNumberTickets() + 6);
                    card.setTicketsEarned(card.getTicketsEarned() + 6);
                    System.out.println("You Beat The Dealer! You Now Have " + card.getNumberTickets() + " Tickets");
                    isUserPlaying();
                }
                else {
                    card.setNumberTickets(card.getNumberTickets() - 3);
                    card.setTicketsEarned(card.getTicketsEarned() - 3);
                    System.out.println("You Lost to Dealer, You now have " + (card.getNumberTickets()) + " Tickets");
                    isUserPlaying();
                    System.out.println();
                }
            }

        }
    }

    private boolean checkFunds() {
        if (card.getNumberTickets() < 3) {
            System.out.println("Insufficient funds!");
            return false;
        }
        return true;
    }
    public void checkPrize() {
        switch (prizeCategory.calculatePrize(card.getTicketsEarned())) {
            case LARGE_PRIZE:
                System.out.println("Congratulations, you earned a Large prize! Redeem your prize in the gift shop");
                break;
            case MEDIUM_PRIZE:
                System.out.println("Congratulations, you earned a Medium prize! Redeem your prize in the gift shop");
                break;
            case SMALL_PRIZE:
                System.out.println("Congratulations, you earned a Small prize! Redeem your prize in the gift shop");
                break;
            default:
                break;
        }
    }
}
