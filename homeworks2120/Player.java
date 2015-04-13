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
import java.util.HashMap;
import java.util.Observable;

public class Player extends Observable 
{

    protected String name;
    protected int numberArmies;
    private HashMap<String, Country> countriesHeld;
    private HashMap<String, Continent> continentsHeld;
    protected ArrayList<Card> riskCards;

	/**
	*Constructor that takes the player's name and number of armies as parameters
	**/
    public Player( String name, int numberArmies )
    {
		this.name = name;
		this.numberArmies = numberArmies;
		countriesHeld = new HashMap<String, Country>();
		continentsHeld = new HashMap<String, Continent>();
		riskCards = new ArrayList<Card>();
    }

    /**
     * Decreases the count of the number of armies the player has on the board
     * This count has to reflect the actual number of armies the players has on 
     * the board
     **/
    public void decrementArmies( int numArmiesLost )
    {
		numberArmies = numberArmies - numArmiesLost;
    }

	public int getNumArmies()
	{
		return numberArmies;	
	}
    /**
     * Increases the count of the number of armies the player has on the board
     * This count has to reflect the actual number of armies the players has on 
     * the board
     **/
    public void incrementArmies( int numArmiesGained )
    {
		numberArmies = numberArmies + numArmiesGained;
    }


    /**
     * When a player conquers a country the country needs to be added to a data structure
     * that keeps track of all the countries the player occupies
     **/
    public void addCountry( Country country )
    {
		country.setOccupant(this);
		countriesHeld.put(country.getName(), country);
    }


    /**
     * Works like addCountry above, but can be used to add multiple countries at once
     **/
    public void addCountry( ArrayList<Country> countriesList )
    {
		for(int i =0; i<countriesList.size();i++)
		{
			countriesList.get(i).setOccupant(this);
			countriesHeld.put(countriesList.get(i).getName(), countriesList.get(i));
		}
    }


    /**
     * When a player loses a country, the country must be removed from the data structure
     * tracking which countries the player occupies
     **/
    public void removeCountry( String countryName )
    {
		countriesHeld.remove(countryName);
    }

	
	public ArrayList<Country> getCountries()
	{
		return new ArrayList<Country>(countriesHeld.values());
	
	}
    /**
     * When a player occupies all the countries on a continent the continent must be added to
     * a data structure that tracks which continents the player occupies
     **/
    public void addContinent( Continent continent )
    {
		continentsHeld.put(continent.getName(), continent);	
    }

    /**
     * Removes a contient from the data structure to reflect that the player nolonger controls
     * the whole continent
     **/
    public void removeContinent( String continentName )
    {
	continentsHeld.remove(continentName);
    }

    public ArrayList<Continent> getContinents()
	{
		return new ArrayList<Continent>(continentsHeld.values());	
	}
    /**
     * Adds a risk card to the players hand
     **/
    public void addRiskCard( Card riskCard )
    {
		riskCards.add(riskCard);
    }
	
    /**
     * Removed a set of risk cards from the players hand to reflect risk cards being turned in
     **/
    public void removeCards( int[] cardsTurnedInIndex )
    {
		ArrayList<Card> removeCards = null;
		for(int i =0; i< cardsTurnedInIndex.length;i++)
		{
			removeCards.add(riskCards.get(cardsTurnedInIndex[i]));
		}
		riskCards.removeAll(removeCards);
    }

}
