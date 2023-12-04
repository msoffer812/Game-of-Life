/**
 * 
 * Circular queue class, holds data in that form
 */
package gameOfLife;


public class CircularQueue<T>{
	private QueueNode<T> head;	/* Pointer to the front of the list */
	private QueueNode<T> tail;	/* Pointer to the back of the list, whose 'next' is the head */
	private int size;			/* Holds the size of the list, to make it O(1) complexity to get the size */
	
	
	/**
	 * Two constructors, one with a value and one without
	 */
	public CircularQueue()
	{
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	public CircularQueue(T val)
	{
		this.head = new QueueNode<T>(val);
		this.tail = head;
		size = 1;
	}
	
	/**
	 * Add an element to the queue
	 * increase the size by one
	 * @param element
	 */
	@SuppressWarnings("unchecked")
	public void enqueue(T element)
	{
		QueueNode<T> newNode = new QueueNode<T>(element);
		if(head == null)
		{
			this.head = newNode;
			this.tail = head;
			this.tail.next = head; //Making it circular
		} else
		{
			tail.next = newNode;
			tail = newNode;
			tail.next = head;
		}
		size++;
	}
	
	/**
	 * Remove and return the element at the front and adjust the queue
	 * @return element at the front, null if there are none
	 */
	public T dequeue()
	{
		if(isEmpty())
		{
			return null;
		}else
		{
			T val = head.val;
			if(size == 1)
			{
				head = null;
				tail = null;
			}else 
			{
				head = head.next;
				tail.next = head;
			}
			size--;
			return val;
		}
	}
	
	/**
	 * Do not remove the element at the front
	 * @return element at the front, null if there are none
	 */
	public T peek()
	{
		if(head == null)
		{
			return null;
		} else
		{
			return head.val;
		}
	}
	
	/**
	 * 
	 * @return boolean if queue is empty or not
	 */
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	/**
	 * 
	 * @return the size of the queue
	 */
	public int size()
	{
		return this.size;
	}
	
	/**
	 * clear all the values from the queue, 
	 * set head and tail to null, size to zero
	 */
	public void clear()
	{
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	/**
	 * private inner class that defines
	 * a node in the linked list chain
	 * @author mbrso
	 *
	 * @param <T>
	 */
	private class QueueNode<T>
	{
		T val;
		QueueNode<T> next;
		
		/**
		 * Constructors
		 */
		
		public QueueNode(T val)
		{
			this.val = val;
			this.next = null;
		}
	}
}
