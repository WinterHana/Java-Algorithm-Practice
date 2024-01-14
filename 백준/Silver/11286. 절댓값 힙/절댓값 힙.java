import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);

            if (firstAbs == secondAbs) {
                return (o1 > o2) ? 1 : -1;
            }
            else {
                return firstAbs - secondAbs;
            }
        });

        for (int i = 0; i < N; i++) {
            int request = Integer.parseInt(br.readLine());
            if(request == 0) {
                if (priorityQueue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(priorityQueue.poll());
                }
            } else {
                priorityQueue.add(request);
            }
        }
    }
}