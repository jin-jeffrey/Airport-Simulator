package homework4;
/**
 * This class implements Passenger objects into a PassengerQueue (in the form of an array
 * @Author Jeffrey Jin 112167837
 * CSE 214
 */
public class PassengerQueue {
	private Passenger[] queue;
	
	/**
	 * Constructs a PassengerQueue
	 * @param q : PassengerQueue, an array of Passengers
	 */
	public PassengerQueue(Passenger[] q) {
		queue = q;
	}
	
	//getters
	/**
	 * Retrieve the Queue
	 * @return Passenger[]
	 */
	public Passenger[] getQueue() {
		return queue;
	}

	//setters
	/**
	 * Change or set the PassengerQueue
	 * @param q : new PassengerQueue (Passenger array)
	 */
	public void setQueue(Passenger[] q) {
		queue = q;
	}
	/**
	 * Add the passenger to the end of the queue
	 * @param p : new Passenger
	 */
	public void enqueue(Passenger p){
		Passenger[] temp = queue;
		queue = new Passenger[temp.length+1];
		for (int x=0;x<temp.length;x++) {
			queue[x]=temp[x];
		}
		queue[queue.length-1]=p;
	}
	/**
	 * Obtain the Passenger that is first in line
	 * @return Passenger 
	 * @throws Exception thrown if the Passenger queue is empty
	 */
	public Passenger peek () throws Exception{
		if (isEmpty()==false) {
			return queue[0];
		}
		else {
			throw new Exception("Passenger queue is empty.");
		}
	}
	/**
	 * Retrieve the size of the queue
	 * @return int data type
	 */
	public int size() {
		return queue.length;
	}
	/**
	 * Retrieves whether the queue is empty or not
	 * @return boolean data type
	 */
	public boolean isEmpty() {
		return (queue[0]==null);
	}
	
	/**
	 * Remove the Passengers by their class
	 * @return Passenger 
	 * @throws Exception thrown if the passenger queue is empty
	 */
	public Passenger dequeue() throws Exception{
		if (isEmpty()) {
			throw new Exception ("Passenger queue is empty.");
		}
		else {
			Passenger[] temp = new Passenger[queue.length-1];
			//search for first class
			for (int x = 0; x<queue.length; x++) {
				if (queue[x].getTravelClass().compareTo("First Class")==0) {
					for (int i = 0; i<x; i++) {
						temp[i] = queue[i];
					}
					for (int j = x+1; j<queue.length; j++) {
						temp[j-1] = queue[j];
					}
					Passenger p = queue[x];
					queue = temp;
					return p;
				}
			}
			//search for business
			for (int x = 0; x<queue.length; x++) {
				if (queue[x].getTravelClass().compareTo("Business")==0) {
					for (int i = 0; i<x; i++) {
						temp[i] = queue[i];
					}
					for (int j = x+1; j<queue.length; j++) {
						temp[j-1] = queue[j];
					}
					Passenger p = queue[x];
					queue = temp;
					return p;
				}
			}
			//search for premium economy
			for (int x = 0; x<queue.length; x++) {
				if (queue[x].getTravelClass().compareTo("Premium Economy")==0) {
					for (int i = 0; i<x; i++) {
						temp[i] = queue[i];
					}
					for (int j = x+1; j<queue.length; j++) {
						temp[j-1] = queue[j];
					}
					Passenger p = queue[x];
					queue = temp;
					return p;
				}
			}
			//search for economy
			for (int x = 0; x<queue.length; x++) {
				if (queue[x].getTravelClass().compareTo("Economy")==0) {
					for (int i = 0; i<x; i++) {
						temp[i] = queue[i];
					}
					for (int j = x+1; j<queue.length; j++) {
						temp[j-1] = queue[j];
					}
					Passenger p = queue[x];
					queue = temp;
					return p;
				}
			}
		}
		throw new Exception ("Passenger queue is empty.");
	}
}
