import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Point implements Comparable<Point> {
    int x;
    int y;

    @Override
    public int compareTo(Point p) {
        if(this.y > p.y) return 1;
        else if (this.y < p.y) return -1;
        else {
            if(this.x > p.x) return 1;
            else if (this.x < p.x) return -1;
            else return 0;
        }
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Point> points = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            Point p = new Point();
            p.x = Integer.parseInt(st.nextToken());
            p.y = Integer.parseInt(st.nextToken());
            points.add(p);
        }

        Collections.sort(points);

        for(Point p : points) {
            System.out.println(p);
        }
    }
}