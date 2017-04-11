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

##### Use Case: #19. Use a Special Card: Assassination
Actor: Player
Pre-Condition: 
1. The dices are rolled by any player's attempt to attack to destroy, control, or neutralize.
2. The player has an “Assassination” card in his Special Card pile.
3. The player selects the “Assassination” card to play.
Post-Condition:
1. The “Assassination" card is discarded into the dead pile.
Events:
1. System checks the player's Special Card pile to see if he has an "Assassination" card.
2. System gives the player the option to use the "Assassination" card after the dices are rolled by any player.
3. Player plays the "Assassination" card.
4. The player that rolled the dice will change, retroactively to a value of 2
5. “Assassination" card is discarded into the dead pile.
Extensions:
4. 
a.
1. "Murphy's Law" Special Card is played.
2. The player that rolled the dice will change, retroactively to a value of 12.
3. "Murphy's Law" Special Card is discarded into the dead pile
4.  System goes to step 5. 
b.
1. “Secrets Man Was Not Meant To Know” Special Card is played.
2. “Secrets Man Was Not Meant To Know” Special Card is discarded into the dead pile.
3. System goes to step 5. 
 
##### Use Case: #20. Use a Special Card: Bribery   
Actor: Player
Pre-Condition:
1. It is the player’s turn to take any free actions.
2. The player has at least one available regular action.
3. The player has a “Bribery” card in his Special Card pile.
4. The player selects the “Bribery” card to play.
Post-Condition:
1. The “Bribery" card is discarded into the dead pile.
Events:
1. System gives player the option to take any free actions or any available regular actions.
2. Player decides to take a free action.
3. Player looks into his Special Card pile.
4. Player plays the “Bribery” card.
5. Player automatically takes control of one uncontrolled group
6. Player's action count goes up by 1. 
7. “Bribery" card is discarded into the dead pile.
Extensions:
6. 
a.
1. “Secrets Man Was Not Meant To Know" Special Card is played.
2. “Secrets Man Was Not Meant To Know" is discarded into the dead pile
3.  System goes to step 7. 
 
##### Use Case: #21. Use a Special Card: Computer Espionage
Actor: Player
Pre-Condition:
        	1. It is the player’s turn to take any free actions.
        	2. The player has a “Computer Espionage” card in his Special Card pile.
        	3. The player selects the “Computer Espionage” card to play.
Post-Condition:
        	1. The “Computer Espionage” card is discarded into the dead pile.
Events:
        	1.  System gives player the option to take any free actions or any available regular actions.
        	2. Player decides to take a free action.
        	3. Player looks into his Special Card pile.
        	4. Player plays the “Computer Espionage” card.
	5. System ask the player to decide to count the money on any one group or examine all of one player's special cards. 
        	6. Player can count the money on any one group.
        	7. “Computer Espionage” card is discarded into the dead pile.
Extensions:
4. 
    a.
1. “Secrets Man Was Not Meant To Know” Special Card is played.
2. “Secrets Man Was Not Meant To Know” Special Card is discarded into the dead pile.
    	3.  System goes to step 7. 
Sub-Variation:
	6.
	     a. 
		1. Player’s can examine all of one player's special cards.
		2. System goes to step 7.

##### Use Case: #22. Use a Special Card: Deep Agent
Actor: Player
Pre-Condition: 
	1. Attack privilege is in effect.
	2. The player has a “Deep Agent” card in his Special Card pile.
        	3. The player selects the “Deep Agent” card to play.
Post-Condition:
        	1. The “Deep Agent” card is discarded into the dead pile.
Events:
1. System checks the player's Special Card pile to see if he has an "Deep Agent" card.
	2. System gives the player the option to use the "Deep Agent" card after attack privilege is in effect.
        	3. Player plays the "Deep Agent" card.
        	4. The attack privilege is abolished.
        	5. “Deep Agent" card is discarded into the dead pile.
Extensions:
3. 
    a.
1. “Secrets Man Was Not Meant To Know” Special Card is played.
2. “Secrets Man Was Not Meant To Know” Special Card is discarded into the dead pile.
    	3.  System goes to step 5. 

