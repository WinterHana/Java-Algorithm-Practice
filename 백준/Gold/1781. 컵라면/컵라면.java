import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Question implements Comparable<Question> {
    int deadLine;
    int cupRamen;

    public Question(int deadLine, int cupRamen) {
        this.deadLine = deadLine;
        this.cupRamen = cupRamen;
    }

    @Override
    public int compareTo(Question o) {
        if(this.deadLine > o.deadLine) {
            return 1;
        } else if(this.deadLine < o.deadLine) {
            return -1;
        } else {
            if(this.cupRamen > o.cupRamen) {
                return -1;
            } else if(this.cupRamen < o.cupRamen) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        // Input data and init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Question> questions = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int cupRamen = Integer.parseInt(st.nextToken());
            questions.add(new Question(deadLine, cupRamen));
        }

        Collections.sort(questions);

        // Input results
        PriorityQueue<Integer> results = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            Question q = questions.get(i);

            if(results.size() < q.deadLine) {
                results.add(q.cupRamen);
            } else {
                if(q.cupRamen > results.peek()) {
                    results.poll();
                    results.add(q.cupRamen);
                }
            }
        }

        // Print result
        long result = 0;
        for(int q : results) {
            result += q;
        }

        System.out.println(result);

    }
}