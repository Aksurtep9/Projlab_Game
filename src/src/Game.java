package src;

import java.util.List;

/**
 * 
 * @author Vili
 * Game
 * This class counts the number of rounds, stores the player who is moving now 
 * and in the previous round and stores all the players playing in this game.
 * This is where building of the map starts. Stores the maximum number of
 * genetic codes that can be learnt. 
 */
public class Game {
	
	/**
	 * The number of players in current game.
	 */
	int playerCount;
	
	/**
	 * The number of rounds played.
	 */
	int roundCount;
	
	/**
	 * The number of genetic codes that can be learnt.
	 */
	static final int maxGenCode;
	
	/**
	 * The player who can currently move and interact with other things.
	 */
	Virologist currentPlayer;
	
	/**
	 * The player who could currently move and interact with other things in the
	 * previous round.
	 */
	Virologist previousPlayer;
	
	/**
	 * The list of current players.
	 */
	List<Virologist> players;
	
	/**
	 * It stores the map.
	 */
	Map map;
	
	
	/**
	 * It starts a new game.
	 */
	void NewGame() {
		
	}
	
	/**
	 * It ends the game and declares the winner.
	 */
	void EndGame() {
		
	}
	
	/**
	 * This method is called every time a Virologist learns a genetic code and checks
	 * if it has learnt all of them.
	 * @return Did the virologist learn all the genetic codes.
	 */
	public boolean CheckWin() {
		
	}
	
	/**
	 * This method sets the next player in the next round. Decreases the effect time 
	 * and crafted agents' time for the previous player. All the effects will affect the
	 * current player.
	 */
	public void NewRound() {
		
	}
}
