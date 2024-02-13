import java.io.*;

public class MixingMilk {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter out = new PrintWriter(new FileOutputStream("mixmilk.out"));
        String[] bucket1 = in.readLine().split(" ");
        String[] bucket2 = in.readLine().split(" ");
        String[] bucket3 = in.readLine().split(" ");
        int c1 = Integer.parseInt(bucket1[0]);
        int c2 = Integer.parseInt(bucket2[0]);
        int c3 = Integer.parseInt(bucket3[0]);
        int m1 = Integer.parseInt(bucket1[1]);
        int m2 = Integer.parseInt(bucket2[1]);
        int m3 = Integer.parseInt(bucket3[1]);
        for (int i = 0; i < 100; i++){
            if (i % 3 == 0){
                int newVal = Math.min(m2 + m1, c2);
                m1 -= newVal - m2;
                m2 = newVal;
            }
            else if (i%3 == 1){
                int newVal = Math.min(m2 + m3, c3);
                m2 -= newVal - m3;
                m3 = newVal;
            }
            else{
                int newVal = Math.min(m3 + m1, c1);
                m3 -= newVal - m1;
                m1 = newVal;
            }
        }
        out.println(m1);
        out.println(m2);
        out.println(m3);
        out.close();
    }
}
