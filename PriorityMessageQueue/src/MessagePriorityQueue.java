import java.util.ArrayList;
import java.util.PriorityQueue;

public class MessagePriorityQueue {

	static ArrayList<PriorityQueue<Message>> messages = new ArrayList<PriorityQueue<Message>>();;
	static int curArrivalTime = 0;
	static int curMsg = 1;
	static ArrayList<Integer> waitingTimes = new ArrayList<Integer>();
	static int numMessages = 100;

	public static void fillQueue() {
		for (int i = 0; i < 5; i++) {
			messages.add(new PriorityQueue<Message>());
		}
		for (int i = 0; i < 5; i++) {
			waitingTimes.add(0);
		}
	}

	public static void eventOccurs() {
		Message msg = new Message((int) (Math.random() * 5), curArrivalTime, curMsg++);
		messages.get(msg.getPriority()).add(msg);
		waitingTimes.set(msg.getPriority(), waitingTimes.get(msg.getPriority()) + (curArrivalTime - msg.getArrival()));
		curArrivalTime += 1;
	}

	public static void processMessages() {
		for (int j = 0; j < messages.size(); j++) {
			int numMessages = 0;
			PriorityQueue<Message> queue = messages.get(j);
			for (int i = 0; i < queue.size(); i++) {
				Message msg = queue.remove();
				System.out.println(msg + " was removed at: " + curArrivalTime);
				System.out.println("That message had a waiting time of " + (curArrivalTime - msg.getArrival()));
				curArrivalTime += 4;
				numMessages++;
			}
			System.out.println("The average waiting time of the Queue with Priority " + j + " was: "
					+ (waitingTimes.get(j) / numMessages));
			System.out.println();
			System.out.println();
		}

	}

	public static void main(String[] args) {

		fillQueue();
		for (int i = 0; i < numMessages; i++) {
			eventOccurs();
		}
		processMessages();

	}

}
