package implementation;

public class ClimbStair {
	
	public static void main(String args[])
	{
		ClimbStair cs=new ClimbStair();
		
		
		long start_time = System.currentTimeMillis();
		long end_time = System.currentTimeMillis();
		System.out.println(cs.climbStairsIterative(44));
		long end_time2 = System.currentTimeMillis();

		System.out.println("Time difference for recursive:"+(end_time-start_time));
		
		System.out.println("Time difference for iterative:"+(end_time2-end_time));

		ClimbStair climbStair = new ClimbStair();

		System.out.println(climbStair.climbStairs2(5));

	}
	
    public int climbStairs2(int n) {

		if(n<=0) return 0;
		if(n==1) return 1;
		if(n==2) return 2;
		if(n==3) return 4;



		int lastOneStep=4;
		int lastTwoStep=2;
		int lastThreeSteps=1;
		int count=0;

		for(int i=4;i<=n;i++)
		{
			count=lastOneStep+lastTwoStep+lastThreeSteps;
			lastThreeSteps=lastTwoStep;
			lastTwoStep=lastOneStep;
			lastOneStep=count;
		}

		return count;
    }

	public int climbStairsIterative(int n)
	{
		int result=0;
		int[] count = new int[n+1];
		count[0]=1;
		count[1]=1;
		for(int i=2;i<=n;i++)
		{
			count[i]=count[i-1]+count[i-2];
		}
		
		result=count[n];
		
		return result;
	}
    
    
}
