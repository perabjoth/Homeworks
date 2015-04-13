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
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Board
{

    private HashMap<String, Country>  countries;
    private HashMap<String, Continent>  continents;

    public Board()
    {
		countries = new HashMap<String, Country>();
		continents = new HashMap<String, Continent>();
    }


    /**
     * Loads the information needed to contruct the board and constructs the country and continent objects
     * needed for the board from three files.  The first file lists all the countries.  The second file lists 
     * all of the continents and which countries are on a given continent.  The third file lists the adjacencies 
     * for each country.
     **/
    public boolean loadBoard( String countriesFile, String continentsFile, String adjacenciesFile ) throws FileNotFoundException
    {
		Scanner fileReader;
		try{
			fileReader = new Scanner(new File(countriesFile));//using the info to list countries with adjacencies
			while(fileReader.hasNextLine())
			{
				String name = fileReader.nextLine().trim();//removing whitespace at the beginning
				Country addCountry = new Country(name);
				this.countries.put(name, addCountry);//adding it to the hashmap of countries
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();		
		}
		
		try{

			fileReader = new Scanner(new File(adjacenciesFile));
			while(fileReader.hasNextLine())
			{
				String countries = fileReader.nextLine();
				String[] adjacencies = countries.split(",");
				String first = adjacencies[0].trim();//removing the whitespace at the beginning
				Country firstCountry = this.countries.get(first);
				ArrayList<Country> allCountries = new ArrayList<Country>();
				for(int i =1; i<adjacencies.length;i++)
				{
					allCountries.add(this.countries.get(adjacencies[i]));//adding the countries to the list of its adjacencies
				}
				firstCountry.addAdjacencies(allCountries);//creating the country with its adjacencies
				this.countries.put(first,firstCountry );//replacing the country with one that has adjacencies
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();		
		}
		
		try{
			fileReader = new Scanner(new File(continentsFile));
			while(fileReader.hasNextLine())
			{
				String values = fileReader.nextLine();
				String[] continent = values.split(",");//getting values separated by commas
				String name = continent[0].trim();
				int bonusArmies = Integer.parseInt(continent[1]);
				ArrayList<Country> members = new ArrayList<Country>();
				for(int i =2; i<continent.length; i++)
				{
					members.add(countries.get(continent[i]));
				}
				Continent addContinent = new Continent(name,bonusArmies, members);//setting the continent with all needed values
				continents.put(name, addContinent);//adding it to the hashmap
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();		
		}
		
		
		if(countries!= null && continents != null)
		return true;//if everything is initialized then load board if not then no
		else 
		return false;
		
    }


    /**
     * Returns a list containing the continent objects the board has
     * */
    public ArrayList<Continent> getContinents()
    {
		ArrayList<Continent> allContinents = (ArrayList<Continent>)continents.values();
		return allContinents;
    }


    /**
     * Returns the continent object whose name is the string continentName
     **/
    public Continent getContinentByName( String continentName )
    {
		return continents.get(continentName);
    }


    /**
     * Returns the number of bonus armies awarded to a player for controlling all the countries in
     * the continent whose name is the string continentName
     **/
    public int getBonusAmrines( String continentName )
    {
		Continent anyContinent = continents.get(continentName);	
		return anyContinent.getBonusArmies();
    }


    /**
     * Returns a list of the country objects that are in the continent specified 
     * by the string continentName
     **/
    public ArrayList<Country> getMemberCountries( String continentName )
    {
		Continent anyContinent = continents.get(continentName);
		ArrayList<Country> memberCountries = anyContinent.getMemberCountries();
		return memberCountries;
    }


    /**
     * Returns a list of all of the country objects in the board
     **/
    public ArrayList<Country> getCountries()
    {
    		ArrayList<Country> allCountries = new ArrayList<Country>(countries.values());
		return allCountries;
    }


    /**
     * Returns the country object for the country secified by the string
     * countryName
     **/
    public Country getCountryByName( String countryName )
    {
		return countries.get(countryName);
    }


    /**
     * Sets the occupant of the country object specified by the string countryName
     * to be the player object supplied as an argument.
     **/
    public void setOccupant( String countryName,  Player occupant )
    {
		countries.get(countryName).setOccupant(occupant);
    }


    /**
     * Returns the player object that currently occupies the country specufied by
     * string countryName
     **/
    public Player getOccupant( String countryName )
    {
		return countries.get(countryName).getOccupant();
    }


    /**
     * Sets the number of armies currently in the country specified by the string
     * countryName to the integer supplied as an argument
     **/
    public void setNumberArmies( String countryName, int numberArmies )
    {
		countries.get(countryName).setNumArmies(numberArmies);
    }


    /**
     * Returns the number of armies currently in the country specified by the string
     * countryName
     **/
    public int getNumberArmies( String countryName )
    {
		return countries.get(countryName).getNumArmies();
    }


    /**
     * Returns a list of the country objects that are the countries adjacent to the country
     * specified by the string countryName on the board
     **/
    public ArrayList<Country> getAdjacencies( String countryName )
    {
		return countries.get(countryName).getAdjacencies();
    }

}
