/**
 * Encapsulates Data for a single cell - row, col, alive or dead, neighbors
 */
package gameOfLife;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import ticTacToe.Location;

public class Cell 
{
	private int row;				/* Row number on the grid */
	private int column;				/* Column number on the grid */
	private int state;				/* State of the cell, either alive or dead */
	private List<Cell> neighbors;	/* Array of it's neighbors to loop through and update it if needed things change */
	
	/**
	 * Constructor
	 * @param row
	 * @param column
	 * @param state
	 */
	public Cell(int row, int column, int state)
	{
		this.row = row;
		this.column = column;
		this.state = state;
		this.neighbors = new ArrayList<>();
	}
	
	/**
	 * Set the neighbors, need to do that after all the cells are set, 
	 * since it's an array of cells there'll be deadlock if part of the constructor
	 * @param neighbors
	 */
	public void setNeighbors(List<Cell> neighbors)
	{
		this.neighbors = neighbors;
	}
	
	/**
	 * Getters
	 */
	public int getRow()
	{
		return this.row;
	}
	
	public int getColumn()
	{
		return this.column;
	}
	
	public int getState()
	{
		return this.state;
	}
	public List<Cell> getNeighbors()
	{
		return this.neighbors;
	}
	
	/**
	 * Change the state to the opposite state
	 * Also mark down on physical board
	 */
	public void changeState()
	{
		if(this.state == 0)
		{
			this.state = 1;
		}else
		{
			this.state = 0;
		}
	}
	
	/**
	 * @return if you need to change the state or not,
	 * conforming to the rules of the game of life
	 */
	public boolean shouldChangeState()
	{
		int[] neighborsStates = neighborsStates();
		
		if(this.state == 1)
		{
			if(neighborsStates[1] > 3 || neighborsStates[1] < 2)
			{
				return true;
			}
		}else
		{
			if(neighborsStates[1] ==  3)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @return amount of dead and live neighbors in an int[]
	 */
	private int[] neighborsStates()
	{
		int  deadNeighbors = 0;
		int liveNeighbors = 0;
		for(Cell neighbor: neighbors)
		{
			if(neighbor.getState() == 1)
			{
				liveNeighbors++;
			}else
			{
				deadNeighbors++;
			}
		}
		return new int[] {deadNeighbors, liveNeighbors};
	}
	
	/**
	 * 
	 * @return the cell's location and state, good for debugging
	 */
	public String cellState()
	{
		return "(" + row + ", " + column + ", " + state + ")";
	}
	
	/**
	 * @return string rep of cell
	 */
	@Override
	public String toString()
	{
		String cellToString = "[" + this.state + "]";
		return cellToString;
	}
	
	/**
	 * @return if a cell is equal to this - for hashset/comparison
	 */
	@Override
	public boolean equals(Object o)
	{
		if(this == o)
		{
			return true;
		} 
		if (o == null)
		{
			return false;
		}
		Cell newCell = (Cell) o;
		return this.row == newCell.getRow() && this.column == newCell.getColumn();
	}
	
	/**
	 * Override standard hashing so a hashset recognizes that two object match
	 */
	 @Override
	    public int hashCode() {
	        return Objects.hash(row, column);
	    }
	
}
