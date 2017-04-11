##### Use Case: #1.	Initialize the Game
Actor: Players
Pre-Conditions:
1. Program is running.
2. Player is ready to start a game.

Post-Conditions:
1. Player reset the game.
2. Game is exited.

Event:
1. System check if there is computer controlled player, if needed, initialize a new player.
2. Amount of players is recorded and initialize players.
3. System initialize eight Illuminati cards.
4. System initialize special cards.
5. System initialize group cards.

Extensions:
1. Rest of the deck is also initialized and shuffled with special cards.

##### Use Case: #2.	Roll Dice
Actor: Players
Pre-Conditions:
1. Game has been already initialized.
2. Player's turn to roll the dices.

Post-Conditions:
1. System record player's roll result and reinitialize the dices.

Event:
1. System randomly generate two out comes for dices as result of rolling.
2. System record results for players.
3. System list the orders of dice rolls.
4. System record player's roll result and reinitialize the dices.

Extensions:
1. Loop as it is next player's turn to roll until every play has a roll result.

##### Use Case: #3.	Draw Card
Actor: Players
Pre-Conditions:
1. Player's turn to process to get new card.
2. Player's can draw another card.

Post-Conditions:
1. Player has already did draw card.

Event:
1. System determine what type of card that player draws.
2. System put the card face-up to other players if player draws a Group card.
3. Player can choose to face-up or face-down if player draws a Special card.

Extensions:
1. Loop as it is player's turn to process.

##### Use Case: #4.	Attack to Control
Actor: Players
Pre-Conditions:
1. Player's turn to take action.
2. Player take action to attack.
3. Previous action is complete.

Post-Conditions:
1. Previous action is not complete.

Event:
1. Player announces which Group is attacking, which one is being attacked, and the type of attack.
2. Player can roll the dice.
3. To find the roll required for a successful attack, subtract the defending Group’s Resistance from the attacking.

Extensions:
1. System process attack as an action to targeted player.

##### Use Case: #5.	Attack to Destroy
Actor: Players
Pre-Conditions:
1. Player's turn to take action.
2. Player take action to attack.
3. Previous action is complete.

Post-Conditions:
1. Previous action is not complete.

Event:
1. Instead of rolling “Power minus Resistance,” the attacker rolls “Power minus Power.” In other words, the defending Group defends with Power rather than its Resistance.
2. A Group with no Power cannot be destroyed except by the Special card Whispering Campaign. The factor which keep powerless Groups from organizing enough to control other Groups also make them too diffuse to wipe out.
3. Groups with different philosophies destroy each other opposite alignment, and a -4 for every opposite alignment, and a -4 for every identical alignment.
4. A Group with no Power cannot be destroyed except by the Special card Whispering Campaign. The factors
to attempt destruction.
5. If the attack succeeds, the target Group goes to the "dead pile.” Its subordinate Groups are not destroyed, but become uncontrolled. It can be revived only by the Special card Media Campaign.
6. You may try to destroy a Group you already control. In this case, the target’s closeness to its Illuminati does not protect it. But no Group may attack itself, or aid an attempt to destroy itself!

Extensions:
1. System process attack as an action to targeted player.

##### Use Case: #6.	Attack to Neutralize
Actor: Players
Pre-Conditions:
1. Player's turn to take action.
2. Player take action to attack.
3. Previous action is complete.

Post-Conditions:
1. Previous action is not complete.

Event:
1. Player announces which Group is attacking, the target must be a Group that is already controlled by another player.
2. Player can roll the dice.
3. To find the roll required for a successful attack, subtract the defending Group’s Resistance from the attacking.

Extensions:
1. System process attack as an action to targeted player.

##### Use Case: #7.	Money Transfer
Actor: Players
Pre-Conditions:
1. Player's turn to take action.
2. Player want to give away money to an adjacent Group.

Post-Conditions:
1. Player has no money to give away.

Event:
1. Player may make two money transfers in one turn.
2. Player can also make a transfer as a regular action.

Extensions:
1. The same money may be moved two or more Groups in one turn.

##### Use Case: #8.	Group Transfer
Actor: Players
Pre-Conditions:
1. Player's turn to take action.
2. Player want to give away or trade a group.

Event:
1. Each Group exchanged counts as an action for the player whose turn it is, whichever way the Group moves.
2. If player trades a Group for a Group counts as two actions, one to move the first Group, one to move the second one.

Extensions:
1. Exception: Using the Bribery card is a regular action.
2. May only give a Group away with the permission of the player who receives.

##### Use Case: #9.	Interfere an Attack
Actor: Players
Pre-Conditions:
1. Player's turn to take action.
2. Player interferes an attack.

Event:
1. A Group may, as an action, transfer any of its money to an adjacent Group either its master, or a puppet.
2. A player may make two money transfers as part of his turn.
3. Player can also make a transfer as a regular action. By successive transfers, the same money may be moved two or more Groups in one turn.

