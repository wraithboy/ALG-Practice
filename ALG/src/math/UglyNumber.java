package math;

public class UglyNumber {
	
	
    public boolean isUgly(int num) {
        // write your code here
    	if(num==1)
    		return true;
    	
    	if(num<2)
    	return false;
    	
    	if(num==2 || num==3 || num==5)
    		return true;
    	
    	boolean r2=false,r3=false,r5=false;
    	
    	if(num%2==0)
    	{
    		r2=isUgly(num/2);
    	}
    	
    	if(num%3==0)
    	{
    		r3=isUgly(num/3);
    	}
    	
    	if(num%5==0)
    	{
    		r5=isUgly(num/5);
    	}
    	
    	return (r2 || r3 || r5) ;
    }
	
    
    public boolean isUgly2(int num) {
    	
    	if(num==1)
    		return true;
    	
    	if(num<2)
    		return false;
    	
    	int[] primes = {2,3,5};
    	
    	int x=num;
    	
    	for(int i=0;i<primes.length;i++)
    	{
    		while(x%primes[i]==0)
    		{
    			x=x/primes[i];
    		}
    	}
    	
    	return x==1;
    }
}
