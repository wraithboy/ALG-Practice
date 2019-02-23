package DivideAndConquer;

public class Sqrt {
    public int mySqrt(int x) {
        if(x<2)
            return x;

        int l=0,r=x;

        while(l<=r)
        {
            int mid = l + (l-r)/2;

            if(x/mid==mid)
            {
                return mid;
            }
            else if(x/mid>mid)
            {
                l=mid+1;
            }
            else
            {
                r=mid-1;
            }

        }
        return r;
    }
}