##### Use Case: #23. Use a Special Card: Interference
Actor: Player
Pre-Condition:
	1. Attack privilege is in effect.
	2. The player has an “Interference” card in his Special Card pile.
        	3. The player selects the “Interference” card to play.
Post-Condition:
        	 1. The “Interference” card is discarded into the dead pile.
Events:
1. System checks the player's Special Card pile to see if he has an "Interference" card.
	2. System gives the player the option to use the "Interference" card after attack privilege is in effect.
        	3. Player plays the "Interference" card.
        	4. Player can interfere with the privileged attack.
        	5. “Interference" card is discarded into the dead pile.
Extensions:
3. 
    a.
1. “Secrets Man Was Not Meant To Know” Special Card is played.
2. “Secrets Man Was Not Meant To Know” Special Card is discarded into the dead pile.
    	3.  System goes to step 5 . 
 
##### Use Case: #24. Use a Special Card: Market Manipulation
Actor: Player
Pre-Condition:
1. Player is in the "Income Phase."
	2. The player has a “Market Manipulation” card in his Special Card pile.
        	3. The player selects the “Interference” card to play.
Post-Condition:
        	1. The “Market Manipulation” card is discarded into the dead pile.
Events:
1. System checks the player's Special Card pile to see if he has an "Market Manipulation" card.
	2. System gives the player the option to use the "Market Manipulation" card during his "Income Phase."
        	3. Player plays the "Market Manipulation" card.
        	4. Double all of the player's groups' incomes for one turn only.
        	5. “Market Manipulation" card is discarded into the dead pile.
Extensions:
3. 
    a.
1. “Secrets Man Was Not Meant To Know” Special Card is played.
2. “Secrets Man Was Not Meant To Know” Special Card is discarded into the dead pile.
    	3.  System goes to step 5. 
4.
	     a. 
		1. I.R.S Group Card cannot collect income twice.
		2. Post Office Group Card is not required to pay twice.
		3. System goes to step 5.

##### Use Case: #25. Use a Special Card of Media Campaign
Actor: Player
Pre-Condition:
	1. There is at least one group in the dead pile.
2. It is the player’s turn to take any free actions.
        	3. The player has a “Media Campaign” card in his Special Card pile.
        	4. The player selects the “Media Campaign” card to play.
Post-Condition:
        	 The “Media Campaign” card is discarded into the dead pile.
Events:
        	1.  System gives player the option to take any free actions or any available regular actions.
        	2. Player decides to take a free action.
        	3. Player looks into his Special Card pile.
        	4. Player plays the “Media Campaign” card.
	5. System ask the player to pick a group in the dead pile to revive.
6. The revived group goes to the uncontrolled area.  
        	7. “Media Campaign” card is discarded into the dead pile.
Extensions:
4. 
    a.
1. “Secrets Man Was Not Meant To Know” Special Card is played.
2. “Secrets Man Was Not Meant To Know” Special Card is discarded into the dead pile.
    	3.  System goes to step 7. 

##### Use Case: #26. Use a Special Card: Murphy’s Law
Actor: Player
Pre-Condition: 
	1. The dices are rolled by any player's attempt to attack to destroy, control, or neutralize.
	2. The player has a “Murphy's Law” card in his Special Card pile.
        	3. The player selects the “Murphy's Law” card to play.
Post-Condition:
        	 1. The “Murphy's Law” card is discarded into the dead pile.
Events:
	1. System checks the player's Special Card pile to see if he has an “Murphy's Law” card.
	2. System gives the player the option to use the “Murphy's Law” card after the dices are rolled by any player.
        	3. Player plays the “Murphy's Law” card.
        	4. The player that rolled the dice will change, retroactively to a value of 12
        	5. “Murphy's Law” card is discarded into the dead pile.
Extensions:
3. 
    a.
1. "Assassination" Special Card is played.
    	2. The player that rolled the dice will change, retroactively to a value of 2.
    	3. "Assassination" Special Card is discarded into the dead pile
    	4.  System goes to step 5. 
    b.
1. “Secrets Man Was Not Meant To Know” Special Card is played.
2. “Secrets Man Was Not Meant To Know” Special Card is discarded into the dead pile.
    	3.  System goes to step 5. 
 
