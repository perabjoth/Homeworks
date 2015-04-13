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
public final class Card
{

    private final String type;
    private final Country country;

	/**
	*Constructing a card that is a of a certain type and
	* has the name of a country
	**/
    public Card( String type, Country country )
    {
		this.type=type;
		this.country=country;
    }
	/**
	*method that returns the type of the card to know what type of army it has
	**/
    public String getType()
    {
		return this.type;
    }
	/**
	*method that returns the country on the card
	**/
    public Country getCountry()
    {
		return this.country;
    }


}
