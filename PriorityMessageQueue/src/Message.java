
public class Message implements Comparable<Message> {

	int priority;
	int arrival;

	public Message(int priority, int arrival) {
		this.priority = priority;
		this.arrival = arrival;
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
		return "Msg with priority: " + priority + " created at: " + arrival;
	}

	@Override
	public int compareTo(Message o) {
		return this.priority - o.getPriority();
	}

}
