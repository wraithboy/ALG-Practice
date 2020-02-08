import java.net.HttpURLConnection;
import java.net.URL;

public class Test {
    private final Character value='a';

    public String toString(){
        return ""+value;
    }

    public static void main(String args[]){

        try{

            HttpURLConnection connection = (HttpURLConnection) new URL("").openConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
