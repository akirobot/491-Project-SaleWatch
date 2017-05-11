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
	private static int playersTurn;

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

		playersTurn = determineWhoGoesFirst();

		// players arrayList has 2 players total, (0) 1st player, (1) 2nd player
		// for simplicity for now, we assume Player 0 goes first.
		// int playersTurn = 0;
		// When the first player is done with his turn, we go counter-clockwise
		// by decrementing the order

		// Pretend there's 7 players. That means the players arrayList size is 7
		// So if the index is 0, which gets decremented to -1, the next player
		// will be index 6

		int Top = 1;
		int Bottom = 2;
		int Left = 3;
		int Right = 4;

		gameOver = false;
		round = 0;
		// While loop stops until game is over
		while (!gameOver) {
			// Player draws income, so its treasury changes

			System.out.println("Round " + (round + 1) + " starts.");

			System.out.println("Player draws income for his cards. ");
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

				// Check winner
				if (checkWinner(players.get(playersTurn))) {
					System.out.println("CONGRATULATIONS TO PLAYER #"
						+ (playersTurn) + " FOR MEETING BASIC GOAL!!!");
					System.out.println("GAME OVER!");
					done = true;
					gameOver = true;
				} else {

					System.out.println("\n***MENU***");
					System.out.println("Player # " + (playersTurn + 1));
					System.out.println("What would you like to do?");
					System.out.println("1. Pass a turn\n" + "2. Take actions\n"
						+ "3. Take free actions\n" + "4. View your stats\n"
						+ "5. Finish turn\n" + "6. Save game\n"
						+ "7. End game\n");

					int highestRange = 7, lowestRange = 1;
					int inputMenuChoice = CheckInput.checkIntRange(lowestRange,
						highestRange);
					// Funny part is that Pass a turn and Finish turn. Pass a
					// turn,
					// means no actions or free actions are taken
					if (inputMenuChoice == 1) {
						// Check if player have regular actions or free actions
						// set
						// to 0, then he did can pass a turn for 5 megabucks to
						// Illuminati's treasury
						// If player took action, then he can't pass a turn, but
						// can
						// finish a turn instead.
						System.out.println("Pass a turn");

						if (players.get(playersTurn).getActionsTaken() == 0
							&& (players.get(playersTurn)
								.getFreeActionsTaken() == 0)) {

							passTurn(playersTurn);

							done = true;

							round++;
							players.get(playersTurn).resetAction();
							players.get(playersTurn).resetDiceValue();
							checkUnControlledAreaAtEndOfTurn();

						} else {
							System.out.println(
								"Sorry you cannot pass a turn because you have already taken an action.\n"
									+ "But if you are done with your turn, then select: Finish turn.");
						}

					} else if (inputMenuChoice == 2) {
						System.out.println("Take actions ");
						takeActions(playersTurn);
					} else if (inputMenuChoice == 3) {
						System.out
							.println("Take free actions *UNDER CONSTRUCTION* ");

					} else if (inputMenuChoice == 4) {
						System.out
							.println("View your stats *UNDER CONSTRUCTION*\n");

						players.get(playersTurn).getIlluminati().displayStats();

						players.get(playersTurn).getIlluminati()
							.printOutAvailableAndOccupiedArrows();

					} else if (inputMenuChoice == 5) {

						if (players.get(playersTurn).getActionsTaken() == 0
							&& players.get(playersTurn)
								.getFreeActionsTaken() == 0) {
							System.out.println(
								"You're passing a turn instead because you have taken zero actions");

							passTurn(playersTurn);

							round++;
							done = true;
							round++;
							players.get(playersTurn).resetAction();
							players.get(playersTurn).resetDiceValue();
							checkUnControlledAreaAtEndOfTurn();

						} else {
							System.out
								.println("Finish turn *UNDER CONSTRUCTION* ");
							System.out
								.println("Next Player's turn should start");
							playersTurn--;

							if (playersTurn < 0) {
								playersTurn = players.size() - 1;
							}
							done = true;
							round++;
							players.get(playersTurn).resetAction();
							players.get(playersTurn).resetDiceValue();
							checkUnControlledAreaAtEndOfTurn();
						}
					} else if (inputMenuChoice == 6) {
						System.out.println("Save game *UNDER CONSTRUCTION* ");
						// Use Serializable???
					}

					else if (inputMenuChoice == 7) {
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
				// 5) Player is done with turn < Higher priority to implement
				// since
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
		} // while(!gameOver);

	}

	public static void takeActions(int player) {
		// Keep player's actions count in mind
		// Can only take two actions per turn

		while (players.get(player).getActionsTaken() < 2) {
			System.out.println("***ACTIONS MENU***");

			System.out.println(
				"Your actions taken: " + players.get(player).getActionsTaken());
			System.out.println("What would you like to do?");
			System.out
				.println("1. Attack to Control\n" + "2. Attack to Destroy\n"
					+ "3. Attack To Neutralize\n" + "4. Exit menu");

			int highestRange = 4, lowestRange = 1;
			int inputMenuChoice = CheckInput.checkIntRange(lowestRange,
				highestRange);

			if (inputMenuChoice == 1) {
				System.out.println("Attack to Control ");
				atkToControl(player);
				// players.get(player).takeAction(); // move
				// players.get(player).takeAction()
				// to atkToControl,
				// atkToNeut methods later

			} else if (inputMenuChoice == 2) {
				System.out.println("Attack to Destroy ");
				atkToDestroy(player);

			} else if (inputMenuChoice == 3) {
				System.out.println("Attack To Neutralize ");
				players.get(player).takeAction();

			} else if (inputMenuChoice == 4) {
				System.out.println("Exit menu ");
				break;
			}

		}

		System.out.println(
			"Your actions taken: " + players.get(player).getActionsTaken());

		if (players.get(player).getActionsTaken() >= 2) {
			System.out.println("You are out of regular actions.");
		}

	}

	public static void drawCardGameDeck(int player) {

		Card cardDrawn = gameDeck.draw();

		if (cardDrawn.getCardType() == 3) {
			System.out.println("Player Drew Special Card from gameDeck: "
				+ cardDrawn.getCardName());
			// Don't put Special Card in uncontrolled Area
			// If this cards get drawn then put it back in the gameDeck
			players.get(player).addSpecialCard((SpecialCard) cardDrawn);

			// Disabled shuffling for testing purposes
			// gameDeck.shuffleDeck();
		} else {
			// Assume we drew Card type 2 here
			System.out.println("Player Drew Group Card from gameDeck: "
				+ cardDrawn.getCardName());
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

		System.out.println("Player #1 goes first for now.");

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
	public static void passTurn(int player) {

		if (players.get(player).getActionsTaken() == 0
			&& players.get(player).getFreeActionsTaken() == 0) {

			round++;
			players.get(player).resetAction();
			players.get(player).resetDiceValue();
			checkUnControlledAreaAtEndOfTurn();
			playersTurn--;

			if (playersTurn < 0) {
				playersTurn = players.size() - 1;
			}

			// Add 5 megaBucks
			int fiveMegaBucks = 5;
			players.get(player).getIlluminati().adjustTreasury(fiveMegaBucks);

		}
	} // passTurn

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
				System.out
					.println("atkToControlanother player is under construction");
				// players.get(player).takeAction();
			} else if (choice == 2) {

				System.out.println(
					"Attack To Control another Group Card from Uncontrolled Area");

				highestRange = 3;
				lowestRange = 1;
				System.out.println("1. Attack with your Illuminati\n"
					+ "2. Attack with your Group Card\n"
					+ "3. Cancel selection\n");
				choice = CheckInput.checkIntRange(lowestRange, highestRange);

				if (choice == 1) {
					System.out.println("Attack with your Illuminati");
					if (players.get(player).getIlluminati().canAtkToControl()) { // Player's
																					// Illuminati
																					// has
																					// available
																					// outgoing
																					// arrows

						atkToControlUncontrolledAreaWithIlluminati(player);

					} else {
						System.out.println(
							"You don't have any available outgoing arrows for your Illuminati. So you can't attack to control with your Illuminati.");

					}
				} else if (choice == 2) {
					if (players.get(player).getIlluminati()
						.getPuppetSize() == 0) {

						System.out.println("You don't have any Group Cards");
					} else {

						System.out.println("Attack with your Group Card");
						atkToControlUncontrolledAreaWithControlledGroupCard(
							player);

					}
					// ********************************************
					// ********************************************

					// let's print out
				} else if (choice == 3) {
					System.out.println("Cancel selection");
				}

			} else if (choice == 3) {
				done = true;
			}
			done = true;
		} // while

	} // atk to control

	/**
	 * Same like attack to control in terms of power versus power. However,
	 * successful attack makes the GroupCard goes back to the Uncontrolled Area
	 * 
	 * @param player
	 */
	public static void atkToNeutralize(int player) {
		// The other player(s) has a controlled group card
	} // atk to neutralize

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
			+ "3. Cancel Attack to Control\n");
		int highestRange = 3;
		int lowestRange = 1;
		int choice = CheckInput.checkIntRange(lowestRange, highestRange);

		boolean done = false;

		while (!done) {
			// The user can attack another Player's Card
			if (choice == 1) {
				// players.get(player).takeAction();
				// players.get(player).takeAction();

				// ///$$$$$$$$$$$$$$$$$$$$

				highestRange = 3;
				lowestRange = 1;
				System.out.println("1. Attack with your Illuminati\n"
					+ "2. Attack with your Group Card\n"
					+ "3. Cancel selection\n");
				choice = CheckInput.checkIntRange(lowestRange, highestRange);

				if (choice == 1) {
					System.out.println("Attack to destroy with your Illuminati");
					if (players.get(player).getIlluminati().canAtkToControl()) { // Player's
																					// Illuminati
																					// has
																					// available
																					// outgoing
																					// arrows

						// ToControlUncontrolledAreaWithIlluminati(player);
						atkToDestroyControlledWithIlluminatiEnemies(player);

					} else {
						System.out.println(
							"You don't have any available outgoing arrows for your Illuminati. So you can't attack to destroy with your Illuminati.");

					}
				} else if (choice == 2) {
					if (players.get(player).getIlluminati()
						.getPuppetSize() == 0) {

						System.out.println("You don't have any Group Cards");
					} else {

						System.out.println(
							"Attack to destroy another player  with your Group Card");
						// atkToDestroyUncontrolledAreaWithControlledGroupCard(
						// player);

						atkToDestroyControlledAreaWithControlledGroupCardEnemies(
							player);
					}
					// ********************************************
					// ********************************************

					// let's print out
				} else if (choice == 3) {
					System.out.println("Cancel selection");
				}

				// /////%%%%%%%%%%%%%%%%%%%%%%
			} else if (choice == 2) {

				System.out.println(
					"Attack To Destroy another Group Card from Uncontrolled Area");

				highestRange = 3;
				lowestRange = 1;
				System.out.println("1. Attack with your Illuminati\n"
					+ "2. Attack with your Group Card\n"
					+ "3. Cancel selection\n");
				choice = CheckInput.checkIntRange(lowestRange, highestRange);

				if (choice == 1) {
					System.out.println("Attack with your Illuminati");
					if (players.get(player).getIlluminati().canAtkToControl()) { // Player's
																					// Illuminati
																					// has
																					// available
																					// outgoing
																					// arrows

						// ToControlUncontrolledAreaWithIlluminati(player);
						atkToDestroyUncontrolledAreaWithIlluminati(player);

					} else {
						System.out.println(
							"0010aab You don't have any available outgoing arrows for your Illuminati. So you can't attack to destroy with your Illuminati.");

					}
				} else if (choice == 2) {
					if (players.get(player).getIlluminati()
						.getPuppetSize() == 0) {

						System.out.println("You don't have any Group Cards");
					} else {

						System.out.println("Attack with your Group Card");
						// atkToDestroyUncontrolledAreaWithControlledGroupCard(
						// player);

						atkToDestroyUncontrolledAreaWithControlledGroupCard(
							player);

					}
					// ********************************************
					// ********************************************

					// let's print out
				} else if (choice == 3) {
					System.out.println("Cancel selection");
				}

			} else if (choice == 3) {
				done = true;
			}
			done = true;
		} // while

	} // atk to destroy

	/**
	 * Attack enemy player's power structure
	 * 
	 * @param player
	 */
	private static void atkToDestroyControlledAreaWithControlledGroupCardEnemies(
		int player) {
		// TODO Auto-generated method stub

	}

	// static boolean canAtkToDest = false;

	private static void atkToDestroyControlledWithIlluminatiEnemies(int player) {

		ArrayList<Integer> playersWithGroupCards = new ArrayList<Integer>();

		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getIlluminati().getPuppetSize() > 0
				&& (i != player)) {
				System.out.println("Player (" + i
					+ ")'s Group Card can be attacked to destroy");
				playersWithGroupCards.add(i);
			}
		}

		if (playersWithGroupCards.size() > 0) {
			System.out.println("44**44 You may attack to destroy!!!!");

			// Check all of the players besides the current player to see if
			// they
			// have at least one group card

			System.out.println(
				"Attack to Destroy with your Illuminati at the Enemy Player");

			Illuminati attacker = players.get(player).getIlluminati();

			// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
			// Disabled shuffling for testing purposes
			// displayUncontrolledAreaCards();

			// players.get(0).getIlluminati()

			System.out.println("\nPlayer's Illuminati's stats:");

			attacker.displayStats();

			System.out.println(
				"Which player's power structure would you like to attack to destroy?\n");
			for (int i = 0; i < players.size(); i++) {
				System.out.println("Player (" + (i + 1) + ")." + " has "
					+ players.get(i).getIlluminati().getPuppetSize()
					+ " group cards.");
				// players.get(i).getIlluminati().displayPuppets());

			}
			int highestEnemyChoiceDefender = players.size();
			int lowestEnemyChoiceDefender = 1;

			boolean pickedEnemy = false;
			while (!pickedEnemy) {
				int enemyPlayer = CheckInput.checkIntRange(
					lowestEnemyChoiceDefender, highestEnemyChoiceDefender);
				enemyPlayer--;
				if (enemyPlayer == player) {
					System.out.println(
						"You can't attack yourself. Please pick another player");
				} else {
					if (players.get(enemyPlayer).getIlluminati()
						.getPuppetSize() > 0) {
						pickedEnemy = true;
						System.out.println(
							"You want to attack the power structure of Player #"
								+ (enemyPlayer + 1));

						System.out.println(
							"Which uncontrolled Group Card would you like to attack to destroy?\n");
						for (int i = 0; i < players.get(enemyPlayer)
							.getIlluminati().getPuppetSize(); i++) {
							System.out.println(
								"(" + i + ") " + players.get(enemyPlayer)
									.getIlluminati().getPuppet(i).getCardName());

						}

						int highestGroupCardChoiceDefender = players
							.get(enemyPlayer).getIlluminati().getPuppetSize()
							- 1;
						int lowestGroupCardChoiceDefender = 0;

						int groupCardChoiceDefender = CheckInput.checkIntRange(
							lowestGroupCardChoiceDefender,
							highestGroupCardChoiceDefender);

						GroupCard defender = players.get(enemyPlayer)
							.getIlluminati().getPuppet(groupCardChoiceDefender);

						// uncontrolledArea.get(0).displayStats();
						int defenderIndex = groupCardChoiceDefender;

						// for testing purpose, buff up power of attackr
						// in normal game, we will ask user to attack privilege

						int tempPowerBuff = 15;
						int atkPower = attacker.getPower() + tempPowerBuff;
						int defPower = defender.getPower();

						int powerAndpowerDifference = atkPower - defPower;

						System.out.println(
							"Power difference is " + powerAndpowerDifference);

						int successRollValue = 0;

						if (powerAndpowerDifference > 10) {
							successRollValue = 10;

						} else {

							successRollValue = powerAndpowerDifference;
						}

						System.out.println("Player must roll " + successRollValue
							+ " or less."
							+ "\nA roll of 11 or 12 is an automatic failure.");

						System.out
							.println("Assume player rolls dice value is 4");
						players.get(0).setDiceRoll_TestModeOnly(4);

						int playerDiceRoll = players.get(player)
							.getDiceRollOutcome();
						System.out.println(
							"Player's dice roll value is " + playerDiceRoll);

						boolean successfulAttack = false;
						if ((playerDiceRoll <= powerAndpowerDifference)
							&& playerDiceRoll < 11) {
							System.out.println("Successful atk to destroy");
							successfulAttack = true;
						} else if (playerDiceRoll == 11
							|| playerDiceRoll == 12) {
							System.out.println("Failed atk to destroy");
						} else {
							System.out.println("Failed atk to destroy");
						}

						if (successfulAttack) {
							deadPile.add(defender);
							players.get(enemyPlayer).getIlluminati()
								.getPuppetArrayList().remove(defenderIndex);
						}

						players.get(enemyPlayer).displayPowerStructure();
						displayDeadPileCards();

						players.get(player).takeAction();
						// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
						// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

					} else {
						System.out.println(
							"Sorry this player does not have any Group Cards. Please pick another player");

					}
				}

			} // while(!pickEnemy)
		} else {
			System.out.println("Sorry can't atk to dest right now");
		} // you may attack to destroy!

	}

	private static void atkToDestroyUncontrolledAreaWithIlluminati(int player) {

		System.out.println("Attack to Destroy with your Illuminati");

		Illuminati attacker = players.get(player).getIlluminati();

		// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		// Disabled shuffling for testing purposes
		displayUncontrolledAreaCards();

		// players.get(0).getIlluminati()

		System.out.println("Player's Illuminati's stat");

		attacker.displayStats();

		System.out.println(
			"Which uncontrolled Group Card would you like to attack to destroy?\n");
		for (int i = 0; i < uncontrolledArea.size(); i++) {
			System.out
				.println("(" + i + ") " + uncontrolledArea.get(i).getCardName());

		}
		int highestGroupCardChoiceDefender = uncontrolledArea.size() - 1;
		int lowestGroupCardChoiceDefender = 0;

		int groupCardChoiceDefender = CheckInput.checkIntRange(
			lowestGroupCardChoiceDefender, highestGroupCardChoiceDefender);

		GroupCard defender = uncontrolledArea.get(groupCardChoiceDefender);

		// uncontrolledArea.get(0).displayStats();
		int defenderIndex = groupCardChoiceDefender;

		// for testing purpose, buff up power of attackr
		// in normal game, we will ask user to attack privilege

		// int tempPowerBuff = 15;

		// int atkPower = attacker.getPower() + tempPowerBuff;
		// getPower() doesn't work as intended since it's a Card class method
		int atkPower = attacker.getPowerDefault();
		int defPower = defender.getPower();

		int powerAndpowerDifference = atkPower - defPower;
		// Spend money to make your attack more powerful

		System.out.println("Power difference is " + powerAndpowerDifference);

		System.out
			.println("Would you like to spend money to increase your attack?"
				+ "\n1. Yes" + "\n2. No");

		int wantToSpend = CheckInput.checkIntRange(1, 2);
		if (wantToSpend == 1) {
			System.out.println("You will spend money to boost your attack.");

			boolean doneSpending = false;
			while (!doneSpending) {

				System.out
					.println("How much megaBucks would you like to spend?");

				System.out.println("\tDisplaying Illumanti's treasury: ");

				System.out.println("\t" + attacker.getCardName()
					+ "'s megaBucks: " + attacker.getTreasury());
				int maxMegaBucks = attacker.getTreasury();

				System.out.println(
					"\nPlease " + "enter a value between 0 and " + maxMegaBucks);

				int megaBucksSpent = CheckInput.checkIntRange(0, maxMegaBucks);

				maxMegaBucks -= megaBucksSpent;

				attacker.adjustTreasury(-(megaBucksSpent));
				// atkPower += megaBucksSpent;
				attacker.adjustPower(megaBucksSpent);

				System.out.println("Current power difference is "
					+ (attacker.getPowerDefault() - defender.getPower()));

				System.out.println("Would you like to keep spending money?"
					+ "\n1. Yes" + "\n2. No");

				int keepSpend = CheckInput.checkIntRange(1, 2);
				if (keepSpend == 2) {
					doneSpending = true;
				} else {
					System.out.println("Continue spending...");
				}
			} // while(!doneSpending)
		} else {
			System.out
				.println("You will not spend any money to boost your attack.");
		}

		powerAndpowerDifference = (attacker.getPowerDefault()
			- defender.getPower());
		System.out.println("Power difference after spending is "
			+ (attacker.getPowerDefault() - defender.getPower()));

		int successRollValue = 0;
		if (powerAndpowerDifference > 10) {
			successRollValue = 10;
		} else {
			successRollValue = powerAndpowerDifference;
		}

		System.out.println("\nPlayer must roll " + successRollValue + " or less."
			+ "\nA roll of 11 or 12 is an automatic failure.");

		// players.get(0).setDiceRoll_TestModeOnly(4);
		players.get(player).rollDie();

		int playerDiceRoll = players.get(player).getDiceRollOutcome();
		System.out.println("\n Player's dice roll value is " + playerDiceRoll);

		boolean successfulAttack = false;
		if ((playerDiceRoll <= powerAndpowerDifference) && playerDiceRoll < 11) {
			System.out.println("\n Successful atk to destroy");
			successfulAttack = true;
		} else if (playerDiceRoll == 11 || playerDiceRoll == 12) {
			System.out.println("\n Failed atk to destroy");
		} else {
			System.out.println("\n Failed atk to destroy");
		}

		if (successfulAttack) {
			deadPile.add(defender);
			uncontrolledArea.remove(defenderIndex);
		}

		displayUncontrolledAreaCards();
		displayDeadPileCards();
		players.get(player).takeAction();
		// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

		attacker.resetAllAttributesToDefault();

	} // atk to destroy with your illuminati

	private static void atkToDestroyUncontrolledAreaWithControlledGroupCard(
		int player) {

		System.out.println("Attack to Destroy with your Group Card");

		System.out
			.println("Select the Group Card you would like to attack with");

		for (int i = 0; i < players.get(player).getIlluminati()
			.getPuppetSize(); i++) {
			System.out.println("(" + i + ") " + players.get(player)
				.getIlluminati().getPuppet(i).getCardName());

		}

		int highestGroupCardChoice = players.get(player).getIlluminati()
			.getPuppetSize() - 1;
		int lowestGroupCardChoice = 0;

		int groupCardChoice = CheckInput.checkIntRange(lowestGroupCardChoice,
			highestGroupCardChoice);
		GroupCard attacker = players.get(player).getIlluminati()
			.getPuppet(groupCardChoice);

		// ********************************************
		System.out
			.println("Attack with your Group Card: " + attacker.getCardName());

		// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		// Disabled shuffling for testing purposes
		displayUncontrolledAreaCards();

		// players.get(0).getIlluminati()

		System.out.println("Player's Group Card's stat");

		attacker.displayStats();

		System.out.println("\nDefender's stat");

		System.out.println(
			"Which uncontrolled Group Card would you like to attack to destroy?\n");
		for (int i = 0; i < uncontrolledArea.size(); i++) {
			System.out
				.println("(" + i + ") " + uncontrolledArea.get(i).getCardName());

		}
		int highestGroupCardChoiceDefender = uncontrolledArea.size() - 1;
		int lowestGroupCardChoiceDefender = 0;

		int groupCardChoiceDefender = CheckInput.checkIntRange(
			lowestGroupCardChoiceDefender, highestGroupCardChoiceDefender);

		GroupCard defender = uncontrolledArea.get(groupCardChoiceDefender);

		// uncontrolledArea.get(0).displayStats();
		int defenderIndex = groupCardChoiceDefender;

		// for testing purpose, buff up power of attackr
		// in normal game, we will ask user to attack privilege

		int tempPowerBuff = 15;
		int atkPower = attacker.getPower() + tempPowerBuff;
		int defPower = defender.getPower();

		int powerAndpowerDifference = atkPower - defPower;

		int successRollValue = 0;

		System.out.println("\nPower difference is " + powerAndpowerDifference);

		if (powerAndpowerDifference > 10) {
			successRollValue = 10;

		} else {
			successRollValue = powerAndpowerDifference;
		}

		System.out.println("\nPlayer must roll " + successRollValue + " or less."
			+ "\nA roll of 11 or 12 is an automatic failure.");

		System.out.println("\n Assume player rolls dice value is 4");
		players.get(0).setDiceRoll_TestModeOnly(4);

		int playerDiceRoll = players.get(player).getDiceRollOutcome();
		System.out.println("\nPlayer's dice roll value is " + playerDiceRoll);

		boolean successfulAttack = false;
		if ((playerDiceRoll <= powerAndpowerDifference) && playerDiceRoll < 11) {
			System.out.println("\n Successful atk to destroy");
			successfulAttack = true;
		} else if (playerDiceRoll == 11 || playerDiceRoll == 12) {
			System.out.println("\n Failed atk to destroy");
		} else {
			System.out.println("\n Failed atk to destroy");
		}

		if (successfulAttack) {
			deadPile.add(defender);
			uncontrolledArea.remove(defenderIndex);
		}

		displayUncontrolledAreaCards();
		displayDeadPileCards();

		players.get(player).takeAction();
		// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	} // atk to destroy with your group card

	private static void atkToControlUncontrolledAreaWithControlledGroupCard(
		int player) {
		// TODO Auto-generated method stub\

		System.out.println("Attack with your Group Card");

		System.out
			.println("Select the Group Card you would like to attack with");

		for (int i = 0; i < players.get(player).getIlluminati()
			.getPuppetSize(); i++) {
			System.out.println("(" + i + ") " + players.get(player)
				.getIlluminati().getPuppet(i).getCardName());

		}

		int highestGroupCardChoice = players.get(player).getIlluminati()
			.getPuppetSize() - 1;
		int lowestGroupCardChoice = 0;

		int groupCardChoice = CheckInput.checkIntRange(lowestGroupCardChoice,
			highestGroupCardChoice);
		GroupCard attacker = players.get(player).getIlluminati()
			.getPuppet(groupCardChoice);

		// ********************************************
		System.out
			.println("Attack with your Group Card: " + attacker.getCardName());
		if (attacker.canAtkToControl()) {

			// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
			// Disabled shuffling for testing purposes
			displayUncontrolledAreaCards();

			// players.get(0).getIlluminati()

			System.out.println("\nPlayer's Group Card's stat");

			attacker.displayStats();

			// Player wants attack to control the 1st card from
			// uncontrolledArea
			System.out.println("\n Defender's stat");

			int indexOfDefender = 0;
			// ask user which group card he wants to attack

			System.out.println(
				"Which uncontrolled Group Card would you like to attack to control?\n");
			for (int i = 0; i < uncontrolledArea.size(); i++) {
				System.out.println(
					"(" + i + ") " + uncontrolledArea.get(i).getCardName());

			}
			int highestGroupCardChoiceDefender = uncontrolledArea.size() - 1;
			int lowestGroupCardChoiceDefender = 0;

			int groupCardChoiceDefender = CheckInput.checkIntRange(
				lowestGroupCardChoiceDefender, highestGroupCardChoiceDefender);

			GroupCard defender = uncontrolledArea.get(groupCardChoiceDefender);

			// uncontrolledArea.get(0).displayStats();
			int attackerIndex = 0;
			int defenderIndex = groupCardChoiceDefender;

			// for testing purpose, buff up power of attackr
			// in normal game, we will ask user to attack privilege

			int tempPowerBuff = 15;
			int atkPower = attacker.getPower() + tempPowerBuff;
			int defResistance = uncontrolledArea.get(0).getResistance();

			int powerAndResistDifference = atkPower - defResistance;
			System.out.println("\n Power and Resistance difference is "
				+ powerAndResistDifference);

			int powerDifference = atkPower - defResistance;

			//
			int successRollValue = 0;

			System.out.println("\nPower difference is " + powerDifference);

			if (powerDifference > 10) {
				successRollValue = 10;

			} else {
				successRollValue = powerDifference;
			}

			//

			System.out.println("\nPlayer must roll " + successRollValue
				+ " or less." + "\nA roll of 11 or 12 is an automatic failure.");

			System.out.println("\nAssume player rolls dice value is 4");
			players.get(0).setDiceRoll_TestModeOnly(4);

			int playerDiceRoll = players.get(player).getDiceRollOutcome();
			System.out
				.println("\n Player's dice roll value is " + playerDiceRoll);

			boolean successfulAttack = false;
			if ((playerDiceRoll <= powerDifference) && playerDiceRoll < 11) {
				System.out.println("\n Successful atk to control");
				successfulAttack = true;
			} else if (playerDiceRoll == 11 || playerDiceRoll == 12) {
				System.out.println("\n Failed atk to control");
			} else {
				System.out.println("\n Failed atk to control");
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
				System.out.println("Select direction for your Group Card \n");
				int highestRange = 4;
				int lowestRange = 1;
				boolean doneAdding = false;

				while (!doneAdding) {

					System.out.println(
						"1. Top\n" + "2. Bottom\n" + "3. Left\n" + "4. Right\n");
					int directionChoice = CheckInput.checkIntRange(lowestRange,
						highestRange);

					if (attacker.canAddToThisArrow(directionChoice)) {
						System.out.println("You can add to this arrow");
						// attacker.addPuppetWithArrow(
						// uncontrolledArea.get(defenderIndex),
						// directionChoice);
						// REFactored
						attacker.addPuppetWithArrow(defender, directionChoice);
						doneAdding = true;
					} else {
						System.out.println(
							"You can't add to an already occupied arrow. Or your Group Card does not have an outgoing arrow of that direction.");
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
			System.out.println(
				"You don't have any available outgoing arrows for your Group Card.");

		}

	} // atk to control with your group card

	private static void atkToControlUncontrolledAreaWithIlluminati(int player) {

		// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		// Disabled shuffling for testing purposes
		displayUncontrolledAreaCards();

		// players.get(0).getIlluminati()

		System.out.println("\nPlayer's Illuminati's stat");

		players.get(player).getIlluminati().displayStats();

		// Player wants attack to control the 1st card from
		// uncontrolledArea
		System.out.println("\nDefender's stat");

		int indexOfDefender = 0;
		// ask user which group card he wants to attack

		System.out.println(
			"Which uncontrolled Group Card would you like to attack to control?\n");
		for (int i = 0; i < uncontrolledArea.size(); i++) {
			System.out
				.println("(" + i + ") " + uncontrolledArea.get(i).getCardName());

		}
		int highestGroupCardChoiceDefender = uncontrolledArea.size() - 1;
		int lowestGroupCardChoiceDefender = 0;

		int groupCardChoiceDefender = CheckInput.checkIntRange(
			lowestGroupCardChoiceDefender, highestGroupCardChoiceDefender);

		GroupCard defender = uncontrolledArea.get(groupCardChoiceDefender);

		int defenderIndex = groupCardChoiceDefender;

		Card attacker = players.get(player).getIlluminati();

		int atkPower = players.get(player).getIlluminati().getPower();
		int defResistance = uncontrolledArea.get(0).getResistance();

		// int powerAndResistDifference = atkPower - defResistance;
		// System.out.println("\nPower and Resistance difference is " +
		// powerAndResistDifference);

		int powerDifference = atkPower - defResistance;
		System.out.println("\n0Power difference is " + powerDifference);

		// <
		int successRollValue = 0;

		System.out.println("\nPower difference is " + powerDifference);

		if (powerDifference > 10) {
			successRollValue = 10;

		} else {
			successRollValue = powerDifference;
		}

		// >

		System.out.println("\n Player must roll " + successRollValue
			+ " or less." + "\nA roll of 11 or 12 is an automatic failure.");

		System.out.println("\n Assume player rolls dice value is 4");
		players.get(0).setDiceRoll_TestModeOnly(4);

		int playerDiceRoll = players.get(player).getDiceRollOutcome();
		System.out.println("\n Player's dice roll value is " + playerDiceRoll);

		boolean successfulAttack = false;
		if ((playerDiceRoll <= powerDifference) && playerDiceRoll < 11) {
			System.out.println("\n Successful atk to control");
			successfulAttack = true;
		} else if (playerDiceRoll == 11 || playerDiceRoll == 12) {
			System.out.println("\n Failed atk to control");
		} else {
			System.out.println("\n Failed atk to control");
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

			System.out.println("Select direction for your Illuminati Card \n");
			int highestRange = 4;
			int lowestRange = 1;
			boolean doneAdding = false;

			while (!doneAdding) {

				System.out.println(
					"1. Top\n" + "2. Bottom\n" + "3. Left\n" + "4. Right\n");
				int directionChoice = CheckInput.checkIntRange(lowestRange,
					highestRange);

				if (players.get(player).getIlluminati()
					.canAddToThisArrow(directionChoice)) {
					System.out.println("You can add to the preceding arrow");
					players.get(player).getIlluminati().addPuppetWithArrow(
						uncontrolledArea.get(defenderIndex), directionChoice);

					doneAdding = true;
				} else {
					System.out
						.println("You can't add to an already occupied arrow.");
				}

			}
			players.get(player).getIlluminati()
				.printOutAvailableAndOccupiedArrows();
			uncontrolledArea.remove(defenderIndex);
		}

		displayUncontrolledAreaCards();

		players.get(player).takeAction();
		// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	} // atkToControl w/ Illuminati

	// Create Uncontrolled area for first round
	public static void createUnControlledArea() {

		while (uncontrolledArea.size() != 4) {

			Card cardDrawn = gameDeck.draw();

			if (cardDrawn.getCardType() == 3) {
				System.out.println("Drew Special Card from gameDeck: "
					+ cardDrawn.getCardName());
				// Don't put Special Card in uncontrolled Area
				// If this cards get drawn then put it back in the gameDeck
				gameDeck.addCards(cardDrawn);

				// Disabled shuffling for testing purposes
				// gameDeck.shuffleDeck();
			} else {
				// Assume we drew Card type 2 here
				System.out.println(
					"Drew Group Card from gameDeck: " + cardDrawn.getCardName());
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
				System.out.println("Drew Special Card from gameDeck: "
					+ cardDrawn.getCardName());
				// Don't put Special Card in uncontrolled Area
				// If this cards get drawn then put it back in the gameDeck
				gameDeck.addCards(cardDrawn);

				// Disabled shuffling for testing purposes
				// gameDeck.shuffleDeck();
			} else {
				// Assume we drew Card type 2 here
				System.out.println(
					"Drew Group Card from gameDeck: " + cardDrawn.getCardName());
				// Keep drawing until there is four in the uncontrolled area
				// Add Group Card to uncontrolled Area
				uncontrolledArea.add((GroupCard) cardDrawn);
			}
		} // while

		displayUncontrolledAreaCards();

	}

	public static void displayDeadPileCards() {
		// Display deadPile cards
		System.out.println("\nDead Pile consists of these cards");
		for (int i = 0; i < deadPile.size(); i++) {
			System.out.println("\t" + i + ": " + deadPile.get(i).getCardName());

		}
	}

	public static void displayUncontrolledAreaCards() {
		// Display uncontrolledArea cards
		System.out.println("\n Uncontrolled Area consists of these cards");
		for (int i = 0; i < uncontrolledArea.size(); i++) {
			System.out.println(
				"\t" + i + ": " + uncontrolledArea.get(i).getCardName());

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
				System.out.println("Player " + (i + 1) + "'s Illuminati: "
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

		Illuminati SocietyOfAssassins = new Illuminati(
			"The Society of Assassins", illuminatiCardType, 8, 8, 8, face);
		SocietyOfAssassins.setTopArrowOut();
		SocietyOfAssassins.setRightArrowOut();
		SocietyOfAssassins.setBottomArrowOut();
		SocietyOfAssassins.setLeftArrowOut();
		illuminatiCards.add(SocietyOfAssassins);

		Illuminati BermudaTriangle = new Illuminati("The Bermuda Triangle",
			illuminatiCardType, 8, 8, 9, face);
		BermudaTriangle.setTopArrowOut();
		BermudaTriangle.setRightArrowOut();
		BermudaTriangle.setBottomArrowOut();
		BermudaTriangle.setLeftArrowOut();
		illuminatiCards.add(BermudaTriangle);

		Illuminati Network = new Illuminati("The Network", illuminatiCardType, 7,
			7, 9, face);
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

		// The resistance for Gun lobby changes to 10 when faced against
		// Communist or weird. Something to think about when we work with rule
		// enforcements

		GroupCard AmericanAutoduelAssociation = new GroupCard(
			"American Autoduel Association", groupCardType, 1, 0, 5, 1, face);
		AmericanAutoduelAssociation.setRightArrowOut();
		AmericanAutoduelAssociation.setLeftArrowIn();
		AmericanAutoduelAssociation.addAlignment(violent);
		AmericanAutoduelAssociation.addAlignment(weird);
		groupCards.add(AmericanAutoduelAssociation);

		GroupCard AntiNuclearActivists = new GroupCard("AntiNuclearActivists",
			groupCardType, 2, 0, 5, 1, face);
		AntiNuclearActivists.setTopArrowOut();

		AntiNuclearActivists.setLeftArrowIn();
		AntiNuclearActivists.addAlignment(liberal);
		groupCards.add(AntiNuclearActivists);

		GroupCard AntiwarActivists = new GroupCard("Antiwar Activists",
			groupCardType, 3, 0, 0, 1, face);

		AntiwarActivists.setLeftArrowIn();
		AntiwarActivists.addAlignment(peaceful);
		AntiwarActivists.addAlignment(liberal);
		groupCards.add(AntiwarActivists);

		GroupCard BigMedia = new GroupCard("Big Media", groupCardType, 4, 3, 6,
			3, face);
		BigMedia.setTopArrowOut();
		BigMedia.setRightArrowIn();
		BigMedia.setBottomArrowOut();
		BigMedia.setLeftArrowOut();
		BigMedia.addAlignment(liberal);
		BigMedia.addAlignment(straight);
		groupCards.add(BigMedia);

		GroupCard BoySprouts = new GroupCard("Boy Sprouts", groupCardType, 0, 0,
			3, 1, face);
		BoySprouts.setTopArrowOut();
		BoySprouts.setLeftArrowIn();
		BoySprouts.setBottomArrowOut();
		BoySprouts.setLeftArrowOut();
		BoySprouts.addAlignment(straight);
		BoySprouts.addAlignment(peaceful);
		groupCards.add(BoySprouts);

		GroupCard California = new GroupCard("California", groupCardType, 5, 0,
			4, 5, face);
		California.setTopArrowOut();
		California.setBottomArrowOut();
		California.setLeftArrowIn();
		California.addAlignment(liberal);
		California.addAlignment(weird);
		California.addAlignment(government);
		groupCards.add(California);

		GroupCard CFLAIO = new GroupCard("CFL-AIO", groupCardType, 6, 0, 5, 3,
			face);
		CFLAIO.setTopArrowOut();
		CFLAIO.setRightArrowIn();
		CFLAIO.setBottomArrowOut();
		CFLAIO.setLeftArrowOut();
		CFLAIO.addAlignment(liberal);
		groupCards.add(CFLAIO);

		GroupCard ChineseCampaignDonors = new GroupCard(
			"Chinese Campaign Donors", groupCardType, 3, 0, 2, 3, face);
		ChineseCampaignDonors.setTopArrowOut();
		ChineseCampaignDonors.setRightArrowIn();
		ChineseCampaignDonors.setBottomArrowOut();
		ChineseCampaignDonors.addAlignment(communist);
		groupCards.add(ChineseCampaignDonors);

		GroupCard CIA = new GroupCard("C.I.A.", groupCardType, 6, 4, 5, 0, face);
		CIA.setTopArrowOut();
		CIA.setRightArrowIn();
		CIA.setBottomArrowOut();
		CIA.setLeftArrowOut();
		CIA.addAlignment(government);
		CIA.addAlignment(violent);
		groupCards.add(CIA);

		GroupCard CloneArrangers = new GroupCard("Clone Arrangers",
			groupCardType, 6, 2, 6, 1, face);
		CloneArrangers.setRightArrowOut();
		CloneArrangers.setBottomArrowOut();
		CloneArrangers.setLeftArrowIn();
		CloneArrangers.addAlignment(violent);
		CloneArrangers.addAlignment(communist);
		CloneArrangers.addAlignment(criminal);
		groupCards.add(CloneArrangers);

		GroupCard ComicBooks = new GroupCard("Comic Book", groupCardType, 1, 0,
			1, 2, face);
		ComicBooks.setTopArrowOut();

		ComicBooks.setLeftArrowIn();
		ComicBooks.addAlignment(weird);
		ComicBooks.addAlignment(violent);
		groupCards.add(ComicBooks);

		GroupCard CongressionalWives = new GroupCard("Congressional Wives",
			groupCardType, 1, 0, 4, 1, face);
		CongressionalWives.setRightArrowOut();
		CongressionalWives.setLeftArrowIn();
		CongressionalWives.addAlignment(conservative);
		CongressionalWives.addAlignment(straight);
		groupCards.add(CongressionalWives);

		GroupCard ConvenienceStores = new GroupCard("Conveninece Stores",
			groupCardType, 1, 0, 4, 3, face);

		ConvenienceStores.setBottomArrowOut();
		ConvenienceStores.setLeftArrowIn();
		ConvenienceStores.addAlignment(straight);
		groupCards.add(ConvenienceStores);

		GroupCard CopyShops = new GroupCard("Copy Shops", groupCardType, 1, 0, 3,
			4, face);
		CopyShops.setRightArrowIn();
		CopyShops.setLeftArrowOut();
		CopyShops.addAlignment(peaceful);
		groupCards.add(CopyShops);

		GroupCard Democrats = new GroupCard("Democrats", groupCardType, 5, 0, 4,
			3, face);
		Democrats.setRightArrowIn();
		Democrats.setBottomArrowOut();
		Democrats.setLeftArrowOut();
		Democrats.addAlignment(liberal);
		groupCards.add(Democrats);

		GroupCard EcoGuerrillas = new GroupCard("Eco-Guerrillas", groupCardType,
			0, 0, 6, 1, face);
		EcoGuerrillas.setRightArrowIn();

		EcoGuerrillas.addAlignment(liberal);
		EcoGuerrillas.addAlignment(violent);
		EcoGuerrillas.addAlignment(weird);

		groupCards.add(EcoGuerrillas);

		GroupCard EmptyVee = new GroupCard("Empty Vee", groupCardType, 3, 0, 3,
			4, face);
		EmptyVee.setRightArrowIn();
		EmptyVee.setBottomArrowOut();
		EmptyVee.setLeftArrowOut();
		groupCards.add(EmptyVee);

		GroupCard EvilGeniuses = new GroupCard(
			"Evil Geniuses For A Better Tomorrow", groupCardType, 0, 2, 6, 3,
			face);
		EvilGeniuses.setRightArrowIn();

		EvilGeniuses.addAlignment(violent);
		EvilGeniuses.addAlignment(weird);
		groupCards.add(EvilGeniuses);

		GroupCard FastFoodChains = new GroupCard("Fast Food Chains",
			groupCardType, 2, 0, 4, 3, face);
		FastFoodChains.setBottomArrowOut();
		FastFoodChains.setLeftArrowIn();
		FastFoodChains.addAlignment(straight);
		groupCards.add(FastFoodChains);

		GroupCard FBI = new GroupCard("F.B.I.", groupCardType, 4, 2, 6, 0, face);

		FBI.setTopArrowOut();
		FBI.setRightArrowIn();
		FBI.setBottomArrowOut();
		FBI.addAlignment(government);
		FBI.addAlignment(straight);
		groupCards.add(FBI);

		GroupCard FederalReserve = new GroupCard("Federal Reserve",
			groupCardType, 5, 3, 7, 6, face);
		FederalReserve.setTopArrowOut();
		FederalReserve.setRightArrowOut();
		FederalReserve.setLeftArrowIn();
		FederalReserve.addAlignment(government);
		groupCards.add(FederalReserve);

		GroupCard Feminists = new GroupCard("Feminists", groupCardType, 2, 0, 2,
			1, face);

		Feminists.setBottomArrowOut();
		Feminists.setLeftArrowIn();
		Feminists.addAlignment(liberal);
		groupCards.add(Feminists);

		GroupCard FiendishFluoridators = new GroupCard("Fiendish Fluoridators",
			groupCardType, 3, 0, 5, 1, face);
		FiendishFluoridators.setTopArrowOut();
		FiendishFluoridators.setRightArrowOut();
		FiendishFluoridators.setLeftArrowIn();
		FiendishFluoridators.addAlignment(communist);
		FiendishFluoridators.addAlignment(fanatic);
		groupCards.add(FiendishFluoridators);

		GroupCard FlatEarthers = new GroupCard("Flat Earthers", groupCardType, 1,
			0, 2, 1, face);
		FlatEarthers.setRightArrowIn();
		FlatEarthers.setLeftArrowOut();
		FlatEarthers.addAlignment(weird);
		FlatEarthers.addAlignment(conservative);
		groupCards.add(FlatEarthers);

		GroupCard FnordMotorCompany = new GroupCard("Fnord Motor Company",
			groupCardType, 2, 0, 4, 2, face);
		FnordMotorCompany.setRightArrowOut();
		FnordMotorCompany.setLeftArrowIn();
		FnordMotorCompany.addAlignment(peaceful);
		groupCards.add(FnordMotorCompany);

		GroupCard FraternalOrders = new GroupCard("Fraternal Orders",
			groupCardType, 3, 0, 5, 3, face);
		FraternalOrders.setTopArrowOut();
		FraternalOrders.setRightArrowIn();

		FraternalOrders.addAlignment(conservative);
		groupCards.add(FraternalOrders);

		GroupCard GirlieMagazines = new GroupCard("GirlieMagazine",
			groupCardType, 2, 0, 2, 3, face);
		GirlieMagazines.setRightArrowIn();
		GirlieMagazines.setBottomArrowOut();
		GirlieMagazines.setLeftArrowOut();
		GirlieMagazines.addAlignment(liberal);
		groupCards.add(GirlieMagazines);

		GroupCard GoldfishFanciers = new GroupCard("Goldfish Fanciers",
			groupCardType, 0, 0, 4, 1, face);

		GoldfishFanciers.setLeftArrowIn();
		GoldfishFanciers.addAlignment(peaceful);
		GoldfishFanciers.addAlignment(fanatic);
		groupCards.add(GoldfishFanciers);

		GroupCard GunLobby = new GroupCard("Gun Lobby", groupCardType, 1, 0, 3,
			1, face);
		GunLobby.setRightArrowIn();
		GunLobby.setBottomArrowOut();
		GunLobby.setLeftArrowOut();
		GunLobby.addAlignment(conservative);
		GunLobby.addAlignment(violent);
		groupCards.add(GunLobby);

		// Hackers missing
		GroupCard Hackers = new GroupCard("Hackers", groupCardType, 1, 1, 4, 2,
			face);
		Hackers.setRightArrowIn();
		Hackers.setTopArrowOut();
		Hackers.addAlignment(weird);
		Hackers.addAlignment(fanatic);
		groupCards.add(Hackers);

		GroupCard HealthFoodStores = new GroupCard("Health Food Stores",
			groupCardType, 1, 0, 3, 2, face);
		HealthFoodStores.setBottomArrowOut();
		HealthFoodStores.setLeftArrowIn();
		HealthFoodStores.addAlignment(liberal);
		groupCards.add(HealthFoodStores);

		GroupCard Intellectuals = new GroupCard("Intellectuals", groupCardType,
			0, 0, 3, 1, face);

		Intellectuals.setLeftArrowIn();
		Intellectuals.addAlignment(weird);
		Intellectuals.addAlignment(fanatic);
		groupCards.add(Intellectuals);

		GroupCard InternationalCommunistConspiracy = new GroupCard(
			"International Communist Conspiracy", groupCardType, 7, 0, 8, 6,
			face);
		InternationalCommunistConspiracy.setTopArrowOut();
		InternationalCommunistConspiracy.setRightArrowIn();
		InternationalCommunistConspiracy.setBottomArrowOut();
		InternationalCommunistConspiracy.setLeftArrowOut();
		InternationalCommunistConspiracy.addAlignment(communist);
		groupCards.add(InternationalCommunistConspiracy);

		int tax = 0;
		GroupCard IRS = new GroupCard("I.R.S.", groupCardType, 5, 3, 5, tax,
			face);
		IRS.setTopArrowOut();
		IRS.setRightArrowOut();
		IRS.setBottomArrowOut();
		IRS.addAlignment(criminal);
		IRS.addAlignment(government);

		GroupCard JunkMail = new GroupCard("Junk Mail", groupCardType, 1, 0, 3,
			2, face);
		JunkMail.setTopArrowOut();
		JunkMail.setRightArrowIn();
		JunkMail.addAlignment(criminal);
		groupCards.add(JunkMail);

		GroupCard KGB = new GroupCard("KGB", groupCardType, 2, 2, 6, 0, face);
		KGB.setRightArrowIn();
		KGB.setBottomArrowOut();
		KGB.addAlignment(communist);
		KGB.addAlignment(violent);
		groupCards.add(KGB);

		GroupCard KKK = new GroupCard("KKK", groupCardType, 2, 0, 5, 1, face);
		KKK.setRightArrowIn();
		KKK.setBottomArrowOut();
		KKK.addAlignment(conservative);
		KKK.addAlignment(violent);
		groupCards.add(KKK);

		GroupCard L4Society = new GroupCard("L-4 Society", groupCardType, 1, 0,
			2, 0, face);
		L4Society.setRightArrowIn();
		L4Society.setLeftArrowOut();
		L4Society.addAlignment(weird);
		groupCards.add(L4Society);

		GroupCard Libertarians = new GroupCard("Libertarians", groupCardType, 1,
			0, 4, 1, face);
		Libertarians.setTopArrowOut();

		Libertarians.setLeftArrowIn();
		Libertarians.addAlignment(fanatic);
		groupCards.add(Libertarians);

		GroupCard LoanSharks = new GroupCard("Loan Sharks", groupCardType, 5, 0,
			5, 6, face);
		LoanSharks.setRightArrowOut();
		LoanSharks.setLeftArrowIn();
		LoanSharks.addAlignment(criminal);
		LoanSharks.addAlignment(violent);
		groupCards.add(LoanSharks);

		GroupCard LocalPoliceDepartment = new GroupCard(
			"Local Police Department", groupCardType, 0, 0, 4, 1, face);

		LocalPoliceDepartment.setLeftArrowIn();
		LocalPoliceDepartment.addAlignment(conservative);
		LocalPoliceDepartment.addAlignment(straight);
		LocalPoliceDepartment.addAlignment(violent);
		groupCards.add(LocalPoliceDepartment);

		GroupCard MadisonAvenue = new GroupCard("Madison Avenue", groupCardType,
			3, 3, 3, 2, face);
		MadisonAvenue.setRightArrowOut();
		MadisonAvenue.setBottomArrowOut();
		MadisonAvenue.setLeftArrowOut();
		groupCards.add(MadisonAvenue);

		GroupCard Mafia = new GroupCard("The Mafia", groupCardType, 7, 0, 7, 6,
			face);
		Mafia.setTopArrowOut();
		Mafia.setRightArrowIn();
		Mafia.setBottomArrowOut();
		Mafia.setLeftArrowOut();
		Mafia.addAlignment(criminal);
		Mafia.addAlignment(violent);
		groupCards.add(Mafia);

		GroupCard MenInBlack = new GroupCard("The Men In Black", groupCardType,
			0, 2, 6, 1, face);

		MenInBlack.setLeftArrowIn();
		MenInBlack.addAlignment(criminal);
		MenInBlack.addAlignment(weird);
		groupCards.add(MenInBlack);

		GroupCard Militia = new GroupCard("Militia", groupCardType, 2, 0, 4, 2,
			face);
		Militia.setTopArrowOut();
		Militia.setRightArrowIn();
		Militia.setLeftArrowOut();
		Militia.addAlignment(violent);
		Militia.addAlignment(conservative);
		groupCards.add(Militia);

		GroupCard Moonies = new GroupCard("Moonies", groupCardType, 2, 0, 4, 3,
			face);
		Moonies.setTopArrowOut();
		Moonies.setLeftArrowIn();
		Moonies.addAlignment(peaceful);
		Moonies.addAlignment(fanatic);
		groupCards.add(Moonies);

		GroupCard MoralMinority = new GroupCard("Moral Minority", groupCardType,
			2, 0, 1, 2, face);
		MoralMinority.setRightArrowIn();
		MoralMinority.setBottomArrowOut();

		MoralMinority.addAlignment(conservative);
		MoralMinority.addAlignment(straight);
		MoralMinority.addAlignment(fanatic);
		groupCards.add(MoralMinority);

		GroupCard Morticians = new GroupCard("Morticians", groupCardType, 0, 0,
			4, 1, face);
		Morticians.setRightArrowIn();

		Morticians.addAlignment(straight);
		Morticians.addAlignment(peaceful);
		groupCards.add(Morticians);

		GroupCard MultinationalOilCompanies = new GroupCard(
			"Multinational Oil Companies", groupCardType, 6, 0, 4, 8, face);
		MultinationalOilCompanies.setTopArrowOut();
		MultinationalOilCompanies.setRightArrowOut();
		MultinationalOilCompanies.setBottomArrowOut();
		MultinationalOilCompanies.setLeftArrowIn();
		groupCards.add(MultinationalOilCompanies);

		GroupCard NephewsOfGod = new GroupCard("Nephews Of GOd", groupCardType,
			0, 0, 4, 2, face);
		NephewsOfGod.setRightArrowIn();

		NephewsOfGod.addAlignment(conservative);
		NephewsOfGod.addAlignment(fanatic);
		groupCards.add(NephewsOfGod);

		GroupCard NewYork = new GroupCard("New York", groupCardType, 7, 0, 8, 3,
			face);
		NewYork.setTopArrowOut();
		NewYork.setRightArrowIn();
		NewYork.setBottomArrowOut();
		NewYork.setLeftArrowOut();
		NewYork.addAlignment(violent);
		NewYork.addAlignment(criminal);
		NewYork.addAlignment(government);
		groupCards.add(NewYork);

		GroupCard NuclearPowerCompanies = new GroupCard(
			"Nuclear Power Companies", groupCardType, 4, 0, 4, 3, face);

		NuclearPowerCompanies.setRightArrowIn();
		NuclearPowerCompanies.setLeftArrowOut();
		NuclearPowerCompanies.addAlignment(conservative);
		groupCards.add(NuclearPowerCompanies);

		GroupCard OrbitalMindControlLasers = new GroupCard(
			"Orbital Mind Control Lasers", groupCardType, 4, 2, 5, 0, face);
		OrbitalMindControlLasers.setTopArrowOut();
		OrbitalMindControlLasers.setRightArrowOut();

		OrbitalMindControlLasers.setLeftArrowIn();
		OrbitalMindControlLasers.addAlignment(communist);
		groupCards.add(OrbitalMindControlLasers);

		GroupCard ParentTeacher = new GroupCard("Parent/Teacher Agglomeration",
			groupCardType, 0, 0, 5, 1, face);

		ParentTeacher.setLeftArrowIn();
		ParentTeacher.addAlignment(peaceful);
		ParentTeacher.addAlignment(conservative);
		ParentTeacher.addAlignment(straight);
		groupCards.add(ParentTeacher);

		GroupCard Pentagon = new GroupCard("Pentagon", groupCardType, 6, 0, 6, 2,
			face);
		Pentagon.setTopArrowOut();
		Pentagon.setRightArrowIn();
		Pentagon.setBottomArrowOut();
		Pentagon.setLeftArrowOut();
		Pentagon.addAlignment(government);
		Pentagon.addAlignment(violent);
		Pentagon.addAlignment(straight);
		groupCards.add(Pentagon);

		GroupCard PhoneCompany = new GroupCard("The Phone Company",
			groupCardType, 5, 2, 6, 3, face);

		PhoneCompany.setRightArrowOut();
		PhoneCompany.setBottomArrowOut();
		PhoneCompany.setLeftArrowIn();
		groupCards.add(PhoneCompany);

		GroupCard PhonePhreaks = new GroupCard("Phone Phreaks", groupCardType, 0,
			1, 1, 1, face);

		PhonePhreaks.setLeftArrowIn();
		PhonePhreaks.addAlignment(criminal);
		PhonePhreaks.addAlignment(liberal);
		groupCards.add(PhonePhreaks);

		GroupCard PostOffice = new GroupCard("Post Office", groupCardType, 4, 3,
			3, 1, face);

		PostOffice.setRightArrowIn();
		PostOffice.setBottomArrowOut();
		PostOffice.addAlignment(government);
		groupCards.add(PostOffice);

		GroupCard ProfessionalSports = new GroupCard("Professional Sports",
			groupCardType, 2, 0, 4, 3, face);
		ProfessionalSports.setRightArrowOut();
		ProfessionalSports.setBottomArrowOut();
		ProfessionalSports.setLeftArrowIn();
		ProfessionalSports.addAlignment(violent);
		ProfessionalSports.addAlignment(fanatic);
		groupCards.add(ProfessionalSports);

		GroupCard Psychiatrists = new GroupCard("Psychiatrists", groupCardType,
			0, 0, 6, 2, face);
		Psychiatrists.setRightArrowIn();

		Psychiatrists.addAlignment(weird);
		groupCards.add(Psychiatrists);

		GroupCard PunkRockers = new GroupCard("Punk Rockers", groupCardType, 0,
			0, 4, 1, face);
		PunkRockers.setLeftArrowIn();
		PunkRockers.addAlignment(weird);
		groupCards.add(PunkRockers);

		GroupCard Recyclers = new GroupCard("Recyclers", groupCardType, 2, 0, 2,
			3, face);
		Recyclers.setRightArrowIn();
		Recyclers.setLeftArrowOut();
		Recyclers.addAlignment(liberal);
		groupCards.add(Recyclers);

		GroupCard Republicans = new GroupCard("Republicans", groupCardType, 4, 0,
			4, 4, face);
		Republicans.setTopArrowOut();
		Republicans.setRightArrowIn();
		Republicans.setBottomArrowOut();
		Republicans.setLeftArrowOut();
		Republicans.addAlignment(conservative);
		groupCards.add(Republicans);

		GroupCard RobotSeaMonsters = new GroupCard("Robot Sea Monsters",
			groupCardType, 0, 0, 6, 2, face);
		RobotSeaMonsters.setRightArrowIn();

		RobotSeaMonsters.addAlignment(violent);
		RobotSeaMonsters.addAlignment(communist);
		groupCards.add(RobotSeaMonsters);

		GroupCard ScienceFictionFans = new GroupCard("Science Fiction Fans",
			groupCardType, 0, 0, 5, 1, face);

		ScienceFictionFans.setLeftArrowIn();
		ScienceFictionFans.addAlignment(weird);
		groupCards.add(ScienceFictionFans);

		GroupCard SemiconsciousLiberationArmy = new GroupCard(
			"Semiconscious Liberation Army", groupCardType, 0, 0, 5, 1, face);

		SemiconsciousLiberationArmy.setLeftArrowIn();
		SemiconsciousLiberationArmy.addAlignment(criminal);
		SemiconsciousLiberationArmy.addAlignment(violent);
		SemiconsciousLiberationArmy.addAlignment(liberal);
		SemiconsciousLiberationArmy.addAlignment(weird);
		SemiconsciousLiberationArmy.addAlignment(communist);
		groupCards.add(SemiconsciousLiberationArmy);

		GroupCard SMOF = new GroupCard("S.M.O.F.", groupCardType, 1, 0, 1, 0,
			face);
		SMOF.setTopArrowOut();
		SMOF.setRightArrowIn();
		SMOF.setBottomArrowOut();
		SMOF.addAlignment(weird);
		groupCards.add(SMOF);

		GroupCard SocietyForCA = new GroupCard("Society for Creative Anarchism",
			groupCardType, 0, 0, 4, 1, face);
		SocietyForCA.addAlignment(violent);
		SocietyForCA.addAlignment(weird);
		SocietyForCA.setRightArrowIn();

		groupCards.add(SocietyForCA);

		GroupCard SouthAmericanNazis = new GroupCard("South American Nazis",
			groupCardType, 4, 0, 6, 2, face);
		SouthAmericanNazis.setTopArrowOut();
		SouthAmericanNazis.setRightArrowIn();
		SouthAmericanNazis.setBottomArrowOut();
		SouthAmericanNazis.addAlignment(conservative);
		SouthAmericanNazis.addAlignment(violent);
		groupCards.add(SouthAmericanNazis);

		GroupCard Survivalists = new GroupCard("Survivalists", groupCardType, 0,
			0, 6, 2, face);
		Survivalists.setRightArrowIn();

		Survivalists.addAlignment(conservative);
		Survivalists.addAlignment(violent);
		Survivalists.addAlignment(fanatic);
		groupCards.add(Survivalists);

		GroupCard Tabloids = new GroupCard("Tabloids", groupCardType, 2, 0, 3, 3,
			face);
		Tabloids.setTopArrowOut();
		Tabloids.setRightArrowIn();

		Tabloids.addAlignment(weird);
		groupCards.add(Tabloids);

		GroupCard Texas = new GroupCard("Texas", groupCardType, 6, 0, 6, 4,
			face);
		Texas.setTopArrowOut();
		Texas.setRightArrowOut();
		Texas.setLeftArrowIn();
		Texas.addAlignment(violent);
		Texas.addAlignment(conservative);
		Texas.addAlignment(government);
		groupCards.add(Texas);

		GroupCard TobaccoLiquorCompanies = new GroupCard(
			"Tobacco & Liquor Companies", groupCardType, 4, 0, 3, 3, face);
		TobaccoLiquorCompanies.setTopArrowOut();
		TobaccoLiquorCompanies.setRightArrowIn();
		TobaccoLiquorCompanies.setLeftArrowOut();
		TobaccoLiquorCompanies.addAlignment(straight);
		groupCards.add(TobaccoLiquorCompanies);

		GroupCard Trekkies = new GroupCard("Trekkies", groupCardType, 0, 0, 4, 3,
			face);
		Trekkies.setRightArrowIn();

		Trekkies.addAlignment(weird);
		Trekkies.addAlignment(fanatic);
		groupCards.add(Trekkies);

		GroupCard TriliberalCommission = new GroupCard("Triliberal Commission",
			groupCardType, 5, 0, 6, 3, face);
		TriliberalCommission.setTopArrowOut();
		TriliberalCommission.setRightArrowIn();
		TriliberalCommission.setBottomArrowOut();
		TriliberalCommission.addAlignment(liberal);
		TriliberalCommission.addAlignment(straight);
		groupCards.add(TriliberalCommission);

		GroupCard TVPreachers = new GroupCard("TV Preachers", groupCardType, 3,
			0, 6, 4, face);
		TVPreachers.setRightArrowIn();
		TVPreachers.setBottomArrowOut();
		TVPreachers.setLeftArrowOut();
		TVPreachers.addAlignment(straight);
		TVPreachers.addAlignment(fanatic);
		groupCards.add(TVPreachers);

		GroupCard UndergroundNewspapers = new GroupCard("Underground Newspaper",
			groupCardType, 1, 1, 5, 0, face);
		UndergroundNewspapers.setTopArrowOut();
		UndergroundNewspapers.setRightArrowIn();

		UndergroundNewspapers.addAlignment(communist);
		UndergroundNewspapers.addAlignment(liberal);
		groupCards.add(UndergroundNewspapers);

		GroupCard TheUnitedNations = new GroupCard("The United Nations",
			groupCardType, 1, 0, 3, 3, face);

		TheUnitedNations.setBottomArrowOut();
		TheUnitedNations.setLeftArrowIn();
		TheUnitedNations.addAlignment(liberal);
		groupCards.add(TheUnitedNations);

		GroupCard VideoGames = new GroupCard("Video Games", groupCardType, 2, 0,
			3, 7, face);

		VideoGames.setRightArrowIn();
		VideoGames.setBottomArrowOut();
		groupCards.add(VideoGames);

		GroupCard Yuppies = new GroupCard("Yuppies", groupCardType, 1, 1, 4, 5,
			face);

		Yuppies.setRightArrowIn();
		Yuppies.setBottomArrowOut();

		Yuppies.addAlignment(conservative);
		groupCards.add(Yuppies);

		// /////////////////////////////////////////////////////////////////////
		// THIS IS ONLY 10 GROUP CARDS
		// ////////////////////////////////////////////////////////////////////

	}

	public static void initializeSpecialCards() {
		int specialCardType = 3;
		ImageIcon face = null;

		SpecialCard Assassination = new SpecialCard("Assassination",
			specialCardType, face);
		specialCards.add(Assassination);
		SpecialCard Bribery = new SpecialCard("Bribery", specialCardType, face);
		specialCards.add(Bribery);
		SpecialCard ComputerEspionage = new SpecialCard("Computer Espionage",
			specialCardType, face);

		SpecialCard DeepAgent = new SpecialCard("Deep Agent", specialCardType,
			face);

		SpecialCard Interference = new SpecialCard("Interference",
			specialCardType, face);

		SpecialCard MarketManipulation = new SpecialCard("Market Manipulation",
			specialCardType, face);

		SpecialCard MediaCampaign = new SpecialCard("Media Campaign",
			specialCardType, face);

		SpecialCard MurphysLaw = new SpecialCard("Murphy's Law", specialCardType,
			face);

		SpecialCard Secrets = new SpecialCard(
			"Secreats Man Was Not Meant To Know", specialCardType, face);

		SpecialCard Senate = new SpecialCard("Senate Investigating Committee",
			specialCardType, face);

		SpecialCard SlushFund = new SpecialCard("Slush Fund", specialCardType,
			face);

		SpecialCard SwissBankAccount = new SpecialCard("Swiss Bank Account",
			specialCardType, face);

		SpecialCard WhisperingCampaign = new SpecialCard("Whispering Campaign",
			specialCardType, face);

		SpecialCard WhiteCollarCrime = new SpecialCard("White Collar Crime",
			specialCardType, face);

	}

	public static void createGameDeck() {
		gameDeck = new Deck();
		// Add special cards later
		// SpecialCard.length();

		// Add group cards for now
		// System.out.println("002 groupCards's size is " + groupCards.size());

		for (int i = 0; i < groupCards.size(); i++) {
			gameDeck.addCards(groupCards.get(i));
		}

		// display not-shuffled deck
		gameDeck.displayAllCards();

		// shuffle Deck

		gameDeck.shuffleDeck();
		System.out.println("Shuffled the game deck");

		// display shuffled deck
		gameDeck.displayAllCards();

	}

	public static boolean checkWinner(Player player) {

		if (player.getIlluminati().getCardName() == "The Bavarian Illuminati") {
			//System.out.println("Bavarian");
		}

		if (player.getIlluminati().getPuppetSize() == 2) {
			System.out.println("Yay winner! ");
			return true;
		}

		return false;
	}
}
