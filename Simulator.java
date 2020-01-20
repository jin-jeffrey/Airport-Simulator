package homework4;
import java.util.*;
/**
 * Simulates an Airport using Passenger, PassengerQueue, and Airplane objects
 * @author Jeffrey Jin 112167837 CSE214
 *
 */
public class Simulator {
	private static String[] name = {"David","John","Paul","Mark","James","Andrew","Scott","Steven","Robert","Stephen","William","Craig","Michael","Stuart","Christopher","Alan","Colin","Brian","Kevin","Gary","Richard","Derek","Martin","Thomas","Neil","Barry","Ian","Jason","Iain","Gordon","Alexander","Graeme","Peter","Darren","Graham","George","Kenneth","Allan","Simon","Douglas","Keith","Lee","Anthony","Grant","Ross","Jonathan","Gavin","Nicholas","Joseph","Stewart","Daniel","Edward","Matthew","Donald","Fraser","Garry","Malcolm","Charles","Duncan","Alistair","Raymond","Philip","Ronald","Ewan","Ryan","Francis","Bruce","Patrick","Alastair","Bryan","Marc","Jamie","Hugh","Euan","Gerard","Sean","Wayne","Adam","Calum","Alasdair","Robin","Greig","Angus","Russell","Cameron","Roderick","Norman","Murray","Gareth","Dean","Eric","Adrian","Gregor","Samuel","Gerald","Henry","Justin","Benjamin","Shaun","Callum"};
	private static String[] location = {"New York","California","Chicago","Texas","Florida","Shanghai","Paris","Munich","Michigan","Hong Kong"};
	private static String[] travelClass = {"First Class","Business", "Premium Economy","Economy"};
	private static double arrivalProbability; 
	private static Airplane[] planes = new Airplane[1];
	
	/**
	 * Simulates the Airport (adds Passengers, prints Simulation statements, add Planes, departs Planes)
	 * @param duration : Duration of the Simulation
	 */
	public static void simulate (int duration) {
		Scanner scan = new Scanner(System.in);
		int t = 0;
		boolean newPlane = false;
		int timeArrived = 0;
		while (t<duration) {
			//test if you can add people to each plane, if possible, then queue
			for (int x=0;x<planes.length;x++) {
				Passenger traveller1 = new Passenger(name[(int)(Math.random()*99)],planes[x].getDepart(),planes[x].getDest(),t+0.5,travelClass[(int)(Math.random()*4)]);
				if (occurs() && planes[x].canBoard() && planes[x].checkQueue(traveller1.getTravelClass())){
					planes[x].getOnBoard().enqueue(traveller1);
				}
				Passenger traveller2 = new Passenger(name[(int)(Math.random()*99)],planes[x].getDepart(),planes[x].getDest(),t+1,travelClass[(int)(Math.random()*4)]);
				if (occurs() && planes[x].canBoard() && planes[x].checkQueue(traveller2.getTravelClass())){
					planes[x].getOnBoard().enqueue(traveller2);
				}
			}
			//simulation print statements
			System.out.println("Minute " + t);
			//add plane every 20 minutes
			if (t%20==0 && t!=0) {
				System.out.println("A new flight has arrived. It will be refueling for now!");
				newPlane=true;
				timeArrived = t;
			}
			if (newPlane == true && t>29 && t%5==0) {
				System.out.println("The plane that returned at " + timeArrived + " minutes is ready to depart. \nWould you like to set a destination for it? (Y for Yes, N for No)");
				String input = scan.nextLine().substring(0,1);
				if (input.compareTo("Y")==0 || input.compareTo("y")==0) {
					System.out.println("Where would you like it to go?");
					String loc = scan.nextLine();
					Airplane[] temp = planes;
					planes = new Airplane[temp.length+1];
					for (int y = 0; y<temp.length;y++) {
						planes[y] = temp[y];
					}
					planes[planes.length-1]=new Airplane(location[(int)(Math.random()*10)],loc,30,new PassengerQueue(new Passenger[0]));					
				}
			}
			//planes take off
			if (t%30==0 && t!=0) {
				int count = 0;
				for (int x=0;x<planes.length;x++) {
					if (planes[x].getTime()==0) {
						count++;
						System.out.println("Flight " + (x+1) + " is going to " + planes[x].getDest() + " with " + planes[x].getOnBoard().size() + " passengers.");
					}
				}
				System.out.println("The " + count + " flights are taking off!");
				Airplane[] temp = new Airplane[planes.length-count];
				int numAdded=0;
				for (int y=0;y<planes.length;y++) {
					if (planes[y].getTime()!=0) {
						temp[numAdded]=planes[y];
						numAdded++;
					}
				}
				planes = temp;
			}
			//simulation print statements
			System.out.println("There are " + planes.length + " airplane(s) at this airport.");
			if (planes.length==0) {
				System.out.println("Waiting for planes to land...");
			}
			for (int z=0;z<planes.length;z++) {
				System.out.println("Flight " + (z+1) + " is to " + planes[z].getDest() + " with " + planes[z].getOnBoard().size() + " passengers.");
			}
			System.out.println("\n");
			for (int a=0;a<planes.length;a++) {
				System.out.print((a+1) + " ("+planes[a].getDest()+"):");
				for (int b=0;b<planes[a].getOnBoard().size();b++) {
					System.out.print(" ["+planes[a].getOnBoard().getQueue()[b].getName()+", "+planes[a].getOnBoard().getQueue()[b].getTravelClass()+","+planes[a].getOnBoard().getQueue()[b].getTime()+" minutes]");
				}
				System.out.println("\n");
			}
			//remove time from each plane
			for (int y=0;y<planes.length;y++) {
				planes[y].setTime(planes[y].getTime()-1);
			}
			//add time to simulation
			t++;
		}
	}
	/**
	 * Returns whether a Passenger arrives based on a randomly generated number compared to the user defined arrivalProbability
	 * @return boolean data type
	 */
	public static boolean occurs () {
		return (Math.random()<arrivalProbability);
	}
	/**
	 * The main method of the project that utilizes user input in the application. 
	 * This method allows users to decide the initial number of planes, the arrival probability of Passengers, and duration of the simulaton
	 * @param args : Unused
	 */
	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			try {
					Scanner scan = new Scanner (System.in);
					System.out.println("Welcome to ARK Private International Airport!\n");
					System.out.println("Enter the number of airplanes waiting to take off: ");
					int i = Integer.parseInt(scan.nextLine());
					//add new planes
					for (int x=0;x<i;x++) {
						System.out.println("Enter the destination of flight "+ (x+1));
						String s = scan.nextLine();
						if (planes[0]==null) {
							planes=new Airplane[1];
							planes[0] = new Airplane(location[(int)(Math.random()*10)],s,30,new PassengerQueue(new Passenger[0]));
						}
						else {
							Airplane[] temp = planes;
							planes = new Airplane[temp.length+1];
							for (int y = 0; y<temp.length;y++) {
								planes[y] = temp[y];
							}
							planes[planes.length-1]=new Airplane(location[(int)(Math.random()*10)],s,30,new PassengerQueue(new Passenger[0]));
						}
					}
					System.out.println("Enter the arrival probability");
					arrivalProbability = Double.parseDouble(scan.nextLine());
					System.out.println("Enter the duration of the simulation");
					int d = Integer.parseInt(scan.nextLine());
					simulate(d);
					run = false;
				System.out.println("Thank you for working with us. If you need more updates, please let us know! \nGood Bye!");
			} catch (Exception e) {
				System.out.println("Try again! Seems like one of your inputs are the wrong type...");
			}
		}
	}
}
