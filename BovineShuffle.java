import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BovineShuffle {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter out = new PrintWriter(new FileOutputStream("shuffle.out"));
        final int N = Integer.parseInt(in.readLine());
        String[] line1 = in.readLine().split(" ");
        String[] positions = in.readLine().split(" ");
        Map<Integer, Integer> targetPositions = new HashMap<Integer, Integer>();
        for (int i = 0; i < N; i++){
            targetPositions.put(Integer.parseInt(line1[i]), i+1);
        }
        for (int j = 0; j < 3; j++){
            String[] newPositions = new String[N];
            for (int x = 0; x < N; x++){
                newPositions[targetPositions.get(x+1)-1] = positions[x];
            }
            positions = newPositions.clone();
        }
        for (String position:positions){
            out.println(position);
        }
        out.close();
    }
}
