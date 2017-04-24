import java.util.ArrayList;

public class Game {

    private static ArrayList<Player> players = new ArrayList<Player>();

    private static Illuminati[] illuminatiCards = new Illuminati[8];

    private static Group[] groupCards = new Group[83];

    private static SpecialCard[] specialCards = new SpecialCard[15];

    private static ArrayList<Deck> gameDeck = new ArrayList<Deck>();

    private static ArrayList<Group> deadPile = new ArrayList<Group>();

    private static ArrayList<Group> uncontrolledArea = new ArrayList<Group>();

    private static boolean gameOver;

    public static void main(String[] args) {
	System.out.println("Main method...");
	Group g1 = new Group("hi", 1, 2, 3, 4, 2);
	g1.getPower();

    }

    public void createPlayers(){
	
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
