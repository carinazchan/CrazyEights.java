/**
* The Player class stores information about players and contains methods involving Player objects
* @author Carina Zelda Chan
* @version 1.0
* @see Card, Deck, TestCards, Game, & CrazyEightsDriver
*/

/* CHAPMAN STANDARDS
2367721
carchan@chapman.edu
CPSC-231-04
Mastery Project 3B: Crazy Eights! - Player.java
*/


import java.util.LinkedList;
import java.util.Random;

public class Player extends Dealer{

  //ATTRIBUTES
  protected int playerNum;
  protected LinkedList<Card> handCards = new LinkedList<Card>();
  public Dealer stock = new Dealer();
  public LinkedList<Card> starterPile = new LinkedList<Card>();


  //ACCESSORS
  public int getPlayerNum() {
   return playerNum;
  }
  public LinkedList<Card> getHandCards() {
    return handCards;
  }
  public Dealer getStock() {
    return stock;
  }
  public LinkedList<Card> getStarterPile() {
    return starterPile;
  }

/*----------------------------------------------------------------------------*/

  //CONSTRUCTORS
  public Player() { //DEFAULT
    playerNum = 1;
    handCards = stock.deals(5); //Deals 5 cards to player from stock
  }

  public Player(int inputPlayerNum, Dealer inputStock, LinkedList<Card> inputStarterPile) { //OVERLOAD
    playerNum = inputPlayerNum;
    stock = inputStock;
    starterPile = inputStarterPile;
    handCards = inputStock.deals(5); //Deals 5 cards to player from stock
  }

/*----------------------------------------------------------------------------*/

  //METHODS

  public int stockSize() {
    int numCardsStock = stock.size();

    return numCardsStock;

  } //End of stockSize method


  public Card takeTurn() {

    Card playableCard = new Card(); //Card that will be returned by the end of takeTurn
    LinkedList<Card> dealtCards = new LinkedList<Card>(); //LinkedList of dealtCards
    Card dealtCard = new Card(); //Card that will be dealt - taken from dealtCards
    Card newCard8 = new Card(); //Card that will be used if an 8 is dealt or played
    LinkedList<Card> localnewHandCards = new LinkedList<Card>(); //Deep copy of handCards
    int indexNumRemoved = 0; //Index number of card to be removed from handCards/card that will be played
    int numCardProcessed = 0; //Number of cards that have been evaluated (if they are playable or not)

    //Make deep copy of handCards
    for (Card currCard: handCards) {
      localnewHandCards.add(new Card(currCard));
    }

      for (Card chosenCard: localnewHandCards) { //Evaluates all cards in hand, use copy of handCards***************************************

        //If current card is playable
        if ((chosenCard.getSuit() == starterPile.getLast().getSuit()) ||
            (chosenCard.getRank() == starterPile.getLast().getRank()) ||
            (chosenCard.getRank() == 8) )  {

          indexNumRemoved = localnewHandCards.indexOf(chosenCard); //Index number of card to be removed from handCards/card that will be played
          handCards.remove(indexNumRemoved); //Remove chosenCard from handCards to be played

          //If chosenCard is an 8
          if (chosenCard.getRank() == 8){
               Card new8Card = new Card (8, newSuit().getSuit()); //Create new Card, new8Card, to pick random suit with 8
               starterPile.add(new8Card); //Add new8Card to the top of the starterPile
               playableCard = new8Card;
           }
           else {
              starterPile.add(chosenCard); //Add playable card to the top of the starterPile
              playableCard = chosenCard;
           }

           break; //Breaks out of for-loop
        }

        //If current card is NOT playable
        else {
          numCardProcessed ++; //Increment (current card is not playable)
        }

      } //Evaluated all cards in hand


      //If all cards in hand are NOT playable********************************************************************************************
      while (numCardProcessed == localnewHandCards.size()) {

        //If stock is empty
        if (stock.size() == 0){
             playableCard = null; //Returns null
             break; //Breaks out of while-loop
        }

        //If stock is NOT empty
        else {
           dealtCards = stock.deals(1); //LinkedList of dealtCards
           dealtCard = dealtCards.getLast(); //Card that will be dealt - taken from dealtCards

           //Evalutes if dealtCard is playable
           if ((dealtCard.getSuit() == starterPile.getLast().getSuit()) ||
               (dealtCard.getRank() == starterPile.getLast().getRank()) ||
               (dealtCard.getRank() == 8)) {

                 //If dealtCard is an 8
                 if (dealtCard.getRank() == 8){
                   Card newDealtCard8 = new Card (8,newSuit().getSuit()); //Create new Card, newDealtCard8, using newSuit()
                   starterPile.add(newDealtCard8); //Add newDealtCard8 to the top starterPile
                   playableCard = newDealtCard8; //Returns the newDealtCard8
                 }

                 //If dealtCard is NOT an 8
                 else {
                   starterPile.add(dealtCard); //Add dealtCard to the top of the starterPile
                   playableCard = dealtCard;
                 }

                 break; //Breaks out of while-loop
               }

           //If dealtCard is NOT playable, add to handCards
          else {
            handCards.add(dealtCard);
          }

        }

      } //End of while-loop, a playable card has been found

    return playableCard;
    
  } //End of takeTurn method


  //Gets a randomized suit
  public Card newSuit() {

    Random randomGen = new Random();
    int suitNum = randomGen.nextInt(3); //Generate random number, range: 0-3. assign to suitNum

    Card new8Card = new Card(8, suitNum); //Rank: 8, suit: random

    return new8Card;

  } //End of newSuit method



} //END OF PLAYER CLASS
