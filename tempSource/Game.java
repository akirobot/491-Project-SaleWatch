/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theilluminatigame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
   // private static Illuminati[] illuminatiCards = new Illuminati[4];
     private static ArrayList<Illuminati> illuminatiCards = new ArrayList<Illuminati>();

  //  private static GroupCard[] groupCards = new GroupCard[10];
    
   private static ArrayList<GroupCard> groupCards = new ArrayList<GroupCard>();

    
    // private static SpecialCard[] specialCards = new SpecialCard[15];
    private static ArrayList<SpecialCard> specialCards  = new ArrayList<SpecialCard>();

    
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
	// Initialize Illuminati Cards, Special Cards, and Group Cards
	initializeIlluminatiCards();
	
	initializeSpecialCards();
	initializeGroupsCards();

	// Create players
	// At least 2 players. Max is 8 players
	int totalPlayers = 2;
	createPlayers(totalPlayers);
	// Randomly assign an Illuminati Card to each player
	// Initialize Game Deck
	// gameDeck contains Special Cards and Group Cards
	
	createGameDeck();
	
	createUnControlledArea();

	
	// unControlledArea should have at least 4 Group Cards at beginning of round
	// round
	
	// Find out which player goes first	
	// Every player rolls a dice value
	// If rolling dice values are tied, then let these players roll again until
	// there is one person with the highest roll value
	// First player is determined from roll values
	// Reset all player roll values to 0
	// 1st round starts with the first player going first
	
	
	
		// Assume player 1 goes first for now
	
		// Let's Attack to Destroy
		System.out.println("008 Attack to Destroy");
		
		atkToDestroy(2);
	
		// Whenever UncontrolledArea has less than 2 cards, keep drawing until there are at
		// least 2 cards in uncontrolled Area.
		
	gameOver = false;
	round = 0;
	// While loop stops until game is over
	while(!gameOver){
		// Player draws income, so its treasury changes
		// Player draws a card, if special card, keep it. Else uncontrolledArea gets one Card
		
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
    
    /**
     * 
     * @param choice 
     *  <p> 1 for Attacking a Player's Card 
     *  <p> 2 for Attacking an Uncontrolled Area's Card 
     *  
     */
    public static void atkToDestroy(int choice){
    	// The user can attack another Player's Card
    	if(choice == 1){
    		
    	} else {
    	// The user can attack a Card from the Uncontrolled Group
    		
    		// while loop until attack to destroy is finished
    		/*
    		 while(attackIsDone){
    		 
    		 }
    		 */
    		
    		// Disabled shuffling for testing purposes
    		displayUncontrolledAreaCards();

    		
    		System.out.println("\n009 Player's 1 stat");
    		
    		players.get(0).getIlluminati().displayStats();
    		
    		
    		// Player wants attack to destroy the 1st card from uncontrolledArea
    		System.out.println("\n010 Defender's stat");

    		uncontrolledArea.get(0).displayStats();

    		int attackerIndex = 0;
    		int defenderIndex = 0;
    		
    		Card attacker = players.get(0).getIlluminati();
    		Card defender = uncontrolledArea.get(0);
    		
    		
    	    int atkPower = players.get(0).getIlluminati().getPower();
    	    int defPower = uncontrolledArea.get(0).getPower();
    	    
    	    int powerDifference = atkPower - defPower;
    		System.out.println("\n011 Power difference is " + powerDifference);
    
    		System.out.println("\n012 Player must roll " + powerDifference + " or less." 
    		+ "\nA roll of 11 or 12 is an automatic failure.");
    	    
    		System.out.println("\n013 Assume player rolls dice value is 7");
    		players.get(0).setDiceRoll_TestModeOnly(7);
    		
    		int playerDiceRoll = players.get(0).getDiceRollOutcome();
    		System.out.println("\n014 Player's dice roll value is " + playerDiceRoll);
    		
    		boolean successfulAttack = false;
    		if((playerDiceRoll <= powerDifference) && playerDiceRoll < 11 ){
    			System.out.println("\n015 Successful atk to destroy");
    			successfulAttack = true;
    		} else if(playerDiceRoll == 11 || playerDiceRoll == 12){
    			System.out.println("\n016 Failed atk to destroy");
    		} else {
    			System.out.println("\n017 Failed atk to destroy");
    		}

    		if(successfulAttack){
    			deadPile.add(defender);
    			displayDeadPileCards();
    			uncontrolledArea.remove(defenderIndex);
    		}
    		
    		displayUncontrolledAreaCards();
    	    
    		// If Card is destroyed, it goes to deadPile
    		
    	}
    }
    
    // Create Uncontrolled area for first round
    public static void createUnControlledArea() {
		
			while(uncontrolledArea.size() != 4) {
				
				Card cardDrawn = gameDeck.draw();
				
				if(cardDrawn.getCardType() == 3) {
					System.out.println("005 Drew Special Card from gameDeck: " + cardDrawn.getCardName());
					// Don't put Special Card in uncontrolled Area
					// If this cards get drawn then put it back in the gameDeck
					gameDeck.addCards(cardDrawn);
					
		    		// Disabled shuffling for testing purposes
					//gameDeck.shuffleDeck();
				}
				else{
					// Assume we drew Card type 2 here
					System.out.println("006 Drew Group Card from gameDeck: " + cardDrawn.getCardName());
					// Keep drawing until there is four in the uncontrolled area
					// Add Group Card to uncontrolled Area
					uncontrolledArea.add((GroupCard) cardDrawn);
			}
		} // while
		
			
			displayUncontrolledAreaCards();
		
	}
    
    public static void displayDeadPileCards(){
    	// Display deadPile cards
		System.out.println("\n020 Dead Pile consists of these cards" );
		for(int i = 0 ;  i < deadPile.size(); i++){
	 		    System.out.println("\t" + i + ": " + deadPile.get(i).getCardName());
			 
		}
    }
    
    public static void displayUncontrolledAreaCards(){
    	// Display uncontrolledArea cards
		System.out.println("\n007 Uncontrolled Area consists of these cards" );
		for(int i = 0 ;  i < uncontrolledArea.size(); i++){
	 		    System.out.println("\t" + i + ": " + uncontrolledArea.get(i).getCardName());
			 
		}
    }

	public static void createPlayers(int totalNumOfPlayers) {
    	
    	if(totalNumOfPlayers > 1 && totalNumOfPlayers < 9){
    		
    		
        	for(int i = 0; i < totalNumOfPlayers; i++){
        		players.add(new Player());
        	}
        
        	// Assign Illuminati Cards
        	for(int i = 0; i < totalNumOfPlayers; i++){
        		players.get(i).setIlluminati(illuminatiCards.get(i));
        	}
        		
        	for(int i = 0; i < totalNumOfPlayers; i++){
        		System.out.println("000a Player " + i + "'s Illuminati: " + players.get(i).getIlluminati().getCardName());
        	}
        	
    	}
    	
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
        illuminatiCards.add(BavarianIlluminati);
        
        Illuminati SocietyOfAssassins = new Illuminati("The Society of Assasins", illuminatiCardType,8,8,8,face);
        SocietyOfAssassins.setTopArrow(out);
        SocietyOfAssassins.setRightArrow(out);
        SocietyOfAssassins.setBottomArrow(out);
        SocietyOfAssassins.setLeftArrow(out);
        illuminatiCards.add(SocietyOfAssassins);
        
        Illuminati BermudaTriangle = new Illuminati("The Bermuda Triangle",illuminatiCardType,8,8,9,face);
        BermudaTriangle.setTopArrow(out);
        BermudaTriangle.setRightArrow(out);
        BermudaTriangle.setBottomArrow(out);
        BermudaTriangle.setLeftArrow(out);
        illuminatiCards.add(BermudaTriangle);
        
        Illuminati Network = new Illuminati ("The Network", illuminatiCardType,7,7,9,face);
        Network.setTopArrow(out);
        Network.setRightArrow(out);
        Network.setBottomArrow(out);
        Network.setLeftArrow(out);
        illuminatiCards.add(Network);
        
        ///////////////////////////////////////////////////////////////////////
        //              STILL NEED THE REAMAINING ILLUMINATI
        ///////////////////////////////////////////////////////////////////////
        

    }
    public static void initializeGroupsCards() {
	Arrow out = new OutgoingArrow();
	Arrow in = new IncomingArrow();
	int groupCardType = 2;
        ImageIcon face = null;//THIS VARIABLE WILL BE CHANGED TO FIT THE IMAGAGE THAT WILL BE USED IN THE PARAMETER 
	GroupCard FBI = new GroupCard("F.B.I.", groupCardType, 4, 2, 6, 0,face);
	FBI.setTopArrow(out);
	FBI.setRightArrow(in);	
	FBI.setBottomArrow(out);
	FBI.setLeftArrow(null);
	FBI.addAlignment(government);
	FBI.addAlignment(straight);
	groupCards.add( FBI);
	
        
        GroupCard CloneArrangers = new GroupCard("Clone Arrangers",groupCardType,6,2,6,1,face);
        CloneArrangers.setTopArrow(null);
        CloneArrangers.setRightArrow(out);
        CloneArrangers.setBottomArrow(out);
        CloneArrangers.setLeftArrow(in);
        CloneArrangers.addAlignment(violent);
        CloneArrangers.addAlignment(communist);
        CloneArrangers.addAlignment(criminal);
        groupCards.add( CloneArrangers);
      
        
        GroupCard Moonies = new GroupCard("Moonies", groupCardType,2,0,4,3,face);
        Moonies.setTopArrow(out);
        Moonies.setRightArrow(null);
        Moonies.setBottomArrow(null);
        Moonies.setLeftArrow(in);
        Moonies.addAlignment(peaceful);
        Moonies.addAlignment(fanatic);
        groupCards.add( Moonies);
        
        GroupCard PunkRockers = new GroupCard("Punk Rockers", groupCardType,0,0,4,1,face);
        PunkRockers.setTopArrow(null);
        PunkRockers.setRightArrow(null);
        PunkRockers.setBottomArrow(null);
        PunkRockers.setLeftArrow(in);
        PunkRockers.addAlignment(weird);
        groupCards.add( PunkRockers);
        
        GroupCard TVPreachers = new GroupCard("TV Preachers", groupCardType,3,0,6,4,face);
        TVPreachers.setTopArrow(null);
        TVPreachers.setRightArrow(in);
        TVPreachers.setBottomArrow(out);
        TVPreachers.setLeftArrow(out);
        TVPreachers.addAlignment(straight);
        TVPreachers.addAlignment(fanatic);
        groupCards.add( TVPreachers);
        
        GroupCard NewYork = new GroupCard("New York",groupCardType,7,0,8,3,face);
        NewYork.setTopArrow(out);
        NewYork.setRightArrow(in);
        NewYork.setBottomArrow(out);
        NewYork.setLeftArrow(out);
        NewYork.addAlignment(violent);
        NewYork.addAlignment(criminal);
        NewYork.addAlignment(government);
        groupCards.add(NewYork);
        
        GroupCard MadisonAvenue = new GroupCard("Madison Avenue",groupCardType,3,3,3,2,face);
        MadisonAvenue.setTopArrow(null);
        MadisonAvenue.setRightArrow(out);
        MadisonAvenue.setBottomArrow(out);
        MadisonAvenue.setLeftArrow(out);
        groupCards.add(MadisonAvenue);
        
        //The resistance for Gun lobby changes to 10 when faced against Communist or weird. Something to think about when we work with rule enforcements
        GroupCard GunLobby = new GroupCard("Gun Lobby", groupCardType,1,0,3,1,face);
        GunLobby.setTopArrow(null);
        GunLobby.setRightArrow(in);
        GunLobby.setBottomArrow(out);
        GunLobby.setLeftArrow(out);
        GunLobby.addAlignment(conservative);
        GunLobby.addAlignment(violent);
        groupCards.add( GunLobby);
        
        GroupCard California = new GroupCard ("California",groupCardType,5,0,4,5,face);
        California.setTopArrow(out);
        California.setRightArrow(null);
        California.setBottomArrow(out);
        California.setLeftArrow(in);
        California.addAlignment(liberal);
        California.addAlignment(weird);
        California.addAlignment(government);
        groupCards.add(California);
        
        GroupCard JunkMail = new GroupCard ("Junk Mail",groupCardType,1,0,3,2,face);
        JunkMail.setTopArrow(out);
        JunkMail.setRightArrow(in);
        JunkMail.setBottomArrow(null);
        JunkMail.setLeftArrow(null);
        JunkMail.addAlignment(criminal);
        groupCards.add( JunkMail);
        
        
    
        
        ///////////////////////////////////////////////////////////////////////
        //              THIS IS ONLY 10 GROUP CARDS
        //////////////////////////////////////////////////////////////////////
        
    }
    public static void initializeSpecialCards() {
	int specialCardType = 3;
        ImageIcon face = null;
        
        SpecialCard Assassination = new SpecialCard("Assassination", specialCardType,face);
        specialCards.add(Assassination);
        SpecialCard Bribery = new SpecialCard("Bribery", specialCardType, face);
        specialCards.add(Bribery);
        SpecialCard ComputerEspionage = new SpecialCard("Computer Espionage", specialCardType, face);
        
        SpecialCard DeepAgent = new SpecialCard("Deep Agent",specialCardType,face);

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
    	gameDeck = new Deck();
    	System.out.println("001 createGameDeck");
    	// Add special cards later
    	//SpecialCard.length();
    	
    	// Add group cards for now
    	System.out.println("002 groupCards's size is " + groupCards.size());

    	// Print out first card in groupCards array
    	System.out.println("003 first card in groupCards array " + groupCards.get(0).getCardName());
    	
    	for(int i = 0; i < groupCards.size(); i++){
    		gameDeck.addCards(groupCards.get(i));
    	}
    
    	// display not-shuffled deck
    	gameDeck.displayAllCards();
    	
    	// shuffle Deck
    	
		// Disabled shuffling for testing purposes
    	//gameDeck.shuffleDeck();
    	System.out.println("004 shuffled the game deck ");
    	
    	// display shuffled deck
    	gameDeck.displayAllCards();

    	
    	
    }
    
    public static boolean checkWinner(Player player) {
	System.out.println("999 checkWinner returning false for now");
	return false;
    }
}


