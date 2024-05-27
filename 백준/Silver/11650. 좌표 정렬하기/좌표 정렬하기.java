import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Point implements Comparable {
    int x; int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Object o) {
        Point compare = (Point) o;
        if(this.x != compare.x) {
            return (this.x - compare.x);
        } else {
            return (this.y - compare.y);
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
        Point[] arr = new Point[N];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            int x = Integer.parseInt(line.split(" ")[0]);
            int y = Integer.parseInt(line.split(" ")[1]);
            arr[i] = new Point(x, y);
        }


        Arrays.stream(arr).sorted().forEach(System.out::println);
    }
}