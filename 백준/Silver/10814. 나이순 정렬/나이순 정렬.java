import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Member {
    int age;
    String name;
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(sb.readLine());

        List<Member> members = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(sb.readLine());
            Member m = new Member();
            m.age = Integer.parseInt(st.nextToken());
            m.name = st.nextToken();

            members.add(m);
        }

        members.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o1.age - o2.age;
            }
        });

        for(Member m : members) {
            System.out.println(m.age + " " + m.name);
        }
    }
}