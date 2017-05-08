/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theilluminatigame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.ImageIcon;

/**
 * 
 * @authors saidz, ly
 */
// Game logic
// Convert Flowchart into code
public class Game {

    private static ArrayList<Player> players = new ArrayList<Player>();
    private static ArrayList<Illuminati> illuminatiCards = new ArrayList<Illuminati>();
    private static ArrayList<GroupCard> groupCards = new ArrayList<GroupCard>();
    private static ArrayList<SpecialCard> specialCards = new ArrayList<SpecialCard>();
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
        System.out.println("*** Welcome to Illuminati! ***\n");

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
        assignIDsToGroupCards();
        // Create players
        // At least 2 players. Max is 8 players
        int totalPlayers = 2;
        createPlayers(totalPlayers);
        // Randomly assign an Illuminati Card to each player
        // Initialize Game Deck
        // gameDeck contains Special Cards and Group Cards

        createGameDeck();

        createUnControlledArea();

        // unControlledArea should have at least 4 Group Cards at beginning of
        // round

        // Find out which player goes first
        // Every player rolls a dice value
        // If rolling dice values are tied, then let these players roll again
        // until
        // there is one person with the highest roll value
        // First player is determined from roll values
        // Reset all player roll values to 0
        // 1st round starts with the first player going first

        int playersTurn = determineWhoGoesFirst();

        // players arrayList has 2 players total, (0) 1st player, (1) 2nd player
        // for simplicity for now, we assume Player 0 goes first.
        // int playersTurn = 0;
        // When the first player is done with his turn, we go counter-clockwise
        // by decrementing the order

        // Pretend there's 7 players. That means the players arrayList size is 7
        // So if the index is 0, which gets decremented to -1, the next player
        // will be index 6

        /*
         * playersTurn--; if(playersTurn < 0){ playersTurn = players.size() - 1;
         * }
         */

        //
        //
        // for(int i = 0; i < groupCards.size()-6; i++){
        // testPStrans.add(groupCards.get(i));
        // }
        //
        // for(int i = 0; i < testPStrans.size(); i++){
        // System.out.println("44444 " + i + ": " +
        // testPStrans.get(i).getCardName());
        // }

        int Top = 1;
        int Bottom = 2;
        int Left = 3;
        int Right = 4;

