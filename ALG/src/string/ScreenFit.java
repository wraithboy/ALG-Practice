package string;

import java.util.ArrayList;
import java.util.List;

public class ScreenFit {

    public static void main(String args[])
    {
        int maxL=8;

        List<String> result = new ArrayList<>();

        String str="An apple a day keeps doctors away";

        int index=0;
        int prev=0;

        while(prev+maxL<str.length())
        {
            index=prev+maxL;

            if(str.charAt(index)==' ')
            {
                result.add(str.substring(prev,index));
            }
            else
            {
                while(str.charAt(index)!=' ')
                {
                    index=index-1;
                }
                result.add(str.substring(prev,index));
            }

            prev=index+1;
        }

        result.add(str.substring(prev));

        for(String s: result)
        {
            System.out.println(s);
        }


    }
}
