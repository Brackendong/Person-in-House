/*
* Person.java
* Author: JiaoAng Dong
* Submission Date: 10/24/2019
*
* Purpose: this class sets up the object person.
* it contains instance variables such as name age and
* how much money the person has. It contains set and
* get methods as well as void methods that takes action
* during the process of buying a house.
 *
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing
* or posting of source code for this project is strictly
* prohibited unless you have written consent from the Department
* of Computer Science at the University of Georgia.
*/
import java.text.DecimalFormat;


/**
 * Class representing a person (a human user) on a real estate market.
 * A person has a name, age, cash, and (potentially) a house.
 */
public class Person {

	/* Instance variables */

	private String name;
	private int age;
	private double cash;
	private House house;
	
	/* Constructors */

	/**
	 * The Default constructor creates a 21 year old John L. with a penny of cash and no home.
	 */
	
	// setting up the default constructors and making the house null 
	public Person() {
		
		this.name = "John L.";
		this.age = 21;
		this.cash = 0.01 ;
		this.house = null;
	}
	/**
	 * A second constructor that enables the creation of a custom instance of the Person class. 
	 * The house instance variable is set to null.
	 * @param name : the person's name 
	 * @param age : the person's age
	 * @param cash : the amount of money the person has
	 */
	
	//setting the instance variables to the parameters. 
	
	public Person(String name, int age, double cash) {
		
		this.name = name;
		this.age = age;
		this.cash = cash;
		this.house = null;

	}

	/**
	 * A third constructor including a parameter for the persons house. The house is also updated
	 * because it is no longer for sale.
	 * @param name : the person's name 
	 * @param age : the person's age
	 * @param cash : the amount of money the person has
	 * @param house : the person's home
	 */
	//setting the instance variables to the parameters. 

	public Person(String name, int age, double cash, House house) {
		
		this.name = name;
		this.age = age;
		this.cash = cash;
		this.house = house;

	}
	
	/**
	 * Show the name and age of the person as well as their assets (cash and home if they have one).
	 * E.g.
	 * Name: John L.
	 * Age: 20 years old
	 * Cash: $ 0.01
	 */
	@Override
	// using decimalFormatObj, set the decimal places of cash to 2 and create a String
	// that output the needed information
	// in addition, using the toString method to output the house info IF there is house.
	public String toString() {
		DecimalFormat decimalFormatObj = (DecimalFormat) DecimalFormat.getInstance();
		decimalFormatObj.setDecimalSeparatorAlwaysShown(true);
        decimalFormatObj.setMinimumFractionDigits(2);
        decimalFormatObj.setMaximumFractionDigits(2);
		String s ="";
		s+= "Name: " + getName() + "\n";
		s+= "Age: " + getAge() + " years old\n";
		s+= "Cash: $" + decimalFormatObj.format(getCash()) + "\n";
		if ( house != null) {
			s+= house.toString();
		}
		return s;
		
	}
	
	/* Accessors / Getters */
	
	/**
	 * @return the person's name 
	 */
	public String getName() {
		
		return name; 
	}
	/**
	 * @return the person's age
	 */
	public int getAge() {
		
		return age; 
	}
	
	/**
	 * @return the amount of cash this person has
	 */
	public double getCash() {
		
		return cash; 
	}
	
	/**
	 * @return a reference the house object currently owned by this person
	 */
	public House getHouse() {
				
		
		return house;
	}
	

	/**
	 * @return true if this person has a home
	 */
	// if the house object is null, then there is no house
	
	public boolean ownsAHouse() {
		
		if ( house == null ) {
			return false;
		}
		else { 
			return true;
		}
	}
	
	/* Mutators */
	
	/**
	 * @param amount : the amount of cash to give this person
	 */
	
	// adding the additional amount to the cash amount. 
	public void addCash(double amount) {
		
		this.cash = cash + amount ;
	}
	
	/**
	 * If this person owns home, put it up for sale and pay the person the price of the home.
	 */
	
	// if the house is not null, meaning he/she has a house. do the actions of sell home.
	// adding money to cash and changing the boolean instance variables 
	// if the house is null, then there is nothing to sell.
	
	public void sellHome() {
		
		if( house != null  ) {
			
			System.out.println( name + " has already sold their house to the market!");
			this.cash = house.getPrice() + cash;
			house.setForSale(true);
			house = null;
		}
		else if ( house == null ) {
			System.out.println( name + " has no home to sell.");
		}
	}

	/**
	 * This method lets the person buy a home if they do not already have a home, have the cash and the home is for sale.
	 * If the person successfully buys a home, their cash is decreased by the cost of the home.
	 * @param h the house to be bought
	 */
	
	// if the house is null, cash is greater than the price of the house, and the house
	// is for sell, then do the actions of buy house. decreasing the cash and changing the 
	// boolean. 
	// errors:
	// iF the house is not null, then the person already has a house (doesn't do buyHouse)
	// if the cash is lower than the price, then the person can't afford the house. (doesn't do buyHouse)
	
	public void buyHouse(House h) {
		
		if (house == null && cash >= h.getPrice() && h.isForSale() == true ) {
			
			this.cash = cash - h.getPrice();
			this.house = h;
			h.setForSale(false);
			System.out.println( name + " is now a proud homeowner!");
			
		}
		else if (house != null) {
			System.out.println( name + " is already a homeowner!");
		}
		else if (cash < h.getPrice()) {
			System.out.println( name + " cannot afford this home.");
		}
		

	}
}