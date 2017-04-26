/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theilluminatigame;
import java.util.ArrayList;
import javax.swing.ImageIcon;
/**
 *
 * @author saidz
 */
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
    private static String violent = "Violent";
    private static String communist = "Communist";
    private static String criminal = "Criminal";
    private static String liberal = "Liberal";
    private static String weird = "Weird";
    private static String conservative = "Conservative";
    private static String peaceful = "Peaceful";
    private static String fanatic = "Fanatic";
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
        Arrow out = new OutgoingArrow();
        ImageIcon face = null;
        Illuminati BavarianIlluminati = new Illuminati("The Bavarian Illuminati",illuminatiCardType,10,10,9,face);
        BavarianIlluminati.setTopArrow(out);
        BavarianIlluminati.setRightArrow(out);
        BavarianIlluminati.setBottomArrow(out);
        BavarianIlluminati.setLeftArrow(out);
        
        Illuminati SocietyOfAssassins = new Illuminati("The Society of Assasins", illuminatiCardType,8,8,8,face);
        SocietyOfAssassins.setTopArrow(out);
        SocietyOfAssassins.setRightArrow(out);
        SocietyOfAssassins.setBottomArrow(out);
        SocietyOfAssassins.setLeftArrow(out);
    
        Illuminati BermudaTriangle = new Illuminati("The Bermuda Triangle",illuminatiCardType,8,8,9,face);
        BermudaTriangle.setTopArrow(out);
        BermudaTriangle.setRightArrow(out);
        BermudaTriangle.setBottomArrow(out);
        BermudaTriangle.setLeftArrow(out);
        
        Illuminati Network = new Illuminati ("The Network", illuminatiCardType,7,7,9,face);
        Network.setTopArrow(out);
        Network.setRightArrow(out);
        Network.setBottomArrow(out);
        Network.setLeftArrow(out);
        
        ///////////////////////////////////////////////////////////////////////
        //              STILL NEED THE REAMAINING ILLUMINATI
        ///////////////////////////////////////////////////////////////////////
        

    }
    public static void initializeGroupsCards() {
	Arrow out = new OutgoingArrow();
	Arrow in = new IncomingArrow();
	int groupCardType = 2;
        ImageIcon face = null;//THIS VARIABLE WILL BE CHANGED TO FIT THE IMAGAGE THAT WILL BE USED IN THE PARAMETER 
	GroupCard FBI = new GroupCard("F.B.I", groupCardType, 4, 2, 6, 0,face);
	FBI.setTopArrow(out);
	FBI.setRightArrow(in);	
	FBI.setBottomArrow(out);
	FBI.setLeftArrow(null);
	FBI.addAlignment(government);
	FBI.addAlignment(straight);
	groupCards[0] = FBI;
        
        GroupCard CloneArrangers = new GroupCard("Clone Arrangers",groupCardType,6,2,6,1,face);
        CloneArrangers.setTopArrow(null);
        CloneArrangers.setRightArrow(out);
        CloneArrangers.setBottomArrow(out);
        CloneArrangers.setLeftArrow(in);
        CloneArrangers.addAlignment(violent);
        CloneArrangers.addAlignment(communist);
        CloneArrangers.addAlignment(criminal);
        groupCards[1] = CloneArrangers;
        
        GroupCard Moonies = new GroupCard("Moonies", groupCardType,2,0,4,3,face);
        Moonies.setTopArrow(out);
        Moonies.setRightArrow(null);
        Moonies.setBottomArrow(null);
        Moonies.setLeftArrow(in);
        Moonies.addAlignment(peaceful);
        Moonies.addAlignment(fanatic);
        groupCards[2] = Moonies;
        
        GroupCard PunkRockers = new GroupCard("Punk Rockers", groupCardType,0,0,4,1,face);
        PunkRockers.setTopArrow(null);
        PunkRockers.setRightArrow(null);
        PunkRockers.setBottomArrow(null);
        PunkRockers.setLeftArrow(in);
        PunkRockers.addAlignment(weird);
        groupCards[3] = PunkRockers;
        
        GroupCard TVPreachers = new GroupCard("TVPreachers", groupCardType,3,0,6,4,face);
        TVPreachers.setTopArrow(null);
        TVPreachers.setRightArrow(in);
        TVPreachers.setBottomArrow(out);
        TVPreachers.setLeftArrow(out);
        TVPreachers.addAlignment(straight);
        TVPreachers.addAlignment(fanatic);
        groupCards[4] = TVPreachers;
        
        GroupCard NewYork = new GroupCard("New York",groupCardType,7,0,8,3,face);
        NewYork.setTopArrow(out);
        NewYork.setRightArrow(in);
        NewYork.setBottomArrow(out);
        NewYork.setLeftArrow(out);
        NewYork.addAlignment(violent);
        NewYork.addAlignment(criminal);
        NewYork.addAlignment(government);
        groupCards[5] = NewYork;
        
        GroupCard MadisonAvenue = new GroupCard("Madison Avenue",groupCardType,3,3,3,2,face);
        MadisonAvenue.setTopArrow(null);
        MadisonAvenue.setRightArrow(out);
        MadisonAvenue.setBottomArrow(out);
        MadisonAvenue.setLeftArrow(out);
        groupCards[6] = MadisonAvenue;
        
        //The resistance for Gun lobby changes to 10 when faced against Communist or weird. Something to think about when we work with rule enforcements
        GroupCard GunLobby = new GroupCard("Gun Lobby", groupCardType,1,0,3,1,face);
        GunLobby.setTopArrow(null);
        GunLobby.setRightArrow(in);
        GunLobby.setBottomArrow(out);
        GunLobby.setLeftArrow(out);
        GunLobby.addAlignment(conservative);
        GunLobby.addAlignment(violent);
        groupCards[7] = GunLobby;
        
        GroupCard California = new GroupCard ("California",groupCardType,5,0,4,5,face);
        California.setTopArrow(out);
        California.setRightArrow(null);
        California.setBottomArrow(out);
        California.setLeftArrow(in);
        California.addAlignment(liberal);
        California.addAlignment(weird);
        California.addAlignment(government);
        groupCards[8] = California;
        
        GroupCard JunkMail = new GroupCard ("Junk Mail",groupCardType,1,0,3,2,face);
        JunkMail.setTopArrow(out);
        JunkMail.setRightArrow(in);
        JunkMail.setBottomArrow(null);
        JunkMail.setLeftArrow(null);
        JunkMail.addAlignment(criminal);
        groupCards[9] = JunkMail;
        
        ///////////////////////////////////////////////////////////////////////
        //              THIS IS ONLY 10 GROUP CARDS
        //////////////////////////////////////////////////////////////////////
        
    }
    public static void initializeSpecialCards() {
	int specialCardType = 3;
        ImageIcon face = null;
        SpecialCard DeepAgent = new SpecialCard("Deep Agent",specialCardType,face);
        
        SpecialCard Assassination = new SpecialCard("Assassination", specialCardType,face);
        
        SpecialCard Bribery = new SpecialCard("Bribery", specialCardType, face);
        
        SpecialCard ComputerEspionage = new SpecialCard("Computer Espionage", specialCardType, face);
        
        SpecialCard Interference = new SpecialCard("Interference", specialCardType, face);
        
        SpecialCard MarketManipulation = new SpecialCard("Market Manipulation", specialCardType, face);
        
        SpecialCard MediaCampaign = new SpecialCard("Media Campaign", specialCardType, face);
        
        SpecialCard MurphysLaw = new SpecialCard("Murphy's Law", specialCardType, face);
        
        SpecialCard Secrets = new SpecialCard("Secreats Man Was Not Meant To Know", specialCardType, face);
         
        SpecialCard Senate = new SpecialCard("Senate Investigating Committee", specialCardType, face);
        
        SpecialCard SlushFund = new SpecialCard("Slush Fund", specialCardType, face);
        
        SpecialCard SwissBankAccount = new SpecialCard("Swiss Bank Account", specialCardType, face);
        
        SpecialCard WhisperingCampaign = new SpecialCard("Whispering Campaign", specialCardType, face);
        
        SpecialCard WhiteCollarCrime = new SpecialCard("White Collar Crime", specialCardType, face);
        
    }
    
    public static void createGameDeck() {
    }
    
    public static boolean checkWinner(Player player) {
	System.out.println("checkWinner returning false for now");
	return false;
    }
}
