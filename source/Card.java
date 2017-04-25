/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theilluminatigame;

/**
 *
 * @author saidz
 */
/** Card is a representation of card */

public class Card {
    /** The name of this card */
    private String name;
    /**
     * The type of this card. Types of Card (1): Illuminati Card (2): Group Card
     * (3): Special Card
     */
    private int type;
    private int power;
    private int transferPower;
    private int income;
    private int resistance;
    
    /**
     * Special Card constructor
     * 
     * @param name
     * @param type - Must be type 3
     */
    public Card(String name, int type) {
        this.name = name;
        this.type = type;
    }
    /**
     * Illuminati Card constructor - An Illuminati Card does not have any
     * resistances
     * 
     * @param name
     * @param type - Must be type 1
     * @param income
     * @param power
     * @param transferPower
     */
    public Card(String name, int type, int power, int transferPower, int income) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.transferPower = transferPower;
        this.income = income;
    }
 
    /**
     * Group Card constructor
     * 
     * @param name
     * @param type - Must be type 2
     * @param income
     * @param power
     * @param transferPower
     * @param resistance
     */
    public Card(String name, int type, int power, int transferPower,int resistance, int income) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.transferPower = transferPower;
        this.resistance = resistance;
        this.income = income;
    }
    public String getCardName() {
	return name;
    }
    public int getCardType() {
	if (type == 1) {
	    System.out.println("This is an Illuminati card");
	}
	if (type == 2) {
	    System.out.println("This is a Group card");
	}
	if (type == 3) {
	    System.out.println("This is a Special card");
	}
	return type;
    }
    public int getPower(){
        return power;
    }
    public int getTransferPower(){
        return transferPower;
    }
    public int getResistance(){
        return resistance;
    }
    public int getIncome(){
        return income;
    }
}

           
