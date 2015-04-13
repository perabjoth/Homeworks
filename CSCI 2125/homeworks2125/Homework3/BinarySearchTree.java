import java.util.ArrayList;

// When I implemented my AVL tree, I first wrote a BinarySearchTree.
// My AVL tree extended my BST, providing the balance methods and
// overriding the insert and remove to work as AVL should. 
// Since my AVL extended my Binary Search Tree, it inherited the printTree
// method I have below.
// You can implement your code as I did, or you can simply include printTree
// in your AVLTree class, changing BinaryNode to AVLNode if necessary

// I offer no guarantees or warrantees on the following code. 

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>{

    protected BinaryNode<AnyType> root;

    /*
    * printTree prints out a BinarySearchTree in the same way that we
    * would draw one.
	* @require
	* 	there exists a height method that takes in a BinaryNode and
	* 		returns it's height. See book for this.
	*	The root is a BinaryNode and allows direct access to its left
	*		and right children
	* Algorithm
	* 	First initialize an ArrayList of levels. I need to print out all
	* 		the nodes on a level, so I need a list of all the nodes on
	* 		a level and then a list of all the levels.
	*	Second, add all the nodes to my levels ArrayList. Perform an in
	*		order traversal of the tree, adding each node to the proper
	*		level at the proper place.
	* 	Third, build the strings to represent all the levels and the
	* 		edges between them. 
	*	Fourth, print out all the strings.
    */
    public void printTree( ){
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
                   
    protected int height(BinaryNode<AnyType> t)
    {
        return t == null ? -1 : t.height;
    }

	// recursively perform an inOrder traversal to build the levels of
	// the tree.
	// @param
	// t - the binary node from which we are traversing
	// list - the list of levels that we are building
	// levelIndex - the index into t's level of it's position in that level
	// depth - the depth of t into the tree (also the index of it's level)
    protected void buildTreeArray(BinaryNode<AnyType> t, ArrayList<ArrayList<AnyType> > list, int levelIndex, int depth) {
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

	// My Binary node so that you can see how I had it. just like the
	// book, but with height.
    protected static class BinaryNode<AnyType>{
        AnyType element;
        BinaryNode<AnyType> left;  // Left Child
        BinaryNode<AnyType> right; // Right Child
        int height;
    
        BinaryNode( AnyType _element ) {
            this( _element, null, null, 0 );
        }

        BinaryNode( AnyType _element, BinaryNode<AnyType> _left, BinaryNode<AnyType> _right, int _height ) {
            element = _element;
            left = _left;
            right = _right;
            height = _height;
        }
    }
}
