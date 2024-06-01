import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] lineSplit = line.split(" ");
        int A = Integer.parseInt(lineSplit[0]);
        int B = Integer.parseInt(lineSplit[1]);
        int V = Integer.parseInt(lineSplit[2]);
        double tmp = ((double)(V - A) / (double)(A - B)) + 1.0;

        int day = (int) Math.ceil(tmp);

        System.out.println(day);
     }
}