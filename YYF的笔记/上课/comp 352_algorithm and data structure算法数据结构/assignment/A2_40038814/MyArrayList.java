package comp352;import java.util.Collection;import java.util.Arrays;

public class MyArrayList <E> implements List <E> {
	private E array[];
	private int realSize;
	private int mostSize;
//_______________________________________________________________________________________________________________
	public MyArrayList() {
		mostSize=2;
		realSize=0;
		array= (E[])new Object[mostSize];
	}
	public void DoubleHalve() {
	Object temp[]=array;
    if 	(realSize==0) {
		mostSize=2;
		array= (E[])new Object[mostSize];
	}
    else if ((double)realSize/(double)mostSize<0.25) {
        mostSize=mostSize/2;
    	array= (E[])new Object[mostSize];
		}
	else if (realSize==mostSize) {
		mostSize=mostSize*2;
		array= (E[])new Object[mostSize];
		}
	for (int i=0; i<realSize;i++) {
		array[i] = (E) temp[i];
		}
	 return;
	}
	public boolean add (E e) {
		array[realSize]=e;   //the array[realSize-1] is last,[realSize]is empty
		realSize++;
		DoubleHalve();
		return true;
	}
	public void add (int index, E e) {  //最后一位不能加
		if (index>realSize) {
			System.out.println("index too big");
			return;
		}
		for (int i=realSize; i>index; i--) {
			array[i]=array[i-1];
		}
		array[index]=e;
		realSize++;
		DoubleHalve();
	}
	public void clear() {
		mostSize=2;
		realSize=0;
		array= (E[])new Object[mostSize];
	}
	public E remove (int index) {
		if (index>=realSize) {
			System.out.println("doesn't exist");
			return null;
		}
		E e=array[index];
		for (int i=index; i<realSize; i++) {
			array[i]=array[i+1];
		}
		array[realSize-1]=null;//realSize is empty before this ,realSize is empty now 
		realSize--;
		DoubleHalve();
		return e;
	}
	
	public boolean remove (Object o) { 
		if (o==null) {
			return false;
		}
		E temp=(E)o;
		for (int i=0; i<realSize; i++) {
			if (array[i]==temp) {				
				for (int j=i; j<realSize; j++) {
					array[j]=array[j+1];
				}
				array[realSize-1]=null;
				realSize--;
				DoubleHalve();
				return true;     //why not use remove(int index),because it will return e we don't need
			}
		}
		return false; 
	}
	public String toString()	{
		if (realSize==0) {
			return "Empty.";
		}
		String s="";
		for (int i=0; i<realSize; i++) {
			s=s+array[i].toString()+ "|";
		}
		return s;
	}
	public int size() {
		return realSize;
	}
	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList();
		
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);//add at end checked
		list.add(3,5);
		list.add(0,1);
		System.out.println(list);
		list.remove(0);
		list.remove(list.size()-1);
		list.remove((Integer)3);
		System.out.println(list);//remove head checked
		System.out.println(list.size());
		


		

	}
}