package CodingImplementation;


import java.util.*;

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}

public class MergeInternals {

    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> result = new ArrayList<Interval>();

        if(intervals==null || intervals.size()==0)
        {
            return result;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });

        Interval temp = intervals.get(0);

        for(int i=1;i<intervals.size();i++)
        {
             Interval cur=intervals.get(i);

             if(cur.start>temp.end)
             {
                 result.add(temp);
                 temp=cur;
             }
             else
             {
                 temp.end=cur.end>temp.end?cur.end:temp.end;
             }
        }

        result.add(temp);

        return result;

    }
}
