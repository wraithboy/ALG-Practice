package string;

public class SentenceScreenFitting {

    public int wordsTyping(String[] sentence, int rows, int cols) {

        StringBuilder sb = new StringBuilder();

        for(String s:sentence)
        {
            sb.append(s);
            sb.append(" ");
        }

        String str=sb.toString();

        int l=str.length();

        int pos=0;

        for(int i=0;i<rows;i++)
        {
            pos=pos+cols;

            if(str.charAt(pos%l)==' ')
            {
                pos++;
            }
            else
            {
                while(pos>0 && str.charAt((pos-1)%l)!=' ')
                {
                    pos--;
                }
            }
        }

        return pos/l;
    }
}
