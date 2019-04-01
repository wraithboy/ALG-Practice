package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

public class MeetingRooms {

    public boolean canAttendMeetings(Interval[] intervals) {

        if(intervals.length<=1)
        {
            return true;
        }

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                    return o1.start-o2.start;
            }
        });

        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i].start<intervals[i-1].end)
            {
                return false;
            }

        }

        return true;
    }
}
