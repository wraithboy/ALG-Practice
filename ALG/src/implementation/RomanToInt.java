package implementation;

public class RomanToInt {

    public int romanToInt(String s) {

        int sum=0;

        if(s.indexOf("IV")!=-1) sum=sum-2;
        if(s.indexOf("IX")!=-1) sum=sum-2;
        if(s.indexOf("XL")!=-1) sum=sum-20;
        if(s.indexOf("XC")!=-1) sum=sum-20;
        if(s.indexOf("CD")!=-1) sum=sum-200;
        if(s.indexOf("CM")!=-1) sum=sum-200;

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='I')
            {
                sum=sum+1;
                continue;
            }

            if(s.charAt(i)=='V')
            {
                sum=sum+5;
                continue;
            }

            if(s.charAt(i)=='X')
            {
                sum=sum+10;
                continue;
            }

            if(s.charAt(i)=='L')
            {
                sum=sum+50;
                continue;
            }

            if(s.charAt(i)=='C')
            {
                sum=sum+100;
                continue;
            }

            if(s.charAt(i)=='D')
            {
                sum=sum+500;
                continue;
            }

            if(s.charAt(i)=='M')
            {
                sum=sum+1000;
                continue;
            }
        }

        return sum;
    }

}
