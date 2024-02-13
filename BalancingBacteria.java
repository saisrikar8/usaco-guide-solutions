import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BalancingBacteria {
    static int min;
    public static int minSprays(long N, long[] A) {
        int totalSprays = 0;
        for (long L = -N; L < N; L++){
            long[] A_clone = A.clone();
            for (int i = 0; i < A_clone.length; i++){
                A_clone[i] += L - (A_clone.length - i);
            }
            totalSprays++;
            if (Arrays.stream(A_clone).allMatch(e->e==0)){
                return totalSprays;
            }
            int removeTotalSprays = minSprays(-N, A_clone);
            if (min > removeTotalSprays + totalSprays){
                min = removeTotalSprays + totalSprays;
                return min;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(reader.readLine());
        long[] A = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        int min = (int)N;
        System.out.println(minSprays(N, A));
    }
}