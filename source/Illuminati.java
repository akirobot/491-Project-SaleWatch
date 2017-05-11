/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theilluminatigame;

/**
 *
 * @authors saidz, ly
 */
import java.util.ArrayList;

//4.26.17 7:35 am: Have to remove abstract because you can't instantiate Illuminati Cards in main

public class Illuminati extends Card implements Attack, cardStats, cardUpdateStats {
    private ArrayList<GroupCard> puppets = new ArrayList<GroupCard>();
    private final static int outgoingArrows = 4;
    private int income;
    private int treasury;
    private int power;
    private int transferrablePower;
    // private Arrow top = new OutgoingArrow();
    // private Arrow bottom = new OutgoingArrow();
    // private Arrow left = new OutgoingArrow();
    // private Arrow right = new OutgoingArrow();

    private OutgoingArrow top;
    private OutgoingArrow bottom;
    private OutgoingArrow leftOut;
    private OutgoingArrow rightOut;

    private Card master = null;

    // Default values
    // These values should not change during the course of the game, besides the
    // initial assignment
    private int incomeDefault;
    private int powerDefault;
    private int transferrablePowerDefault;

    public Illuminati(String name, int type, int power, int tPower, int income,
            javax.swing.ImageIcon face) {
        super(name, type, power, tPower, income, face);
        incomeDefault = income;
        this.income = income;
    }

    /*
     * An Illuminati has a max of 4 direct puppets, and an unlimited amount of
     * indirect puppets
     */
    public GroupCard getIlluminatiPuppet(int choice) {
        if ((choice > outgoingArrows) && (choice < 0)) {
        // invalid choice
        }
        return null;
    }

    public void addIncomeAtStartOfTurn() {
        this.treasury += this.income;

    }

    public void moveMegaBucks() {
    }

    public void movePuppets() {
    }

    public void useSpecialPowerActions() {
        if (this.getCardName() == "The Bavarian Illuminati") {
        } else if (this.getCardName() == "The Bermuda Triangle") {
        }
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

    public void setRightArrowOut() {

        rightOut = new OutgoingArrow();

    }

    @Override
    public void adjustTreasury(int megaBucks) {
        // TODO Auto-generated method stub
        this.treasury += megaBucks;
    }

    @Override
    public void adjustPower(int pow) {
        // TODO Auto-generated method stub
    //	System.out.println("900 adjust power b4 is " + this.powerDefault);
    //	System.out.println("900a adjust power after is " + this.getPower());

        this.powerDefault += pow;
    	//System.out.println("901 adjust power after is " + this.powerDefault);
    	
    	//System.out.println("900b adjust power after is " + this.getPower());


    }
    
    

    @Override
    public void adjustTransferrablePower(int tPower) {
        this.transferrablePower += tPower;

    }

    @Override
    public int getTreasury() {
        // TODO Auto-generated method stub
        return treasury;
    }

    @Override
    public int getTransferrablePower() {
        // TODO Auto-generated method stub
        return transferrablePower;
    }

    public int getIncomeDefault() {
        return incomeDefault;

    }

    public int getPowerDefault() {

        return powerDefault;
    }

    public int getTansferrablePowerDefault() {
        return transferrablePowerDefault;
    }

    public void resetAllAttributesToDefault() {

        income = incomeDefault;
        power = powerDefault;
        transferrablePower = transferrablePowerDefault;

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
    /**
     * Show power, tPower, treasury, etc.
     */
    public void displayStats() {
        // this.getCardName();
        System.out.println("Displaying Stats for " + this.getCardName());

        System.out.println("\t Power: " + this.getPower());
        System.out.println("\t tPower: " + this.getTransferPower());
        System.out.println("\t treasury: " + this.getTreasury());
        System.out.println("\t income: " + this.getIncome());

    }

    public void addPuppet(GroupCard puppet) {
        puppets.add(puppet);
    }

    @Override
    public void attackToControl(Card attacker, GroupCard defender) {
        // TODO Auto-generated method stub

    }

    /**
     * Probably have to remove these interface methods and use them in the game
     * logic instead. Attack to Destroy Power vs Power
     */
    @Override
    public void attackToDestroy(Card attacker, GroupCard defender) {
        // TODO Auto-generated method stub
        if ((attacker.getPower() - defender.getPower()) < 11) {

        }
    }

    @Override
    public void attackToNeutralize(Card attacker, GroupCard defender) {
        // TODO Auto-generated method stub

    }

    /**
     * Display puppets in file-hierarchy form
     * 
     */
    public void displayPuppets() {

    }

    /**
     * 
     * @param puppet
     * @param arrowDirection
     *            - 1:TOP, 2:BOTTOM, 3: LEFT, 4:RIGHT
     */
    public void addPuppetWithArrow(GroupCard puppet, int arrowDirection) {

        if (this.puppets.contains(puppet) == false) {
//System.out.println("99998888 adding puppet ");
        this.puppets.add(puppet);
        }
        
        //System.out.println("99998888a puppets size " + this.getPuppetSize());

        
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
     * this class. Continuation method
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
        System.out.println("Top Outgoing arrow is added with this puppet: "
                + puppet.getCardName());
        this.getTopArrow().addCardToArrow(puppet);
        } else if ((this.getTopArrow() instanceof OutgoingArrow)
                && (this.getTopArrow().getCardFromArrow() != null)) {
        System.out.println("Top Outgoing arrow is already occupied");
        } else {
        System.out
                .println("You can't add a puppet to an Incoming arrow. Or the top arrow does not exists");
        }
        } else if (arrowDirection == Bottom) {
        // BOTTOM
        if ((this.getBottomArrow() instanceof OutgoingArrow)
                && (this.getBottomArrow().getCardFromArrow() == null)) {
        System.out.println("Bottom Outgoing arrow is added with this puppet: "
                + puppet.getCardName());
        this.getBottomArrow().addCardToArrow(puppet);
        } else if ((this.getBottomArrow() instanceof OutgoingArrow)
                && (this.getBottomArrow().getCardFromArrow() != null)) {
        System.out.println("Bottom Outgoing arrow is already occupied");
        } else {
        System.out
                .println("You can't add a puppet to an Incoming arrow. Or the bottom arrow does not exists");
        }
        } else if (arrowDirection == Left) {
        // LEFT
        if ((this.getLeftArrowOut() instanceof OutgoingArrow)
                && (this.getLeftArrowOut().getCardFromArrow() == null)) {
        System.out.println("Left Outgoing arrow is added with this puppet: "
                + puppet.getCardName());
        this.getLeftArrowOut().addCardToArrow(puppet);
        } else if ((this.getLeftArrowOut() instanceof OutgoingArrow)
                && (this.getLeftArrowOut().getCardFromArrow() != null)) {
        System.out.println("Left Outgoing arrow is already occupied");
        } else {
        System.out
                .println("You can't add a puppet to an Incoming arrow. Or the left arrow does not exists");
        }
        } else if (arrowDirection == Right) {
        // RIGHT
        if ((this.getRightArrowOut() instanceof OutgoingArrow)
                && (this.getRightArrowOut().getCardFromArrow() == null)) {
        System.out.println("Right Outgoing arrow is added with this puppet: "
                + puppet.getCardName());
        this.getRightArrowOut().addCardToArrow(puppet);
        } else if ((this.getRightArrowOut() instanceof OutgoingArrow)
                && (this.getRightArrowOut().getCardFromArrow() != null)) {
        System.out.println("Right Outgoing arrow is already occupied");
        } else {
        System.out
                .println("You can't add a puppet to an Incoming arrow. Or the right arrow does not exists");
        }
        } else {
        System.out.println("Invalid arrowDirection choice");
        }
    }

