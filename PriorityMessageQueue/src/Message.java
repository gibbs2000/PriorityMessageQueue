/**
 * A class that represents a method with three fields, priority, arrival and the
 * message number, both integers
 * 
 * @author Sean Gibbons
 *
 */
public class Message implements Comparable<Message> {

	int priority, arrival, msgNum;

	/**
	 * A constructor that provides three integer parameters to use for its
	 * constructors
	 * 
	 * @param priority
	 *            the priority of the Message for when it is added to the
	 *            PriorityQueues
	 * @param arrival
	 *            the arrivalTime of the Message
	 * @param msgNum
	 *            a number used simply to keep track of the Message
	 */
	public Message(int priority, int arrival, int msgNum) {
		this.priority = priority;
		this.arrival = arrival;
		this.msgNum = msgNum;
	}

	/**
	 * Returns the priority of the Message
	 * 
	 * @return the priority of the Message
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Returns the arrivalTime of the Message
	 * 
	 * @return the arrivalTime of the Message
	 */
	public int getArrival() {
		return arrival;
	}

	/**
	 * Adds a given number to the arrivalTime to the Message's preexisting
	 * arrivalTime
	 * 
	 * @param arrival
	 *            the time to add to the Message's preexisting arrivalTime
	 */
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
