package math;

public class DivdeTwoIntegers {

    public int divide(int dividend, int divisor) {

        int sign=1;

        if(dividend==Integer.MIN_VALUE && divisor==-1)
        {
            return Integer.MAX_VALUE;
        }

        long div = (long)dividend;
        long dsor= (long)divisor;

        if(div<0)
        {
            sign=-sign;
            div=Math.abs(div);
        }

        if(dsor<0)
        {
            sign=-sign;
            dsor=Math.abs(dsor);
        }

        int result=0;

        while(div>=dsor)
        {
            int shift=0;

            while(div>dsor<<shift)
            {
                shift++;
            }

            result=result+(1<<(shift-1));

            div=div-(dsor<<(shift-1));

        }


        return result;
    }
}
