package com.unimelb.swen30006.monopoly;
/**
 * This class is modified for Workshop 9 exercises for SWEN30006 Software Design and Modelling at the University of Melbourne
 * @author Patanamon Thongtanunam
 * @version 1.1
 * @since 2019-05
 */
/**
 * This class is created based on case study of Monopoly of "Applying UML and Patterns, 3rd edition by Craig Larman".
 * For demonstration on subject SWEN30006 at The University of Melbourne 
 * @author 	Yunzhe(Alvin) Jia
 * @version 1.0
 * @since 	2016-07-18
 *
 */
public class Die {
	public static final int MAX = 6;
	private int faceValue;
	
	public Die(){
		roll();
	}
	
	public void roll(){
		faceValue = (int)((Math.random()*MAX)+1);
	}
	
	public int getFaceValue() {
		return faceValue;
	}
}