/**
 * OUTPUT as of 4/26/17 11:57 AM PDT
Main method...
000a Player 0's Illuminati: The Bavarian Illuminati
000a Player 1's Illuminati: The Society of Assasins
001 createGameDeck
002 groupCards's size is 10
003 first card in groupCards array F.B.I.
101 deck.size() is 10
	0: F.B.I.
	1: Clone Arrangers
	2: Moonies
	3: Punk Rockers
	4: TV Preachers
	5: New York
	6: Madison Avenue
	7: Gun Lobby
	8: California
	9: Junk Mail
004 shuffled the game deck 
101 deck.size() is 10
	0: F.B.I.
	1: Clone Arrangers
	2: Moonies
	3: Punk Rockers
	4: TV Preachers
	5: New York
	6: Madison Avenue
	7: Gun Lobby
	8: California
	9: Junk Mail
006 Drew Group Card from gameDeck: Junk Mail
006 Drew Group Card from gameDeck: California
006 Drew Group Card from gameDeck: Gun Lobby
006 Drew Group Card from gameDeck: Madison Avenue

007 Uncontrolled Area consists of these cards
	0: Junk Mail
	1: California
	2: Gun Lobby
	3: Madison Avenue
008 Attack to Destroy

007 Uncontrolled Area consists of these cards
	0: Junk Mail
	1: California
	2: Gun Lobby
	3: Madison Avenue

009 Player's 1 stat
102 Display Stats for The Bavarian Illuminati
	 Power: 10
	 tPower: 10
	 treasury: 0
	 income: 9

010 Defender's stat
103 Display Stats for Junk Mail
	 Power: 0
	 tPower: 0
	 tPower: 3
	 treasury: 0
	 income: 0

011 Power difference is 10

012 Player must roll 10 or less.
A roll of 11 or 12 is an automatic failure.

013 Assume player rolls dice value is 7

014 Player's dice roll value is 7

015 Successful atk to destroy

020 Dead Pile consists of these cards
	0: Junk Mail

007 Uncontrolled Area consists of these cards
	0: California
	1: Gun Lobby
	2: Madison Avenue
End Game

 */
