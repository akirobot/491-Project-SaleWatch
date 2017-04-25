import java.util.ArrayList;

// Game logic
// Convert Flowchart into code

public class Game {

    private static ArrayList<Player> players = new ArrayList<Player>();
    
    /** For simplicity, we will create fewer cards for now */
    //private static Illuminati[] illuminatiCards = new Illuminati[8];
    private static Illuminati[] illuminatiCards = new Illuminati[4];

    //private static Group[] groupCards = new Group[83];
    private static Group[] groupCards = new Group[8];

    //private static SpecialCard[] specialCards = new SpecialCard[15];
    private static SpecialCard[] specialCards = new SpecialCard[4];

    private static Deck gameDeck = new Deck();

    private static ArrayList<Group> deadPile = new ArrayList<Group>();

    private static ArrayList<Group> uncontrolledArea = new ArrayList<Group>();

    private static boolean gameOver;

    public static void main(String[] args) {
	System.out.println("Main method...");
	//Group g1 = new Group("hi", 1, 2, 3, 4, 2);
	//g1.getPower();
	
	int totalPlayers = 4;
	createPlayers(totalPlayers);
	    
	// Find out which player goes first
	

    }

    public static void createPlayers(int totalNumOfPlayers){
	   
    }
    
    public static void initializeIlluminatiCards() {

    }

    public static void initializeOtherGroupsCards() {

    }

    public static void initializeSpecialCards() {

    }
    
    public static void createGameDeck(){
	
    }

    public static boolean checkWinner(Player player) {
	System.out.println("checkWinner returning false for now");
	return false;
    }

 
    
   

}
