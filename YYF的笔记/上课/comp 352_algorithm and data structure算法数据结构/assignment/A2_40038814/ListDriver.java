package comp352;

import java.util.ArrayList;
import java.util.LinkedList;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import java.util.LinkedList;
import java.util.ArrayList;
import java.io.*;

import java.util.LinkedList;
import java.util.ArrayList;
import java.io.*;

public class ListDriver {

	public static void main(String[] args) {
		
		PrintWriter pw = null;

		MyLinkedList l1=new MyLinkedList();
		MyArrayList l2=new MyArrayList();
		LinkedList l3=new LinkedList();
		ArrayList l4=new ArrayList();
		
		int [] duration= new int [16];
		double startTime;
		double endTime ;
		int n=10;
		
		/*
		 * *********************************Insert@end**************************************
		 */

		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			l1.add((int)((2*n)*Math.random()+1));
		}
		endTime = System.nanoTime();
		duration[0] = (int)(endTime - startTime)/1000;
		
		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			l2.add((int)((2*n)*Math.random()+1));
		}
		endTime = System.nanoTime();
		duration[1] =(int) (endTime - startTime)/1000;
		
		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			l3.add((int)((2*n)*Math.random()+1));
		}
		endTime = System.nanoTime();
		duration[2] =(int) (endTime - startTime)/1000;
		
		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			l4.add((int)((2*n)*Math.random()+1));
		}
		endTime = System.nanoTime();
		duration[3] =(int) (endTime - startTime)/1000;
		
		/*
		 * *********************************Insert@start**************************************
		 */
		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			l1.add(0,(int)((2*n)*Math.random()+1));
		}
		endTime = System.nanoTime();
		duration[4] =(int) (endTime - startTime)/1000;
		
		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			l2.add(0,(int)((2*n)*Math.random()+1));
		}
		endTime = System.nanoTime();
		duration[5] =(int) (endTime - startTime)/1000;
		
		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			l3.add(0,(int)((2*n)*Math.random()+1));
		}
		endTime = System.nanoTime();
		duration[6] =(int) (endTime - startTime)/1000;
		
		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			l4.add(0,(int)((2*n)*Math.random()+1));
		}
		endTime= System.nanoTime();
		duration[7] =(int) (endTime - startTime)/1000;
		/*
		 * *********************************Insert@random**************************************
		 */		
		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			l1.add((int) Math.random()*l1.size(),(int)((2*n)*Math.random()+1));
		}
		endTime = System.nanoTime();
		duration[8] =(int) (endTime - startTime)/1000;

		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			l2.add((int)(i*Math.random()),(int)((2*n)*Math.random()+1));
			//l2.add((int)0,(int)((2*n)*Math.random()+1));
		}
		endTime = System.nanoTime();
		duration[9] =(int) (endTime - startTime)/1000;
		
		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			//l3.add((int)(i*Math.random()),(int)((2*n)*Math.random()+1));
			l3.add((int)0,(int)((2*n)*Math.random()+1));
		}
		endTime = System.nanoTime();
		duration[10] =(int) (endTime - startTime)/1000;
		
		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			//l4.add((int)(i*Math.random()),(int)((2*n)*Math.random()+1));
			l4.add((int)0,(int)((2*n)*Math.random()+1));
		}
		endTime= System.nanoTime();
		duration[11] =(int) (endTime - startTime)/1000;
		
		
		System.out.println("------------------------------------------------------------------------------------");
		final Object[][] table = new String[6][];
		table[0] = new String[] { "N="+n+"", "| Insert at end", "Insert at start", "Insert at random" };
		table[1] = new String[] { "--------------------", "--------------------", "--------------------", "--------------------" };
		table[2] = new String[] { "MyLinkedList","| "+duration[0], ""+duration[4], ""+duration[8]};
		table[3] = new String[] { "MyArrayList","| "+duration[1], ""+duration[5], ""+duration[9] };
		table[4] = new String[] { "LinkedList", "| "+duration[2], ""+duration[6], ""+duration[10] };
		table[5] = new String[] { "ArrayList","| "+duration[3], ""+duration[7], ""+duration[11] };
		
		for (final Object[] row : table) {
		    System.out.format("%-20s%-20s%-20s%-20s\n", row);
		}
		System.out.println("----------------------------------------------------------------------------");
		
		
		/*
		 * Remove@start
		 */

		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			l1.remove(0);
		}
		endTime = System.nanoTime();
		duration[0] =(int) (endTime - startTime)/1000;

		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			l2.remove(0);
		}
		endTime = System.nanoTime();
		duration[1] =(int) (endTime - startTime)/1000;
		
		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			l3.remove(0);
		}
		endTime = System.nanoTime();
		duration[2] =(int) (endTime - startTime)/1000;
		
		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			l4.remove(0);
		}
		endTime = System.nanoTime();
		duration[3] =(int) (endTime - startTime)/1000;

		/*
		 * Remove@end
		 */
		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			l1.remove(l1.size()-l1.size());
		}
		endTime = System.nanoTime();
		duration[4] =(int) (endTime - startTime)/1000;
		
		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			l2.remove(l2.size()-1);
		}
		endTime = System.nanoTime();
		duration[5] =(int) (endTime - startTime)/1000;
		
		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			l3.remove(l3.size()-1);
		}
		endTime = System.nanoTime();
		duration[6] =(int) (endTime - startTime)/1000;
		
		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			l4.remove(l4.size()-1);
		}
		endTime = System.nanoTime();
		duration[7] =(int) (endTime - startTime)/1000;
        
		/*
		 * Remove@randomIndex
		 */
	/*	startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			l1.remove(1);
		}
		endTime = System.nanoTime();
		duration[8] =(int) (endTime - startTime)/1000;
		*/

		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			int a=(int)Math.random()*l2.size();
			l2.remove(a);
		}
		endTime = System.nanoTime();
		duration[9] =(int) (endTime - startTime)/1000;
		
		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			int a=(int)Math.random()*l3.size();
			l3.remove(a);
		}
		endTime = System.nanoTime();
		duration[10] =(int) (endTime - startTime)/1000;
		
		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			int a=(int)Math.random()*l4.size();
			l4.remove(a);
		}
		endTime = System.nanoTime();
		duration[11] =(int) (endTime - startTime)/1000;
		/*
		 * Remove@randomByvalue
		 */
		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			int a=(int)Math.random()*l1.size();
			l1.remove((Integer) a);
		}
		endTime = System.nanoTime();
		duration[12] =(int) (endTime - startTime)/1000;
		
		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			int a=(int)Math.random()*l2.size();
			l2.remove((Integer) a);
		}
		endTime = System.nanoTime();
		duration[13] =(int) (endTime - startTime)/1000;
		
		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			int a=(int)Math.random()*l3.size();
			l3.remove((Integer) a);
		}
		endTime = System.nanoTime();
		duration[14] =(int) (endTime - startTime)/1000;
		
		startTime = System.nanoTime();
		for (int i=0; i<n; i++) {
			int a=(int)Math.random()*l4.size();
			l4.remove((Integer) a);
		}
		endTime = System.nanoTime();
		duration[15] =(int) (endTime - startTime)/1000;
		
		System.out.println("------------------------------------------------------------------------------------------------------");
		final Object[][] table2 = new String[6][];
		table2[0] = new String[] { "N="+n+"", "| Remove at start", "Remove at end", "Remove at random", "Remove at byValue" };
		table2[1] = new String[] { "--------------------", "--------------------", "--------------------", "--------------------" ,"--------------------"};
		table2[2] = new String[] { "MyLinkedList","| "+duration[0], ""+duration[7], ""+duration[8],""+duration [12]};
		table2[3] = new String[] { "MyArrayList","| "+duration[1], ""+duration[6], ""+duration[9],""+duration [13]};
		table2[4] = new String[] { "LinkedList", "| "+duration[2], ""+duration[5], ""+duration[10],"" +duration [14]};
		table2[5] = new String[] { "ArrayList","| "+duration[3], ""+duration[4], ""+duration[11],""+duration [15]};
		
		for (final Object[] row : table2) {
		    System.out.format("%-20s%-20s%-20s%-20s%-20s\n", row);
		}
		System.out.println("------------------------------------------------------------------------------------------------------------");


}
}