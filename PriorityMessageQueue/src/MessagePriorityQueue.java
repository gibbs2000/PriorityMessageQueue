import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * A mostly static class that runs a simulation in which a Message event with
 * random priority from 0 to 4 occurs with a probability of 0.2 each "minute"
 * 
 * @author Sean Gibbons
 *
 */
public class MessagePriorityQueue {
	// Fields that either store the priorityQueues or handle the timing elements
	static ArrayList<PriorityQueue<Message>> messages = new ArrayList<PriorityQueue<Message>>();;
	static int curArrivalTime = 0;
	static int curMsg = 1;
	static ArrayList<Integer> waitingTimes = new ArrayList<Integer>();;
	static ArrayList<Integer> numElements = new ArrayList<Integer>();

	// All of these fields can be changed to allow for more messages or
	// priorityQueues

	final static int processTime = (int) Math.pow(10, 10);
	final static int numQueues = 5;

	/**
	 * A private helper class that setups up the queues and ArrayLists for later
	 * Implementation
	 */
	private static void makeQueues() {
		for (int i = 0; i < numQueues; i++) {
			messages.add(new PriorityQueue<Message>());
		}

		for (int i = 0; i < numQueues; i++) {
			waitingTimes.add(0);
			numElements.add(0);
		}
	}

	/**
	 * A private helper method that adds a message with a given number and random
	 * priority to the appropriate queue in messages
	 * 
	 * @param i
	 *            the number of the message to be added
	 */
	private static void addMessage(int i) {
		Message msg = new Message((int) (Math.random() * numQueues), curArrivalTime, i);
		messages.get(msg.getPriority()).add(msg);
	}

	/**
	 * A private helper method that processes one message out of the ArrayList from
	 * the highest priority queue if it has been there at least 4 "minutes" in run
	 * time
	 */
	private static void processMessages() {
		for (PriorityQueue<Message> queue : messages) {
			if (queue.isEmpty()) {
				continue;
			} else {
				Message msg = queue.peek();
				if (curArrivalTime - msg.getArrival() >= 4) {
					processMessage(queue.remove());
					return;
				}
			}

		}
	}

	/**
	 * A private helper method that prints a description of a given message and adds
	 * appropriate data to the arrayLists that keep track of totals and run times
	 * 
	 * @param msg
	 *            the message to be printed and processed
	 */
	private static void processMessage(Message msg) {
		System.out.println(msg + " was removed at: " + curArrivalTime);
		System.out.println("That specific message had a waiting time of " + (curArrivalTime - msg.getArrival()));
		numElements.set(msg.getPriority(), numElements.get(msg.getPriority()) + 1);
		waitingTimes.set(msg.getPriority(), waitingTimes.get(msg.getPriority()) + (curArrivalTime - msg.getArrival()));
	}

	/**
	 * A private helper method that runs the system until the given time
	 * 
	 * @param t
	 *            the end time of the program
	 */
	private static void runSystem(int t) {
		for (; curArrivalTime < t; curArrivalTime++) {
			addMessage(curArrivalTime);
			processMessages();

		}
		for (

		PriorityQueue<Message> queue : messages) {
			if (!queue.isEmpty()) {
				processMessage(queue.remove());
				curArrivalTime++;
			}
		}
	}

	/**
	 * A private helper method that prints the results of each of the queues
	 */
	private static void showResults() {
		for (int j = 0; j < numQueues; j++) {
			System.out.println("The average waiting time of the Queue with Priority " + j + " was: "
					+ (waitingTimes.get(j) / numElements.get(j)));
		}

	}

	/**
	 * Tests the static methods of the MessagePriorityQueueClass
	 * 
	 * @param args
	 *            optional String parameters
	 */
	public static void main(String[] args) {
		makeQueues();
		runSystem(processTime);
		System.out.println();
		showResults();

	}

}