##### Use Case: #27. Use a Special Card: Secrets Man Was Not Meant To Know
Actor: Player
Pre-Condition:
	1. A Special Card that is not “Secrets Man Was Not Meant To Know” is played.
	2. The player has a “Secrets Man Was Not Meant To Know” card in his Special Card pile.
        	3. The player selects the “Secrets Man Was Not Meant To Know” card to play.
Post-Condition:
	1. The “Secrets Man Was Not Meant To Know” card is discarded into the dead pile.
Events:
1. System checks the player's Special Card pile to see if he has an “Secrets Man Was Not Meant To Know” card.
	2. System gives the player the option to use the “Secrets Man Was Not Meant To Know” card after any other Special Card is played.       	  
	3. Player plays the “Secrets Man Was Not Meant To Know” card.
        	4. The other Special Card is neutralized.
	5. The other Special Card has no effect.
        	6. “Murphy's Law” card is discarded into the dead pile.
Extensions:
	Not Applicable. 

##### Use Case: #28. Use a Special Card: Senate Investigating Committee
Actor: Player
Pre-Condition: 
	1. It is the beginning of any other player's turn.
	2. The player has a “Senate Investigating Committee” card in his Special Card pile.
        	3. The player selects the “Senate Investigating Committee” card to play.
Post-Condition:
        	 The “Senate Investigating Committee” card is discarded into the dead pile.
Events:
	1. System checks the player's Special Card pile to see if he has an “Senate Investigating Committee” card.
	2. System gives the player the option to use the “Senate Investigating Committee” card during the beginning of any other player's turn.
        	3. Player plays the “Senate Investigating Committee” card.
        	4. The other player's turn is over completely.
        	5. “Senate Investigating Committee” card is discarded into the dead pile.
Extensions:
3. 
    a.
1. “Secrets Man Was Not Meant To Know” Special Card is played.
2. “Secrets Man Was Not Meant To Know” Special Card is discarded into the dead pile.
    	3.  System goes to step 5. 

##### Use Case: #29. Use a Special Card: Slush Fund
Actor: Player
Pre-Condition:
        	1. It is the player’s turn to take any free actions.
        	2. The player has a “Slush Fund” card in his Special Card pile.
        	3. The player selects the “Slush Fund” card to play.
Post-Condition:
        	 1. The “Slush Fund” card is discarded into the dead pile.
Events:
        	1.  System gives player the option to take any free actions or any available regular actions.
        	2. Player decides to take a free action.
        	3. Player looks into his Special Card pile.
        	4. Player plays the “Slush Fund” card.
        	5. Player’s Illuminati treasury gains 15 MB.
        	6. “Slush Fund” card is discarded into the dead pile.
Extensions:
4. 
    a.
1. “Secrets Man Was Not Meant To Know” Special Card is played.
2. “Secrets Man Was Not Meant To Know” Special Card is discarded into the dead pile.
    	3.  System goes to step 6. 

##### Use Case: #30. Use a Special Card: Swiss Bank Account
Actor: Player
Pre-Condition: 
1. It is the player’s turn to take any free actions. 
2. The player has a "Swiss Bank Account“ card in his Special Card pile.
3. The player selects the "Swiss Bank Account“ card to play.
Post-Condition: 
The "Swiss Bank Account“ card is discarded into the dead pile.
Events:
1.  System gives player the option to take any free actions or any available regular actions.
2. Player decides to take a free action.
3. Player looks into her Special Card pile.
4. Player plays the "Swiss Bank Account“ card.
5. Player’s Illuminati treasury gains 25 MB.
6. "Swiss Bank Account“ card is discarded into the dead pile.
Extensions:
4. 
    a.
1. “Secrets Man Was Not Meant To Know” Special Card is played.
2. “Secrets Man Was Not Meant To Know” Special Card is discarded into the dead pile.
    	3.  System goes to step 6. 

