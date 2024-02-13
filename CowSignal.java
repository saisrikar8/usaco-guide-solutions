import java.io.*;

public class CowSignal {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("cowsignal.in"));
        PrintWriter out = new PrintWriter(new FileOutputStream("cowsignal.out"));
        String[] mnk = in.readLine().split(" ");
        final int M = Integer.parseInt(mnk[0]);
        final int N = Integer.parseInt(mnk[1]);
        final int K = Integer.parseInt(mnk[2]);
        String signal = "";
        for (int i = 0; i < M; i++){
            signal += in.readLine();
        }
        out.println(multiplyLines(breakLines(signal.replaceAll("X", multiplyString("X", K)).replaceAll("\\.", multiplyString(".", K)), K*N), K));
        out.close();
    }
    public static String multiplyString(String str, int factor){
        String retStr = "";
        for (int i =0; i < factor; i++){
            retStr += str;
        }
        return retStr;
    }
    public static String breakLines(String str, int lineLength){
        String retStr = "";
        for (int i = 1; i < str.length() + 1; i++){
            if (i % lineLength == 0){
                retStr += str.charAt(i - 1) + "\n";
            }
            else{
                retStr += str.charAt(i - 1);
            }
        }
        return retStr;
    }
    public static String multiplyLines(String str, int factor){
        String[] lines = str.split("\n");
        String retStr = "";
        for (String line: lines){
            for (int i = 0; i < factor; i++){
                retStr += line + "\n";
            }
        }
        return retStr.stripTrailing();
    }
}
