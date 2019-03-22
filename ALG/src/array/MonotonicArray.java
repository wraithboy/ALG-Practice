package array;

public class MonotonicArray {
    public boolean isMonotonic(int[] A) {

        if(A==null || A.length==0)
            return false;

        boolean resultIncrease = true;
        boolean resultDecrease = true;

        for(int i=0;i<A.length-1;i++)
        {
            if(A[i]>A[i+1])
                resultDecrease=false;

            if(A[i]<A[i+1])
                resultIncrease=false;
        }


        return resultDecrease||resultIncrease;
    }
}
