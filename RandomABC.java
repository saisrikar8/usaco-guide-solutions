import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class RandomABC {
    public static String[] getRandomTestCase(){
        PrintWriter out = new PrintWriter(System.out);
        int a = random(1, 100);
        int b = random(1, 100);
        int c = random(1, 100);
        int[] arr = {a, b, c, a + b, a + c, b + c, a + b + c};
        int[] abc = new int[7];
        for (int num: arr){
            int index;
            do {
                index = random(0, 6);
            }
            while (abc[index] != 0);
            if (abc[index] == 0){
                abc[index] = num;
            }
        }
        out.println(a + " " + b + " " + c);
        out.println(abc[0] + " "+ abc[1] + " "+ abc[2] + " "+ abc[3] + " "+ abc[4] + " "+ abc[5] + " "+ abc[6]);
        out.close();
        return new String[]{a + " " + b + " " + c, abc[0] + " "+ abc[1] + " "+ abc[2] + " "+ abc[3] + " "+ abc[4] + " "+ abc[5] + " "+ abc[6]};
    }
    public static int random(double min, double max){
        return (int)Math.round((Math.random()*max)+min);
    }

}
