package DivideAndConquer;

public class FindMaxSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[]={1,-5,6,8,-13,9,4,-2,-15,12,-29,11};
		int A2[]={4,2,-5,10,-3,-7,-9,-3,5};
		//Result rlt=	findMaxCrossingSubArray(A2,0,A2.length/2,A2.length-1);
		
		int[] rlt = findMaxSubArray(A2,0,A2.length-1);
		
		System.out.print(rlt[0]+" "+rlt[1]+" "+rlt[2]);
	}
	
	public static int[] findMaxSubArray(int[] A,int low,int high)
	{
		int[] rlt = new int[3];
		int[] right=new int[3],left=new int[3],cross=new int[3];
		if(high == low)
		{
			rlt[0]=low;
			rlt[1]=low;
			rlt[2]=A[low];
			return rlt;
		}
		else
		{
			int mid=(low+high)/2;
			left = findMaxSubArray(A,low,mid);
			right = findMaxSubArray(A,mid+1,high);
			cross = findMaxCrossingSubArray(A,low,mid,high);
			
			if (left[2]>=right[2] && left[2]>=cross[2])
			{
				return left;
			}
			else if(right[2]>=left[2] && right[2] >=cross[2])
			{
				return right;
			}
			else 
			{
				return cross;
			}
			
		}	
	}
	
	
	public static int[] findMaxCrossingSubArray(int[] A,int low, int mid , int high)
	{	
		
		System.out.println("Mid:"+mid);
		int[] rlt=new int[3];
		int maxLeft=mid;
		int maxRight=mid+1;
		int leftSum=Integer.MIN_VALUE;
		int rightSum=Integer.MIN_VALUE;
		int sum=0;
		for(int i=mid;i>=low;i--)
		{
			sum=sum + A[i];
			
			if(sum>leftSum)
			{
				leftSum=sum;
				maxLeft=i;
			}
		}
		
		sum=0;
		
		for(int i=mid+1;i<=high;i++)
		{
			sum=sum+A[i];
			
			if(sum>rightSum)
			{
				rightSum=sum;
				maxRight=i;
			}

		}
		
		rlt[0]=maxLeft;
		rlt[1]=maxRight;
		rlt[2]=leftSum+rightSum;
		
		return rlt;
	}
	
	
	private static class Result{
		
		public int low;
		public int high;
		public int sum;
	}
}