##### Use Case: #31. Use a Special Card: Whispering Campaign
Actor: Player
Pre-Condition: 
1. It is the player’s turn to take any free actions. 
2. The player has at least one available regular action.
3. At least one group card with Power 0 is in the uncontrolled area.
4. At least one group card with Power 0 is part of another player's power structure.
5. The player has a "Whispering Campaign“ card in his Special Card pile.
6. The player selects the "Whispering Campaign“ card to play.
Post-Condition: 
1. The "Whispering Campaign“ card is discarded into the dead pile.
Events:
1. System gives player the option to take any free actions or any available regular actions.
2. Player decides to take a free action.
3. Player looks into her Special Card pile.
4. Player plays the "Whispering Campaign“ card.
5. Player decides to take a regular action of attacking a group card with Power 0.
6. Player rolls attacking power versus defending resistance.
7. The defending group card with Power 0 is sent to the dead pile after a successful attack. 
8. Player's action count goes up by 1. 
9. "Whispering Campaign“ card is discarded into the dead pile.
Extensions:
 4.
     a.
1. “Secrets Man Was Not Meant To Know” Special Card is played.
2. “Secrets Man Was Not Meant To Know” Special Card is discarded into the dead pile.
    	3.  System goes to step 8. 
Sub-Variation:
	7
	    a.
		1. The defending group card with Power 0 is not sent to the dead pile after an unsuccessful attack.
		2. System goes to step 8.

##### Use Case: #32. Use a Special Card: White Collar Crime
Actor: Player
Pre-Condition:
        	1. It is the player’s turn to take any free actions.
	2. The player has at least one group card in his power structure, not including his Illuminati.
	3. The player has at least one megabuck.
        	2. The player has a “White Collar Crime” card in his Special Card pile.
        	3. The player selects the “White Collar Crime” card to play.
Post-Condition:
        	 1. The “White Collar Crime” card is discarded into the dead pile.
Events:
        	1. System gives player the option to take any free actions or any available regular actions.
        	2. Player decides to take a free action.
        	3. Player looks into his Special Card pile.
        	4. Player plays the “White Collar Crime” card.
	5. System ask the user which group card will get an extra 5 megabucks.
	6. System ask the user if he would like to transfer megabucks between any of his groups.
        	7. “Slush Fund” card is discarded into the dead pile.
Extensions:
4. 
    a.
1. “Secrets Man Was Not Meant To Know” Special Card is played.
2. “Secrets Man Was Not Meant To Know” Special Card is discarded into the dead pile.
    	3.  System goes to step 7. 
Sub-Variation:
	6. 
   a.
1. Player decides to transfer megabucks between any of his groups.
		2. System ask the user which group card will be the source of megabucks transfer.
        		3. System ask the user how many megabucks he would like to transfer from the source group card.
		4. System ask the user which group card will be the destination of megabucks transfer.
5. Megabucks are transferred from the source group card to the destination group card.
6. System goes to step 6.
	   b. 
		1. Player decides to not transfer anymore megabucks between any of his groups.
		2. System goes to step 7.

##### Use Case: #33. Discard a Special Card to Make Attack Privilege
Actor: Player
Pre-Condition:
1. The player has at least one available regular action.
2. The player has at least one Special Card in her pile.
Post-Condition: 
	1. The discarded Special Card is sent into the dead pile.
Events:
1. System gives player the option to take any free actions or any available regular actions.
2. Player decides to take a regular action by attacking a group.
3. Player looks into her Special Card pile.
4. Player discards one Special Card.
5. Player declares attack as privileged
6. Player's action count goes up by 1. 
7. "The discarded Special Card is sent into the dead pile.
Extensions:
 5.
     a.
 	1. A "Deep Agent" Special Card is played by another player.
i. Player's privilege attack is now abolished.
ii. System goes to step 6
2. “Secrets Man Was Not Meant To Know” Special Card is played.
	i. "Deep Agent" Special Card has no effect on the player's privilege attack.
	ii. System goes to step 6.
     b. 
1. Another player discarded two Special Cards
	i.	i. Player's privilege attack is now abolished.
		ii. System goes to step 6.
