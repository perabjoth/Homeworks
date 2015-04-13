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


public class Country
{

    private String name;
    private Player occupant;
    private int numOfArmies;
    private ArrayList<Country> adjacencies;

	/**
	*constructor that takes the name of the country as its parameter
	**/
    public Country( String name )
    {
		this.name = name;
		occupant = null;
		numOfArmies = 0;
		adjacencies = new ArrayList<Country>();
    }

    
    /**
     * Used only when contstructing the country object, it should not be called after
     * the board is initialized
     **/
    public void addAdjacencies( ArrayList<Country> adjacencies )
    {
		this.adjacencies = adjacencies;
    }

   
    public String getName()
    {
		return this.name;
    }


    /**
     * When a player conquers a country the player object is set as the occupant of the country
     **/
    public void setOccupant( Player occupant )
    {
		this.occupant = occupant;
    }


    /**
     * Returns the player object who currently occupies the country
     **/
    public Player getOccupant()
    {
		return this.occupant;
    }


    /**
     * Used to set the number of armies currently stationed in this country
     **/
    public void setNumArmies( int numArmies )
    {
		this.numOfArmies = numArmies;
    }


    /**
     * Returns the number of armies currently stationed in this country
     **/
    public int getNumArmies()
    {
		return this.numOfArmies;
    }


    /**
     *  Returns a list of the country objects that are adjacent to this country on the baord
     **/
    public ArrayList<Country> getAdjacencies()
    {
		return this.adjacencies;
    }
}
