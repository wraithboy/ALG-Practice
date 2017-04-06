package Coding;

public class Sqrt {
	
	public static void main(String args[])
	{
		
		System.out.println(sqrt(8));
		
	}
	
    public static int sqrt(int x) {
        if(x==0)
        return x;
        
        if(x<4)
        return 1;
        
        int low=0;
        int high=x;
        int mid;
        
        while(low<high-1)
        {
            mid=low+(high-low)/2;
            
            if(x/mid==mid)
            return mid;
            else if(x/mid<mid)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        
        return low;
    }
}
