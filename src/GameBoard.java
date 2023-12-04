/**
 * interface for a general board that can be reused 
 */
package gameOfLife;

public interface GameBoard {
	int getWidth();					/* Return the width of the board */
	int getHeight();				/* Return the height of the board */
	Cell get(int row, int col);		/* Return the cell that conforms to the right location */
	String toString();				/* Return the string representation of the cell */
}
