package array;

import java.util.Arrays;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {

        int[] count=new int[26];

        for(char t: tasks)
        {
            count[t-'A']++;
        }

        Arrays.sort(count);

        int time=0;

        while(count[count.length-1]!=0)
        {
            int i=0, c=0;

            for(int j=0;j<=n;j++)
            {
                if(count[count.length-1]==0)
                    break;
                if(i<26)
                {
                    if(count[25-i]>0) {
                        count[25-i]--;
                    }
                    i++;
                }
                time++;
            }

            Arrays.sort(count);
        }

        return time;
    }
}
