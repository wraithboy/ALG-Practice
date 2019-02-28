package CodingImplementation;

public class ClimbStair {
	
	public static void main(String args[])
	{
		ClimbStair cs=new ClimbStair();
		
		
		long start_time = System.currentTimeMillis();
		System.out.println(cs.climbStairs(44));
		long end_time = System.currentTimeMillis();
		System.out.println(cs.climbStairsIterative(44));
		long end_time2 = System.currentTimeMillis();

		System.out.println("Time difference for recursive:"+(end_time-start_time));
		
		System.out.println("Time difference for iterative:"+(end_time2-end_time));

	}
	
    public int climbStairs(int n) {
        if(n==0)
        return 1;
        else if(n==1)
        return 1;
        else
        {
            return climbStairs(n-1)+climbStairs(n-2);
        }
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
