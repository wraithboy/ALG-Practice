package LeetCodeQuestions;

//Divide two integers without using multiplication, division and mod operator.
//
//If it is overflow, return MAX_INT.


public class DivideTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
				
		
		
//		byte a=65;
//		
//		
//		byte b= -1;
//		System.out.println((int)(char)b);
//		System.out.println((int)(char)(b & 0xff));
//		
//		System.out.println(b);
		
		System.out.println(divide(2147483647,1));
		
//		System.out.println((byte)128);
		
	}
	
	public static int divide(int dividend, int divisor) {
        
        int i=0,j=0;
		
		boolean isNeg=false;
		
		if(divisor==0)
		{
			return Integer.MAX_VALUE;
		}
		
		if(divisor==1)
		{
		    return dividend;
		}
		
		if(dividend==Integer.MIN_VALUE)
		{
			dividend=dividend+Math.abs(divisor);
			
			if(divisor==-1)
			{
				return Integer.MAX_VALUE;
			}
			
			j++;
		}
		
		if(divisor==Integer.MIN_VALUE)
		{
			return j;
		}
		
		if(dividend>=0 && divisor<0 || dividend<0 && divisor>0)
		{
			isNeg=true;
		}
		
		dividend=Math.abs(dividend);
		divisor=Math.abs(divisor);
		
		while((divisor<<1)<=dividend)
		{
			divisor=divisor<<1;
			i++;
		}
		
		while(i>=0)
		{
			if(dividend>=divisor)
			{
				dividend=dividend-divisor;				
				j=j+(1<<i);
			}
			
			divisor=divisor>>1;
			i--;
		}
		
		return isNeg?-j:j;
	    
	}
	
}
