package implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubdomainVisitCount {

    public List<String> subdomainVisits(String[] cpdomains) {

        List<String> result = new ArrayList<String>();

        HashMap<String,Integer> map = new HashMap<>();

        for(String s : cpdomains)
        {
            String[] str=s.split(" ");
            int count=Integer.valueOf(str[0]);

            String[] frags= str[1].split("\\.");

            String cur="";
            for(int i=frags.length-1;i>=0;i--)
            {
                cur= frags[i]+(i<frags.length-1?".":"")+cur;

                if(map.containsKey(cur))
                {
                    map.put(cur,map.get(cur)+count);
                }
                else
                {
                    map.put(cur,count);
                }
            }
        }

        for(String key : map.keySet())
        {
            result.add(map.get(key)+" "+key);
        }

        return result;
    }
}
