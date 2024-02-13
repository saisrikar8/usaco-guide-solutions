import java.io.*;

public class Teleportation {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("speeding.in"));
        String[] vals = in.readLine().split(" ");
        int a = Integer.parseInt(vals[0]);
        int b = Integer.parseInt(vals[1]);
        int x = Integer.parseInt(vals[2]);
        int y = Integer.parseInt(vals[3]);
        int path1 = Math.abs(a-x) + Math.abs(b - y);
        int path2 = Math.abs(a-y) + Math.abs(b-x);
        int path3 = Math.abs(a-b);
        PrintWriter out = new PrintWriter(new FileOutputStream("speeding.out"));
        out.println(Math.min(Math.min(path1, path2), path3));
        out.close();
    }
}
