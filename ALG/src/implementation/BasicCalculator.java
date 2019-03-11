package implementation;

import java.util.Stack;

public class BasicCalculator {
	
	public static void main(String args[])
	{	
		System.out.print(calculate("11+30+(2+5)"));
		
	}
	
	
	    public static int calculate(String s) {
	        int result=0;
			int sum=0;
			int sign=1;
			Stack<Integer> stack= new Stack<Integer>();
			
			for(int i=0;i<s.length();i++)
			{	
				char c=s.charAt(i);
				if(c>='0' && c<='9')
				{
				    sum=10*sum+c-'0';
				}
				else if(c=='+')
				{
					result=result+sum*sign;
				    sum=0;
					sign=1;
				}
				else if(c=='-')
				{
					result=result+sum*sign;
	                sum=0;
					sign=-1;
				}
				else if(c=='(')
				{
					stack.push(result);
					stack.push(sign);
					sign=1;
					result=0;
				}
				else if(c==')')
				{
					result=result+sum*sign;
				    int prev_sign=stack.pop();
				    int prev_num=stack.pop();
				    
				    result=result*prev_sign+prev_num;
				    sum=0;
				}
			}
		
	        result=sum+result*sign;
			
			return result;
	    }
	}
