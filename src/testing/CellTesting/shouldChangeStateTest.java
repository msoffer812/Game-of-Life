package gameOfLife.testing.CellTesting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import gameOfLife.Cell;

class shouldChangeStateTest {
	static Cell cell;
	
	@BeforeAll
	static void initializeCell()
	{
		cell = new Cell(1, 2, 1);
	}
	
	@Test
	void liveCellLessThanTwoLiveNeighborsShouldDie() {
		cell.setNeighbors(Arrays.asList(new Cell(1, 3, 1), 
				new Cell(1, 1, 0), new Cell(0, 2, 0), new Cell(1, 2, 0), 
					new Cell(2, 3, 0), new Cell(2, 1, 0), new Cell(0, 1, 0), new Cell(2, 2, 0)));
		assertTrue(cell.shouldChangeState());
	}
	
	@Test
	void liveCellThreeLiveNeighborsSurvives() {
		cell.setNeighbors(Arrays.asList(new Cell(1, 3, 1), 
				new Cell(1, 1, 1), new Cell(0, 2, 1), new Cell(1, 2, 0), 
					new Cell(2, 3, 0), new Cell(2, 1, 0), new Cell(0, 1, 0), new Cell(2, 2, 0)));
		assertFalse(cell.shouldChangeState());
	}
	
	@Test
	void liveCellFourLiveNeighborsShouldDie() {
		cell.setNeighbors(Arrays.asList(new Cell(1, 3, 1), 
				new Cell(1, 1, 1), new Cell(0, 2, 1), new Cell(1, 2, 1), 
					new Cell(2, 3, 0), new Cell(2, 1, 0), new Cell(0, 1, 0), new Cell(2, 2, 0)));
		assertTrue(cell.shouldChangeState());
	}
	
	@Test
	void deadCellThreeLiveNeighborsRevives() {
		cell.changeState();
		cell.setNeighbors(Arrays.asList(new Cell(1, 3, 1), 
				new Cell(1, 1, 1), new Cell(0, 2, 1), new Cell(1, 2, 0), 
					new Cell(2, 3, 0), new Cell(2, 1, 0), new Cell(0, 1, 0), new Cell(2, 2, 0)));
		assertTrue(cell.shouldChangeState());
	}
	
	@Test
	void deadCelllWithTwoNeighborsStaysTheSame() {
		cell.setNeighbors(Arrays.asList(new Cell(1, 3, 1), 
				new Cell(1, 1, 0), new Cell(0, 2, 1), new Cell(1, 2, 0), 
					new Cell(2, 3, 0), new Cell(2, 1, 0), new Cell(0, 1, 0), new Cell(2, 2, 0)));
		assertFalse(cell.shouldChangeState());
	}

}