    public OutgoingArrow getTopArrow() {
        return top;
    }

    public OutgoingArrow getBottomArrow() {
        return bottom;
    }

    public OutgoingArrow getLeftArrowOut() {
        return leftOut;
    }

    public OutgoingArrow getRightArrowOut() {
        return rightOut;
    } // getRightArrowOut

    public void printOutAvailableAndOccupiedArrows() {
        //System.out.println("313 printOutAvailableAndOccupiedArrows called ");
        System.out.println(this.getCardName()
                + " has the following available and occupied arrows and types: ");

        if (top != null) {

        if (top.getCardFromArrow() == null) {
        System.out.println("\tTop Out: <Empty>");
        }

        if (top.getCardFromArrow() != null) {
        System.out.println("\tTop Out: " + top.getCardFromArrow().getCardName());
        }
        }

        if (bottom != null) {

        if (bottom.getCardFromArrow() == null) {
        System.out.println("\tBottom Out: <Empty>");
        }

        if (bottom.getCardFromArrow() != null) {
        System.out.println("\tBottom Out: " + bottom.getCardFromArrow().getCardName());
        }

        }

        if (leftOut != null) {
        if (leftOut.getCardFromArrow() == null) {
        System.out.println("\tLeft Out: <Empty>");
        }

        if (leftOut.getCardFromArrow() != null) {
        System.out.println("\tLeft Out: " + leftOut.getCardFromArrow().getCardName());
        }
        }

        if (rightOut != null) {
        if (rightOut.getCardFromArrow() == null) {
        System.out.println("\tRight Out: <Empty>");
        }

        if (rightOut.getCardFromArrow() != null) {
        System.out.println("\tRight Out: " + rightOut.getCardFromArrow().getCardName());
        }
        }

    } // printOut method

    public boolean canAtkToControl() {
      //  System.out.println("3145 checkOutAvailableAndOccupiedArrows called ");
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
       // System.out.println("\tTop Out: " + top.getCardFromArrow().getCardName());

       // }
        }

        if (bottom != null) {

        if (bottom.getCardFromArrow() == null) {
        System.out.println("\tBottom Out: <Empty>");
        availOutArrows++;

        }

//        if (bottom.getCardFromArrow() != null) {
//        System.out.println("\tBottom Out: " + bottom.getCardFromArrow().getCardName());
//        }

        }

        if (leftOut != null) {
        if (leftOut.getCardFromArrow() == null) {
        System.out.println("\tLeft Out: <Empty>");
        availOutArrows++;

        }

//        if (leftOut.getCardFromArrow() != null) {
//        System.out.println("\tLeft Out: " + leftOut.getCardFromArrow().getCardName());
//        }
        }

        if (rightOut != null) {
        if (rightOut.getCardFromArrow() == null) {
        System.out.println("\tRight Out: <Empty>");
        availOutArrows++;

        }

//        if (rightOut.getCardFromArrow() != null) {
//        System.out.println("\tRight Out: " + rightOut.getCardFromArrow().getCardName());
//        }
        }
        int IlluminatiCardType = 1;

        if (this.getCardType() == IlluminatiCardType) {
        // has 4 outgoing arrows
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

        }
        if (leftOut.getCardFromArrow() == null) {
        System.out.println("\tLeft Out: <Empty>");
        canAddHere = true;

        }

        }

        if (directionChoice == RightC) {
        if (rightOut != null) {

        }
        if (rightOut.getCardFromArrow() == null) {
        System.out.println("\tRight Out: <Empty>");
        canAddHere = true;

        }

        }

        // TODO Auto-generated method stub

        return canAddHere;

    } // can add to this arrow method

} // class

