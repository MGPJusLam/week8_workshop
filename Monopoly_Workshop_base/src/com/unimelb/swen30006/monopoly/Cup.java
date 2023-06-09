package com.unimelb.swen30006.monopoly;
/**
 * This class is modified for Workshop 9 exercises for SWEN30006 Software Design and Modelling at the University of Melbourne
 * @author Patanamon Thongtanunam
 * @version 1.1
 * @since 2019-05
 */
import java.util.ArrayList;
import java.util.List;

/**
 * This class is created based on case study of Monopoly of "Applying UML and Patterns, 3rd edition by Craig Larman".
 * For demonstration on subject SWEN30006 at The University of Melbourne 
 * 
 * This class is proposed by Pure Fabrication, and holds a collection of many Die objects;
 * 
 * The behavior is coded based on Figure 25.8 and 25.9
 * 
 * New Feature:
 * 1. made a global variable and accessible to Property Squares
 * 
 * @author 	Yunzhe(Alvin) Jia
 * @version 2.0
 * @since 	2016-07-19
 *
 */
public class Cup {
	
	private static List<Die> dice;
	private static int total;
	
	public static void initialize(int numOfDice) {
		dice = new ArrayList<Die>(numOfDice);
		for (int i = 0; i < numOfDice; i++ ){
			dice.add(new Die());
		}
	}
	
	/**
	 * roll all the dice
	 */
	public static void roll(){
		total = 0;
		for (Die die:dice){
			die.roll();
			total += die.getFaceValue();
		}
	}
	
	public static int getTotal(){
		return total;
	}

}
