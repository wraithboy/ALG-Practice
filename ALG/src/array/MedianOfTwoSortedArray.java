package array;

public class MedianOfTwoSortedArray {
	
	public static void main(String args[])
	{
		
	}

    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        
    	if(A.length> B.length)
    	{
    		return findMedianSortedArrays(B,A);
    	}
    	
        if (A.length == 0)
            return ((double) B[(B.length - 1) / 2] + (double) B[B.length / 2]) / 2;
    	
    	int low=0;
    	int high=A.length;
    	
    	while ( low <= high )
    	{
    		
    		int cutA=(low+high)/2;
    		
    		int cutB=(A.length+B.length+1)/2 - cutA;
    		
    		int maxLeftA=(cutA==0)?Integer.MIN_VALUE:A[cutA-1];
    		int minRightA=(cutA==A.length)?Integer.MAX_VALUE: A[cutA];
    		
    		int maxLeftB=(cutB==0)?Integer.MIN_VALUE:B[cutB-1];
    		int minRightB=(cutB==B.length)?Integer.MAX_VALUE:B[cutB];
    		
    		if(maxLeftA<minRightB && maxLeftB<minRightA)
    		{
    			
    			if((A.length+B.length)%2==0)
    				return (double)(Math.max(maxLeftA,maxLeftB)+Math.min(minRightA,minRightB))/2;
    			else
    			{
    				return (double)(Math.max(A[cutA-1], B[cutB-1]));
    			}
    		}
    		else if(maxLeftA>minRightB )
    		{
    			high=cutA-1;
    		}
    		else
    		{
    			low=cutA+1;
    		}
    		
    	}
    	 throw new IllegalArgumentException();
    }
    
    
    
}