2. “Secrets Man Was Not Meant To Know” Special Card is played.
	i. One of the discarded Special Card is canceled.
		a. Another Special Card is discarded to replace the canceled Special Card.
 	i. Player's privilege attack is now abolished.
			ii. The discarded Special Card is sent to the dead pile. 
	iii. System goes to step 6. 
b. Other player did not discard another Special Card to replace the canceled Special Card.
i. Player's privilege attack is still in effect.
ii. System goes to step 6.
     	 
##### Use Case: #34. Discard two Special Cards to Abolish Someone Else's Attack Privilege
Actor: Player
Pre-Condition: 
	1. Another player has an attack that is privileged.
	2. The player has at least two Special Cards in his pile.
Post-Condition:
	1. At least two Special Cards are discarded into the dead pile.
Events:
	1. System checks the player's Special Card pile to see if he has at least two Special Cards.
	2. System gives the player the option to discard two Special Cards during the attack phase of another player where the attack is privileged.
        	3. Player discards two Special Cards
        	4. The other player's privilege attack is now abolished
        	5. The discarded two Special Cards are sent to the dead pile.
Extensions:
3. “Secrets Man Was Not Meant To Know” Special Card is played.
i. One of the player's discarded Special Card is canceled.
			a. Player discard another Special Card to replace the canceled Special Card.
	i. The discarded Special Card is sent to the dead pile. 
ii. System goes to step 4. 
b. Other player did not discard another Special Card to replace the canceled Special Card.
i. The other player's privilege attack is still in effect.
ii. System goes to step 5.

##### Use Case: #35. Meets Basic Goal
Actor: Player
Pre-Condition:
	1. It is the end of a player's turn.
	2. All active players have power structures with controlled groups, including their Illuminatis.
Post-Condition:
	1. System ends the game.
Events:
	1. System checks how many controlled groups is controlled by all player(s).
	2. System decides the winner when the right number of controlled groups is met based on the amount of players at the beginning of the game.
	3. System checks if there are more than one player who meet the basic goal.
4. System declares the winner.
5. System congratulates the winner.
6. System ends the game. 
Extensions:
	3
   a. 
1. System checks if there are more than one player who meet the basic goal.
2. System decides the winners.
3. System declares the winners.
4. System congratulates the winners.
5. System goes to step 6. 
Sub-Variation:
 	2
   a.
	1. System checks if there are 2 to 3 players were playing at the start of the game.
		i.  System checks if any of the players have 13 controlled groups.
		ii. System goes to step 3. 
	2. System checks if there are 4 players were playing at the start of the game.
i.  System checks if any of the players have 12 controlled groups.
		ii. System goes to step 3. 
	3. System checks if there are 5 players were playing at the start of the game.
		i.  System checks if any of the players have 10 controlled groups.
		ii. System goes to step 3. 
	4. System checks if there are 6 players were playing at the start of the game.
		i.  System checks if any of the players have 9 controlled groups.
		ii. System goes to step 3. 
	5. System checks if there are 7 to 8 players were playing at the start of the game.
		i.  System checks if any of the players have 8 controlled groups.
		ii. System goes to step 3. 

##### Use Case: #36. Meets Special Goal of The Bavarian Illuminati
Actor: Player
Pre-Condition:
1. 	Game is still taking place(Any players turn)
2. 	Player has controlling groups
3. 	Player total power of controlling groups is Power 35
Post-Condition:
1. 	Game is over and this player wins
Events:
1. 	System checks the players power structure to see if its legal
2. 	System checks the players power structure to see it is 35
3. 	Bavarian Illuminati Special Goal is activated
4. 	The Game is over and player wins
Extensions:
1. 	None
 
##### Use Case: #37.  Meets Special Goal of The Bermuda Triangle
Actor: Player
Pre-Condition:
1. 	Must be end of players turn
2. 	All ten different alignments must be satisfied
Post-Condition:
1. 	Game is over and this player wins
Events:
1. 	System checks the alignment of the players group structure
2. 	System checks the alignment of other group structures
3. 	System checks to see if all ten different alignments are in effect
4. 	The Bermuda Triangle Special Goal is activated
5. 	The game is over and player wins
Extensions:
1. 	None
 
