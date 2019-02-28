package CodingImplementation;

import java.util.ArrayList;
import java.util.List;


class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class InsertIntervals {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();

        for(Interval i: intervals)
        {
            if(newInterval==null || i.end<newInterval.start)
            {
                result.add(i);
            }
            else if(i.start>newInterval.end)
            {
                result.add(newInterval);
            }
            else
            {
                newInterval.start=i.start>newInterval.start?i.start:newInterval.start;
                newInterval.end=i.end>newInterval.end?i.end:newInterval.end;
            }
        }
        return result;
    }
}
