import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Person implements Comparable {
    int weight;
    int height;


    @Override
    public int compareTo(Object o) {
        Person h = (Person) o;
        int compareWeight = this.weight - h.weight;
        int compareHeight = this.height - h.height;

        if(compareWeight > 0 && compareHeight > 0) return 1;
        else if (compareWeight == 0 && compareHeight == 0) return 0;
        else return -1;
    }

    @Override
    public String toString() {
        return weight + " " + height;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Person> people = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            Person p = new Person();
            p.weight = Integer.parseInt(st.nextToken());
            p.height = Integer.parseInt(st.nextToken());
            people.add(p);
        }
        
        for(int i = 0; i < N; i++) {
            int k = 1;
            for(int j = 0; j < N; j++) {
                if(people.get(j).compareTo(people.get(i)) > 0) k++;
            }
            System.out.print(k + " ");
        }
    }
}