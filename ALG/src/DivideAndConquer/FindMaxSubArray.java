package DivideAndConquer;

public class FindMaxSubArray {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[]={1,-5,6,8,-13,9,4,-2,-15,12,-29,11};
		int A2[]={-4,-2,-5,-10,-3,-7,-9,-3,-5};
		//Result rlt=	findMaxCrossingSubArray(A2,0,A2.length/2,A2.length-1);
		
		//int[] rlt = findMaxSubArray(A2,0,A2.length-1);
		
		//System.out.println(rlt[0]+" "+rlt[1]+" "+rlt[2]);
		
		//findMaxSubArrayBrute(A);
		
		//findMaxContinousArrayBrute(A);
		
		System.out.println(findMaxContinuousSubArrayDivideAndConquer(A,0,A.length-1));
		int max=Integer.MIN_VALUE;
		
		System.out.println(findMaxSubArrayDP(A));
	}
	
	public static int findMaxSubArrayDP(int[] A)
	{
		
		int[] dp = new int[A.length];
		
		int max=Integer.MIN_VALUE;
		
		for(int i=0;i<A.length;i++)
		{
			if(i==0)
			dp[i]=A[0];
			else
			{
				dp[i]=Math.max(dp[i-1]+A[i],A[i]);
			}
			
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}
	
	
	public static void findMaxSubArrayBrute(int[] A)
	{
		int maxSum=Integer.MIN_VALUE;
		int sum=0;
		int start=0;
		int end=0;
		
		for ( int i=0;i<A.length;i++)
		{
			if(maxSum<A[i])
				maxSum=A[i];
			
			sum=A[i];
			for (int j=i+1;j<A.length;j++)
			{
				sum=sum+A[j];
				if(sum>maxSum)
				{
					maxSum=sum;
					start=i;
					end=j;
				}
			}
		}
		
		System.out.println("start"+start+" end"+end+" MaxSum:"+maxSum);
	}
	
	
	public static void findMaxContinousArrayBrute(int[] A)
	{
		int max=Integer.MIN_VALUE;
		
		int sum=0;
		
		for(int i=0;i<A.length;i++)
		{			
			sum=A[i];
			
			if(max<sum)
				max=sum;
			
			for(int j=i+1;j<A.length;j++)
			{
				sum=sum+A[j];
				if(max<sum)
				{
					max=sum;
				}
			}

		}
		System.out.println(max);
	}
	
	
	public static int findMaxContinuousSubArrayDivideAndConquer(int[] A,int low, int high)
	{
		
		if(A==null || A.length==0)
		{
			System.out.println("Input is null or empty, invalid input!");
			
			return 0;
		}
		
		if(low==high)
		{
			return A[low];
		}
		
		int mid=low + (high - low)/2;
		
		int leftsum=findMaxContinuousSubArrayDivideAndConquer(A,low,mid);
		int rightsum=findMaxContinuousSubArrayDivideAndConquer(A,mid+1,high);
		int crossingsum=crossSubarray(A,low,high);
		
	    if (leftsum >= rightsum && leftsum >= crossingsum){
	        return leftsum;
	    }
	    if (rightsum >= leftsum && rightsum >= crossingsum){
	        return rightsum;
	    }
	    return crossingsum;
	}
	
    public static int crossSubarray(int[] A,int left,int right){
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        int mid = left + (right - left) / 2;
        for(int i = mid; i >= left ; i--){
            sum = sum + A[i];
            if(leftSum < sum){
                leftSum = sum;
            }
        }
        sum = 0;
        for(int j = mid + 1; j <= right; j++){
            sum = sum + A[j];
            if(rightSum < sum){
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }
	
	private static class Result{
		
		public int low;
		public int high;
		public int sum;
	}
}
