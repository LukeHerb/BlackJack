

package com.lukeherb;

import java.util.Random;

public class App {

    public static void main(String[] args) {


		int cardNumber = new Random().nextInt(111111);
		Card userCard = new Card(cardNumber);
		Terminal terminal = new Terminal(userCard);
		Game blackJack = new Game(userCard, terminal);
		System.out.println("Your ID number is : " + userCard.getNumber());
		terminal.setUserDeposit();
		blackJack.isUserPlaying();
	}
}