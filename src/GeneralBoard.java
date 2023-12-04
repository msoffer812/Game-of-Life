/**
 * General Board class that can be reused in a bunch of different ways
 */
package gameOfLife;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

public class GeneralBoard implements GameBoard
{
	protected Cell[][] board;					/* This 2d array holds the representation of the board*/
	protected final int BOARDWIDTH;				/*The size of the board, so we know how to initialize it. */
	protected final int BOARDHEIGHT;			/*	This is the beginning of extensibility to different board sizes, 
														however it's not fully supported in the algorithm in general*/
	
	/**
	 * 
	 * Initialize the board
	 * I want the code to be more extensible, 
	 * so putting in the option for different board sizes if need be
	 */
	public GeneralBoard(int cols, int rows)
	{
		BOARDWIDTH = cols;
		BOARDHEIGHT = rows;
		this.board = new Cell[BOARDHEIGHT][BOARDWIDTH];
	}
	
	/**
	 * creating cells neighbors, seeing if the cell is valid
	 */
	protected boolean isValid(int row, int col)
	{
		return row>=0 && col>=0 && row<BOARDHEIGHT && col<BOARDWIDTH;
	}
	
	/**
	 * 
	 * @return board's width
	 */
	@Override
	public int getWidth()
	{
		return this.BOARDWIDTH;
	}
	
	/**
	 * @return board's height
	 */
	@Override
	public int getHeight()
	{
		return this.BOARDWIDTH;
	}
	
	/**
	 * 
	 * @param row
	 * @param col
	 * @return the corresponding cell to the given row, col
	 * if doesn't exist, return null
	 */
	@Override
	public Cell get(int row, int col)
	{
		if(row<BOARDHEIGHT && col<BOARDWIDTH)
		{
			return board[row][col];
		}
		return null;
	}
	
	/**
	 * 
	 * @return the board as a string to print out
	 */
	@Override
	public String toString()
	{
		/*
		 * Use a StringBuilder to save memory
		 */
		StringBuilder boardToString = new StringBuilder();
		
		/*
		 * First loop to add the column numbers
		 */
		for(int row=0;row<BOARDHEIGHT;row++)
		{
			for(int column=0;column<BOARDWIDTH;column++)
			{
				System.out.print((board[row][column]).toString());
			}
			System.out.println("");
		}
		return boardToString.toString();
	}
}
