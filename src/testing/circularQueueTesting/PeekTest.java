package gameOfLife.testing.circularQueueTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameOfLife.CircularQueue;

class PeekTest {

	@Test
	void queueWithPeekDoesNotRemoveElementAndDequeuRemovesElement() {
		CircularQueue<Integer> queue = new CircularQueue<>();
		queue.enqueue(5);
		queue.enqueue(6);
		assertEquals(2, queue.size());
		queue.peek();
		assertEquals(2, queue.size());
		queue.dequeue();
		assertEquals(1, queue.size());
	}
	
	@Test
	void queueWithPeekProperlyReturnsElement() {
		CircularQueue<Integer> queue = new CircularQueue<>();
		queue.enqueue(5);
		queue.enqueue(6);
		assertEquals(5, queue.peek());
	}

}
