import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Team {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int problems = Integer.parseInt(in.readLine());
        int implementations = 0;
        String[][] votes = new String[problems][3];
        for (int i = 0; i < problems; i++){
            votes[i] = in.readLine().split(" ");
        }
        for (String[] vote: votes){
            implementations += Math.round(((double)(Integer.parseInt(vote[0]) + Integer.parseInt(vote[1]) +Integer.parseInt(vote[2])))/3.0);
        }
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.println(implementations);
        out.close();
    }
}
