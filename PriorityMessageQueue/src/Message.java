
public class Message implements Comparable<Message> {

	int priority, arrival, msgNum;

	public Message(int priority, int arrival, int msgNum) {
		this.priority = priority;
		this.arrival = arrival;
		this.msgNum = msgNum;
	}

	public int getPriority() {
		return priority;
	}

	public int getArrival() {
		return arrival;
	}

	public void addArrival(int arrival) {
		this.arrival += arrival;
	}

	@Override
	public String toString() {
		return "Message Number " + msgNum + " has priority: " + priority + " created at: " + arrival;
	}

	@Override
	public int compareTo(Message o) {
		return this.priority - o.getPriority();
	}

}
