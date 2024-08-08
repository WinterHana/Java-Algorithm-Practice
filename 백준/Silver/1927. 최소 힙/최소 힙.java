import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<Integer>();
        heap.add(0);
    }

    public void insert(int num) {
        heap.add(num);
        int p = heap.size() - 1;

        while(p > 1 && heap.get(p) < heap.get(p / 2)) {
            int tmp = heap.get(p / 2);
            heap.set(p / 2, num);
            heap.set(p, tmp);

            p /= 2;
        }
    }

    public int delete() {
        if(heap.size() - 1 < 1) return 0;

        int deleteItem = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int pos = 1;
        while((pos * 2) < heap.size()) {
            int min = heap.get(pos * 2);
            int minPos = pos * 2;

            if(((pos * 2 + 1) < heap.size()) && heap.get(pos * 2 + 1) < min) {
                min = heap.get(pos * 2 + 1);
                minPos = pos * 2 + 1;
            }

            if(heap.get(pos) < min) break;

            int tmp = heap.get(pos);
            heap.set(pos, heap.get(minPos));
            heap.set(minPos, tmp);
            pos = minPos;
        }

        return deleteItem;
    }
}

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        MinHeap heap = new MinHeap();

        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if(number == 0) System.out.println(heap.delete());
            else if(number > 0) heap.insert(number);
        }
    }
}