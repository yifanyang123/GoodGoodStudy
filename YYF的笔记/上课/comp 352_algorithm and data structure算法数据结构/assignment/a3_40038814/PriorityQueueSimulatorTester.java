package assignment3;

public class PriorityQueueSimulatorTester {

	public static void main(String[] args) {
		
		int maxNumberOfJobs = 100;// number of jobs we want to use
		int totalWaitTime = 0;
		long startTime=System.currentTimeMillis();
		int cycleNum=0;
		boolean moveOnce=false;
		Job processing=null;// the processing job   
		Job[] jobsInputArray = new Job[maxNumberOfJobs];
		//set jobsInputArray 
		for (int i =0; i< maxNumberOfJobs; i++) {
			int jobLength = (int )(Math.random()*69 )+1; 
			int jobPriority = (int )(Math.random()*39 )+1; 
			jobsInputArray[i]= new Job((i+1), jobLength, jobPriority);
		}
		//moveOnce explanation:  when 30 jobs are terminated, we should move starved,after we change starved job priority to 1,and do the while loop 
		//in fact we are just loop a cycle of job, maybe after this cycle,no job is terminate, and maxNumberOfJobs-ALPQ.size())%30 is still 0
		//then we will change starve priority again, however , in fact 0 job is terminated
		
		
		
//----------------------------------------------------------------------------------------------------------------------	

/*
		ArrayListHeapPriorityQueue ALPQ = new ArrayListHeapPriorityQueue(); 
		//to input job of job inputarray into pq
		for (int i=0; i<maxNumberOfJobs; i++) {
			ALPQ.addToPQ(new Job (jobsInputArray[i]), cycleNum);
			cycleNum++;//every add will add 1 cycle
		}
		
		while( ALPQ.size()>0) {
			if ((maxNumberOfJobs-ALPQ.size())%30==0&&moveOnce==true) {//move starved job
				ALPQ.moveStarved();		
				moveOnce=false;//eg: if n=100, and when we have 70 jobs , we will only move once,when we move starved, we will set moveOnce to false 
			}
			if ((maxNumberOfJobs-ALPQ.size())%30!=0){//eg: now we have 69 jobs, we will set moveOnce to true, then when we have 40 jobs, we can move starved again
				moveOnce=true;
			}
			processing = ALPQ.removeMin();//process the smallest final priority job
			cycleNum++;			
			System.out.println(processing);			
			if (processing.process()) {//when current length =0, terminate job and add total waittime
				processing.terminateJob(cycleNum);
				totalWaitTime += processing.getWaitTime();
			}else {//when current length>0, add it into pq again
				ALPQ.addToPQ(processing, cycleNum);
			}
		}
		System.out.println("ArrayList Heap PQ ");
        System.out.println("Current system time (cycles): " + cycleNum);
        System.out.println("Total number of jobs executed: " + maxNumberOfJobs + " jobs");
        System.out.println("Average process waiting time: " + totalWaitTime/maxNumberOfJobs + " cycles");
        System.out.println("Total number of priority changes: " + ALPQ.getPriorityChanges());
        System.out.println("Actual system time needed to execute all jobs: " + (System.currentTimeMillis()-startTime) + " ms");
        System.out.println();   */

//---------------------------------------------------------------------------------------------------------------------------------------------
   
		SortPriorityQueue SPQ = new SortPriorityQueue();
		for (int i=0; i<maxNumberOfJobs; i++) {
			SPQ.addToPQ(  new Job (jobsInputArray[i]), cycleNum);
			cycleNum++;
		}
		while( SPQ.size()>0) {		
			if ((maxNumberOfJobs-SPQ.size())%30==0&&moveOnce==true) {
				SPQ.moveStarved();		
				moveOnce=false;
			}
			if ((maxNumberOfJobs-SPQ.size())%30!=0){
				moveOnce=true;
			}
			processing = SPQ.removeMin();
			cycleNum++;			
	     	System.out.println(processing);
			boolean check = processing.process(); 
			if (check) {
				processing.terminateJob(cycleNum);
				totalWaitTime += processing.getWaitTime();
			}
			else {
				SPQ.addToPQ(processing, cycleNum);
			}
		}
		System.out.println("Sorted ArrayList PQ ");
		System.out.println("Current system time (cycles): " + cycleNum);
        System.out.println("Total number of jobs executed: " + maxNumberOfJobs + " jobs");
        System.out.println("Average process waiting time: " + totalWaitTime/maxNumberOfJobs + " cycles");
        System.out.println("Total number of priority changes: " + SPQ.getPriorityChanges());
        System.out.println("Actual system time needed to execute all jobs: " + (System.currentTimeMillis()-startTime) + " ms");
        System.out.println();
 
        
	}
	

}