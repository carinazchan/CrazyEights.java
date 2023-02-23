/**
* The Deck class stores information about decks of cards and contains methods involving Deck objects
* @author Carina Zelda Chan
* @version 1.0
* @see Card, Dealer, & TestCards
*/

/* CHAPMAN STANDARDS
2367721
carchan@chapman.edu
CPSC-231-04
Mastery Project 3A: Let’s Play Cards! - Deck.java
*/


import java.util.LinkedList;
import java.util.Random;

public class Deck extends Card{

  //ATTRIBUTES
  protected LinkedList<Card> m_cards = new LinkedList<Card>();

/*----------------------------------------------------------------------------*/

  //CONSTRUCTORS - Creates Deck object

  public Deck() { //DEFAULT
    m_cards = new LinkedList<Card>(); //Creates empty LinkedList to be populated

    //Populating m_cards with fresh deck of cards (52 cards)
    for (int i=0; i<cardSuit.length; i++) {
      for (int k=0; k<cardRank.length; k++){
        m_cards.add(new Card(cardRank[k], cardSuit[i]));
      }
    }
  }

  public Deck(Deck inputDeck) { //DEEP COPY (Deck object)
    m_cards = new LinkedList<Card>(); //Creates empty LinkedList to be populated

    //Populating m_cards with a deep copy of inputDeck-which is a Deck object
    for (Card currCard: inputDeck.m_cards) {
      m_cards.add(new Card(currCard));
    }
  }

/*----------------------------------------------------------------------------*/

  //METHODS

  //Returns string of pretty print of all cards in a deck
  public String toString() {
    String deckPP = "";

    //Iterate through all cards in Deck m_cards
    for (Card currCard: m_cards) {
        deckPP += currCard.toString() + "\n"; //Utilize Card.java toString() method for each card
    }

    return deckPP;
  }

  //Returns integer of the size of a deck
  public int size() {
    int numCardsDeck = m_cards.size();

    return numCardsDeck;
  }

  //Returns card that has been removed from a deck
  public Card deal() {
    Random randomNum = new Random(); //Initialize random number generator

    //Takes a random number in the range 0 to size of deck
    int indexNum = randomNum.nextInt(m_cards.size());

    //Removes the card from a deck at the chosen index number
    Card removedCard = m_cards.remove(indexNum);

    return removedCard;
  }

}