##### Use Case: #38. Meets the Special Goal of The Discordian Society
Actor: Player
Pre-Condition:
1. 	Must be players turn
2. 	Control 5 Weird Groups
Post-Condition:
1. 	The game is over and the player wins
Events:
1. 	System checks if players turn
2. 	System checks to see how many controlling groups are part of structure
3. 	System checks if there are 5 weird groups controlled
4. 	The Discordian Society Special Goal is activated
5. 	The game is over and the player wins
Extensions:
1. 	None
 
##### Use Case: #39. Meets the Special Goal of The Gnomes of Zurich
Actor: Player
Pre-Condition:
1. 	Must be players turn
2. 	Must amass 150 megabucks
a) 	On either their Illumaniati or
b)	On or their treasuries of their whole power structure
Post- Condition:
1. 	The game is over and the player wins
Events:
1. 	System checks to see if players turn
2. 	System checks players megabucks and treasuries
3. 	System counts to see if players megabucks is 150 or more
4. 	The Gnomes of Zurich special goal is activated
5. 	The game is over and the player wins
Extensions:
1. 	None

##### Use Cases: #40. Meets the Special Goal of The Network
Actor: Player
Pre-Condition:
1. 	Must be players turn
2. 	Player has total of 25 points of transferable power, including its own 7
Post-Condition:
1. 	The game is over and the player wins
Events:
1. 	System checks to see if players turn
2. 	System checks players transferable powers
3. 	System counts if transferable power is 25 or more
4. 	The Network Special Goal is activated
5. 	The game is over and the player wins
Extensions:
1. 	None
 
##### Use Case: #41. Meets Special Goal of The Servants of Cthulhu
Actor: Player
Pre-Condition:
1. 	Must be players turn
2. 	Must have destroyed 8 other groups
Post-Condition:
1. 	They game is over and the player wins
Events:
1. 	System checks to see if players turn
2. 	System checks how many groups player has destroyed
3. 	System counts if groups destroyed is 8
4. 	The Servants of Cthulhu Special Goal is activated
5. 	The game is over and the player has won
Extensions:
1. 	None
 
##### Use Case: #42. Meets the Special Goal of The Society of Assassins
Actor: Player
Pre-Conditions:
1. 	Must be players turn
2. 	Player must own 6 Violent groups
Post-Conditions:
1. 	The game is over and the player wins
Events:
1. 	System checks to se if players turn
2. 	System checks players violent groups
3. 	System counts if players violent groups is more than 6
4. 	The Society of Assassins Special Goal is activated
5. 	The game is over and player has won
Extensions:
1. 	None
 
##### Use Case: #43. Meets the Special Goal of The UFO’s
Actor: Player
Pre-Conditions:
1. 	Must be players turn
2. 	Player must satisfy goal they set for themselves
3. 	Goal must be valid
Post-Conditions:
1. 	The game is over and player has won
Events:
1. 	System checks if game still in progress
2. 	System will check players chosen special goal
3. 	System will check if chosen goal is valid
4. 	System will check if players goal is satisfied
5. 	The UFO’s special goal is activated via chosen goal
6. 	The game is over and player has won
Extensions:
1. 	None
##### Use Case: #44. Use a Special Ability of The Bavarian Illuminati
Actor: Player
Pre-Conditions:
1. 	Must be players turn
2. 	Player must have an action available
3. 	Player must be attacking
Post-Conditions:
1. 	Player completes a privileged attack
2. 	Player loses 5 megabucks
Events:
1. 	System check if its players turn
2. 	System check if player has attack actions available
3. 	Player will declare attack
4. 	Player will spend 5 megabucks
5. 	Special Ability of The Bavarian Illuminati is activated
6. 	System will block any interference
7. 	Now privileged attack takes place
8. 	Attack is over
Extensions:
1. 	None
##### Use Case: #45. Use a Special Ability of The Bermuda Triangle
Actor: Player
Pre-Conditions:
1. 	Must be end of players turn
Post-Conditions:
1. 	Players power structure is re-organized
2. 	Players turn is over
Events:
1. 	System checks if it’s the end of players turn regardless of action usage
2. 	Special Ability of The Bermuda Triangle is activated
3. 	System checks if reorganized structure is legal
4. 	Players turn comes to an end
Extensions:
1. 	None
 
