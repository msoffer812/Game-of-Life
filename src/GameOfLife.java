/**
 * class that represents the game of life
 */
package gameOfLife;

public class GameOfLife 
{
	private ToroidalGridBoard board;			/* Representation of the board*/
	private final int GENERATIONS;				/* For how long the game should run*/
	private CircularQueue<Cell> cellsToChange;	/* Cells that need to be switched in that generation, unloaded at the end of a round */
	
	/**
	 * Constructor
	 * @param BOARDWIDTH
	 * @param BOARDHEIGHT
	 * @param GENERATIONS
	 */
	public GameOfLife(int BOARDWIDTH, int BOARDHEIGHT, int GENERATIONS)
	{
		this.board = new ToroidalGridBoard(BOARDWIDTH, BOARDHEIGHT);
		this.GENERATIONS = GENERATIONS;
		cellsToChange = new CircularQueue<>();
	}
	
	/**
	 * 
	 * run the game for a generations
	 * @see liveGenerations()
	 * @see changeAllStates()
	 */
	public void runGame()
	{
		for(int generation=0; generation < GENERATIONS; generation++)
		{
			System.out.println(board.toString());
			liveGeneration();
			changeAllStates();
		}
	}
	
	/**
	 * Loop through the board and check which cells need to change state, add to queue
	 */
	private void liveGeneration()
	{
		for(int row=0;row<board.getWidth(); row++)
		{
			for(int col=0; col< board.getHeight(); col++)
			{
				Cell cell = board.get(row, col);
				if(cell.shouldChangeState())
				{
					cellsToChange.enqueue(cell);
				}
			}
		}
	}
	
	/**
	 * Loop through queue and change the states in them
	 */
	private void changeAllStates()
	{
		while(!cellsToChange.isEmpty())
		{
			Cell cell = cellsToChange.dequeue();
			cell.changeState();
		}
	}
}
