package gameOfLife.testing.CellTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameOfLife.Cell;

class changeStateTesting {
	
	@Test
	void liveCellChangedStateTurnsDead() {
		Cell cell = new Cell(1, 1, 1);
		assertEquals(cell.getState(), 1);
		cell.changeState();
		assertEquals(cell.getState(), 0);
	}
	
	@Test
	void deadCellChangedStateTurnsLive() {
		Cell cell = new Cell(1, 1, 0);
		assertEquals(cell.getState(), 0);
		cell.changeState();
		assertEquals(cell.getState(), 1);
	}

}