##### Use Case: #46. Use a Special Ability of The Discordian Society
Actor: Player
Pre-Condition:
1. 	 Either
a) 	Must be players turn
                                          I.         Player must have action to attack
                                        II.         Player must be attacking to control
                                      III.         Player must be targeting weird groups
b)	Any time during the game
Post-Conditions:
1. 	Either
a) 	Player has received +4 boost on attack to control weird groups
b)	Attacks by Straight and Government have no effect
Events:
1. 	Either
a) 	System checks if players turn
                                          I.         System checks if player has action to attack
                                        II.         Player must be attacking to control Weird groups
                                      III.         Player declares attack
                                     IV.         System checks if attack is on controlling Weird groups
                                       V.         The Special Ability of The Discordian Society is activated
                                     VI.         Attack to control weird groups takes place
                                   VII.         Attack is over
b)	Game is still going
                                          I.         Opposition declares attack on player
                                        II.         System checks if its attack to control
                                      III.         System check if attacking group is Straight or Government
                                     IV.         The Special Ability of the Discordian Society is activated
Extensions:
1. 	None
 
##### Use Cases: #47. Use the Special Ability of The Gnomes of Zurich
Actor: Player
Pre-Conditions:
1. 	Must be end of players turn
Post-Conditions:
1. 	Players money is restructured
2. 	Players turn is over
Events:
1. 	System checks if the end of players turn
2. 	Special Ability of The Gnomes of Zurich is activated
3. 	System checks if the restored megabucks is legal
4. 	Players turn is over
Extensions:
1. 	None
 
##### Use Case: #48 Use a Special Ability of The Network
Actor: Player
Pre-Conditions:
1. 	Must be start of players turn
Post-Conditions:
1. 	Player has an extra card in hand
2. 	Players turn continues
Events:
1. 	System checks if start of players turn
2. 	Special Ability of The Network is activated
3. 	Players turn continues
Extensions:
1. 	None
 
##### Use Case: #49. Use a Special Ability of The Servants of Cthulhu
Actor: Player
Pre-Conditions:
1. 	Must be players turn
2. 	Player must have attack action left
3. 	Player must be attacking to destroy
Post-Conditions:
1. 	Player receives boost on attack to destroy
2. 	Players turn is over
Events:
1. 	System checks if Players turn
2. 	System checks if player has attack action available
3. 	Player declares attack
4. 	System checks if player is attacking to destroy
5. 	The Special Ability of The Servants of Cthulhu is activated
6. 	Attack takes place
7. 	Attack is over
Extensions:
1. 	None
 
##### Use Case: #50. Use Special Ability of The Society of Assassins
Actor: Player
Pre-Conditions:
1. 	Must be players turn
2. 	Player must have attacking action
3. 	Player must be attacking to neutralize
Post-Conditions:
1. 	Player receives boost on attack to neutralize
2. 	Players turn is over
Events:
1. 	System checks if players turn
2. 	System checks if player has attack action available
3. 	Player declares attack
4. 	System checks if player is attacking to neutralize
5. 	The Special Ability of The Society of Assassins is activated
6. 	Attack takes place
7. 	Attack is over
Extensions:
1. 	None
 
##### Use Case: #51. Use Special Ability of The UFO’s
Actor: Player
Pre-Conditions:
1. 	Must be players turn
2. 	Player must have already attacked or aid an attack
Post-Conditions:
1. 	Player will have aided attack or attacked twice in turn
2. 	Players turn is over
Events:
1. 	System checks if players turn
2. 	System checks if player has attack action available
3. 	System checks if player has already attacked
4. 	Special Ability of The UFO’s is activated
5. 	Second attack/aid has taken place
6. 	Second attack/aid is over
Extensions:
1. 	None
 
##### Use Cases: #52. Leave Game
Actor: Player
Pre-Conditions:
1. 	A winner has been declared
Post-Conditions:
1. 	None
Events:
1. 	System checks if winner has been declared
2. 	Leave the game
Extensions:
1. 	None
 
 
 
 



 
 
 
 


