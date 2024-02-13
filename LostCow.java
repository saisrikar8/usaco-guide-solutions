import java.io.*;

public class LostCow {
    public static void main(String[] args) throws IOException {
        boolean wrongAnswer = false;
        for (int i = 1; i < 11; i++){
            BufferedReader solutionFile = new BufferedReader(new FileReader("./lostcowtestcases/"+ i + ".out"));
            int startTime = (int)System.currentTimeMillis();
            int distanceTraveled = getDistanceTraveled(i);
            int endTime = (int)System.currentTimeMillis();
            int elapsedTime = endTime - startTime;
            if (Integer.parseInt(solutionFile.readLine()) == distanceTraveled && elapsedTime <= 4000){
                System.out.println("Testcase " + i + " passed" + " in " + elapsedTime + " ms.");
            }
            else if (elapsedTime > 4000){
                System.out.println("Testcase" + i + "experienced a timeout error. Your code took " + elapsedTime + " ms.");
                wrongAnswer = true;
            }
            else{
                System.out.println("Testcase " + i + " was given a wrong answer.");
                wrongAnswer = true;
            }
        }
        if (!wrongAnswer){
            System.out.println("All testcases passed!");
        }
        else{
            System.out.println("There is probably a bug in your code...");
        }
    }
    public static int getDistanceTraveled(int testcase) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("./lostcowtestcases/"+testcase + ".in"));
        PrintWriter out = new PrintWriter(new FileOutputStream("lostcow.out"));
        String[] input = in.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int power = (int)Math.ceil(Math.log(Math.abs(x - y)) / Math.log(2));
        int anticipatedFarmerPosition;
        if (power % 2 == 0){
            if (x > y){
                power += 1;
                anticipatedFarmerPosition = x - (int)Math.pow(2, power);
            }
            else{
                anticipatedFarmerPosition = (int)Math.pow(2, power) + x;
            }
        }
        else {
            if (x < y) {
                power += 1;
                anticipatedFarmerPosition = (int)Math.pow(2, power) + x;
            }
            else{
                anticipatedFarmerPosition = x - (int)Math.pow(2, power);
            }
        }
        int distanceTraveled = (int)(sumOfDistances(power - 1) + Math.pow(2, power) - Math.abs(y - anticipatedFarmerPosition));
        //out.println(distanceTraveled);
        out.close();
        return distanceTraveled;
    }
    public static int sumOfDistances(int power){
        if (power == 0){
            return 2;
        }
        return (int)Math.pow(2, power + 1) + sumOfDistances(power - 1);
    }
}
