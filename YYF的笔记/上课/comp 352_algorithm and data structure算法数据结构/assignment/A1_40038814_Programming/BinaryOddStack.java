package comp352;
import java.util.Scanner;
//Yifan Yang 40038814
//COMP 352 assignment 1
//the obbnacci of binary version
public class BinaryOddStack
{
	private static int numOfCalls = 0;	//record number of this method is called
	public static int  binaryOdd(int k)
	{
		int OddVal;//the value of kth oddnacci number
		numOfCalls++;
		if(k == 1 || k == 2|| k==3)//initial
		{
			OddVal = 1;
		}
		else
		{
			OddVal = binaryOdd(k - 1) + binaryOdd(k - 2)+binaryOdd(k-3);
		}		
		return OddVal;
	}
	
	public static void main(String[] args) 
	{
		long startTime = System.currentTimeMillis();//record starttime
		int n;
		Scanner kb = new Scanner(System.in);	
		System.out.print("Please enter the a non-negative value to find its Oddnacci sequence: ");
		n = kb.nextInt();
		int OddVal = binaryOdd(n);	
		System.out.println("The Oddnacci value for n=" + n + " is:" + OddVal +".");
		System.out.println("The method has been called " + numOfCalls  + " times.");
		kb.close();  
		long endTime = System.currentTimeMillis();//record endtime
		System.out.println("Running time is " + (endTime - startTime) + " ms");
	}
}
