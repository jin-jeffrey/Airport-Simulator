package homework4;
/**
 * This class creates an Airplane object that implements the PassengerQueue
 * @Author Jeffrey Jin 112167837 CSE214
 */
public class Airplane {
	private static final double CAPACITY = 35;
	private String departureCity;
	private String destinationCity;
	private int timeToTakeOff;
	private PassengerQueue passengers;
	
	/**
	 * Constructs an Airplane
	 * @param depart : location where the Airplane departs from
	 * @param dest : location where the Airplane will go
	 * @param time : time before flight
	 * @param p : queue of Passengers
	 */
	public Airplane (String depart, String dest, int time, PassengerQueue p) {
		departureCity = depart;
		destinationCity = dest;
		timeToTakeOff = time;
		passengers = p;
	}
	
	//getters
	/**
	 * Retrieve departing location
	 * @return String data type
	 */
	public String getDepart() {
		return departureCity;
	}
	/**
	 * Retrieve destination location
	 * @return String data type
	 */
	public String getDest() {
		return destinationCity;
	}
	/**
	 * Retrieve the time before takeoff of the Airplane
	 * @return int data type
	 */
	public int getTime() {
		return timeToTakeOff;
	}
	/**
	 * Retrieve the PassengerQueue
	 * @return PassengerQueue
	 */
	public PassengerQueue getOnBoard() {
		return passengers;
	}
	
	//setters
	/**
	 * Change or set the departing location
	 * @param d : departing location
	 */
	public void setDepart(String d) {
		departureCity = d;
	}
	/**
	 * Change or set the destination location
	 * @param d : destination location
	 */
	public void setDest (String d) {
		destinationCity = d;
	}
	/**
	 * Change or set the time of departure
	 * @param t : time before take off
	 */
	public void setTime(int t) {
		timeToTakeOff = t;
	}
	/**
	 * Change or set the PassengerQueue
	 * @param p : PassengerQueue
	 */
	public void setPassengers(PassengerQueue p) {
		passengers = p;
	}
	/**
	 * Return and remove the number of Passengers on the Airplane queue
	 * @return integer data type
	 */
	public int unload() {
		int x = passengers.size();
		passengers = new PassengerQueue(new Passenger[0]);
		return x;
	}
	/**
	 * Ensure that each queue doesn't go over the set number of First Class, Business, Premium Economy, and Economy spots
	 * @param c : travel class
	 * @return boolean data type
	 */
	public boolean checkQueue(String c) {
		int count = 0;
		if (c.compareTo("First Class")==0 || c.compareTo("Business")==0) {
			for (int x=0;x<passengers.size();x++) {
				if (passengers.getQueue()[x].getTravelClass().compareTo(c)==0) {
					count++;
				}
			}
			if (count<5) {
				return true;
			}
			return false;
		}
		else if (c.compareTo("Premium Economy")==0) {
			for (int x=0;x<passengers.size();x++) {
				if (passengers.getQueue()[x].getTravelClass().compareTo(c)==0) {
					count++;
				}
			}
			if (count<10) {
				return true;
			}
			return false;
		}
		else {
			for (int x=0;x<passengers.size();x++) {
				if (passengers.getQueue()[x].getTravelClass().compareTo(c)==0) {
					count++;
				}
			}
			if (count<15) {
				return true;
			}
			return false;
		}
	}
	/**
	 * checks if Passengers can still board
	 * @return boolean data type
	 */
	public boolean canBoard() {
		return timeToTakeOff>5;
	}
	/**
	 * Make sure the Passenger can be added to the queue based on class
	 * @param travelClass : Passenger's travel class
	 * @return boolean data type
	 */
	public boolean ensureCapacity(String travelClass) {
		int i=0;
		int count=0;
		if (travelClass.compareTo("First Class")==0) {
			i=5;
			for (int x=0;x<passengers.size();x++) {
				if (passengers.getQueue()[x].getTravelClass().compareTo("First Class")==0) {
					count++;
				}
			}
		}
		if (travelClass.compareTo("Business")==0) {
			i=5;
			for (int x=0;x<passengers.size();x++) {
				if (passengers.getQueue()[x].getTravelClass().compareTo("Business")==0) {
					count++;
				}
			}
		}
		if (travelClass.compareTo("Premium Economy")==0) {
			i=10;
			for (int x=0;x<passengers.size();x++) {
				if (passengers.getQueue()[x].getTravelClass().compareTo("Premium Economy")==0) {
					count++;
				}
			}
		}
		if (travelClass.compareTo("Economy")==0) {
			i=15;
			for (int x=0;x<passengers.size();x++) {
				if (passengers.getQueue()[x].getTravelClass().compareTo("Economy")==0) {
					count++;
				}
			}
		}
		if (count<i) {
			return true;
		}
		return false;
	}
}
