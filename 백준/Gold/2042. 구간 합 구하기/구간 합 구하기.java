import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static long[] segTree;

    // 세그먼트 트리 초기화
    // (마지막 인덱스) = (트리의 크기) - 1
    public static void initTree(int lastIndex) {
        while (lastIndex != 1) {
            segTree[lastIndex / 2] += segTree[lastIndex];
            lastIndex--;
        }
    }

    // 변경된 값에 대한 업데이트 진행
    public static void updateTree(int index, long num, int startIndex) {
        index = index + startIndex - 1;
        long diff = num - segTree[index];
        while(index > 0) {
            segTree[index] = segTree[index] + diff;
            index = index /  2;
        }
    }

    // 구간에 대한 합 구하기
    public static long getSum(int start, int end, int startIndex) {
        long sum = 0;
        start = start + startIndex - 1;
        end = end + startIndex - 1;
        while(start <= end) {
            if(start % 2 == 1) {
                sum += segTree[start];
            }

            if(end % 2 == 0) {
                sum += segTree[end];
            }

            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }

        return sum;
    }

    // 세그먼트 트리 출력
    public static void printSegTree() {
        for(int i = 0; i < segTree.length; i++) {
            System.out.print(segTree[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        // 1. 첫번째 줄의 값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 2. treeSize, startIndex 구하기
        int treeHeight = 0;
        int length = N;
        while(length != 0) {
            length /= 2;
            treeHeight++;
        }
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int startIndex = treeSize / 2;
        segTree = new long[treeSize + 1];

        // 3. 데이터 입력 및 세그먼트 트리 초기화
        for(int i = startIndex; i < startIndex + N; i++) {
            segTree[i] = Long.parseLong(br.readLine()); 
        }
        initTree(treeSize - 1);
        // printSegTree();

        // 4. a 값을 입력받음에 따라 분기하기
        for(int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()); 
            long c = Long.parseLong(st.nextToken());

            if(a == 1) {
                updateTree(b, c, startIndex);
                // printSegTree();
            } else if(a == 2) {
                System.out.println(getSum(b, (int) c, startIndex));
            }
        }
    }
}
