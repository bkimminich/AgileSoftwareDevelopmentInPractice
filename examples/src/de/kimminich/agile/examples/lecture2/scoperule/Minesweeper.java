package de.kimminich.agile.examples.lecture2.scoperule;

import java.util.ArrayList;
import java.util.List;

public class Minesweeper {
	
	private List<Cell> gameBoard;
	
	public List<Cell> getFlaggedCells() {
	    List<Cell> flaggedCells = new ArrayList<>();
	    for (Cell cell : gameBoard){
	        if (cell.isFlagged())
	            flaggedCells.add(cell);
	    }
	    return flaggedCells;
	}
	
	public class Cell {
		
		private boolean flagged;

		public boolean isFlagged() {
			return flagged;
		}

	}

}