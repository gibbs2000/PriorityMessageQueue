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
	}

	public static void eventOccurs() {
		Message msg = new Message((int) (Math.random() * 5), curArrivalTime, curMsg++);
		messages.get(msg.getPriority()).add(msg);
		curArrivalTime += 1;
	}

	public static void processMessages() {
		for (PriorityQueue<Message> queue : messages) {
			for (int i = 0; i < queue.size(); i++) {
				Message msg = queue.remove();
				System.out.println(msg + " was removed at: " + curArrivalTime);
				System.out.println("That message had a waiting time of " + (curArrivalTime - msg.getArrival()));
				curArrivalTime += 4;
			}
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
