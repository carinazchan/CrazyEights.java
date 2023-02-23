/**
* The Dealer class stores information about dealt cards and contains methods involving Dealer objects
* @author Carina Zelda Chan
* @version 1.0
* @see Card, Deck, & TestCards
*/

/* CHAPMAN STANDARDS
2367721
carchan@chapman.edu
CPSC-231-04
Mastery Project 3A: Let’s Play Cards! - Dealer.java
*/


import java.util.LinkedList;
import java.util.Random;

public class Dealer extends Deck {

  //ATTRIBUTES
  protected Deck m_deck;

/*----------------------------------------------------------------------------*/

  //CONSTRUCTORS - Creates Dealer object

  public Dealer() { //DEFAULT
    m_deck = new Deck();
  }

/*----------------------------------------------------------------------------*/

  //MEHTODS

  //Returns LinkedList of n number of dealt cards
  public LinkedList<Card> deals(int n) {

    LinkedList<Card> dealtCards = new LinkedList<Card>(); //Creates empty LinkedList to be populated

    //Populating dealtCards with n number of random cards
    if (m_deck.size() != 0) { //Enter for-loop if m_deck is not empty
      for (int i=0; i<n; i++) {
        dealtCards.add(m_deck.deal()); //Utilize Deck.java deal() method to add random cards
      }
    }

    return dealtCards;
  }

  //Returns integer of the size of the number of cards dealt
  public int size() {
    int numCardsDealt = m_deck.size();

    return numCardsDealt;
  }

  //Returns string of pretty print of all dealt cards
  public String toString() {
    String dealtCardsPP = m_deck.toString(); //Utilize Deck.java toString() method to print all dealt cards

    return dealtCardsPP;
  }

}
