package string;

public class StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {

        if(num==null)
            return false;

        int[] map = new int[10];

        map[0]=0;
        map[1]=1;
        map[6]=9;
        map[9]=6;
        map[8]=8;

        int i=0,j=num.length()-1;

        while(i<=j)
        {
            if(map[num.charAt(i)-'0']==num.charAt(j)-'0')
            {
                i++;
                j--;
                continue;
            }

            else
                return false;
        }

        return true;
    }
}
