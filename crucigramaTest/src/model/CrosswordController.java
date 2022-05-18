package model;

import java.util.Collections;

/**
 * @author avillota
 * @since may 2022
 */
public class CrosswordController {
	
	/**
	 * Matrix of cells representing the crossword puzzle
	 */
	private Cell [][] crossword;
	
	/**
	 * method for initializing a crossword puzzle
	 * @param puzzle is a matrix of Strings containing 
	 * the initial state of a crossword puzzle
	 */
	public void initCrossword(String[][] puzzle) {
		
		
	}
	/**
	 * Method to verify if a crossword puzzle is initialized
	 * @return boolean, true if it is initialized, else false
	 */
	public boolean isInitialized(){
		return crossword!=null;
	}
	
	/**
	 * Method to provide the dimensions of the crossword puzzle
	 * @return
	 */
	public int[] getGameDimensions() {
		int[] dims = new int[2];
		dims[0]= crossword.length;
		dims[1]= crossword[0].length;
		
		return dims;
	}
	
	public Cell[][] getCells(){
		return crossword;
	}
	/**
	 * 
	 * @param letter
	 * @return
	 */
	public String getHint(String letter) {
		
		return null;
	}
	
	/**
	 * 
	 * @param letter
	 * @param num
	 * @return
	 */
	public String evaluateCell(String letter, int num) {
		
		return null;
	}
	
	public String showCrossword() {
		int rows= crossword.length;
		int columns= crossword[0].length;
	
		String out="";
		String separator = "+--+ ";
		String line = "" + String.join("", Collections.nCopies(rows, separator));
		
		
		String numbers ="";
		String letters = "";
		for(int i=0 ;i<rows ; i++) {
			numbers ="";
			letters ="";
			for(int j=0 ;j<rows ; j++) {
				Cell actual = crossword[i][j];
				//empty cell
				if (actual.getState()==CellType.BLACK) {
					numbers += " --- ";
					letters += " --- ";
					
				}
				//letter cell
				else {
					numbers += " "+actual.getNumber() +"   ";
					letters += "   "+ actual.getLetter() + " ";
				}
			}
			//por cada fila se imprimen las lineas
			out+= line + "\n";
			out+= numbers + "\n";
			out+= letters + "\n";
			
			
		}
		out+= line + "\n";
		return out;
	}


}
