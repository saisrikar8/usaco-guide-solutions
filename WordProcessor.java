import java.io.*;

public class WordProcessor {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("word.in"));
        PrintWriter out = new PrintWriter(new FileOutputStream("word.out"));
        int characters = 0;
        int k = Integer.parseInt(in.readLine().split(" ")[1]);
        String[] words = in.readLine().split(" ");
        String essay = "";
        for (int i = 0; i < words.length; i++ ){
            String word = words[i];
            int len = word.length();
            if (characters + len <= k){
                characters += len;
                essay += word + " ";
            }
            else{
                essay = essay.stripTrailing();
                essay += "\n";
                characters = 0;
                i--;
            }
        }
        out.println(essay.stripTrailing());
        out.close();
    }
}
