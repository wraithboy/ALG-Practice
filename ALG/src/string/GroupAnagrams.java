package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        HashMap<String,List<String>> map = new HashMap<>();


        for(String str:strs)
        {
            char[] chars=str.toCharArray();
            Arrays.sort(chars);

            String sorted=String.valueOf(chars);

            if(map.containsKey(sorted))
            {
                map.get(sorted).add(str);
            }
            else
            {
                List<String> list =new ArrayList<>();
                list.add(str);
                map.put(sorted,list);
            }
        }

        for(String key:map.keySet())
        {
            result.add(map.get(key));
        }

        return result;
    }
}
