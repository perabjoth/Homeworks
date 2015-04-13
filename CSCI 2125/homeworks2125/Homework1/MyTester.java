/**
* Name: Perabjoth Singh Bajwa
* ID:2449713
* CSCI 2125 Fall 2014
* Homework1 : Root finder
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
/**couldn't perform junit test on my machine so i made another class that runs it to
see if i get correct values with the help of my calculator
**/
public class MyTester{
	public static void main(String[] args)
	{
		NumericalAnalysis myAnalyzer = new NumericalAnalysis();//create a numerical analysis object	
		double ans = myAnalyzer.solveForZero(new SomeFunction(),-1.0,5.0);//getting the zero value for this function between -1 and 5
		System.out.print(ans);//printing out answer so i can verify with calculator
		
	
	}
}
