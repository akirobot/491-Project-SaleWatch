package theilluminatigame;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class GroupCard extends Card
	implements Attack, cardStats, cardUpdateStats {

	private int ID;

	public void setID(int n) {
		ID = n;
	}

	public int getID() {
		return ID;
	}

	private Card master;
	private Card rootMaster;
	private Illuminati illuminati;
	private ArrayList<GroupCard> puppets = new ArrayList<GroupCard>();

	private ArrayList<String> alignments = new ArrayList<String>();

	// Non-default values
	// These values change during the course of the game
	private int treasury;
	private int income;
	private int power;
	private int resistance;
	private int transferrablePower;

	// Default values
	// These values should not change during the course of the game, besides the
	// initial assignment
	private int incomeDefault;
	private int powerDefault;
	private int transferrablePowerDefault;
	private int resistanceDefault;

	private IncomingArrow leftIn;
	private IncomingArrow rightIn;

	private OutgoingArrow top;
	private OutgoingArrow bottom;
	private OutgoingArrow leftOut;
	private OutgoingArrow rightOut;

	// When the card gets removed and have no children, reset distFRoot to 0;
	private int distFRoot = 0;

	public int getDistanceFromRoot() {
		// if (this.distFRoot == 0) {
		distanceFromRoot();
		// }
		return distFRoot;
	}

	/**
	 * Calculates distance from root
	 * 
	 * @return
	 */
	public int distanceFromRoot() {
		int distFromRoot = 0;
		Card tempMaster = this.getMaster();

		if (tempMaster != null) {
			// System.out.println("501 Dist tempMaster "
			// + tempMaster.getCardName() + "for " + this.getCardName());
		}
		while ((tempMaster != null)) {

			// System.out.println("502 Dist ");
			if (tempMaster.getCardType() == 2) {
				System.out.println("504a tempMaster is a Group Card "
					+ tempMaster.getCardName());
				distFromRoot += 1;

				if (tempMaster != null) {
					System.out.println(
						"504a888 tempMaster is " + tempMaster.getCardName());
					this.rootMaster = tempMaster;
				}

			}

			if (tempMaster.getCardType() == 1) {
				System.out.println("504 tempMaster is an illuminati "
					+ tempMaster.getCardName());
				distFromRoot += 1;

				if (tempMaster != null) {
					System.out.println(
						"504Z tempMaster is " + tempMaster.getCardName());
					this.rootMaster = tempMaster;
				}

				break;
			}
			tempMaster = ((GroupCard) tempMaster).getMaster();

		}

		// System.out.println("500 Distance From Root is " + distFromRoot);
		this.distFRoot = distFromRoot;
		return distFromRoot;
	}

	public Card getRootMaster() {
		this.distanceFromRoot();
		return this.rootMaster;
	}

	public void swapPowerStructureWithPuppets(GroupCard pup) {

		System.out.println("600a " + this.getRootMaster().getCardName());
		System.out.println("600b " + pup.getCardName());

		System.out.println("600ca " + (this.getRootMaster() == pup));
		System.out.println("600cb " + pup);

		if (this.getMaster() == pup) {
			this.setMaster(null);
			this.setLeftArrowIn();
			this.setRightArrowIn();

			if (pup.getBottomArrow().getCardFromArrow() == pup) {
				pup.setBottomArrowOut();
			}

			if (pup.getTopArrow().getCardFromArrow() == pup) {
				pup.setTopArrowOut();
			}

			if (pup.getLeftArrowOut().getCardFromArrow() == pup) {
				pup.setLeftArrowOut();
			}

			if (pup.getRightArrowOut().getCardFromArrow() == pup) {
				pup.setRightArrowOut();
			}

			pup.getPuppetArrayList().clear();

		}
		if ((this.getRootMaster() == pup)) {
			this.setMaster(null);
			this.setLeftArrowIn();
			this.setRightArrowIn();

			if (pup.getTopArrow() != null) {

				if (pup.getTopArrow().getCardFromArrow() == pup) {
					pup.setTopArrowOut();
				}
			}

			if (pup.getBottomArrow() != null) {
				if (pup.getBottomArrow().getCardFromArrow() == pup) {
					pup.setBottomArrowOut();
				}
			}

			if (pup.getLeftArrowOut() != null) {

				if (pup.getLeftArrowOut().getCardFromArrow() == pup) {
					pup.setLeftArrowOut();
				}

			}

			if (pup.getRightArrowOut() != null) {

				if (pup.getRightArrowOut().getCardFromArrow() == pup) {
					pup.setRightArrowOut();
				}
			}

			// System.out.println("607a calculate distance from root should be
			// 0: "
			// + this.distanceFromRoot());
			System.out.println("607b distance from root should be 0: "
				+ this.getDistanceFromRoot());

		}

		// check available outgoing arrows for this card

	}

	public GroupCard(String name, int type, int power, int tPower,
		int resistance, int income, ImageIcon face) {
		super(name, type, power, tPower, resistance, income, face);

		this.incomeDefault = income;
		this.powerDefault = power;
		this.transferrablePowerDefault = tPower;
		this.resistanceDefault = resistance;

		this.income = income;
		this.power = power;
		this.transferrablePower = tPower;
		this.resistance = resistance;
	}

	/**
	 * Print out all of the arrows with types of this Card If leftIn is null,
	 * then
	 */
	public void printOutTypeOfArrows() {
		System.out.println("311 printOutTypeOfArrows called ");

		System.out.println(
			this.getCardName() + "has the following arrows and types: ");
		if (top != null) {
			System.out.println("\tTop Out");
		}

		if (bottom != null) {
			System.out.println("\tBottom Out");
		}

		if (leftIn != null) {
			System.out.println("\tLeft In");
		}

		if (rightIn != null) {
			System.out.println("\tRight In");
		}

		if (leftOut != null) {
			System.out.println("\tLeft Out");
		}

		if (rightOut != null) {
			System.out.println("\tRight Out");
		}

	}

	/**
	 * Print out all of the available arrows with types. In order words, print
	 * out the open slots for this card,
	 * 
	 */
	public void printOutAvailableArrows() {
		System.out.println("312 printOutAvailableArrows called ");
		System.out.println(this.getCardName()
			+ "has the following available arrows and types: ");

		if (top != null) {

			if (top.getCardFromArrow() == null) {
				System.out.println("\tTop Out <Empty>");
			}
		}

		if (bottom != null) {

			if (bottom.getCardFromArrow() == null) {
				System.out.println("\tBottom Out <Empty>");
			}
		}

		if (leftIn != null) {
			if (leftIn.getCardFromArrow() == null) {
				System.out.println("\tLeft In <Empty>");
			}
		}

		if (rightIn != null) {
			if (rightIn.getCardFromArrow() == null) {
				System.out.println("\tRight In <Empty>");
			}
		}

		if (leftOut != null) {
			if (leftOut.getCardFromArrow() == null) {
				System.out.println("\tLeft Out <Empty>");
			}
		}

		if (rightOut != null) {
			if (rightOut.getCardFromArrow() == null) {
				System.out.println("\tRight Out <Empty>");
			}
		}

	}

	public void printOutAvailableAndOccupiedArrows() {
		System.out.println("313 printOutAvailableAndOccupiedArrows called ");
		System.out.println(this.getCardName()
			+ " has the following available and occupied arrows and types: ");

		if (top != null) {

			if (top.getCardFromArrow() == null) {
				System.out.println("\tTop Out: <Empty>");
			}

			if (top.getCardFromArrow() != null) {
				System.out.println(
					"\tTop Out: " + top.getCardFromArrow().getCardName());
			}
		}

		if (bottom != null) {

			if (bottom.getCardFromArrow() == null) {
				System.out.println("\tBottom Out: <Empty>");
			}

			if (bottom.getCardFromArrow() != null) {
				System.out.println(
					"\tBottom Out: " + bottom.getCardFromArrow().getCardName());
			}

		}

		if (leftIn != null) {
			if (leftIn.getCardFromArrow() == null) {
				System.out.println("\tLeft In: <Empty>");
			}

			if (leftIn.getCardFromArrow() != null) {
				System.out.println(
					"\tLeft In: " + leftIn.getCardFromArrow().getCardName());
			}

		}

		if (rightIn != null) {
			if (rightIn.getCardFromArrow() == null) {
				System.out.println("\tRight In: <Empty>");
			}

			if (rightIn.getCardFromArrow() != null) {
				System.out.println(
					"\tRight In: " + rightIn.getCardFromArrow().getCardName());
			}
		}

		if (leftOut != null) {
			if (leftOut.getCardFromArrow() == null) {
				System.out.println("\tLeft Out: <Empty>");
			}

			if (leftOut.getCardFromArrow() != null) {
				System.out.println(
					"\tLeft Out: " + leftOut.getCardFromArrow().getCardName());
			}
		}

		if (rightOut != null) {
			if (rightOut.getCardFromArrow() == null) {
				System.out.println("\tRight Out: <Empty>");
			}

			if (rightOut.getCardFromArrow() != null) {
				System.out.println(
					"\tRight Out: " + rightOut.getCardFromArrow().getCardName());
			}
		}

	}

	public void printOutAvailableAndOccupiedArrowsWithNumbers() {
		System.out.println(
			"314 printOutAvailableAndOccupiedArrows with numbers called ");

		// ArrayList of Integer Objects with a capital I. integer is a
		// primitive. Integer is a wrapper.
		ArrayList<Integer> numbersList = new ArrayList<Integer>();
		numbersList.clear();

		// iterator
		int numIt = 0;
		System.out.println(this.getCardName()
			+ "has the following available and occupied arrows and types: ");

		if (top != null) {
			numIt++;
			numbersList.add((Integer) numIt);
			System.out.print("\t");
			// ArrayList.get(numIt - 1) because of 0-based numbering.
			System.out.print(numbersList.get(numIt - 1).intValue());
			System.out.print(". ");

			if (top.getCardFromArrow() == null) {
				System.out.println("Top Out: <Empty>");
			}

			if (top.getCardFromArrow() != null) {
				System.out
					.println("Top Out: " + top.getCardFromArrow().getCardName());
			}
		}

		if (bottom != null) {
			numIt++;
			numbersList.add((Integer) numIt);
			System.out.print("\t");

			System.out.print(numbersList.get(numIt - 1).intValue());
			System.out.print(". ");

			if (bottom.getCardFromArrow() == null) {
				System.out.println("Bottom Out: <Empty>");
			}

			if (bottom.getCardFromArrow() != null) {
				System.out.println(
					"Bottom Out: " + bottom.getCardFromArrow().getCardName());
			}

		}

		if (leftIn != null) {
			numIt++;
			numbersList.add((Integer) numIt);
			System.out.print("\t");

			System.out.print(numbersList.get(numIt - 1).intValue());
			System.out.print(". ");

			if (leftIn.getCardFromArrow() == null) {
				System.out.println("Left In: <Empty>");
			}

			if (leftIn.getCardFromArrow() != null) {
				System.out.println(
					"Left In: " + leftIn.getCardFromArrow().getCardName());
			}

		}

		if (rightIn != null) {
			numIt++;
			numbersList.add((Integer) numIt);
			System.out.print("\t");

			System.out.print(numbersList.get(numIt - 1).intValue());
			System.out.print(". ");

			if (rightIn.getCardFromArrow() == null) {
				System.out.println("Right In: <Empty>");
			}

			if (rightIn.getCardFromArrow() != null) {
				System.out.println(
					"Right In: " + rightIn.getCardFromArrow().getCardName());
			}
		}

		if (leftOut != null) {
			numIt++;
			numbersList.add((Integer) numIt);
			System.out.print("\t");

			System.out.print(numbersList.get(numIt - 1).intValue());
			System.out.print(". ");

			if (leftOut.getCardFromArrow() == null) {
				System.out.println("Left Out: <Empty>");
			}

			if (leftOut.getCardFromArrow() != null) {
				System.out.println(
					"Left Out: " + leftOut.getCardFromArrow().getCardName());
			}
		}

		if (rightOut != null) {
			numIt++;
			numbersList.add((Integer) numIt);
			System.out.print("\t");
			System.out.println(numbersList.get(numIt - 1).intValue());
			System.out.print(". ");

			if (rightOut.getCardFromArrow() == null) {
				System.out.println("Right Out: <Empty>");
			}

			if (rightOut.getCardFromArrow() != null) {
				System.out.println(
					"Right Out: " + rightOut.getCardFromArrow().getCardName());
			}
		}

	}

	/**
	 * Attemping to print out all of the childrens/puppets outgoing arrows,
	 * including empties of a master card, No Incoming Arrows
	 */
	public void recursivePrintOutAvailableAndOccupiedArrowsWithNumbers() {

		// ArrayList of Integer Objects with a capital I. integer is a
		// primitive. Integer is a wrapper.
		ArrayList<Integer> numbersList = new ArrayList<Integer>();
		numbersList.clear();

		int topChoice = 1;
		int bottomChoice = 2;
		int rightOutChoice = 3;
		int leftOutChoice = 4;

		System.out.println("330% this card's distance is " + this.getCardName()
			+ ": " + this.getDistanceFromRoot());
		// iterator
		int numIt = 0;
		if (this.getDistanceFromRoot() == 0) {
			System.out.println("rooty " + this.getCardName());
		}
		// if(this.getDistanceFromRoot() > 0){
		// for(int i = 0; i <= this.getDistanceFromRoot(); i++){
		// System.out.print(" ");
		// }
		// }

		if (top != null) {
			// numIt++;
			// numbersList.add((Integer) numIt);
			// System.out.print("\t");
			// ArrayList.get(numIt - 1) because of 0-based numbering.
			// System.out.print(numbersList.get(numIt - 1).intValue());
			// System.out.print(". ");

			if (top.getCardFromArrow() == null) {

				if (this.getDistanceFromRoot() > 0) {
					for (int i = 0; i <= this.getDistanceFromRoot(); i++) {
						System.out.print(" - ");
					}
				}
				System.out.println("Top Out: <Empty>");

				// System.out.println("Top Out: <Empty>");
				System.out.print(" under " + this.getCardName() + "    ( "
					+ ((GroupCard) top.getCardFromArrow()).getID() + " )"
					+ "\n");
				System.out.println();
			}

			if (top.getCardFromArrow() != null) {
				numIt++;
				numbersList.add((Integer) numIt);

				if (this.getDistanceFromRoot() > 0) {
					for (int i = 0; i <= this.getDistanceFromRoot(); i++) {
						System.out.print(" - ");
					}
				}

				System.out
					.print("Top Out: " + top.getCardFromArrow().getCardName());

				// System.out.println("Top Out: " +
				// top.getCardFromArrow().getCardName());
				System.out.print(" under " + this.getCardName() + "    ( "
					+ ((GroupCard) top.getCardFromArrow()).getID() + " )"
					+ "\n");
				System.out.println();

				((GroupCard) top.getCardFromArrow())
					.recursivePrintOutAvailableAndOccupiedArrowsWithNumbers();
			}
		}

		if (bottom != null) {
			// numIt++;
			// numbersList.add((Integer) numIt);
			// System.out.print("\t");

			// System.out.print(numbersList.get(numIt - 1).intValue());
			// System.out.print(". ");

			if (bottom.getCardFromArrow() == null) {

				if (this.getDistanceFromRoot() > 0) {
					for (int i = 0; i <= this.getDistanceFromRoot(); i++) {
						System.out.print(" - ");
					}
				}
				System.out.print("Bottom Out: <Empty>");

				// System.out.println("Bottom Out: <Empty>");
				System.out.print(" under " + this.getCardName() + "\n");
			}
			if (bottom.getCardFromArrow() != null) {

				numIt++;
				numbersList.add((Integer) numIt);
				if (this.getDistanceFromRoot() > 0) {
					for (int i = 0; i <= this.getDistanceFromRoot(); i++) {
						System.out.print(" - ");
					}
				}
				// System.out.println("Bottom Out: " +
				// bottom.getCardFromArrow().getCardName());

				System.out.print(
					"Bottom Out: " + bottom.getCardFromArrow().getCardName());

				System.out.print(" under " + this.getCardName() + "\n");

				((GroupCard) bottom.getCardFromArrow())
					.recursivePrintOutAvailableAndOccupiedArrowsWithNumbers();

			}

		}

		if (leftIn != null) {
			// numIt++;
			// numbersList.add((Integer) numIt);
			// System.out.print("\t");

			// System.out.print(numbersList.get(numIt - 1).intValue());
			// System.out.print(". ");

			// if (leftIn.getCardFromArrow() == null) {
			// System.out.println("Left In: <Empty>");
			// }

			// if (leftIn.getCardFromArrow() != null) {
			// System.out.println("Left In: " +
			// leftIn.getCardFromArrow().getCardName());
			// ((GroupCard)
			// leftIn.getCardFromArrow()).recursivePrintOutAvailableAndOccupiedArrowsWithNumbers();

			// }

		}

		if (rightIn != null) {
			// / numIt++;
			// numbersList.add((Integer) numIt);
			// System.out.print("\t");

			// System.out.print(numbersList.get(numIt - 1).intValue());
			// System.out.print(". ");

			// if (rightIn.getCardFromArrow() == null) {
			// System.out.println("Right In: <Empty>");
			// }

			// if (rightIn.getCardFromArrow() != null) {
			// System.out.println("Right In: " +
			// rightIn.getCardFromArrow().getCardName());
			// ((GroupCard)
			// rightIn.getCardFromArrow()).recursivePrintOutAvailableAndOccupiedArrowsWithNumbers();

			// }
		}

		if (leftOut != null) {
			// numIt++;
			// numbersList.add((Integer) numIt);
			// System.out.print("\t");

			// System.out.print(numbersList.get(numIt - 1).intValue());
			// System.out.print(". ");

			if (leftOut.getCardFromArrow() == null) {

				if (this.getDistanceFromRoot() > 0) {
					for (int i = 0; i <= this.getDistanceFromRoot(); i++) {
						System.out.print(" - ");
					}
				}
				// System.out.println("Left Out: <Empty>");

				System.out.print("Left Out: <Empty>");
				System.out.print(" under " + this.getCardName() + "\n");

			}

			if (leftOut.getCardFromArrow() != null) {
				numIt++;
				numbersList.add((Integer) numIt);
				if (this.getDistanceFromRoot() > 0) {
					for (int i = 0; i <= this.getDistanceFromRoot(); i++) {
						System.out.print(" - ");
					}
				}
				// System.out.println("Left Out: " +
				// leftOut.getCardFromArrow().getCardName());

				System.out.print(
					"Left Out: " + leftOut.getCardFromArrow().getCardName());
				System.out.print(" under " + this.getCardName() + "\n");

				((GroupCard) leftOut.getCardFromArrow())
					.recursivePrintOutAvailableAndOccupiedArrowsWithNumbers();

			}
		}

		if (rightOut != null) {
			// numIt++;
			// numbersList.add((Integer) numIt);
			// System.out.print("\t");
			// System.out.println(numbersList.get(numIt - 1).intValue());
			// System.out.print(". ");

			if (rightOut.getCardFromArrow() == null) {
				numIt++;
				numbersList.add((Integer) numIt);
				if (this.getDistanceFromRoot() > 0) {
					for (int i = 0; i <= this.getDistanceFromRoot(); i++) {
						System.out.print(" - ");
					}
				}
				System.out.print("Right Out: <Empty>");

				// System.out.println("Right Out: <Empty>");
				System.out.print(" under " + this.getCardName() + "\n");

			}

			if (rightOut.getCardFromArrow() != null) {

				if (this.getDistanceFromRoot() > 0) {
					for (int i = 0; i <= this.getDistanceFromRoot(); i++) {
						System.out.print(" - ");
					}
				}
				System.out.print(
					"Right Out: " + rightOut.getCardFromArrow().getCardName());

				// System.out.println("Right Out: " +
				// rightOut.getCardFromArrow().getCardName());
				System.out.print(" under " + this.getCardName() + "\n");

				((GroupCard) rightOut.getCardFromArrow())
					.recursivePrintOutAvailableAndOccupiedArrowsWithNumbers();

			}
		}

		System.out.println("330aaaaaaa numbersList.size() for "
			+ this.getCardName() + " " + numbersList.size());

	}

	/**
	 * Attemping to print out all of the childrens/puppets outgoing arrows,
	 * including empties of a master card, No Incoming Arrows
	 */
	public void recursivePrintOutAvailableAndOccupiedArrowsWithNumbersTwo() {

		// ArrayList of Integer Objects with a capital I. integer is a
		// primitive. Integer is a wrapper.
		ArrayList<Integer> numbersList = new ArrayList<Integer>();
		numbersList.clear();

		int topChoice = 1;
		int bottomChoice = 2;
		int rightOutChoice = 3;
		int leftOutChoice = 4;

		System.out.println("330% this card's distance is " + this.getCardName()
			+ ": " + this.getDistanceFromRoot());
		// iterator
		int numIt = 0;
		if (this.getDistanceFromRoot() == 0) {
			System.out.println("rooty " + this.getCardName());
		}
		// if(this.getDistanceFromRoot() > 0){
		// for(int i = 0; i <= this.getDistanceFromRoot(); i++){
		// System.out.print(" ");
		// }
		// }

		if (top != null) {
			// numIt++;
			// numbersList.add((Integer) numIt);
			// System.out.print("\t");
			// ArrayList.get(numIt - 1) because of 0-based numbering.
			// System.out.print(numbersList.get(numIt - 1).intValue());
			// System.out.print(". ");

			if (top.getCardFromArrow() == null) {

				if (this.getDistanceFromRoot() > 0) {
					for (int i = 0; i <= this.getDistanceFromRoot(); i++) {
						System.out.print(" - ");
					}
				}
				System.out.println("(1) Top Out: <Empty>");

				// System.out.println("Top Out: <Empty>");
				System.out.print(" under " + this.getCardName() + "    ( "
					+ ((GroupCard) top.getCardFromArrow()).getID() + " )"
					+ "\n");
				System.out.println();
			}

			if (top.getCardFromArrow() != null) {
				numIt++;
				numbersList.add((Integer) numIt);

				if (this.getDistanceFromRoot() > 0) {
					for (int i = 0; i <= this.getDistanceFromRoot(); i++) {
						System.out.print(" - ");
					}
				}

				System.out
					.print("Top Out: " + top.getCardFromArrow().getCardName());

				// System.out.println("Top Out: " +
				// top.getCardFromArrow().getCardName());
				System.out.print(" under " + this.getCardName() + "    ( "
					+ ((GroupCard) top.getCardFromArrow()).getID() + " )"
					+ "\n");
				System.out.println();

				((GroupCard) top.getCardFromArrow())
					.recursivePrintOutAvailableAndOccupiedArrowsWithNumbers();
			}
		}

		if (bottom != null) {
			// numIt++;
			// numbersList.add((Integer) numIt);
			// System.out.print("\t");

			// System.out.print(numbersList.get(numIt - 1).intValue());
			// System.out.print(". ");

			if (bottom.getCardFromArrow() == null) {

				if (this.getDistanceFromRoot() > 0) {
					for (int i = 0; i <= this.getDistanceFromRoot(); i++) {
						System.out.print(" - ");
					}
				}
				System.out.print("(2) Bottom Out: <Empty>");

				// System.out.println("Bottom Out: <Empty>");
				System.out.print(" under " + this.getCardName() + "\n");
			}
			if (bottom.getCardFromArrow() != null) {

				numIt++;
				numbersList.add((Integer) numIt);
				if (this.getDistanceFromRoot() > 0) {
					for (int i = 0; i <= this.getDistanceFromRoot(); i++) {
						System.out.print(" - ");
					}
				}
				// System.out.println("Bottom Out: " +
				// bottom.getCardFromArrow().getCardName());

				System.out.print(
					"Bottom Out: " + bottom.getCardFromArrow().getCardName());

				System.out.print(" under " + this.getCardName() + "\n");

				((GroupCard) bottom.getCardFromArrow())
					.recursivePrintOutAvailableAndOccupiedArrowsWithNumbers();

			}

		}

		if (leftIn != null) {
			// numIt++;
			// numbersList.add((Integer) numIt);
			// System.out.print("\t");

			// System.out.print(numbersList.get(numIt - 1).intValue());
			// System.out.print(". ");

			// if (leftIn.getCardFromArrow() == null) {
			// System.out.println("Left In: <Empty>");
			// }

			// if (leftIn.getCardFromArrow() != null) {
			// System.out.println("Left In: " +
			// leftIn.getCardFromArrow().getCardName());
			// ((GroupCard)
			// leftIn.getCardFromArrow()).recursivePrintOutAvailableAndOccupiedArrowsWithNumbers();

			// }

		}

		if (rightIn != null) {
			// / numIt++;
			// numbersList.add((Integer) numIt);
			// System.out.print("\t");

			// System.out.print(numbersList.get(numIt - 1).intValue());
			// System.out.print(". ");

			// if (rightIn.getCardFromArrow() == null) {
			// System.out.println("Right In: <Empty>");
			// }

			// if (rightIn.getCardFromArrow() != null) {
			// System.out.println("Right In: " +
			// rightIn.getCardFromArrow().getCardName());
			// ((GroupCard)
			// rightIn.getCardFromArrow()).recursivePrintOutAvailableAndOccupiedArrowsWithNumbers();

			// }
		}

		if (leftOut != null) {
			// numIt++;
			// numbersList.add((Integer) numIt);
			// System.out.print("\t");

			// System.out.print(numbersList.get(numIt - 1).intValue());
			// System.out.print(". ");

			if (leftOut.getCardFromArrow() == null) {

				if (this.getDistanceFromRoot() > 0) {
					for (int i = 0; i <= this.getDistanceFromRoot(); i++) {
						System.out.print(" - ");
					}
				}
				// System.out.println("Left Out: <Empty>");

				System.out.print("(3) Left Out: <Empty>");
				System.out.print(" under " + this.getCardName() + "\n");

			}

			if (leftOut.getCardFromArrow() != null) {
				numIt++;
				numbersList.add((Integer) numIt);
				if (this.getDistanceFromRoot() > 0) {
					for (int i = 0; i <= this.getDistanceFromRoot(); i++) {
						System.out.print(" - ");
					}
				}
				// System.out.println("Left Out: " +
				// leftOut.getCardFromArrow().getCardName());

				System.out.print(
					"(3) Left Out: " + leftOut.getCardFromArrow().getCardName());
				System.out.print(" under " + this.getCardName() + "\n");

				((GroupCard) leftOut.getCardFromArrow())
					.recursivePrintOutAvailableAndOccupiedArrowsWithNumbers();

			}
		}

		if (rightOut != null) {
			// numIt++;
			// numbersList.add((Integer) numIt);
			// System.out.print("\t");
			// System.out.println(numbersList.get(numIt - 1).intValue());
			// System.out.print(". ");

			if (rightOut.getCardFromArrow() == null) {
				numIt++;
				numbersList.add((Integer) numIt);
				if (this.getDistanceFromRoot() > 0) {
					for (int i = 0; i <= this.getDistanceFromRoot(); i++) {
						System.out.print(" - ");
					}
				}
				System.out.print("(4) Right Out: <Empty>");

				// System.out.println("Right Out: <Empty>");
				System.out.print(" under " + this.getCardName() + "\n");

			}

			if (rightOut.getCardFromArrow() != null) {

				if (this.getDistanceFromRoot() > 0) {
					for (int i = 0; i <= this.getDistanceFromRoot(); i++) {
						System.out.print(" - ");
					}
				}
				System.out.print(
					"Right Out: " + rightOut.getCardFromArrow().getCardName());

				// System.out.println("Right Out: " +
				// rightOut.getCardFromArrow().getCardName());
				System.out.print(" under " + this.getCardName() + "\n");

				((GroupCard) rightOut.getCardFromArrow())
					.recursivePrintOutAvailableAndOccupiedArrowsWithNumbers();

			}
		}

		System.out.println("330aaaaaaa numbersList.size() for "
			+ this.getCardName() + " " + numbersList.size());

	}

	public void setTopArrowOut() {

		top = new OutgoingArrow();
	}

	public void setBottomArrowOut() {
		bottom = new OutgoingArrow();
	}

	public void setLeftArrowOut() {

		leftOut = new OutgoingArrow();

	}

	public void setLeftArrowIn() {

		leftIn = new IncomingArrow();

	}

	public void setRightArrowOut() {

		rightOut = new OutgoingArrow();

	}

	public void setRightArrowIn() {

		rightIn = new IncomingArrow();

	}

	// Every Group Card has one incoming Arrow, either on its left or right.
	public IncomingArrow getIncomingArrow() {
		if (this.leftIn instanceof IncomingArrow) {
			System.out.println("305a This Group Card " + this.getCardName()
				+ " has a Left Incoming Arrow");
			return this.leftIn;
		} else if (this.rightIn instanceof IncomingArrow) {
			System.out.println("305b This Group Card " + this.getCardName()
				+ " has a Right Incoming Arrow");
			return this.rightIn;
		} else {

			System.out.println("305bb This Group Card has no Incoming Arrows");
			return null;
		}
	}

	public OutgoingArrow getTopArrow() {
		return top;
	}

	public OutgoingArrow getBottomArrow() {
		return bottom;
	}

	public IncomingArrow getLeftArrowIn() {
		return leftIn;
	}

	public IncomingArrow getRightArrowIn() {
		return rightIn;
	}

	public OutgoingArrow getLeftArrowOut() {
		return leftOut;
	}

	public OutgoingArrow getRightArrowOut() {
		return rightOut;
	}

	public Card getMaster() {
		return master;
	}

	// A group card can have max of 3 direct puppets
	public void addPuppetOfPuppets() {

		System.out.println("340a addPueppets");

		for (int i = 0; i < puppets.size(); i++) {
			int j = 0;
			while (puppets.get(i).getPuppetSize() > 0 && j < 4) {

				puppets.add(puppets.get(j));
				j++;

			}
		}
		System.out.println("340b addPueppets");
	}

	public int getPuppetSize() {
		return puppets.size();
	}

	public ArrayList<GroupCard> getPuppetArrayList() {
		return puppets;
	}

	public GroupCard getPuppet(int choice) {

		return puppets.get(choice);
	}

	public void setMaster(Card master) {
		this.master = master;
	}

	public void setIlluminati(Illuminati illuminati) {
		this.illuminati = illuminati;
	}

	/**
	 * Add a puppet to this Group Card Set the puppet's master to this Group
	 * Card
	 * 
	 * @param puppet
	 */
	public void addPuppet(GroupCard puppet) {
		puppets.add(puppet);
		// Next steps
		// 1) Check if available arrows
		// 2) Which arrow to add puppet to? Top, Bot, Left, Right
		puppet.setMaster(this);
	}

	/**
	 * 
	 * @param puppet
	 * @param arrowDirection
	 *            - 1:TOP, 2:BOTTOM, 3: LEFT, 4:RIGHT
	 */
	public void addPuppetWithArrow(GroupCard puppet, int arrowDirection) {
		// make sure we don't add puppet again if it is already in the puppets
		// arraylist
		if (puppets.contains(puppet) == false) {

			puppets.add(puppet);
		}
		;
		// Check if available "outgoing" arrows
		// Check if puppet has an available incoming arrow spot
		// With the Game UI graphics, we need to check if the arrow isn't
		// blocked by another card, such as collision detection.
		int Top = 1;
		int Bottom = 2;
		int Left = 3;
		int Right = 4;

		// System.out.println("310a puppet.getLeftArrow().getCardFromArrow()" +
		// puppet.getLeftArrow().getCardFromArrow());
		// System.out.println("310b puppet.getRightArrow().getCardFromArrow()" +
		// puppet.getRightArrow().getCardFromArrow());
		// A Group Card's incoming arrow is either the left or right direction,
		// but never the top or bottom direction
		// So we check the left and right of the puppet's incoming arrow
		if (puppet.getIncomingArrow() instanceof IncomingArrow) {

			if (puppet.getIncomingArrow().getCardFromArrow() == null) {
				addPuppetWithArrowTwo(puppet, arrowDirection);
				// Set this Group Card as the master of the puppet
				puppet.setMaster(this); // Have to have incoming arrow direction
				// in
				// mind as well.
				puppet.getIncomingArrow().addCardToArrow(this); // Set the
				// master for
				// the incoming
				// arrow of
				// puppet
			}
		}

	}

	/**
	 * Private method so that it can't be called from main, but can be called in
	 * this class
	 * 
	 * @param puppet
	 * @param arrowDirection
	 */
	private void addPuppetWithArrowTwo(GroupCard puppet, int arrowDirection) {
		int Top = 1;
		int Bottom = 2;
		int Left = 3;
		int Right = 4;

		if (arrowDirection == Top) {
			// TOP
			if ((this.getTopArrow() instanceof OutgoingArrow)
				&& (this.getTopArrow().getCardFromArrow() == null)) {
				System.out.println(
					"303a Top Outgoing arrow is added with this puppet: "
						+ puppet.getCardName());
				this.getTopArrow().addCardToArrow(puppet);
			} else if ((this.getTopArrow() instanceof OutgoingArrow)
				&& (this.getTopArrow().getCardFromArrow() != null)) {
				System.out
					.println("303b Top Outgoing arrow is already occupied");
			} else {
				System.out.println(
					"303c You can't add a puppet to an Incoming arrow. Or the top arrow does not exists");
			}
		} else if (arrowDirection == Bottom) {
			// BOTTOM
			if ((this.getBottomArrow() instanceof OutgoingArrow)
				&& (this.getBottomArrow().getCardFromArrow() == null)) {
				System.out.println(
					"304a Bottom Outgoing arrow is added with this puppet: "
						+ puppet.getCardName());
				this.getBottomArrow().addCardToArrow(puppet);
			} else if ((this.getBottomArrow() instanceof OutgoingArrow)
				&& (this.getBottomArrow().getCardFromArrow() != null)) {
				System.out
					.println("304b Bottom Outgoing arrow is already occupied");
			} else {
				System.out.println(
					"304c You can't add a puppet to an Incoming arrow. Or the bottom arrow does not exists");
			}
		} else if (arrowDirection == Left) {
			// LEFT
			if ((this.getLeftArrowOut() instanceof OutgoingArrow)
				&& (this.getLeftArrowOut().getCardFromArrow() == null)) {
				System.out.println(
					"305a Left Outgoing arrow is added with this puppet: "
						+ puppet.getCardName());
				this.getLeftArrowOut().addCardToArrow(puppet);
			} else if ((this.getLeftArrowOut() instanceof OutgoingArrow)
				&& (this.getLeftArrowOut().getCardFromArrow() != null)) {
				System.out
					.println("305b Left Outgoing arrow is already occupied");
			} else {
				System.out.println(
					"305c You can't add a puppet to an Incoming arrow. Or the left arrow does not exists");
			}
		} else if (arrowDirection == Right) {
			// RIGHT
			if ((this.getRightArrowOut() instanceof OutgoingArrow)
				&& (this.getRightArrowOut().getCardFromArrow() == null)) {
				System.out.println(
					"306a Right Outgoing arrow is added with this puppet: "
						+ puppet.getCardName());
				this.getRightArrowOut().addCardToArrow(puppet);
			} else if ((this.getRightArrowOut() instanceof OutgoingArrow)
				&& (this.getRightArrowOut().getCardFromArrow() != null)) {
				System.out
					.println("306b Right Outgoing arrow is already occupied");
			} else {
				System.out.println(
					"306c You can't add a puppet to an Incoming arrow. Or the right arrow does not exists");
			}
		} else {
			System.out.println("310 Invalid arrowDirection choice");
		}
	}

	public void addAlignment(String alignment) {
		alignments.add(alignment);
	}

	/**
	 * When a Group Card gets destroyed or neutralized, set its master to null
	 */
	public void resetMaster() {
		this.master = null;
	}

	@Override
	public void adjustTreasury(int megaBucks) {
		// TODO Auto-generated method stub
		this.treasury += megaBucks;
	}

	@Override
	public void adjustPower(int power) {
		// TODO Auto-generated method stub
		this.power += power;
	}

	@Override
	public void adjustTransferrablePower(int tPower) {
		// TODO Auto-generated method stub
		this.transferrablePower += tPower;
	}

	@Override
	public int getIncome() {
		// TODO Auto-generated method stub
		return income;
	}

	@Override
	public int getTreasury() {
		// TODO Auto-generated method stub
		return treasury;
	}

	@Override
	public int getPower() {
		// TODO Auto-generated method stub
		return power;
	}

	@Override
	public int getTransferrablePower() {
		// TODO Auto-generated method stub
		return transferrablePower;
	}

	// Maybe income stays consistent instead of changing values throughout the
	// game
	public int getIncomeDefault() {
		return incomeDefault;

	}

	public int getPowerDefault() {

		return powerDefault;
	}

	public int getTansferrablePowerDefault() {
		return transferrablePowerDefault;
	}

	public int getResistanceDefault() {

		return resistanceDefault;
	}

	/**
	 * Let's say a Group Card was controlled, then neutralized back to the
	 * UncontrolledArea. Then we want to reset its power, tPower, and resistance
	 * back to its default value.
	 */
	public void resetAllAttributesToDefault() {

		income = incomeDefault;
		power = powerDefault;
		resistance = resistanceDefault;
		transferrablePower = transferrablePowerDefault;

	}

	/**
	 * Show power, tPower, treasury, and resistance
	 */
	public void displayStats() {
		// this.getCardName();
		System.out.println("103 Display Stats for " + this.getCardName());

		System.out.println("\t Power: " + this.getPower());
		System.out.println("\t Transferrable Power: " + this.getTransferPower());
		System.out.println("\t Resistance: " + this.getResistance());
		System.out.println("\t MegaBucks: " + this.getTreasury()); // megaBucks
		System.out.println("\t Income: " + this.getIncome());

		for (int i = 0; i < alignments.size(); i++) {
			System.out.println("\t Aliignment: " + this.alignments.get(i));
		}

	}

	@Override
	public void attackToControl(Card attacker, GroupCard defender) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attackToDestroy(Card attacker, GroupCard defender) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attackToNeutralize(Card attacker, GroupCard defender) {
		// TODO Auto-generated method stub

	}

	public boolean canAtkToControl() {
		System.out.println("3145 checkOutAvailableAndOccupiedArrows called ");
		System.out.println(this.getCardName()
			+ " has the following available and occupied arrows and types: ");
		boolean canAttackToControl = false;

		int availOutArrows = 0;

		if (top != null) {

			if (top.getCardFromArrow() == null) {
				System.out.println("\tTop Out: <Empty>");
				availOutArrows++;
			}

			// if (top.getCardFromArrow() != null) {
			// System.out.println("\tTop Out: " +
			// top.getCardFromArrow().getCardName());
			//
			// }
		}

		if (bottom != null) {

			if (bottom.getCardFromArrow() == null) {
				System.out.println("\tBottom Out: <Empty>");
				availOutArrows++;

			}

			// if (bottom.getCardFromArrow() != null) {
			// System.out.println("\tBottom Out: " +
			// bottom.getCardFromArrow().getCardName());
			// }

		}

		if (leftOut != null) {
			if (leftOut.getCardFromArrow() == null) {
				System.out.println("\tLeft Out: <Empty>");
				availOutArrows++;

			}

			// if (leftOut.getCardFromArrow() != null) {
			// System.out.println("\tLeft Out: " +
			// leftOut.getCardFromArrow().getCardName());
			// }
		}

		if (rightOut != null) {
			if (rightOut.getCardFromArrow() == null) {
				System.out.println("\tRight Out: <Empty>");
				availOutArrows++;

			}

			// if (rightOut.getCardFromArrow() != null) {
			// System.out.println("\tRight Out: " +
			// rightOut.getCardFromArrow().getCardName());
			// }
		}

		int GroupCardType = 2;
		if (this.getCardType() == GroupCardType) {
			// has 0 to 3 outgoing arrows
			if (availOutArrows > 0) {
				canAttackToControl = true;

			}
		}
		return canAttackToControl;

	} // check method

	public boolean canAddToThisArrow(int directionChoice) {

		int TopC = 1;
		int BottomC = 2;
		int LeftC = 3;
		int RightC = 4;

		boolean canAddHere = false;
		if (directionChoice == TopC) {
			if (top != null) {

				if (top.getCardFromArrow() == null) {
					System.out.println("\tTop Out: <Empty>");
					canAddHere = true;

				}
			}

		}
		if (directionChoice == BottomC) {

			if (bottom != null) {

				if (bottom.getCardFromArrow() == null) {
					System.out.println("\tBottom Out: <Empty>");
					canAddHere = true;

				}

			}
		}

		if (directionChoice == LeftC) {
			if (leftOut != null) {
				if (leftOut.getCardFromArrow() == null) {
					System.out.println("\tLeft Out: <Empty>");
					canAddHere = true;

				}
			}

		}

		if (directionChoice == RightC) {
			if (rightOut != null) {
				if (rightOut.getCardFromArrow() == null) {
					System.out.println("\tRight Out: <Empty>");
					canAddHere = true;

				}
			}

		}

		// TODO Auto-generated method stub

		return canAddHere;

	} // can add to this arrow method
}
