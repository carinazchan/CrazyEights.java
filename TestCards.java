/**
* The TestCards class stores the main method for driving Card, Deck, & Dealer
* @author Carina Zelda Chan
* @version 1.0
* @see Card, Deck, & Dealer
*/

/*
This class tests almost every case of every constructor and method of
the mentioned files.
*/

/* CHAPMAN STANDARDS
2367721
carchan@chapman.edu
CPSC-231-04
Mastery Project 3A: Let’s Play Cards! - TestCards.java
*/


import java.util.LinkedList;

public class TestCards {

  public static void main(String args[]) {

    System.out.println("******************** Card.java Testing ********************");
    System.out.println();

    //CREATING CARDS
    Card c0 = new Card(); //0 of Hearts
    Card c1 = new Card(2, 0); //2 of Hearts
    Card c2 = new Card(7, 1); //7 of Spades
    Card c3 = new Card(12, 2); //Queen of Clubs
    Card c4 = new Card(14, 3); //Ace of Diamonds
    Card c5 = new Card(c4); //Ace of Diamonds - COPY

    //PRINTING CARDS
    System.out.println(c0.toString()); //0 of Hearts
    System.out.println(c1.toString()); //2 of Hearts
    System.out.println(c2.toString()); //7 of Spades
    System.out.println(c3.toString()); //Queen of Clubs
    System.out.println(c4.toString()); //Ace of Diamonds
    System.out.println(c5.toString()); //Ace of Diamonds - COPY

    System.out.println();

    //EQUALS OR NOT
    System.out.println("------------ Card.java equals() Testing ------------");
    System.out.println(c1.equals(c1)); //true
    System.out.println(c1.equals(c2)); //false
    System.out.println(c2.equals(c1)); //false


    System.out.println();


    System.out.println("******************** Deck.java Testing ********************");
    System.out.println();

    //CREATING DECKS
    Deck d1 = new Deck(); //Initializing d1 with 52 cards
    Deck d2 = new Deck(d1); //Initializing d2 with a deep copy of d1

    //PRINTING DECKS
    System.out.println(d1.toString()); //Pretty print all 52 cards in a deck
    System.out.println();
    System.out.println(d2.toString()); //Pretty print all 52 cards in a deck

    //RETURN SIZE OF DECK, REMOVE CARDS
    System.out.println("------------ Deck.java size(), deal() Testing ------------");
    System.out.println(d1.size()); //Return size of deck: 52
    System.out.println(d1.deal()); //Remove one random card
    System.out.println(d1.deal()); //Remove one random card
    System.out.println(d1.size()); //Return size of deck after removing 2 cards: 50


    System.out.println();


    System.out.println("******************** Dealer.java Testing ********************");
    System.out.println();

    //CREATING DEALER
    Dealer dlr1 = new Dealer(); //Initializing dlr1 with 52 cards

    //CREATING HANDS OF CARDS (DEALT CARDS)
    System.out.println("------------ Dealer.java deals() Testing ------------");
    LinkedList<Card> hCards1 = dlr1.deals(0); //hCards1 is dealt 0 cards
    LinkedList<Card> hCards2 = dlr1.deals(3); //hCards2 is dealt 3 cards

    //PRINTING HANDS OF CARDS (DEALT CARDS)
    System.out.println(hCards1.toString()); //Print hCards1
    System.out.println(hCards2.toString()); //Print hCards2

    //RETURN SIZE OF HANDS OF CARDS (DEALT CARDS)
    System.out.println("------------ Dealer.java size() Testing ------------");
    System.out.println(hCards1.size()); //Return size of hCards1: 0
    System.out.println(hCards2.size()); //Return size of hCards2: 3

  }

}