Extensions:
1. System remove money from player.
2. System process the interfere player performed on the attack.

##### Use Case: #10.	Call Off an Attack
Actor: Players
Pre-Conditions:
1. After a player announced an attack.
2. Player take action to spend no money on attack.

Post-Conditions:
1. Player committed attack.

Event:
1. If the attacker spends no money, the attack is committed when another player spends money (either for or against him) or when the attacker rolls the dice.
2. Attack is uncommitted.

Extensions:
1. Cancel the previous attack action.

##### Use Case: #11.	Passing a Turn
Actor: Players
Pre-Conditions:
1. Player's turn to take action.
2. Player may choose not to take any actions of any sort

Post-Conditions:
1. Player want to take action.

Event:
1. Player may choose not to take any actions of any sort and collect 5MB instead.

##### Use Case: #12.	Dropping Groups
Actor: Players
Pre-Conditions:
1. Player's can perform as a free action.
2. Player want dropping group.

Post-Conditions:
1. Player has no group to drop.

Event:
1. System removing a Group from Player's Power Structure and returning it to the uncontrolled area.


##### Use Case: #13.	Aiding an Attack
Actor: Players
Pre-Conditions:
1. Player's turn to perform action.
2. Player want to transfer power to another group.

Post-Conditions:
1. Player has no group that can perform a transfer of power.

Event:
1. All Illuminati, and some other Groups, have transferable power. If a Group has two Power numbers separated by a slash (like 5/2), the second number is its transferable power. If a Group does not attack during a turn, it may use its transferable power to aid an attack made by any other Group in its Power Structure.
2. Any number of Groups may aid one attack by adding Transferable Power. However, any one Group may participate in only one attack per turn.
3. When an attack is announced, all transferable power to be used in that attack must be announced before any money is spent to support the attack. No transferable power may be added in the middle of the attack.

Extensions:
1. Exception: The Special Ability of the UFOs lets them participate in two attacks per turn.) Example: A Group with a power of 6, aided by another Group with a transferable power of 4, is attacking a Group with a resistance of 3. The attacker has a total power of 10 (6 plus 4), and will have to roll a 7 or less (10 minus 3) to succeed.

##### Use Case: #14.	Giving away Special Cards
Actor: Players
Pre-Conditions:
1. Player decide to give away their Special Card from iLLuminati

Post-Conditions:
1. There is no Special Card for player to give away
2. Player already loose

Event:
1. Player can give away Special Card(s) from iLLuminati anytime without an action.
2. Player need to select a Special Card as it is a give away Special Card(s).
3. Player who gives away Special Card(s) need to select another play.

Extensions:
1. System draw Special Card(s) from player who gives away Special Card(s) and add the the target player who receive Special Card(s).

##### Use Case: #15.	Trade Special Cards
Actor: Players
Pre-Conditions:
1. Player in the turn involved.
2. Player take action to Transfer or Trade Special Card to another specified player.

Post-Conditions:
1. Player has no Special Card for trade.
2. Player already loose.
3. Another player declined to receive Transfer or trade.

Event:
1. System ask player which Special Card to trade or Transfer.
2. System ask player which player to trade or transfer.
3. System ask player trade condition.
4. System ask another player if accept the trade to transfer.
5. System record the transfer or trade.

Extensions:
1. Transaction will not be process if another player declined trade.

##### Use Case: #16.	Giving away Groups
Actor: Players
Pre-Conditions:
1. Player decide to give away their group away.

Post-Conditions:
1. There is no group for player to give away
2. Player already loose

Event:
1. Player can give away group(s) from anytime without an action.
2. Player need to select group(s) to give away.
3. Player who gives away group(s) need to select another player.

Extensions:
1. System draw group(s) card from player who gives away and add to the target player who receive group(s).

##### Use Case: #17.	Trade Groups
Actor: Players
Pre-Conditions:
1. Player in the turn involved.
2. Player take action to Trade group to another specified player.

Post-Conditions:
1. Player has no group for trade.
2. Player already loose.
3. Another player declined to receive trade.

Event:
1. System ask player which group to trade.
2. System ask player which player to trade.
3. System ask player trade condition.
4. System ask another player if accept the trade.
5. System record the trade.

Extensions:
1. Transaction will not be process if another player declined trade.

##### Use Case: #18.	Gift Money
Actor: Players
Pre-Conditions:
1. Player decide to give away their money from iLLuminati

Post-Conditions:
1. There is no money for player to give away
2. Player already loose

Event:
1. Player can give away money from iLLuminati anytime without an action
2. Player need to input a number as the amount of give away money.
3. Player who gives away money need to select another player.

Extensions:
1. System minus money from player who gives away money and add the the target player who receive money.
