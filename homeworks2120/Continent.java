/**
* Name: Perabjoth Singh Bajwa
* ID:2449713
* CSCI 2120 Spring 2014
* Game of Risk
*      ******
*    **********
*   *************
*  ***************
*  **   *****  ***
*  ***************
*   ****** ******
*    ***********
*     *********
*    ***********
*   ************* 
**/  
import java.util.ArrayList;


public class Continent
{

    private String name;
    private int bonusArmies;
    private ArrayList<Country> countries;

	/**
	*contructor for the class that takes the name 
	* number of bonues armies and the list of member countries as parameters
	**/
    public Continent( String name, int bonusArmies, ArrayList<Country> memberCountries )
    {
		this.name = name;
		this.bonusArmies = bonusArmies;
		this.countries = memberCountries;
    }
	/**
	*method that returns the name of the country
	**/
    public String getName()
    {
		return this.name;
    }


    /**
     *  Returns the number of bonus armies a player gets per round when the player controls this
     * continent
     **/
    public int getBonusArmies()
    {
		return this.bonusArmies;
    }


    /**
     * Returns a list of the country objects that are on this continent
     **/
    public ArrayList<Country> getMemberCountries()
    {
		return this.countries;
    }

}
