import java.io.*;
import java.util.ArrayList;

public class SpeedingTicket {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter out = new PrintWriter(new FileOutputStream("speeding.out"));
        String[] nm = in.readLine().split(" ");
        final int N = Integer.parseInt(nm[0]);
        final int M = Integer.parseInt(nm[1]);
        int startPos = 1;
        ArrayList<SpeedSegment> segments = new ArrayList<SpeedSegment>();
        for (int i = 0; i < N; i++){
            String[] line = in.readLine().split(" ");
            SpeedSegment segment = new SpeedSegment(startPos, startPos + Integer.parseInt(line[0]) - 1, Integer.parseInt(line[1]));
            segments.add(segment);
            startPos = segment.endPos + 1;
        }
        Road road = new Road(segments);
        ArrayList<SpeedSegment> tractorPath = new ArrayList<>();
        startPos = 1;
        for (int j = 0; j < M; j++){
            String[] line = in.readLine().split(" ");
            SpeedSegment segment = new SpeedSegment(startPos, startPos + Integer.parseInt(line[0]) - 1, Integer.parseInt(line[1]));
            tractorPath.add(segment);
            startPos = segment.endPos + 1;
        }
        TractorPath path = new TractorPath(tractorPath, road);
        int maxInfraction = 0;
        for (int x = 1; x <= 100; x++){
            int infraction = path.getSpeedInfraction(x);
            if (infraction > maxInfraction){
                maxInfraction = infraction;
            }
        }
        out.println(maxInfraction);
        out.close();
    }
}

class SpeedSegment{
    int startPos;
    int endPos;
    int speedLimit;
    public SpeedSegment(int start, int end, int speedLimit){
        this.startPos = start;
        this.endPos = end;
        this.speedLimit = speedLimit;
    }
    public boolean positionInRange(int position){
        return position > this.startPos && position < this.endPos;
    }
    public boolean speedUnderLimit(int speed){
        return speed < this.speedLimit;
    }
    public static int compare(SpeedSegment e1, SpeedSegment e2){
        return e1.startPos - e2.startPos;
    }
}
class Road{
    ArrayList<SpeedSegment> segments;
    public Road(ArrayList<SpeedSegment> segments){
        this.segments = segments;
        this.segments.sort(SpeedSegment::compare);
    }
    public int getSpeedLimit(int position){
        for (SpeedSegment segment: this.segments){
            if (segment.endPos >= position){
                return segment.speedLimit;
            }
        }
        return -1;
    }
    public boolean isUnderSpeedLimit(int position, int speed){
        return getSpeedLimit(position) > speed;
    }
}

class TractorPath{
    ArrayList<SpeedSegment> segments;
    Road road;
    public TractorPath(ArrayList<SpeedSegment> segments, Road road){
        this.segments = segments;
        this.segments.sort(SpeedSegment::compare);
        this.road = road;
    }
    public int getSpeed(int position){
        for (SpeedSegment segment: this.segments){
            if (segment.endPos >= position){
                return segment.speedLimit;
            }
        }
        return -1;
    }
    public int getSpeedInfraction(int position){
        return this.getSpeed(position) - road.getSpeedLimit(position);
    }
}