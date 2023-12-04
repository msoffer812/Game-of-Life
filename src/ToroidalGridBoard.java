package gameOfLife;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class ToroidalGridBoard extends GeneralBoard{
	public ToroidalGridBoard(int rows, int cols)
	{
		super(cols, rows);
		/*
		 * Board can be from 20 to 30 in width and height,
		 * No more or less
		 */
		if(rows < 20 || rows > 30 || cols < 20 || cols > 30)
		{
			throw new InputMismatchException("Height and Width must be between 20 and 30");
		}
		/*
		 * Call the method that fills in the board
		 */
		fillInBoard();
	}
	/**
	 * @return random either 0 or 1
	 */
	public int randomState()
	{
		Random rand = new Random();
		int state = (int)Math.round(rand.nextDouble());
		return state;
	}
	/**
	 * Start off the dfs that fills in all the Cells
	 * and neighbors
	 */
	public void fillInBoard()
	{
		int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, 1}, {1, -1}, {-1, -1}, {1, 1}};
		/*
		 * Call the dfs method to fill in, starting at 0, 0
		 */
		createCells(0, 0, directions);
	}
	/**
	 * @return int[] attached neighbor on the other side of the board
	 */
	protected int[] getCorrespondingCoordinate(int row, int col)
	{
		if(row < 0)
		{
			if(col < 0)
			{
				return new int[] {BOARDHEIGHT-1, BOARDWIDTH - 1};
			} else if(col >= BOARDWIDTH)
			{
				return new int[] {BOARDHEIGHT-1,0};
			} else
			{
				return new int[] {BOARDHEIGHT-1, col};
			}
		}else if(row >= BOARDHEIGHT)
		{
			if(col < 0)
			{
				return new int[] {0, BOARDWIDTH - 1};
			} else if(col >= BOARDWIDTH)
			{
				return new int[] {0,0};
			} else
			{
				return new int[] {0, col};
			}
		}else if(col < 0)
		{
			return new int[] {row, BOARDWIDTH-1};
		} else if(col>=BOARDWIDTH)
		{
			return new int[] {row, 0};
		}
		return new int[] {row, col};
	}
	/**
	 * initialize the board with all the cells and their neighbors
	 * @param row
	 * @param col
	 * @param seen
	 * @param directions
	 * @return
	 */
	public Cell createCells(int row, int col, int[][] directions)
	{
		Cell currCell;
		/*
		 * If the cell for these coordinates were already
		 * created, just return the already
		 * created cell
		 */
		if(board[row][col] == null)
		{
			/*
			 * Generate a state, 1 or 0, alive or dead
			 */
			int state = randomState();
			/*
			 * Declare as a new cell
			 */
			currCell = new Cell(row, col, state);
			board[row][col] = currCell;
			List<Cell> neighbors = new ArrayList<>();
			/*
			 * now loop through the possible neighbors and 
			 * call depthFirst search to generate all the 
			 * neighbors and their possible neighbors
			 */
			for(int[] direction: directions)
			{
				int row2 = row, col2 = col;
				row2+= direction[0];
				col2+=direction[1];
				/*
				 * Either the neighbor  is a valid location,
				 * or call the method that determines the corresponding
				 * cell on the other side of the grid
				 */
				if(isValid(row2, col2))
				{
					Cell newCell = (createCells(row2, col2, directions));
					if(newCell != null)
					{
						neighbors.add(newCell);
					}
				} else
				{
					int[] coord = getCorrespondingCoordinate(row2, col2);
					Cell newCell = (createCells(coord[0], coord[1], directions));
					if(newCell != null)
					{
						neighbors.add(newCell);
					}
				}
			}
			currCell.setNeighbors(neighbors);
		} else
		{
			currCell = board[row][col];
		}
		return currCell;
	}
	
}
