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
		// Inicialar la matriz de celdas con el tamaño de la 
		// matriz de Strings 
		crossword = new Cell[puzzle.length][puzzle[0].length];
		int count = 0; 
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle[0].length; j++) {
				// si la letra que hay en puzzle es igual a 
				// un string vacio, la celda de crossword
				// es BLACK
				if(!puzzle[i][j].equals(" ")){
					// el número de la celda puede ser cualquiera (0 por ejemplo) 
					// en este caso, puse -1.
					count++; 
					crossword[i][j] = 
						new Cell(CellType.CLOSED, puzzle[i][j], count);
				}
				else{
					crossword[i][j] = 
						new Cell(CellType.BLACK, puzzle[i][j], -1); 
				}
			}
		}
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
		String msj = "Lo siento, no hay palabras con esa " + letter;

		for (int i = 0; i < crossword.length; i++) {
			for (int j = 0; j < crossword[0].length; j++) {
				if(crossword[i][j].getLetter().equalsIgnoreCase(letter)){
					msj = "“Hay una palabra con la letra: "+letter+
						" en el crucigrama en la casilla: " 
						+crossword[i][j].getNumber();
				}
			}
		}
		return msj;
	}
	
	/**
	 * 
	 * @param letter
	 * @param num
	 * @return
	 */
	public String evaluateCell(String letter, int num) {
		String msj = " Lo siento, la letra "+letter
			+" NO está en la casilla: "+ num; 

		boolean isFound = false;

		for (int i = 0; i < crossword.length && !isFound; i++) {
			for (int j = 0; j < crossword[0].length && !isFound; j++) {
				if(crossword[i][j].getNumber() == num){
					isFound = true;
					if(crossword[i][j].getLetter().equalsIgnoreCase(letter)){
						msj = " La "+letter+" SI está en la casilla: "
							+ crossword[i][j].getNumber();
					}
				}
			}
		}
		return msj;
	}
	
	public String showCrossword() {
		int rows= crossword.length;
		int columns= crossword[0].length;
	
		String out="";
		String separator = "+---+ ";
		String line = "" + String.join("", Collections.nCopies(columns, separator));
		
		
		String numbers ="";
		String letters = "";
		int count =0;
		for(int i=0 ;i<rows ; i++) {
			numbers ="";
			letters ="";
			for(int j=0 ;j<columns ; j++) {
				count++;
				Cell actual = crossword[i][j];
				
				// numeros de dos cifras
				if (count>10) {
					//empty cell
					if (actual.getState()==CellType.BLACK) {
						numbers += " ---  ";
						letters += " ---  ";
						
					}else if(actual.getState() == CellType.CLOSED){
						numbers += " "+actual.getNumber() +"   ";

					}else {
						numbers += " "+actual.getNumber() +"   ";
						letters += "    "+ actual.getLetter() + " ";
					}
				}
				else //una cifra
				{
					//empty cell
					if (actual.getState()==CellType.BLACK) {
						numbers += " ---  ";
						letters += " ---  ";

					}else if(actual.getState() == CellType.CLOSED){
						numbers += " "+actual.getNumber() +"   ";

					}else {
						numbers += " "+actual.getNumber() +"    ";
						letters += "    "+ actual.getLetter() + " "; 
					}
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
