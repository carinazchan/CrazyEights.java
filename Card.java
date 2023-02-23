/**
* The Card class stores information about cards and contains methods involving Card objects
* @author Carina Zelda Chan
* @version 1.0
* @see Deck, Dealer, & TestCards
*/

/* CHAPMAN STANDARDS
2367721
carchan@chapman.edu
CPSC-231-04
Mastery Project 3A: Let’s Play Cards! - Card.java
*/


public class Card {

  //ATTRIBUTES
  protected int rank;
  protected int suit;

  //CONSTANTS - Ranks
  public static final int JACK = 11;
  public static final int QUEEN = 12;
  public static final int KING = 13;
  public static final int ACE = 14;
  //Array of all possible card ranks
  public static final int cardRank[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, JACK, QUEEN, KING, ACE};

  //CONSTANTS - Suits
  public static final int HEARTS = 0;
  public static final int SPADES = 1;
  public static final int CLUBS = 2;
  public static final int DIAMONDS = 3;
  //Array of all possible card suits
  public static final int cardSuit[] = {HEARTS, SPADES, CLUBS, DIAMONDS};

  //ACCESSORS
  public int getRank() {
    return rank;
  }
  public int getSuit() {
    return suit;
  }

  //MUTATORS
  public void setRank(int r) {
    rank = r;
  }
  public void setSuit(int s) {
    suit = s;
  }

/*----------------------------------------------------------------------------*/

  //CONSTRUCTORS - Creates Card object

  public Card() { //DEFAULT
    rank = 0;
    suit = 0;
  }

  public Card(int inputRank, int inputSuit) { //OVERLOAD, (rank, suit)
    rank = inputRank;
    suit = inputSuit;
  }

  public Card(Card inputCard) { //COPY (Card object)
    rank = inputCard.rank;
    suit = inputCard.suit;
  }

/*----------------------------------------------------------------------------*/

  //METHODS

  //Returns string of pretty print card
  public String toString() {
    String cardPP = "";

    //Returns rank of this-which is a Card object
    if (this.getRank() == 11) {
      cardPP += "Jack";
    }
    else if (this.getRank() == 12) {
      cardPP += "Queen";
    }
    else if (this.getRank() == 13) {
      cardPP += "King";
    }
    else if (this.getRank() == 14) {
      cardPP += "Ace";
    }
    else {
      cardPP += this.getRank();
    }

    //Returns suit of this-which is a Card object
    if (this.getSuit() == 0) {
      cardPP += " of Hearts";
    }
    else if (this.getSuit() == 1) {
      cardPP += " of Spades";
    }
    else if (this.getSuit() == 2) {
      cardPP += " of Clubs";
    }
    else if (this.getSuit() == 3) {
      cardPP += " of Diamonds";
    }

    return cardPP;
  }

  //Returns true or false, compares this and inputCard
  public boolean equals(Card inputCard) {
    boolean answer = false;

    if (suit == (inputCard.suit)) {
      if (rank == (inputCard.rank)) {
        answer = true;
      }
    }

    return answer;
  }

}
