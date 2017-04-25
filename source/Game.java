import java.util.ArrayList;

// Game logic
// Convert Flowchart into code

public class Game {

    private static ArrayList<Player> players = new ArrayList<Player>();

    /** For simplicity, we will create fewer cards for now */
    // private static Illuminati[] illuminatiCards = new Illuminati[8];
    private static Illuminati[] illuminatiCards = new Illuminati[4];

    // private static Group[] groupCards = new Group[83];
    private static GroupCard[] groupCards = new GroupCard[8];

    // private static SpecialCard[] specialCards = new SpecialCard[15];
    private static SpecialCard[] specialCards = new SpecialCard[4];

    private static Deck gameDeck = new Deck();

    private static ArrayList<Card> deadPile = new ArrayList<Card>();

    private static ArrayList<GroupCard> uncontrolledArea = new ArrayList<GroupCard>();

    private static boolean gameOver;
    
    private static int round;

    // Alignments
    private static String government = "Government";
    private static String straight = "Straight";

   
    // Main method will be called from gameUI.java later
    // This main method in Game.java is temporary for now
    public static void main(String[] args) {
	System.out.println("Main method...");

	gameLoop();

    }
    
    /**
     * Game logic is based on the flowchart
     */
    public static void gameLoop() {
	
	// Initialize Illuminati Cards
	initializeIlluminatiCards();

	// Create players
	// At least 2 players. Max is 8 players
	int totalPlayers = 4;
	createPlayers(totalPlayers);

	// Randomly assign an Illuminati Card to each player

	// Initialize Game Deck
	// gameDeck contains Special Cards and Group Cards

	// unControlledArea should have at least 4 Group Cards at beginning of round
	// round

	// Find out which player goes first

	// Every player rolls a dice value
	
	// If rolling dice values are tied, then let these players roll again until
	// there is one person with the highest roll value
	
	// First player is determined from roll values
	// Reset all player roll values to 0
	
	// 1st round starts with the first player going first
	
	gameOver = false;
	round = 0;
	
	// While loop stops until game is over
	while(!gameOver){
	    
	    // 1) Player can pass a turn
	    // 2) Player can take actions if available - Check player's actionsTaken value
	    // 3) Player can take free actions
	    // 4) Player can give up
	    // 5) Player is done with turn
	    
	    // Next player starts
	    
	    // A player meets a win condition (Basic Goal or Special Goal)
	    gameOver = true;
	}
	
	System.out.println("End Game");
	
	
    }

    public static void createPlayers(int totalNumOfPlayers) {

    }

    public static void initializeIlluminatiCards() {
	int illuminatiCardType = 1;

    }

    public static void initializeGroupsCards() {
	
	Arrow out = new OutgoingArrow();
	Arrow in = new IncomingArrow();
	int groupCardType = 2;
	
	GroupCard FBI = new GroupCard("F.B.I", groupCardType, 4, 2, 6, 0);
	
	FBI.setTopArrow(out);
	FBI.setRightArrow(in);	
	FBI.setBottomArrow(out);
	FBI.setLeftArrow(null);
	FBI.addAlignment(government);
	FBI.addAlignment(straight);
	
	groupCards[0] = FBI;
    }

    public static void initializeSpecialCards() {
	int specialCardType = 3;

    }

    public static void createGameDeck() {

    }

    public static boolean checkWinner(Player player) {
	System.out.println("checkWinner returning false for now");
	return false;
    }

}
