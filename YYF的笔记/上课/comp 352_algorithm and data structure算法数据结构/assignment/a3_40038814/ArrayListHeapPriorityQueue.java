package assignment3;

import java.util.Comparator;

public class ArrayListHeapPriorityQueue <K,V>{
	private MyArrayList<Job> heap;
	private int priorityChanges;
	//inside comparator that only take job as parameter
    public static Comparator<Job> jobComparator = new Comparator<Job>(){
        public int compare(Job c1, Job c2) {
            return (int) (c1.getKey() - c2.getKey());
        }
    };
	public ArrayListHeapPriorityQueue() {
		this.heap = new MyArrayList();
		this.priorityChanges = 0;
	}
	
	public String toString() {
		return heap.toString();
	}
	
	private void swap (int p, int q) {
		Job temp= heap.get(p);
		heap.set(p,heap.get(q));
		heap.set(q, temp);
	}
   //to make sure root has least final priority
	private int downHeap(int j) {
		int parent = j;
		int left = 2*j+1;
		int right = 2*j+2;
		if (heap.get(parent)==null) return 0;
		if (left>heap.size()-1|| right>heap.size()-1) {
			return j;
		}
		//when left <parent and right < parent,  find the smallest one, and swap (smallest,parent)
		if (jobComparator.compare(heap.get(left),heap.get(parent))<0&&jobComparator.compare(heap.get(right),heap.get(parent))<0)   //如果左边的小于parent，那么swap，就一定要保持current最小
		{ 
			if(jobComparator.compare(heap.get(left),heap.get(right))<0) {
				swap(left,parent);
				return downHeap(left);
			}				
			else {
				swap(right,parent);
				return downHeap(right);
			}
				
		}
		//left<parent,swap
		if (jobComparator.compare(heap.get(left),heap.get(parent))<0)  
		{ 
			swap(left,parent);
			return downHeap(left);
		}
		//right<parent,swap
		else if (jobComparator.compare(heap.get(right),heap.get(parent))<0) 
		{ 
			swap(right,parent);
			return downHeap(right);
		}
		return parent;
	}
	
	private int upHeap(int i) {
		int parent = 0;  
		if (i<=0 || i>=heap.size()) 
			return 0;				
		// if right child
		else if (i%2 ==0) {
			parent = (i-2)/2;
		}
		else {// left child
			parent = (i-1)/2;
		}
		// parent > child so swap
		if (jobComparator.compare(heap.get(parent),heap.get(i))<0) {
			swap (parent,i);
			return upHeap(parent);//然后bubbleup他的parent
		}
		// parent < child everything is okay
		return i;
	}

	public void addToPQ(Job j, int entryTime) {//把一个jobadd到PQ里，只有pure的时候才能add，entrytime
		if (j.isPure()) j.setEntryTime(entryTime);
		// add value to end of
		heap.add(j);//加在最后
		// restore heap starting from insertion point
		upHeap(heap.size()-1);//bubbleUp最后面一个
	}
	
	public Job removeMin() {	
		// get value at head
		Job temp = heap.get(0);
		// put last value at root
		heap.set(0, heap.remove(heap.size()-1));
		downHeap(0);		
		return temp;
	}
	
	public int size() {
		return heap.size();
	}
	
	public void moveStarved() {
		int indexOfOldest = 0;
		int i=heap.size()-1; 
		if (heap.get(i).isPure()) {
			indexOfOldest = i;	
			heap.get(indexOfOldest).setFinalPriority(1);
			this.upHeap(i);
			this.priorityChanges++;
		}
		else
			return;
	}
	
	
	public int getPriorityChanges() {
		return priorityChanges;
	}
}