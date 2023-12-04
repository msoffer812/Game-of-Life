package gameOfLife.testing.circularQueueTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameOfLife.CircularQueue;

class SizeAndClearTest {

	@Test
	void initializedEmptyQueueReturnsZero() {
		CircularQueue<Integer> queue = new CircularQueue<>();
		assertEquals(0, queue.size());
	}
	
	@Test
	void queueInitializedWithOneElementReturnsOne() {
		CircularQueue<Integer> queue = new CircularQueue<>(5);
		assertEquals(1, queue.size());
	}

	@Test
	void queueWithTwoElementsReturnsTwo() {
		CircularQueue<Integer> queue = new CircularQueue<>();
		queue.enqueue(2);
		queue.enqueue(2);
		assertEquals(2, queue.size());
	}

	@Test
	void clearedQueueReturnsZero() {
		CircularQueue<Integer> queue = new CircularQueue<>();
		queue.enqueue(2);
		queue.enqueue(2);
		queue.clear();
		assertEquals(0, queue.size());
	}
}
