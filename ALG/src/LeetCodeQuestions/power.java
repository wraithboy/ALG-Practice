package LeetCodeQuestions;

public class power {
	
	public static void main(String args[])
	{
		
		double r=pow(1.00000,-2147483648);
	}
	
    public static double pow(double x, int n) {
        
        if(n<0)
        {
            System.out.println(-n);
            return 1.0/power(x,-n);
            
        }
        else
        {
            return power(x,n);
        }
        
    }
    
    private static double power(double x, int n)
    {
        System.out.println(n);
        if(n==0)
        return 1;
        else if(n==1)
        return x;
        else if ( n>= 2)
        {
            double rlt=power(x,n/2);
            if(n%2==0)
            {
                return rlt*rlt;
            }
            else
            {
                return rlt*rlt*x;
            }
        }
        
        System.out.println(n);
        return -535;
    }
}
