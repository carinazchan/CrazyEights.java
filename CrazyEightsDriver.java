/**
* The CrazyEightsDriver class stores the main method for driving Player & Game
* @author Carina Zelda Chan
* @version 1.0
* @see Card, Deck, TestCards, Player, & Game
*/

/* CHAPMAN STANDARDS
2367721
carchan@chapman.edu
CPSC-231-04
Mastery Project 3B: Crazy Eights! - Game.java
*/


public class CrazyEightsDriver {

  public static void main(String[] args) {

    System.out.println("------------GAME 1------------");
    Game game1 = new Game(); //Creates a new game
    game1.play(); //Plays the new game, game1

    System.out.println("------------GAME 2------------");
    Game game2 = new Game(); //Creates a new game
    game2.play(); //Plays the new game, game2

    System.out.println("------------GAME 3------------");
    Game game3 = new Game(); //Creates a new game
    game3.play(); //Plays the new game, game3

  } //End of main method



} //END OF CRAZYEIGHTSDRIVER CLASS
