package CodingImplementation;

public class Reader4 {

    public int read(char[] buf, int n) {

        char[] buffer = new char[4];

        boolean eof = false;

        int count=0;

        while(count<n && !eof)
        {
            int k=read4(buffer);

            if(k<4)
            {
                eof=true;
            }

            if(count+k>n)
            {
                k=n-count;
            }

            for(int i=0;i<k;i++)
            {
                buf[count]=buffer[i];
                count++;
            }
        }

        return count;

    }

    int read4(char[] buf){
        return 0;
    };
}
