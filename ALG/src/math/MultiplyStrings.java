package math;

import java.util.ArrayList;
import java.util.LinkedList;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {

        int n1=num1.length();
        int n2=num2.length();

        int[] result = new int[n1+n2];

        for(int i=n1-1;i>=0;i++)
        {
            for(int j=n2-1;j>=0;j++)
            {
                int product = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');

                int lowPos= i+j+1;
                int highPos= i+j;

                product=result[lowPos]+product;

                result[lowPos]=product%10;
                result[highPos]=result[highPos]+product/10;
            }
        }

        StringBuilder tlt = new StringBuilder();

        for(int i=0;i<result.length;i++)
        {
            if(result[i]==0 || tlt.length()==0)
            {
                continue;
            }

            tlt.append(result[i]);
        }

        if(num1.equals("0") || num2.equals("0"))
        return "0";

        LinkedList<Integer> l = new ArrayList<>();
        l.getLast()
        return tlt.toString();
    }
}
