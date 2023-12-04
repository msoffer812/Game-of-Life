package gameOfLife.testing.toroidalBoardTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameOfLife.ToroidalGridBoard;

class GetCorrespondingCoordinatesTest extends ToroidalGridBoard{
	
	/**
	 * Constructor
	 */
	public GetCorrespondingCoordinatesTest()
	{
		super(25, 30);
	}
	
	@Test
	void rowNegative1Col5ReturnsRow29Col5() {
		int[] coord = getCorrespondingCoordinate(-1, 5);
		assertEquals(coord[0], 24);
		assertEquals(coord[1], 5);
	}
	
	@Test
	void row25Col5ReturnsRow0Col5() {
		int[] coord = getCorrespondingCoordinate(25, 5);
		assertEquals(coord[0], 0);
		assertEquals(coord[1], 5);
	}
	
	@Test
	void row5ColNegativeOneReturnsRow5Col29() {
		int[] coord = getCorrespondingCoordinate(5, -1);
		assertEquals(coord[0], 5);
		assertEquals(coord[1], 29);
	}

	@Test
	void row5Col30ReturnsRow5Col0() {
		int[] coord = getCorrespondingCoordinate(5, 30);
		assertEquals(coord[0], 5);
		assertEquals(coord[1], 0);
	}
	
	@Test
	void rowNegativeOneColNegativeOneReturnsRow24Col29() {
		int[] coord = getCorrespondingCoordinate(-1, -1);
		assertEquals(coord[0], 24);
		assertEquals(coord[1], 29);
	}
	
	@Test
	void row25Col30ReturnsRow0Col0() {
		int[] coord = getCorrespondingCoordinate(25, 30);
		assertEquals(coord[0], 0);
		assertEquals(coord[1], 0);
	}
	
	@Test
	void row25ColNegativeOneReturnsRow0Col29() {
		int[] coord = getCorrespondingCoordinate(25, -1);
		assertEquals(coord[0], 0);
		assertEquals(coord[1], 29);
	}
	
	@Test
	void rowNegativeOneCol30ReturnsRow24Col0() {
		int[] coord = getCorrespondingCoordinate(-1, 30);
		assertEquals(coord[0], 24);
		assertEquals(coord[1], 0);
	}


}
