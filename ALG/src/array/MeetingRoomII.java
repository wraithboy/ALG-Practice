package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomII {


    public int minMeetingRooms2(Interval[] intervals)
    {

        if(intervals==null || intervals.length==0)
        {
            return 0;
        }

        PriorityQueue<Interval> heap = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end-o2.end;
            }
        });

        Arrays.sort(intervals,new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });

        heap.add(intervals[0]);

        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i].start>=heap.peek().end)
            {
                heap.poll();
            }

            heap.add(intervals[i]);
        }

        return heap.size();
    }


    public int minMeetingRooms1(Interval[] intervals) {

        int[] in = new int[intervals.length];
        int[] out = new int[intervals.length];

        for(int i=0;i<intervals.length;i++)
        {
            in[i]=intervals[i].start;
            out[i]=intervals[i].end;
        }

        Arrays.sort(in);
        Arrays.sort(out);

        int count=0;
        int max=0;
        int i=0,j=0;

        while(i<in.length)
        {
            if(in[i]<out[j])
            {
                count++;
                i++;
            }
            else if(in[i]>out[j])
            {
                count--;
                j++;
            }
            else
            {
                i++;
                j++;
            }

            max=Math.max(count,max);
        }

        return max;
    }


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
