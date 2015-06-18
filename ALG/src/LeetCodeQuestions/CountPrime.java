package LeetCodeQuestions;

//Description:
//
//Count the number of prime numbers less than a non-negative number, n.
//
//Credits:
//Special thanks to @mithmatt for adding this problem and creating all test cases.

public class CountPrime {
	public static void main(String args[])
	{	
		int count=0;
		
		int n=15511;
		
		for(int i=2;i<=n;i++)
		{
			if(isPrime(i))
				count++;
		}
		
		System.out.println(count);
		
		count=0;
		
		int[] record=new int[n+1];
		
		for(int i=0;i<n;i++)
		{
			record[i]=0;
		}
		
		for(int i=2;i*i<n;i++)
		{
			for(int j=i*i;j<n;j=j+i)
			{
				record[j]=-1;
			}
		}
		
		for(int i=2;i<=n;i++)
		{
			if(record[i]==0)
				count++;
		}
		
		System.out.println(count);
		
		
	}
	
	public static boolean isPrime(int n)
	{
		boolean rlt=true;
		
		for(int i=2;i<n;i++)
		{
			if(n%i==0)
				rlt=false;
		}
		
		return rlt;
	}
	
}
