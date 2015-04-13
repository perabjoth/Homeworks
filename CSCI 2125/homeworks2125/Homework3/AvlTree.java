/**
* Name: Perabjoth Singh Bajwa
* ID:2449713
* CSCI 2125 Fall 2014
* Homework3 : AvlTree HashTable implementation and comparison
* Current File: Avl Implementation
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
public class AvlTree<AnyType extends Comparable<AnyType>> extends BinarySearchTree{

	AvlNode<AnyType> root;
	
	public AvlTree ()//intializing the tree as null
	{
		root= null;
	}

	public void insert( AnyType x)//inserting the element using the insert method 
	{
		root = insert(x,root);
	}

	public AnyType findMin()//finding the min uing the findmin method
	{
		return findMin(root).element;
	}

	public void makeEmpty()//emptying the tree by initializing to null again
	{
		root=null;
	}

	public void printTree( )//printing the tree using your code
        {
               System.out.println("PRINTING THE TREE!!!!!!");
        int treeHeight = height( root );
        System.out.println("tree height: " + treeHeight);
		// initialize levels to hold all nulls. 
        ArrayList<ArrayList<AnyType> > levels = new ArrayList<>(treeHeight+1);
        for(int i = 0; i < treeHeight+1; i++){
            int sizeOfList = (int)(Math.pow(2,i)); // level 0 holds 1 element (the root), 
												   // level 1 holds 2 elements, level 2 holds
												   // 4 elements.
            levels.add(new ArrayList<AnyType>(sizeOfList));
            for(int j = 0; j < sizeOfList; j++){
                levels.get(i).add(null); // initialize all elements to be null
            }
        }
		// in order traversal to add all nodes to levels
        buildTreeArray(root.left, levels, 0, 1);
        levels.get(0).set(0,root.element);
        buildTreeArray(root.right, levels, 1, 1);

        int width = 3;
        int space = 0;
		// Build all the strings.
		// WARNING: THERE BE DRAGONS BEYOND HERE. Venture at
		// your own risk.
        ArrayList<String> treeStrings = new ArrayList<>();
        for(int i = levels.size()-1; i >= 0 ; i--){
            int indent = space+1;
            int depth = treeHeight-i;
            space = (((int)Math.pow(2,depth+1))-1)*width;
            int halfWidth = width/2 + 1;
            int halfSpace = space/2 + 1;
			// the following funk was because I wanted to be able to change the
			// the width and spacing of the tree.
			// First it creates a format string specifying the proper length.
			// Then it creates the precise spacing strings needed to draw
			// the tree.
			// If width = 3, format = "%3s"
			// A width of 3 implies the largest length of the string
			// version of a number (including negative signs) should be
			// no more than 3 characters.
            String format = String.format("%s%ds", "%",indent);
            String indentStr = String.format(format,"");
            format = String.format("%s%ds", "%", space);
            String spaceStr = String.format(format,"");
            format = String.format("%s%ds", "%", halfWidth);
            String halfWidthStr = String.format(format,"");
            format = String.format("%s%ds", "%", halfSpace);
            String halfSpaceStr = String.format(format,"");
			// This last format string will be used to format the nodes
            format = String.format("%s%ds", "%", width);
            String widthStr = String.format(format,"");
            
            ArrayList<AnyType> level = levels.get(i);
            
            String levelStr = "";
            String edgesStr = "";
            levelStr = levelStr + indentStr;
            edgesStr = edgesStr + halfSpaceStr + halfWidthStr;
            for(int j = 0; j < level.size(); j++){
                if(level.get(j) != null){
                    levelStr = levelStr + String.format(format,level.get(j)) + spaceStr;
					// The even indices of level hold the left children,
					// draw left edge
                    if(j%2==0)
                        edgesStr = edgesStr + "/" + spaceStr;
                    else // else draw right edge
                        edgesStr = edgesStr + "\\" + halfWidthStr + spaceStr + halfWidthStr;
                } else {
                    levelStr = levelStr + String.format(format,"|-|") + spaceStr;
                    if(j%2==0)
                        edgesStr = edgesStr + "/" + spaceStr;
                    else
                        edgesStr = edgesStr + "\\" + halfWidthStr + spaceStr + halfWidthStr;
                }
            }
            treeStrings.add(levelStr);
            treeStrings.add(edgesStr);
        } 
		// finally, print out all the strings
        for(int i = treeStrings.size()-2; i >= 0; i--){
            System.out.println(treeStrings.get(i));
        }
    }
	
	protected void buildTreeArray(AvlNode<AnyType> t, ArrayList<ArrayList<AnyType> > list, int levelIndex, int depth) {//using your buildarray method to make printree work
        if(t != null){
            buildTreeArray(t.left, list, levelIndex*2, depth+1); // left child is at the next depth and levelIndex*2
            list.get(depth).set(levelIndex, t.element);
            buildTreeArray(t.right, list, levelIndex*2+1, depth+1); // right child is at the next depth and levelIndex*2+1
        }
        // to illustrate the level index progression, consider the following:
        // The values of the nodes represent their indices into the list
        // that holds the nodes at that depth.
        // level 0:                   0
        //                      /           \
        // level 1:           0               1
        //                  /    \         /     \
        // level 2:       0       1       2       3
        //              /  \     / \     / \     / \
        // level 3:    0    1   2   3   4   5   6   7
    }
	

public class AvlNode<AnyType extends Comparable<AnyType>> 
{
// Constructors
	AvlNode( AnyType theElement )
	{ this( theElement, null, null ); }

	AvlNode( AnyType theElement, AvlNode<AnyType> lt, AvlNode<AnyType> rt )
	{ element = theElement; left = lt; right = rt; height = 0; }
	

	AnyType element; // The data in the node
	AvlNode<AnyType> left; // Left child
	AvlNode<AnyType> right; // Right child
	int height; // Height
}


public int height( AvlNode<AnyType> t )
{
return t == null ? -1 : t.height;
}//returns the height or null if no elements exist


 /**
 * Internal method to insert into a subtree.
 * @param x the item to insert.
 * @param t the node that roots the subtree.
 * @return the new root of the subtree.
 */
 private AvlNode<AnyType> insert( AnyType x, AvlNode<AnyType> t )
 {
	if( t == null )
		return new AvlNode<AnyType>( x, null, null );

	int compareResult = x.compareTo( t.element );

	if( compareResult < 0 ){
		t.left = insert( x, t.left );
	}
	else if( compareResult > 0 ){
		t.right = insert( x, t.right );
	}
	else
	; // Duplicate; do nothing

	return balance( t );
 }
      
