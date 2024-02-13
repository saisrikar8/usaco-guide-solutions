import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ABC {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int[] sums = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(sums);
        int a = sums[0];
        int b = sums[1];
        int c = sums[6] - b - a;
        out.println(a + " " + b + " " + c);
        out.close();
    }
}
