package array;

import java.util.Arrays;

public class MeetingRoomII {

    public int minMeetingRooms(Interval[] intervals) {

        if(intervals==null || intervals.length==0)
            return 0;

        int[] start=new int[intervals.length];
        int[] end = new int[intervals.length];

        for(int i=0;i<intervals.length;i++)
        {
            start[i]=intervals[i].start;
            end[i]=intervals[i].end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int count=0;
        int i=0,j=0;
        while(i<start.length)
        {
            if(start[i]>=end[j])
            {
                count--;
                j++;
            }

            count++;
            i++;
        }

        return count;
    }

}
