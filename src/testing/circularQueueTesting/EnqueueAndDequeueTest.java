package gameOfLife.testing.circularQueueTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameOfLife.CircularQueue;

class EnqueueAndDequeueTest {

	@Test
	void queueWithNoEnqueueIsSize0() {
		CircularQueue<Integer> queue = new CircularQueue<>();
		assertEquals(0, queue.size());
	}
	
	@Test
	void queueWithTwoEnqueuedIsSize2ThenDequeueReturnsTheFirstValue() {
		CircularQueue<Integer> queue = new CircularQueue<>();
		queue.enqueue(1);
		queue.enqueue(2);
		assertEquals(2, queue.size());
		assertEquals(1, queue.dequeue());
	}
	
	@Test
	void queueWithOneElementsDequeueTwoReturnsNull() {
		CircularQueue<Integer> queue = new CircularQueue<>();
		queue.enqueue(2);
		assertEquals(2, queue.dequeue());
		assertEquals(null, queue.dequeue());
	}
	
	@Test
	void dequeueWithEmtyQueueReturnsNull() {
		CircularQueue<Integer> queue = new CircularQueue<>();
		assertEquals(null, queue.dequeue());
	}

}
