package homework4;
/**
 * This class creates a Passenger object
 * @Author Jeffrey Jin 112167837
 * CSE 214
 */

public class Passenger {
	private String name;
	private String depart;
	private String destination;
	private double time;
	private String travelClass;
	
	/**
	 * Constructs a Passenger object
	 * @param n : Name of the Passenger
	 * @param dt : Departing location of the Passenger
	 * @param dn : Destination location of the Passenger
	 * @param t : time arrived of the passenger
	 * @param c : flight class of the passenger
	 */
	public Passenger (String n, String dt, String dn, double t, String c ) {
		name = n;
		depart = dt;
		destination = dn;
		time = t;
		travelClass = c;
	}
	
	//getters
	/**
	 * Retrieve the name of the Passenger
	 * @return String data type
	 */
	public String getName() {
		return name;
	}
	/**
	 * Retrieve the departing location of the Passenger
	 * @return String data type
	 */
	public String getDepart() {
		return depart;
	}
	/**
	 * Retrieve the destination of the Passenger
	 * @return String data type
	 */
	public String getDest() {
		return destination;
	}
	/**
	 * Retrieve the time of the Passenger
	 * @return double data type
	 */
	public double getTime() {
		return time;
	}
	/**
	 * Retrieve the travel class of the Passenger
	 * @return String data type
	 */
	public String getTravelClass() {
		return travelClass;
	}
	
	//setters
	/**
	 * Change or set the name of the Passenger
	 * @return String data type
	 */
	public void setName(String n) {
		name = n;
	}
	/**
	 * Change or set the departing location of the Passenger
	 * @return String data type
	 */
	public void setDepart(String d) {
		depart = d;
	}
	/**
	 * Change or set the destination of the Passenger
	 * @return String data type
	 */
	public void setDest(String d) {
		destination = d;
	}
	/**
	 * Change or set the time arrived of the Passenger
	 * @return String data type
	 */
	public void setTime(double t) {
		time = t;
	}
	/**
	 * Change or set the travel class of the Passenger
	 * @return String data type
	 */
	public void setTravelClass(String c) {
		travelClass = c;
	}
}
