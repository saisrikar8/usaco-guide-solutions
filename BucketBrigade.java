import java.io.*;

public class BucketBrigade {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("buckets.in"));
        PrintWriter out = new PrintWriter(new FileOutputStream("buckets.out"));
        int[] lake = new int[2];
        int[] barn = new int[2];
        int[] rock = new int[2];
        for (int i = 0; i < 10; i++){
            String strline = in.readLine();
            String[] line = strline.split("");
            int lakeY = strline.indexOf("L");
            int barnY = strline.indexOf("B");
            int rockY = strline.indexOf("R");
            if (lakeY != -1){
                lake = new int[]{i, lakeY};
            }
            if (barnY != -1){
                barn = new int[]{i, barnY};
            }
            if (rockY != -1){
                rock = new int[]{i, rockY};
            }
        }
        if ((barn[0] == lake[0] && lake[0] == rock[0] && ((rock[1] < barn[1]) && (rock[1] > lake[1])||(rock[1] > barn[1]) && (rock[1] < lake[1])))||(barn[1] == lake[1] && lake[1] == rock[1] && ((rock[0] < barn[0]) && (rock[0] > lake[0])||(rock[0] > barn[0]) && (rock[0] < lake[0])))) {
            out.println(Math.abs(barn[0] - lake[0]) + Math.abs(barn[1] - lake[1]) + 1);
        }
        else {
            out.println(Math.abs(barn[0] - lake[0]) + Math.abs(barn[1] - lake[1]) - 1);
        }
        out.close();
    }
}
