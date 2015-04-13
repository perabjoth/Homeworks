/**
* Name: Perabjoth Singh Bajwa
* ID:2449713
* CSCI 2125 Fall 2014
* Homework3 : AvlTree HashTable implementation and comparison
* Current File: HashTable implementation
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
import java.util.List;
import java.util.LinkedList;
public class SeparateChainingHashTable<AnyType>{
/**
* Construct the hash table.
*/
	public SeparateChainingHashTable( )
	{
		this( DEFAULT_TABLE_SIZE );
	}

	private static final int DEFAULT_TABLE_SIZE = 101;//prime number for default size

/**
* Find an item in the hash table.
* @param x the item to search for.
* @return true if x is not found.
*/
	public boolean contains( AnyType x )
	{
		List<AnyType> whichList = theLists[ myhash( x ) ];
		return whichList.contains( x );
	}

/**
* Insert into the hash table. If the item is
* already present, then do nothing.
* @param x the item to insert.
*/
	public void insert( AnyType x )
	{
		List<AnyType> whichList = theLists[ myhash( x ) ];
	if( !whichList.contains( x ) )
	{
		whichList.add( x );

	// Rehash
		if( ++currentSize > theLists.length )
		rehash( );
		}
	}

/**
* Remove from the hash table.
* @param x the item to remove.
*/
	public void remove( AnyType x )
	{
		List<AnyType> whichList = theLists[ myhash( x ) ];
		if( whichList.contains( x ) )
		{
			whichList.remove( x );
			currentSize--;
		}
	}
/**
* Construct the hash table.
* @param size approximate table size.
*/
	public SeparateChainingHashTable( int size )
	{
		theLists = new LinkedList[ nextPrime( size ) ];
		for( int i = 0; i < theLists.length; i++ )
			theLists[ i ] = new LinkedList<>( );
	}
/**
* Make the hash table logically empty.
*/
	public void makeEmpty( )
	{
		for( int i = 0; i < theLists.length; i++ )
			theLists[ i ].clear( );

		currentSize = 0;
	}

	private List<AnyType> [ ] theLists;
	private int currentSize;

	private void rehash( )//rehashing the hastable when size exceeds list length
	 { 
		List<AnyType> [ ] oldLists = theLists;
		// Create new double-sized, empty table
		theLists = new List[ nextPrime( 2 * theLists.length ) ];

		for( int j = 0; j < theLists.length; j++ )
			theLists[ j ] = new LinkedList<>( );
			// Copy table over
		currentSize = 0;
		for( int i = 0; i < oldLists.length; i++ )
			for( AnyType item : oldLists[ i ] )
				insert( item ); 

	}
	
	private int myhash( AnyType x )//calculalting hashvalue using the given input
	{
		int hashVal = x.hashCode( );
		hashVal %= theLists.length;
		if( hashVal < 0 )//if negative add list length to get a positive value
			hashVal += theLists.length;
		return hashVal;
	 }
	
	private static int nextPrime( int n )//method to get next prime number
        {
            if( n % 2 == 0 )
                n++;

            for( ; !isPrime( n ); n += 2 )
                ;

            return n;
        }
        
	private static boolean isPrime( int n )//checking if the given number is prime or not
        {
            if( n == 2 || n == 3 )
                return true;

            if( n == 1 || n % 2 == 0 )
                return false;

            for( int i = 3; i * i <= n; i += 2 )
                if( n % i == 0 )
                    return false;

            return true;
        }
}
