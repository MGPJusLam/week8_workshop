package com.unimelb.swen30006.monopoly;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.unimelb.swen30006.monopoly.square.GoSquare;
import com.unimelb.swen30006.monopoly.square.GoToJailSquare;
import com.unimelb.swen30006.monopoly.square.IncomeTaxSquare;
import com.unimelb.swen30006.monopoly.square.JailSquare;
import com.unimelb.swen30006.monopoly.square.LotSquare;
import com.unimelb.swen30006.monopoly.square.RRSquare;
import com.unimelb.swen30006.monopoly.square.RegularSquare;
import com.unimelb.swen30006.monopoly.square.Square;
import com.unimelb.swen30006.monopoly.square.UtilitySquare;
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
public class Board {
	public static final int SIZE = 40;
	
	public static final int INDEX_GO = 0;
	public static final int INDEX_INCOME_TAX = 4;
	public static final int INDEX_JAIL = 10;
	public static final int INDEX_GO_TO_JAIL[] = {15,30,38};
	public static final int INDEX_RR[] = {5,25,35}; // Sorted
	public static final int INDEX_UTILITY[] = {12,28}; // Sorted
	public static final int INDEX_LOT[] = {2,17,33};   // Sorted
	
	public static final int PRICE_RR = 300;
	public static final int PRICE_LOT = 200;
	public static final int PRICE_UTILITY = 200;
	
	// ArrayList is used here as per the textbook.
	// Since the size is fixed, an array could have been used.
	private List<Square> squares = new ArrayList<Square>(SIZE);
	
	public Board(){
		buildSquares();
		linkSquares();
	}
	
	public Square getSquare(Square start, int distance){
		int endIndex = (start.getIndex() + distance) % SIZE;
		return squares.get(endIndex);
	}
	
	public Square getStartSquare(){
		return squares.get(INDEX_GO);
	}
	
	private void buildSquares(){
		for(int i = 0; i < SIZE; i++){
			Square s;
			if(INDEX_GO == i){
				s = new GoSquare("GO",i);
			}else if(INDEX_INCOME_TAX == i){
				s = new IncomeTaxSquare("Income Tax",i);
			}else if(contains(INDEX_GO_TO_JAIL,i)){
				s = new GoToJailSquare("Go to jail",i);
			}else if(INDEX_JAIL == i){
				s = new JailSquare("Jail",i);
			}else if(contains(INDEX_UTILITY,i)){
				s = new UtilitySquare("Utility",i,PRICE_UTILITY);
			}else if(contains(INDEX_LOT,i)){
				s = new LotSquare("Lot",i,PRICE_LOT);
			}else if(contains(INDEX_RR,i)){
				s = new RRSquare("Railroad",i,PRICE_RR);
			}else{
				s = new RegularSquare("Square "+i,i);
			}
			squares.add(s);
		}
		//set jail square
		for(int index : INDEX_GO_TO_JAIL) {
			((GoToJailSquare)squares.get(index)).setJail(squares.get(INDEX_JAIL));
		}
		
	}
	
	private void linkSquares(){
		for (int i = 0; i < SIZE; i++){
			link(i);
		}
	}
	
	private void link(int i){
		Square current = squares.get(i);
		Square next = squares.get((i + 1) % SIZE);
		current.setNextSquare(next);
	}
	
	private boolean contains(int list[], int element){
		return IntStream.of(list).anyMatch(x -> x == element);
	}
}
