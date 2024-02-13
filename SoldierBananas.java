import java.io.*;

public class SoldierBananas{
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] knw = in.readLine().split(" ");
        int k = Integer.parseInt(knw[0]);
        int n = Integer.parseInt(knw[1]);
        int w = Integer.parseInt(knw[2]);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.println(Math.max((((w*(w+1))/2)*k)-n, 0));
        out.close();
    }
}
