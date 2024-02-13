import java.io.*;

public class ShellGame {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("shell.in"));
        PrintWriter out = new PrintWriter(new FileOutputStream("shell.out"));
        int swaps = Integer.parseInt(in.readLine());
        int maxPoints = 0;
        String[][] lines = new String[swaps][3];
        for (int initialShellPosition = 1; initialShellPosition<4; initialShellPosition++) {
            int shellPosition = initialShellPosition;
            int points = 0;
            for (int swap = 0; swap < swaps; swap++) {
                String[] line;
                if (lines[swap][0] == null) {
                    line = in.readLine().split(" ");
                    lines[swap] = line;
                }
                else{
                    line = lines[swap];
                }
                int a = Integer.parseInt(line[0]);
                int b = Integer.parseInt(line[1]);
                int g = Integer.parseInt(line[2]);
                if (shellPosition == a) {
                    shellPosition = b;
                }
                else if (shellPosition == b) {
                    shellPosition = a;
                }
                if (shellPosition == g) {
                    points++;
                }
            }
            maxPoints = Math.max(maxPoints, points);
        }
        out.println(maxPoints);
        out.close();
    }
}