public static final int ALLOWED_IMBALANCE = 1;//the balancing condition for avl trees

 // Assume t is either balanced or within one of being balanced
private AvlNode<AnyType> balance( AvlNode<AnyType> t )//checking which subtree is out of balance and performing rotations accordingly
{
	if( t == null )
		return t;

	if( height( t.left ) - height( t.right ) > ALLOWED_IMBALANCE ){
		if( height( t.left.left ) >= height( t.left.right ) )
			t = rotateWithLeftChild( t );
		else
			t = doubleWithLeftChild( t );
	}
	else
		if( height( t.right ) - height( t.left ) > ALLOWED_IMBALANCE ){
			if( height( t.right.right ) >= height( t.right.left ) )
				t = rotateWithRightChild( t );
			else
				t = doubleWithRightChild( t );
		}
	t.height = Math.max( height( t.left ), height( t.right ) ) + 1;
	return t;
}




/**
 * Rotate binary tree node with left child.
 * For AVL trees, this is a single rotation for case 1.
 * Update heights, then return new root.
 */
 private AvlNode<AnyType> rotateWithLeftChild( AvlNode<AnyType> k2 )
 {
	 AvlNode<AnyType> k1 = k2.left;
	 k2.left = k1.right;
	 k1.right = k2;
	 k2.height = Math.max( height( k2.left ), height( k2.right ) ) + 1;
	 k1.height = Math.max( height( k1.left ), k2.height ) + 1;
	 return k1;
 }

   /**
    * Rotate binary tree node with right child.
    * For AVL trees, this is a single rotation for case 4.
    * Update heights, then return new root.
    */
private AvlNode rotateWithRightChild( AvlNode<AnyType> k1 )
{
	AvlNode<AnyType> k2 = k1.right;
	k1.right = k2.left;
	k2.left = k1;
	k1.height = Math.max( height( k1.left ), height( k1.right ) ) + 1;
	k2.height = Math.max( height( k2.right ), k1.height ) + 1;
	return k2;
}

 /**
 * Double rotate binary tree node: first left child
 * with its right child; then node k3 with new left child.
 * For AVL trees, this is a double rotation for case 2.
 * Update heights, then return new root.
 */
 private AvlNode<AnyType> doubleWithLeftChild( AvlNode<AnyType> k3 )
 {
	 k3.left = rotateWithRightChild( k3.left );
	 return rotateWithLeftChild( k3 );
 }

 /**
 * Double rotate binary tree node: first right child
 * with its left child; then node k3 with new right child.
 * For AVL trees, this is a double rotation for case 3.
 * Update heights, then return new root.
 */
 private AvlNode<AnyType> doubleWithRightChild( AvlNode<AnyType> k3 )
 {
	 k3.right = rotateWithLeftChild( k3.right );
	 return rotateWithRightChild( k3 );
 }

 private AvlNode<AnyType> findMin(AvlNode<AnyType> t) //getting the minimum by getting the farthest left element in the tree
{

	while(t.left!=null)
	{
		t=t.left;
	}

	return t;
}

/**
* Internal method to remove from a subtree.
 * @param x the item to remove.
 * @param t the node that roots the subtree.
 * @return the new root of the subtree.
 */
 private AvlNode<AnyType> remove( AnyType x, AvlNode<AnyType> t )
 {
	 if( t == null )
		 return t; // Item not found; do nothing

	 int compareResult = x.compareTo( t.element );

	 if( compareResult < 0 )
		 t.left = remove( x, t.left );
	 else if( compareResult > 0 )
		 t.right = remove( x, t.right );
	 else if( t.left != null && t.right != null ) // Two children
	 {
		 t.element = findMin( t.right ).element;
		 t.right = remove( t.element, t.right );
	 }
	 else
	 t = ( t.left != null ) ? t.left : t.right;

	 return balance( t );
	}


}
