package assignment3;

import java.util.Comparator;

public class SortPriorityQueue <K,V>{
	private Job[] a;
	private int last;
	private int priorityChanges;
	//inside comparator that only take job as parameter
    public static Comparator<Job> jobComparator = new Comparator<Job>(){
        public int compare(Job c1, Job c2) {
            return (int) (c1.getKey() - c2.getKey());
        }
    };
    
	public SortPriorityQueue() {
		a= new Job[2];
		last =-1;
	}
	
	public int addToPQ(Job e, int entryTime) {
		//set entryTime  when the job is first addToPQ
		if (e.isPure()) 
			e.setEntryTime(entryTime);				
		if (last== a.length-1) //array size is full
			resize(1);
		last++;		
		int i=0;
		//attention:  it is <=0 here, so when compare=0, e and a[i] has same final priority,  it will still loop to add at the index after the last a[i] who has same priority
		while (i<last&&a[i]!=null && jobComparator.compare(a[i],e)<=0) {
			i++;
		}
		for (int j=last; j>i; j--) {
			a[j] = a[j-1];
		}
		a[i] = e;
		return i;
	}
	
	public Job removeMin() {
		if (last==-1) 
			return null;		
		Job temp = a[0];
		last--;
		for (int i=0; i<=last; i++) {
			a[i] = a[i+1];
		}		
		if (last+1== a.length/2) 
			resize(-1);
		return temp;
	}
	
	public int size() {
		return last;
	}
	
	private void resize(int i) {
		Job temp[] = a;
		int len = a.length;
		if (i>0) {
			a = new Job[(len+len)];
		}
		else {
			len =len/2;
			if (len<2) {
				a = new Job[2];
			}
			else{
				a = new Job[len];
			}
			
		}
		for (int j=0; j<=last;j++) {
			a[j] = temp[j];
		}
		 return;
		
	}

	public void moveStarved() {
		int i=last-1; //move the largest priority when it is pure
			if (a[i].isPure()) {
				a[i].setFinalPriority(1);
				Job temp=a[i];
				a[i]=null;
				last--; //size -1 temporarily because now we move out the a[i]
				for (int j=last; j>0; j--) {
					a[j] = a[j-1];
				}//now index 0 is empty, the rest index is shift
				a[0]=temp;//add the old a[i] back
				last++;
			    priorityChanges++;
			}
			else
		return ;
	}


	public int getPriorityChanges() {
		return priorityChanges;
	}

	public String toString() {
		String s = "";		
		for (int i=0; i<=last; i++) {
			s+= a[i]+ " |\n";
		}
		return s;
	}
}