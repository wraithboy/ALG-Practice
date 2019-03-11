package implementation;

public class Flatten2DVector {

    int[][] v;
    int col,row;

    public Flatten2DVector(int[][] v) {
        this.v=v;
        col=0;
        row=0;
    }

    public int next() {
        if(hasNext())
        {
            int res=v[col][row];
            col++;
            return res;
        }
        else
        {
            return -1;
        }
    }

    public boolean hasNext() {

        if(row>=v.length) return false;

        if(col>=v[row].length)
        {
            row++;
            col=0;
            return hasNext();
        }
        return true;
    }
}
