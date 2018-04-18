import java.util.ArrayList;
import java.util.PriorityQueue;

public class MessagePriorityQueue {

	static ArrayList<PriorityQueue<Message>> messages = new ArrayList<PriorityQueue<Message>>();;
	static int curArrivalTime = 0;

	public static void fillQueue() {
		for (int i = 0; i < 5; i++) {
			messages.add(new PriorityQueue<Message>());

		}
	}

	public static void eventOccurs() {
		Message msg = new Message((int) (Math.random() * 5), curArrivalTime);
		messages.get(msg.getPriority()).add(msg);
		curArrivalTime += 1;
	}

	public static void processMessages() {
		for (PriorityQueue<Message> queue : messages) {
			for (Message m : queue) {
				System.out.println(m + " arrived at: " + curArrivalTime);
				System.out.println("That message had a waiting time of " + (curArrivalTime - m.getArrival()));
				curArrivalTime += 4;
			}
		}

	}

	public static void main(String[] args) {

		fillQueue();
		for (int i = 0; i < 10; i++) {
			eventOccurs();
		}
		processMessages();

	}

}
