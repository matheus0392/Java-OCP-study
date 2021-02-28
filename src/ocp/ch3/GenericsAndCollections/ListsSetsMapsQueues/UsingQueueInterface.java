package ocp.ch3.GenericsAndCollections.ListsSetsMapsQueues;

import static java.lang.System.*;

import java.util.ArrayDeque;
import java.util.Queue;

// elements are added and removed in a specific order
// a queue is assumed to be FIFO (first-in, first-out).
// The other common format is LIFO (last-in, first-out.)

public class UsingQueueInterface {
	public static void main(String[] args) {

		// Except for push, all are in the Queue interface as well.

		// boolean add(E e) Adds an element to the back of the queue and returns true or
		// throws an exception
		// E element() Returns next element or throws an exception if empty queue
		// boolean offer(E e) Adds an element to the back of the queue and returns
		// whether successful
		// E remove() Removes and returns next element or throws an exception if empty
		// queue
		// void push(E e) Adds an element to the front of the queue
		// E poll() Removes and returns next element or returns null if empty queue
		// E peek() Returns next element or returns null if empty queue
		// E pop() Removes and returns next element or throws an exception if empty
		// queue

		// LIFO (stack), people say push/poll/peek.
		// FIFO (single-ended queue), people say offer/poll/peek

		Queue<Integer> queue = new ArrayDeque<>();
		out.println(queue.offer(10)); // true
		out.println(queue.offer(4)); // true
		out.println(queue.peek()); // 10
		out.println(queue.poll()); // 10
		out.println(queue.poll()); // 4
		out.println(queue.peek()); // null
		out.println();

		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.push(10);
		stack.push(4);
		out.println(stack.peek()); // 4
		out.println(stack.poll()); // 4
		out.println(stack.poll()); // 10
		out.println(stack.peek()); // null

	}
}
