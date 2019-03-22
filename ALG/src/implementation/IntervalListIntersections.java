package implementation;

import java.util.ArrayList;

public class IntervalListIntersections {

    class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }

    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {

        ArrayList<Interval> result =new ArrayList<>();

        if(A==null || B==null || A.length==0 || B.length==0)
            return (Interval[])result.toArray();

        int i=0,j=0;

        while(i<A.length && j<B.length)
        {
            Interval a=A[i];
            Interval b=B[j];

            int start=Math.max(a.start,b.start);
            int end=Math.min(a.end,b.end);

            if(start<=end)
            {
                result.add(new Interval(start,end));
            }

            if(a.end<b.end)
            {
                i++;
            }
            else
            {
                j++;
            }
        }

        return result.toArray(new Interval[result.size()]);
    }
}