        /*
         * // Assume player 1 goes first for now, Collects income
         * 
         * // Let's Attack to Destroy
         * System.out.println("008 Attack to Destroy");
         * 
         * int attackEnemyPowerStructure = 1; int attackUncontrolled= 2;
         * atkToDestroy(attackUncontrolled);
         * 
         * // Let's Attack to Control atkToControl(attackUncontrolled);
         * 
         * // Whenever UncontrolledArea has less than 2 cards, keep drawing
         * until there are at // least 2 cards in uncontrolled Area.
         */
        gameOver = false;
        round = 0;
        // While loop stops until game is over
        while (!gameOver) {
        // Player draws income, so its treasury changes

        System.out.println("0000b Round " + (round + 1) + " starts.");

        System.out.println("0000c Player draws income for his cards. ");
        drawIncome(playersTurn);

        // Player draws a card from a gameDeck, if special card, keep it.
        // Else
        // uncontrolledArea gets one Card

        if (gameDeck.getDeckSize() > 0) {
        drawCardGameDeck(playersTurn);
        } else {
        System.out.println("Game Deck is out of cards.");
        }

        boolean done = false;

        while (!done) {
        System.out.println("\n***MENU***");
        System.out.println("What would you like to do?");
        System.out.println("1. Pass a turn\n" + "2. Take actions\n" + "3. Take free actions\n"
                + "4. View your stats\n" + "5. Finish turn\n" + "6. End game\n");

        int highestRange = 6, lowestRange = 1;
        int inputMenuChoice = CheckInput.checkIntRange(lowestRange, highestRange);

        if (inputMenuChoice == 1) {
        System.out.println("Pass a turn *UNDER CONSTRUCTION* ");
        done = true;
        round++;
        players.get(playersTurn).resetAction();
        players.get(playersTurn).resetDiceValue();
        checkUnControlledAreaAtEndOfTurn();

        } else if (inputMenuChoice == 2) {
        System.out.println("Take actions *UNDER CONSTRUCTION* ");
        takeActions(playersTurn);
        } else if (inputMenuChoice == 3) {
        System.out.println("Take free actions *UNDER CONSTRUCTION* ");
        } else if (inputMenuChoice == 4) {
        System.out.println("View your stats *UNDER CONSTRUCTION* ");
        } else if (inputMenuChoice == 5) {
        System.out.println("Finish turn *UNDER CONSTRUCTION* ");
        System.out.println("Next Player's turn should start");
        done = true;
        round++;
        players.get(playersTurn).resetAction();
        players.get(playersTurn).resetDiceValue();
        checkUnControlledAreaAtEndOfTurn();
        } else if (inputMenuChoice == 6) {
        System.out.println("End game");
        gameOver = true;
        done = true;
        }
        }

        // Can add more menu choices later

        // 1) Player can pass a turn
        // 2) Player can take actions if available - Check player's
        // actionsTaken value
        // 3) Player can take free actions
        // 4) View Player's stats
        // 5) Player is done with turn < Higher priority to implement since
        // it's easier to implement
        // Next player starts
        // playersTurn--;
        // if(playersTurn < 0){
        // playersTurn = players.size() - 1;
        // }

        // When player is done, reset his actions and dice roll values
        // players.get(playersTurn).resetAction();
        // players.get(playersTurn).resetDiceValue();

        // Make sure there is at least 2 cards in uncontrolledArea
        // A player meets a win condition (Basic Goal or Special Goal)

        }

    }

    public static void takeActions(int player) {
        // Keep player's actions count in mind
        // Can only take two actions per turn

        while (players.get(player).getActionsTaken() < 2) {
        System.out.println("***ACTIONS MENU***");

        System.out.println("Your actions taken: " + players.get(player).getActionsTaken());
        System.out.println("What would you like to do?");
        System.out.println("1. Attack to Control\n" + "2. Attack to Destroy\n"
                + "3. Attack To Neutralize\n" + "4. Exit menu");

        int highestRange = 4, lowestRange = 1;
        int inputMenuChoice = CheckInput.checkIntRange(lowestRange, highestRange);

        if (inputMenuChoice == 1) {
        System.out.println("Attack to Control *UNDER CONSTRUCTION* ");
        atkToControl(player);
        // players.get(player).takeAction(); // move
        // players.get(player).takeAction()
        // to atkToControl,
        // atkToNeut methods later

        } else if (inputMenuChoice == 2) {
        System.out.println("Attack to Destroy *UNDER CONSTRUCTION* ");
        atkToDestroy(player);

        } else if (inputMenuChoice == 3) {
        System.out.println("Attack To Neutralize *UNDER CONSTRUCTION* ");
        players.get(player).takeAction();

        } else if (inputMenuChoice == 4) {
        System.out.println("Exit menu ");
        break;
        }

        }

        System.out.println("Your actions taken: " + players.get(player).getActionsTaken());

        if (players.get(player).getActionsTaken() >= 2) {
        System.out.println("You are out of regular actions.");
        }

    }

    public static void drawCardGameDeck(int player) {

        Card cardDrawn = gameDeck.draw();

        if (cardDrawn.getCardType() == 3) {
        System.out.println("005a Player Drew Special Card from gameDeck: "
                + cardDrawn.getCardName());
        // Don't put Special Card in uncontrolled Area
        // If this cards get drawn then put it back in the gameDeck
        players.get(player).addSpecialCard((SpecialCard) cardDrawn);

        // Disabled shuffling for testing purposes
        // gameDeck.shuffleDeck();
        } else {
        // Assume we drew Card type 2 here
        System.out.println("006a Player Drew Group Card from gameDeck: " + cardDrawn.getCardName());
        // Keep drawing until there is four in the uncontrolled area
        // Add Group Card to uncontrolled Area
        uncontrolledArea.add((GroupCard) cardDrawn);
        }

        displayUncontrolledAreaCards();

    }

    public static void drawIncome(int playersIndex) {
        // players.get(playersIndex).getIlluminati().getIncomeDefault();

        // Illuminati draws Income
        players.get(playersIndex).getIlluminati().addIncomeAtStartOfTurn();

        // We need Illuminati's puppets to draw income too later

    }

    // Not randomized for now
    public static int determineWhoGoesFirst() {
        int totalPlayers = players.size();
        int setValue = 7;
        int max = 0;
        int indexOfPlayerWithMax = 0;
        for (int i = 0; i < totalPlayers; i++) {
        players.get(i).setDiceRoll_TestModeOnly(setValue);
        if (players.get(i).getDiceRollOutcome() > max) {
        max = players.get(i).getDiceRollOutcome();
        indexOfPlayerWithMax = i;
        }
        }

        setValue++;
        players.get(0).setDiceRoll_TestModeOnly(setValue);

        System.out.println("0000a Player #0 goes first for now.");

        // Reset all player's dice roll value to 0

        for (int i = 0; i < totalPlayers; i++) {
        players.get(i).setDiceRoll_TestModeOnly(0);
        }

        // return indexOfPlayerWithMax;
        return 0;

    }

    // Pass a turn: If at start of turn, players get +5. Maybe give to
    // Illuminati the 5 MegaBucks
    // To check if start of turn, then player's actions taken must be 0 and no
    // free actions taken
    // If player's take action, remove the option of passing a turn. So in that
    // case, player must
    // say he is done with his turn instead.
    public static void passTurn(Player p) {

    }

    public static void atkToControl(int player) {

        System.out.println("***ATTACK TO CONTROL MENU***");
        System.out.println("1. Attack another player's power structure\n"
                + "2. Attack a Group Card from the Uncontrolled Area\n"
                + "3. Cancel Attack to Control\n");
        int highestRange = 3;
        int lowestRange = 1;
        int choice = CheckInput.checkIntRange(lowestRange, highestRange);

        boolean done = false;

        while (!done) {
        // The user can attack another Player's Card
        if (choice == 1) {
        // players.get(player).takeAction();
        System.out.println("0010a atkToControlanother player is under construction");
        // players.get(player).takeAction();
        } else if (choice == 2) {
        System.out
                .println("0010a Attack To Control another Group Card from Uncontrolled Area is under construction");
        System.out.println("0010b TEST SAMPLE SCENARIO FOR ATK TO CONTROL");

        highestRange = 3;
        lowestRange = 1;
        System.out.println("1. Attack with your Illuminati\n" + "2. Attack with your Group Card\n"
                + "3. Cancel selection\n");
        choice = CheckInput.checkIntRange(lowestRange, highestRange);

        if (choice == 1) {
        System.out.println("0010aa Attack with your Illuminati");
        if (players.get(player).getIlluminati().canAtkToControl()) {
        System.out.println("0010aaa Attack with your Illuminati processing");

        // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        // Disabled shuffling for testing purposes
        displayUncontrolledAreaCards();

        // players.get(0).getIlluminati()

        System.out.println("\n009 Player's Illuminati's stat");

        players.get(player).getIlluminati().displayStats();

        // Player wants attack to control the 1st card from
        // uncontrolledArea
        System.out.println("\n010 Defender's stat");

        uncontrolledArea.get(0).displayStats();
        int attackerIndex = 0;
        int defenderIndex = 0;

        Card attacker = players.get(player).getIlluminati();
        GroupCard defender = uncontrolledArea.get(0);

        int atkPower = players.get(player).getIlluminati().getPower();
        int defResistance = uncontrolledArea.get(0).getResistance();

        int powerAndResistDifference = atkPower - defResistance;
        System.out.println("\n011 Power and Resistance difference is " + powerAndResistDifference);

        int powerDifference = atkPower - defResistance;
        System.out.println("\n011 Power difference is " + powerDifference);

        System.out.println("\n012 Player must roll " + powerDifference + " or less."
                + "\nA roll of 11 or 12 is an automatic failure.");

        System.out.println("\n013 Assume player rolls dice value is 4");
        players.get(0).setDiceRoll_TestModeOnly(4);

        int playerDiceRoll = players.get(player).getDiceRollOutcome();
        System.out.println("\n014 Player's dice roll value is " + playerDiceRoll);

        boolean successfulAttack = false;
        if ((playerDiceRoll <= powerDifference) && playerDiceRoll < 11) {
        System.out.println("\n015 Successful atk to control");
        successfulAttack = true;
        } else if (playerDiceRoll == 11 || playerDiceRoll == 12) {
        System.out.println("\n016 Failed atk to control");
        } else {
        System.out.println("\n017 Failed atk to control");
        }

        if (successfulAttack) {
        // add to players illluminati
        // or add to a group card
        // displayDeadPileCards();

        players.get(0).getIlluminati();

        int Top = 1;
        int Bottom = 2;
        int Left = 3;
        int Right = 4;

        System.out.println("494 Select direction for your Illuminati Card \n");
        highestRange = 4;
        lowestRange = 1;
        boolean doneAdding = false;

        while (!doneAdding) {

        System.out.println("1. Top\n" + "2. Bottom\n" + "3. Left\n" + "4. Right\n");
        int directionChoice = CheckInput.checkIntRange(lowestRange, highestRange);

        if (players.get(player).getIlluminati().canAddToThisArrow(directionChoice)) {
        System.out.println("495a Can add to this arrow");
        players.get(player).getIlluminati().addPuppetWithArrow(uncontrolledArea.get(defenderIndex),
                directionChoice);

        doneAdding = true;
        } else {
        System.out.println("495 You can't add to an already occupied arrow.");
        }

        }
        players.get(player).getIlluminati().printOutAvailableAndOccupiedArrows();
        uncontrolledArea.remove(defenderIndex);
        }

        displayUncontrolledAreaCards();

        players.get(player).takeAction();
        // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        } else {
        System.out
                .println("0010aab You don't have any available outgoing arrows for your Illuminati.");

        }
        } else if (choice == 2) {
        if (players.get(player).getIlluminati().getPuppetSize() == 0) {

        System.out.println("00010cc You don't have any Group Cards");
        } else {

        System.out.println("0010bb Attack with your Group Card");

        System.out.println("Select the Group Card you would like to attack with");

        for (int i = 0; i < players.get(player).getIlluminati().getPuppetSize(); i++) {
        System.out.println("(" + i + ") "
                + players.get(player).getIlluminati().getPuppet(i).getCardName());

        }

        int highestGroupCardChoice = players.get(player).getIlluminati().getPuppetSize() - 1;
        int lowestGroupCardChoice = 0;

        int groupCardChoice = CheckInput.checkIntRange(lowestGroupCardChoice,
                highestGroupCardChoice);
        GroupCard attacker = players.get(player).getIlluminati().getPuppet(groupCardChoice);

        // ********************************************
        System.out.println("0010aa Attack with your Group Card: " + attacker.getCardName());
        if (attacker.canAtkToControl()) {
        System.out.println("0010aaa Attack with your GroupCard processing");

        // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        // Disabled shuffling for testing purposes
        displayUncontrolledAreaCards();

        // players.get(0).getIlluminati()

        System.out.println("\n009 Player's Group Card's stat");

        attacker.displayStats();

        // Player wants attack to control the 1st card from
        // uncontrolledArea
        System.out.println("\n010 Defender's stat");

        uncontrolledArea.get(0).displayStats();
        int attackerIndex = 0;
        int defenderIndex = 0;

        GroupCard defender = uncontrolledArea.get(0);

        // for testing purpose, buff up power of attackr
        int tempPowerBuff = 15;
        int atkPower = attacker.getPower() + tempPowerBuff;
        int defResistance = uncontrolledArea.get(0).getResistance();

        int powerAndResistDifference = atkPower - defResistance;
        System.out.println("\n011 Power and Resistance difference is " + powerAndResistDifference);

        int powerDifference = atkPower - defResistance;
        System.out.println("\n011 Power difference is " + powerDifference);

        System.out.println("\n012 Player must roll " + powerDifference + " or less."
                + "\nA roll of 11 or 12 is an automatic failure.");

        System.out.println("\n013 Assume player rolls dice value is 4");
        players.get(0).setDiceRoll_TestModeOnly(4);

        int playerDiceRoll = players.get(player).getDiceRollOutcome();
        System.out.println("\n014 Player's dice roll value is " + playerDiceRoll);

        boolean successfulAttack = false;
        if ((playerDiceRoll <= powerDifference) && playerDiceRoll < 11) {
        System.out.println("\n015 Successful atk to control");
        successfulAttack = true;
        } else if (playerDiceRoll == 11 || playerDiceRoll == 12) {
        System.out.println("\n016 Failed atk to control");
        } else {
        System.out.println("\n017 Failed atk to control");
        }

        if (successfulAttack) {
        // add to players illluminati
        // or add to a group card
        // displayDeadPileCards();

        int Top = 1;
        int Bottom = 2;
        int Left = 3;
        int Right = 4;

        // Keep in mind Group cards can have 0 to 3 outgoing arrows
        System.out.println("494 Select direction for your Group Card \n");
        highestRange = 4;
        lowestRange = 1;
        boolean doneAdding = false;

        while (!doneAdding) {

        System.out.println("1. Top\n" + "2. Bottom\n" + "3. Left\n" + "4. Right\n");
        int directionChoice = CheckInput.checkIntRange(lowestRange, highestRange);

        if (attacker.canAddToThisArrow(directionChoice)) {
        System.out.println("495a Can add to this arrow");
        attacker.addPuppetWithArrow(uncontrolledArea.get(defenderIndex), directionChoice);

        doneAdding = true;
        } else {
        System.out
                .println("495 You can't add to an already occupied arrow. Or your Group Card does not have that specific outgoing arrow.");
        }

        }
        attacker.printOutAvailableAndOccupiedArrows();
       attacker.printOutAvailableAndOccupiedArrows();
        uncontrolledArea.remove(defenderIndex);
        }

        displayUncontrolledAreaCards();

        players.get(player).takeAction();
        // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        } else {
        System.out
                .println("00101aab You don't have any available outgoing arrows for your Group Card.");

        }
        }
        // ********************************************
        // ********************************************

        // let's print out
        } else if (choice == 3) {
        System.out.println("0010cc Cancel selection");
        }

        // ask user if he wants to attack with illuminati or group cards
        // (1) for illum
        // (2) for gro card

        // attacking card must have outgoing arrows available

        /*
         * // Disabled shuffling for testing purposes
         * displayUncontrolledAreaCards();
         * 
         * 
         * 
         * // players.get(0).getIlluminati()
         * 
         * System.out.println("\n009 Player's Illuminati's stat");
         * 
         * players.get(player).getIlluminati().displayStats();
         * 
         * // Player wants attack to control the 1st card from //
         * uncontrolledArea System.out.println("\n010 Defender's stat");
         * 
         * uncontrolledArea.get(0).displayStats(); int attackerIndex = 0; int
         * defenderIndex = 0;
         * 
         * Card attacker = players.get(player).getIlluminati(); GroupCard
         * defender = uncontrolledArea.get(0);
         * 
         * int atkPower = players.get(player).getIlluminati().getPower(); int
         * defResistance = uncontrolledArea.get(0).getResistance();
         * 
         * int powerAndResistDifference = atkPower - defResistance;
         * System.out.println("\n011 Power and Resistance difference is " +
         * powerAndResistDifference);
         * 
         * int powerDifference = atkPower - defResistance;
         * System.out.println("\n011 Power difference is " + powerDifference);
         * 
         * System.out.println("\n012 Player must roll " + powerDifference +
         * " or less." + "\nA roll of 11 or 12 is an automatic failure.");
         * 
         * System.out.println("\n013 Assume player rolls dice value is 4");
         * players.get(0).setDiceRoll_TestModeOnly(4);
         * 
         * int playerDiceRoll = players.get(player).getDiceRollOutcome();
         * System.out.println("\n014 Player's dice roll value is " +
         * playerDiceRoll);
         * 
         * boolean successfulAttack = false; if ((playerDiceRoll <=
         * powerDifference) && playerDiceRoll < 11) {
         * System.out.println("\n015 Successful atk to control");
         * successfulAttack = true; } else if (playerDiceRoll == 11 ||
         * playerDiceRoll == 12) {
         * System.out.println("\n016 Failed atk to control"); } else {
         * System.out.println("\n017 Failed atk to control"); }
         * 
         * if (successfulAttack) { //add to players illluminati // or add to a
         * group card // displayDeadPileCards();
         * 
         * players.get(0).getIlluminati();
         * 
         * int Top = 1; int Bottom = 2; int Left = 3; int Right = 4;
         * 
         * System.out.println("494 Select direction for your Illuminati Card \n")
         * ; highestRange = 4; lowestRange = 1; boolean doneAdding = false;
         * 
         * while (!doneAdding ) {
         * 
         * System.out.println("1. Top\n" + "2. Bottom\n" + "3. Left\n" +
         * "4. Right\n"); int directionChoice =
         * CheckInput.checkIntRange(lowestRange, highestRange);
         * 
         * 
         * if(players.get(player).getIlluminati().canAddToThisArrow(directionChoice
         * )){ System.out.println("495a Can add to this arrow");
         * players.get(player).getIlluminati().addPuppetWithArrow(
         * uncontrolledArea.get(defenderIndex), directionChoice);
         * 
         * doneAdding = true; }else{
         * System.out.println("495 You can't add to an already occupied arrow."
         * ); }
         * 
         * }
         * players.get(player).getIlluminati().printOutAvailableAndOccupiedArrows
         * (); uncontrolledArea.remove(defenderIndex); }
         * 
         * displayUncontrolledAreaCards();
         * 
         * players.get(player).takeAction();
         */

        } else if (choice == 3) {
        done = true;
        }
        done = true;
        } // while

    } // atk to control

    /**
     * Later, we have to keep the alignment oppositions in mind
     * 
     * @param choice
     *            <p>
     *            1 for Attacking a Player's Card
     *            <p>
     *            2 for Attacking an Uncontrolled Area's Card
     * 
     */
    public static void atkToDestroy(int player) {

        System.out.println("***ATTACK TO DESTROY MENU***");
        System.out.println("1. Attack another player's power structure\n"
                + "2. Attack a Group Card from the Uncontrolled Area\n"
                + "3. Cancel Attack to Destroy\n");
        int highestRange = 3;
        int lowestRange = 1;
        int choice = CheckInput.checkIntRange(lowestRange, highestRange);

        boolean done = false;

        while (!done) {
        // The user can attack another Player's Card
        if (choice == 1) {
        // players.get(player).takeAction();
        System.out.println("0010a atkToDestroy another player is under construction");
        players.get(player).takeAction();
        } else if (choice == 2) {
        System.out
                .println("0010a Attack To Destroy another Group Card from Uncontrolled Area is under construction");
        System.out.println("0010b TEST SAMPLE SCENARIO FOR ATK TO DESTROY");

        // The user can attack a Card from the Uncontrolled Group

        // while loop until attack to destroy is finished
        /*
         * while(attackIsDone){ ??? well player can only attack at most twice
         * per turn
         * 
         * }
         */

        // Disabled shuffling for testing purposes
        displayUncontrolledAreaCards();

        System.out.println("\n009 Player's Illuminati's stat");

        players.get(0).getIlluminati().displayStats();

        // Player wants attack to destroy the 1st card from
        // uncontrolledArea
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

        System.out.println("\n013 Assume player rolls dice value is 5");
        players.get(0).setDiceRoll_TestModeOnly(5);

        int playerDiceRoll = players.get(0).getDiceRollOutcome();
        System.out.println("\n014 Player's dice roll value is " + playerDiceRoll);

        boolean successfulAttack = false;
        if ((playerDiceRoll <= powerDifference) && playerDiceRoll < 11) {
        System.out.println("\n015 Successful atk to destroy");
        successfulAttack = true;
        } else if (playerDiceRoll == 11 || playerDiceRoll == 12) {
        System.out.println("\n016 Failed atk to destroy");
        } else {
        System.out.println("\n017 Failed atk to destroy");
        }

        if (successfulAttack) {
        deadPile.add(defender);
        displayDeadPileCards();
        uncontrolledArea.remove(defenderIndex);
        }

        displayUncontrolledAreaCards();

        // If Card is destroyed, it goes to deadPile
        players.get(player).takeAction();
        } else if (choice == 3) {
        done = true;
        }
        done = true;
        } // while
    }

    // Create Uncontrolled area for first round
    public static void createUnControlledArea() {

        while (uncontrolledArea.size() != 4) {

        Card cardDrawn = gameDeck.draw();

        if (cardDrawn.getCardType() == 3) {
        System.out.println("005 Drew Special Card from gameDeck: " + cardDrawn.getCardName());
        // Don't put Special Card in uncontrolled Area
        // If this cards get drawn then put it back in the gameDeck
        gameDeck.addCards(cardDrawn);

        // Disabled shuffling for testing purposes
        // gameDeck.shuffleDeck();
        } else {
        // Assume we drew Card type 2 here
        System.out.println("006 Drew Group Card from gameDeck: " + cardDrawn.getCardName());
        // Keep drawing until there is four in the uncontrolled area
        // Add Group Card to uncontrolled Area
        uncontrolledArea.add((GroupCard) cardDrawn);
        }
        } // while

        displayUncontrolledAreaCards();

    }

    /**
     * This method makes sure that there is at least 2 Group Cards in the
     * Uncontrolled Area at the end of a player's turn
     */
    public static void checkUnControlledAreaAtEndOfTurn() {

        while (uncontrolledArea.size() < 2) {

        Card cardDrawn = gameDeck.draw();

        if (cardDrawn.getCardType() == 3) {
        System.out.println("005 Drew Special Card from gameDeck: " + cardDrawn.getCardName());
        // Don't put Special Card in uncontrolled Area
        // If this cards get drawn then put it back in the gameDeck
        gameDeck.addCards(cardDrawn);

        // Disabled shuffling for testing purposes
        // gameDeck.shuffleDeck();
        } else {
        // Assume we drew Card type 2 here
        System.out.println("006 Drew Group Card from gameDeck: " + cardDrawn.getCardName());
        // Keep drawing until there is four in the uncontrolled area
        // Add Group Card to uncontrolled Area
        uncontrolledArea.add((GroupCard) cardDrawn);
        }
        } // while

        displayUncontrolledAreaCards();

    }

    public static void displayDeadPileCards() {
        // Display deadPile cards
        System.out.println("\n020 Dead Pile consists of these cards");
        for (int i = 0; i < deadPile.size(); i++) {
        System.out.println("\t" + i + ": " + deadPile.get(i).getCardName());

        }
    }

    public static void displayUncontrolledAreaCards() {
        // Display uncontrolledArea cards
        System.out.println("\n007 Uncontrolled Area consists of these cards");
        for (int i = 0; i < uncontrolledArea.size(); i++) {
        System.out.println("\t" + i + ": " + uncontrolledArea.get(i).getCardName());

        }
    }

    public static void createPlayers(int totalNumOfPlayers) {

        if (totalNumOfPlayers > 1 && totalNumOfPlayers < 9) {

        for (int i = 0; i < totalNumOfPlayers; i++) {
        players.add(new Player());
        }

        // Assign Illuminati Cards
        for (int i = 0; i < totalNumOfPlayers; i++) {
        players.get(i).setIlluminati(illuminatiCards.get(i));
        }

        for (int i = 0; i < totalNumOfPlayers; i++) {
        System.out.println("000a Player " + i + "'s Illuminati: "
                + players.get(i).getIlluminati().getCardName());
        }

        }

    }

    public static void initializeIlluminatiCards() {
        int illuminatiCardType = 1;
        ImageIcon face = null;
        Illuminati BavarianIlluminati = new Illuminati("The Bavarian Illuminati",
                illuminatiCardType, 10, 10, 9, face);
        BavarianIlluminati.setTopArrowOut();
        BavarianIlluminati.setRightArrowOut();
        BavarianIlluminati.setBottomArrowOut();
        BavarianIlluminati.setLeftArrowOut();
        illuminatiCards.add(BavarianIlluminati);

        Illuminati SocietyOfAssassins = new Illuminati("The Society of Assassins",
                illuminatiCardType, 8, 8, 8, face);
        SocietyOfAssassins.setTopArrowOut();
        SocietyOfAssassins.setRightArrowOut();
        SocietyOfAssassins.setBottomArrowOut();
        SocietyOfAssassins.setLeftArrowOut();
        illuminatiCards.add(SocietyOfAssassins);

        Illuminati BermudaTriangle = new Illuminati("The Bermuda Triangle", illuminatiCardType, 8,
                8, 9, face);
        BermudaTriangle.setTopArrowOut();
        BermudaTriangle.setRightArrowOut();
        BermudaTriangle.setBottomArrowOut();
        BermudaTriangle.setLeftArrowOut();
        illuminatiCards.add(BermudaTriangle);

        Illuminati Network = new Illuminati("The Network", illuminatiCardType, 7, 7, 9, face);
        Network.setTopArrowOut();
        Network.setRightArrowOut();
        Network.setBottomArrowOut();
        Network.setLeftArrowOut();
        illuminatiCards.add(Network);

        // /////////////////////////////////////////////////////////////////////
        // STILL NEED THE REAMAINING ILLUMINATI
        // /////////////////////////////////////////////////////////////////////

    }

    public static void assignIDsToGroupCards() {

        ArrayList<GroupCard> groupCardsTempArrayList = new ArrayList<GroupCard>();
        HashMap<Integer, Card> testHashMap = new HashMap<Integer, Card>();
        HashMap<Card, Integer> testHashMapReverse = new HashMap<Card, Integer>();

        for (int i = 0; i < groupCards.size(); i++) {
        testHashMap.put(i, groupCards.get(i));
        testHashMapReverse.put(groupCards.get(i), i);
        groupCards.get(i).setID(i);
        }

        for (int i = 0; i < groupCards.size(); i++) {

        // System.out.println("SBOXa " + groupCards.get(i).getCardName() +
        // "'s ID: " + groupCards.get(i).getID());
        }

        // boolean blah = testHashMap.containsKey(1);

        // System.out.println("SBOX1 blah is " + blah);
        // System.out.println("SBOX2 " + testHashMap.get(1).getCardName());
        Set<Integer> keys = testHashMap.keySet(); // get all keys
        for (Integer i : keys) {
        // System.out.println("SBOX3A: key " +
        // testHashMap.get(i).getCardName());
        }

        Set<Card> keysR = testHashMapReverse.keySet(); // get all keys
        for (Card i : keysR) {
        // System.out.println("SBOX3B: key " + testHashMapReverse.get(i));
        }

        // System.out.println("00000");

        String variableKey = null;
        String variableValue = null;
        for (Integer variableName : testHashMap.keySet()) {
        variableKey = variableName + "";
        variableValue = testHashMap.get(variableName).getCardName() + "\n";
        // System.out.println("YOO: " + variableKey + ": " + variableValue);

        }

        // System.out.println("000009");

        String variableKey2 = null;
        String variableValue2 = null;
        for (Card variableName : testHashMapReverse.keySet()) {
        variableKey2 = variableName.getCardName() + "";
        variableValue2 = testHashMapReverse.get(variableName) + "\n";
        // System.out.println("YOOB: " + variableKey2 + ": " +
        // variableValue2);

        }

    }

    public static void initializeGroupsCards() {
        int in = 1;
        int out = 2;
        int empty = 3;
        // OutgoingArrow out = new OutgoingArrow();
        // IncomingArrow in = new IncomingArrow();
        int groupCardType = 2;
        ImageIcon face = null;// THIS VARIABLE WILL BE CHANGED TO FIT THE
        // IMAGAGE THAT WILL BE USED IN THE PARAMETER
        GroupCard FBI = new GroupCard("F.B.I.", groupCardType, 4, 2, 6, 0, face);
        FBI.setTopArrowOut();
        FBI.setRightArrowIn();
        FBI.setBottomArrowOut();
        // FBI.setLeftArrow(empty);
        FBI.addAlignment(government);
        FBI.addAlignment(straight);
        groupCards.add(FBI);

        GroupCard CloneArrangers = new GroupCard("Clone Arrangers", groupCardType, 6, 2, 6, 1, face);
        CloneArrangers.setRightArrowOut();
        CloneArrangers.setBottomArrowOut();
        CloneArrangers.setLeftArrowIn();
        CloneArrangers.addAlignment(violent);
        CloneArrangers.addAlignment(communist);
        CloneArrangers.addAlignment(criminal);
        groupCards.add(CloneArrangers);

        GroupCard Moonies = new GroupCard("Moonies", groupCardType, 2, 0, 4, 3, face);
        Moonies.setTopArrowOut();
        // Moonies.setRightArrow(empty);
        // Moonies.setBottomArrow(empty);
        Moonies.setLeftArrowIn();
        Moonies.addAlignment(peaceful);
        Moonies.addAlignment(fanatic);
        groupCards.add(Moonies);

        GroupCard PunkRockers = new GroupCard("Punk Rockers", groupCardType, 0, 0, 4, 1, face);
        // PunkRockers.setTopArrow(empty);
        // PunkRockers.setRightArrow(empty);
        // PunkRockers.setBottomArrow(empty);
        PunkRockers.setLeftArrowIn();
        PunkRockers.addAlignment(weird);
        groupCards.add(PunkRockers);

        GroupCard TVPreachers = new GroupCard("TV Preachers", groupCardType, 3, 0, 6, 4, face);
        // TVPreachers.setTopArrow(empty);
        TVPreachers.setRightArrowIn();
        TVPreachers.setBottomArrowOut();
        TVPreachers.setLeftArrowOut();
        TVPreachers.addAlignment(straight);
        TVPreachers.addAlignment(fanatic);
        groupCards.add(TVPreachers);

        GroupCard NewYork = new GroupCard("New York", groupCardType, 7, 0, 8, 3, face);
        NewYork.setTopArrowOut();
        NewYork.setRightArrowIn();
        NewYork.setBottomArrowOut();
        NewYork.setLeftArrowOut();
        NewYork.addAlignment(violent);
        NewYork.addAlignment(criminal);
        NewYork.addAlignment(government);
        groupCards.add(NewYork);

        GroupCard MadisonAvenue = new GroupCard("Madison Avenue", groupCardType, 3, 3, 3, 2, face);
        // MadisonAvenue.setTopArrow(empty);
        MadisonAvenue.setRightArrowOut();
        MadisonAvenue.setBottomArrowOut();
        MadisonAvenue.setLeftArrowOut();
        groupCards.add(MadisonAvenue);

        // The resistance for Gun lobby changes to 10 when faced against
        // Communist or weird. Something to think about when we work with rule
        // enforcements
        GroupCard GunLobby = new GroupCard("Gun Lobby", groupCardType, 1, 0, 3, 1, face);
        // GunLobby.setTopArrow(empty);
        GunLobby.setRightArrowIn();
        GunLobby.setBottomArrowOut();
        GunLobby.setLeftArrowOut();
        GunLobby.addAlignment(conservative);
        GunLobby.addAlignment(violent);
        groupCards.add(GunLobby);

        GroupCard California = new GroupCard("California", groupCardType, 5, 0, 4, 5, face);
        California.setTopArrowOut();
        // California.setRightArrow(empty);
        California.setBottomArrowOut();
        California.setLeftArrowIn();
        California.addAlignment(liberal);
        California.addAlignment(weird);
        California.addAlignment(government);
        groupCards.add(California);

        GroupCard JunkMail = new GroupCard("Junk Mail", groupCardType, 1, 0, 3, 2, face);
        JunkMail.setTopArrowOut();
        JunkMail.setRightArrowIn();
        // JunkMail.setBottomArrow(empty);
        // JunkMail.setLeftArrow(empty);
        JunkMail.addAlignment(criminal);
        groupCards.add(JunkMail);

        // /////////////////////////////////////////////////////////////////////
        // THIS IS ONLY 10 GROUP CARDS
        // ////////////////////////////////////////////////////////////////////

    }

    public static void initializeSpecialCards() {
        int specialCardType = 3;
        ImageIcon face = null;

        SpecialCard Assassination = new SpecialCard("Assassination", specialCardType, face);
        specialCards.add(Assassination);
        SpecialCard Bribery = new SpecialCard("Bribery", specialCardType, face);
        specialCards.add(Bribery);
        SpecialCard ComputerEspionage = new SpecialCard("Computer Espionage", specialCardType, face);

        SpecialCard DeepAgent = new SpecialCard("Deep Agent", specialCardType, face);

        SpecialCard Interference = new SpecialCard("Interference", specialCardType, face);

        SpecialCard MarketManipulation = new SpecialCard("Market Manipulation", specialCardType,
                face);

        SpecialCard MediaCampaign = new SpecialCard("Media Campaign", specialCardType, face);

        SpecialCard MurphysLaw = new SpecialCard("Murphy's Law", specialCardType, face);

        SpecialCard Secrets = new SpecialCard("Secreats Man Was Not Meant To Know",
                specialCardType, face);

        SpecialCard Senate = new SpecialCard("Senate Investigating Committee", specialCardType,
                face);

        SpecialCard SlushFund = new SpecialCard("Slush Fund", specialCardType, face);

        SpecialCard SwissBankAccount = new SpecialCard("Swiss Bank Account", specialCardType, face);

        SpecialCard WhisperingCampaign = new SpecialCard("Whispering Campaign", specialCardType,
                face);

        SpecialCard WhiteCollarCrime = new SpecialCard("White Collar Crime", specialCardType, face);

    }

    public static void createGameDeck() {
        gameDeck = new Deck();
        System.out.println("001 createGameDeck() is called");
        // Add special cards later
        // SpecialCard.length();

        // Add group cards for now
        System.out.println("002 groupCards's size is " + groupCards.size());

        // Print out first card in groupCards array
        System.out.println("003 first card in groupCards array " + groupCards.get(0).getCardName());

        for (int i = 0; i < groupCards.size(); i++) {
        gameDeck.addCards(groupCards.get(i));
        }

        // display not-shuffled deck
        gameDeck.displayAllCards();

        // shuffle Deck

        // Disabled shuffling for testing purposes
        // gameDeck.shuffleDeck();
        System.out.println("004 shuffled the game deck - disabled for now ");

        // display shuffled deck
        gameDeck.displayAllCards();

    }

    public static boolean checkWinner(Player player) {
        System.out.println("999 checkWinner returning false for now");
        return false;
    }
}
