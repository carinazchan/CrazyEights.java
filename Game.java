/**
* The Game class stores information about games and contains methods involving Game objects
* @author Carina Zelda Chan
* @version 1.0
* @see Card, Deck, TestCards, Player, & CrazyEightsDriver
*/

/* CHAPMAN STANDARDS
2367721
carchan@chapman.edu
CPSC-231-04
Mastery Project 3B: Crazy Eights! - Game.java
*/


import java.util.LinkedList;

public class Game extends Player{

  //ATTRIBUTES
  protected Player gameP1 = new Player();
  protected Player gameP2 = new Player();
  protected Dealer gameStock = new Dealer();
  protected LinkedList<Card> gameStarterPile = new LinkedList<Card>();

/*----------------------------------------------------------------------------*/

  //CONSTRUCTORS
  public Game() { //DEFAULT
    gameStock = new Dealer(); //Creates 52 cards for fresh stock
    gameStarterPile = gameStock.deals(1); //Adds 1 card to empty gameStarterPile
    gameP1 = new Player(1, gameStock, gameStarterPile); //Player 1
    gameP2 = new Player(2, gameStock, gameP1.starterPile); //Player 2
  }

/*----------------------------------------------------------------------------*/

  //METHODS

  public void play() {

    int turnP1 = 1; //P1 switch to keep track of whose turn it is
    int turnP2 = 0; //P2 switch to keep track of whose turn it is
    int gameIsOver =0; //Conditional for while-loop

    //While game is NOT over
    while (gameIsOver ==0){

      //If it's P1 turn
      if (turnP1 == 1) {

        //If stock is empty
        if ((gameP1.stock.size() == 0)||(gameP2.stock.size() == 0)) {
            break; //Breaks out of while-loop
        }

        //If both players have empty hands
        else if ((gameP1.handCards.size() == 0 || gameP2.handCards.size() == 0)) {
            break; //Breaks out of while-loop
        }

        //If game is contiuable
        else {
          this.gameP1.takeTurn();
          turnP1 = 0; //P1 turn over
          turnP2 = 1; //P2 turn now
        }
      }

      //If it's P2 turn
      if (turnP2 == 1) {

        //If stock is empty
        if ((gameP1.stock.size() == 0)||(gameP2.stock.size() == 0)) {
            break; //Breaks out of while-loop
        }

        //If both players have empty hands
        else if ((gameP1.handCards.size() == 0) ||(gameP2.handCards.size() == 0)) {
            break; //Breaks out of while-loop
        }

        //If game is contiuable
        else {
          this.gameP2.takeTurn();
          turnP1 = 1; //P1 turn now
          turnP2 = 0; //P2 turn over
        }
      }

      //If one of the players has an empty hand OR if both players have unplayable cards
      else if ((this.gameP1.handCards.size() == 0) || (this.gameP2.handCards.size() == 0) || ((this.gameP1.takeTurn() == null) && (this.gameP2.takeTurn() == null))) {
        gameIsOver = 1; //Escapes while-loop
      }

    } //End of while-loop

    System.out.println(reportResult(gameP1.handCards, gameP2.handCards)); //Prints the results of the game

  } //End of play method


    public String reportResult (LinkedList<Card> P1HandCards, LinkedList<Card> P2HandCards) {

      String resultsPP = ""; //String of game reuslts to be returned
      int p1_handScore = 0; //The points from the cards in player 1's hand
      int p2_handScore = 0; //The points from the cards in player 2's hand
      int totalScore = 0; //The total score for the winner

      p1_handScore = calScores(P1HandCards); //The points from the cards in player 1's hand
      p2_handScore = calScores(P2HandCards); //The points from the cards in player 2's hand
      totalScore = p1_handScore + p2_handScore; //The total score for the winner

      resultsPP += "********END OF GAME STATS********" + "\n";

      //Player 1 results
      resultsPP += "-PLAYER 1-" + "\n";
      resultsPP += "Cards in hand: " + P1HandCards + "\n";
      resultsPP += "Number of cards in hand: " + P1HandCards.size() + "\n";
      resultsPP += "Points from cards: " + p1_handScore + "\n";

      resultsPP += "\n";

      //Player 2 results
      resultsPP += "-PLAYER 2-" + "\n";
      resultsPP += "Cards in hand: " + P2HandCards + "\n";
      resultsPP += "Number of cards in hand: " + P2HandCards.size() + "\n";
      resultsPP += "Points from cards: " + p2_handScore + "\n";

      resultsPP += "\n";

      resultsPP += "********WINNER********" + "\n";

      //If player 1 has less cards
      if (P1HandCards.size() < P2HandCards.size()){
        resultsPP += "Player 1 is the winner, with a score of " + totalScore + "!\n";
      }

      //If player 2 has less cards
      if (P1HandCards.size() > P2HandCards.size()){
        resultsPP += "Player 2 is the winner, with a score of " + totalScore + "!\n";
      }

      //If both players have the same amount of cards
      if (P1HandCards.size() == P2HandCards.size()){
        resultsPP += "The game is a draw\n";
      }

      return resultsPP;

    } //End of reportResult method


    //Calculates the points of the cards in a player's hand
    public int calScores (LinkedList<Card> handCards) {
      int runningScore = 0;

      //Iterates through each card in the hand
      for (int i=0 ; i< handCards.size(); i++) {
        runningScore = scoreOfCard(handCards.get(i)) + runningScore;
      }

      return runningScore;

    } //End of calScores method


    //Calculates the points of a card
    public int scoreOfCard (Card inputcard){
      int score =0;

      //If the card is an 8 - 50 points
      if (inputcard.getRank() == 8) {
        score = 50;
      }

      //If the card is a Jack, Queen, or King - 10 points
      else if ((inputcard.getRank() == 11) || (inputcard.getRank() == 12) ||(inputcard.getRank() == 13)) {
        score = 10;
      }

      //If the card is an Ace - 1 point
      else if (inputcard.getRank() == 14) {
        score = 1;
      }

      //If the card is a 1, 2, 3, 4, 5, 6, 7, 8, 9, or 10
      else {
        score = inputcard.getRank();
      }

      return score;

    } //End of scoreOfCard method


    //FAILED
    // //Executes play method n number of times
    // public void games(int n) {
    //
    //   for (int i=0; i<n; i++) {
    //     System.out.println("------------GAME " + i + "------------");
    //     Game game = new Game(); //Creates a new game
    //     game.play(); //Plays the new game
    //   }
    //
    // } //End of games method


} //END OF GAME CLASS
