import java.util.ArrayList;
import java.util.PriorityQueue;

public class MessagePriorityQueue {

	static ArrayList<PriorityQueue<Message>> messages = new ArrayList<PriorityQueue<Message>>();;
	static int curArrivalTime = 0;
	static int curMsg = 1;
	static int numQueues = 5;
	static ArrayList<Integer> waitingTimes = new ArrayList<Integer>();;
	static ArrayList<Integer> numElements = new ArrayList<Integer>();
	static int processTime = 100000;

	/**
	 * A static helper class that setups up the queues and ArrayLists for later
	 * implemenation
	 */
	public static void makeQueues() {
		for (int i = 0; i < numQueues; i++) {
			messages.add(new PriorityQueue<Message>());
		}

		for (int i = 0; i < numQueues; i++) {
			waitingTimes.add(0);
			numElements.add(0);
		}
	}

	public static void addMessage(int i) {
		Message msg = new Message((int) (Math.random() * numQueues), curArrivalTime, i);
		messages.get(msg.getPriority()).add(msg);
	}

	public static void processMessages() {
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

	public static void processMessage(Message msg) {
		System.out.println(msg + " was removed at: " + curArrivalTime);
		System.out.println("That specific message had a waiting time of " + (curArrivalTime - msg.getArrival()));
		numElements.set(msg.getPriority(), numElements.get(msg.getPriority()) + 1);
		waitingTimes.set(msg.getPriority(), waitingTimes.get(msg.getPriority()) + (curArrivalTime - msg.getArrival()));
	}

	public static void runSystem(int t) {
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

	public static void showResults() {
		for (int j = 0; j < numQueues; j++) {
			System.out.println("The average waiting time of the Queue with Priority " + j + " was: "
					+ (waitingTimes.get(j) / numElements.get(j)));
		}

	}

	public static void main(String[] args) {
		makeQueues();
		runSystem(processTime);
		System.out.println();
		showResults();

	}

}
