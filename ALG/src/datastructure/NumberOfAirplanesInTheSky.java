package datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

class Interval {
     int start, end;
     Interval(int start, int end) {
         this.start = start;
         this.end = end;
     }
}

class Point {
	
	int time;
	int value;
	
	Point(int time, int value)
	{
		this.time=time;
		this.value=value;
	}
}

public class NumberOfAirplanesInTheSky {
	
	@SuppressWarnings("unchecked")
	public int countOfAirplanes2(List<Interval> airplanes){
		
		int max = 0;
		
		if(airplanes==null || airplanes.size()==0)
		{
			return 0;
		}
		
		
		List<Point> list= new ArrayList<Point>();
		
		
		for(Interval flight: airplanes )
		{
			
			list.add(new Point(flight.start,1));
			list.add(new Point(flight.end,-1));			
		}
		
		Collections.sort(list,new Comparator<Point>(){

			public int compare(Point p1, Point p2) {
				// TODO Auto-generated method stub
				if(p1.time==p2.time)
				{
					return p1.value-p2.value;
				}
				else
				{
					return p1.time-p2.time;
				}
			}
		});
		
		int sum=0;
		
		for(Point p: list)
		{
			sum=sum+p.value;
			max=Math.max(sum, max);
		}
		
		
		
		return max;
		
	}
	
	
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
    	
    	if(airplanes==null || airplanes.size()==0)
    	return 0;
    	
    	int max=0;
    	
    	Hashtable<Integer,Integer> map=new Hashtable<>();
    	    	
    	for(Interval i: airplanes)
    	{
    		for(int j=i.start;j<i.end;j++)
    		{
    			if(map.containsKey(j))
    			{
    				int count=map.get(j);
    				count++;
    				map.put(j, count);
    			}
    			else
    			{
    				map.put(j, 1);
    			}
    			
    			max=Math.max(max, map.get(j));
    		}
    	}
    	
    	return max;
    }
	
}
