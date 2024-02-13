import java.io.*;

public class Promotions {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("promote.in"));
        PrintWriter out = new PrintWriter(new FileOutputStream("promote.out"));
        String[] bronze = in.readLine().split(" ");
        String[] silver = in.readLine().split(" ");
        String[] gold = in.readLine().split(" ");
        String[] platinum = in.readLine().split(" ");
        int platinumChange = Integer.parseInt(platinum[1]) - Integer.parseInt(platinum[0]);
        int goldChange = Integer.parseInt(gold[1]) - Integer.parseInt(gold[0]) + platinumChange;
        int silverChange = Integer.parseInt(silver[1]) - Integer.parseInt(silver[0]) + goldChange;
        out.println(silverChange);
        out.println(goldChange);
        out.println(platinumChange);
        out.close();
    }
}
