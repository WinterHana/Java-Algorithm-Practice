import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    int column;
    int row;

    public Node(int column, int row) {
        this.column = column;
        this.row = row;
    }
}

public class Main {
    public static int[][] field;
//    public static int[] dColumns = {-1, -1, -1, 0, 0, 1, 1, 1};
//    public static int[] dRows = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static int[] dColumns = {-1, 0, 1, 1};
    public static int[] dRows = {1, 1, 0, 1};

    // 주어진 조건 내 다음 바둑알이 있는지 확인
    public static boolean fiveLineCheck(Node node, int num) {
        int column = node.column;
        int row = node.row;

        for(int i = 0; i < dColumns.length; i++) {
            // 방향 제시
            int dColumn = dColumns[i];
            int dRow = dRows[i];

            // 개수 확인
            int count = 1;

            // 방향에 따른 오목 개수 확인
            for(int j = 1; j < 5; j++) {
                int checkColumn = column + dColumn * j;
                int checkRow = row + dRow * j;
//                System.out.println("checkColumn : " + checkColumn + " checkRow : "+ checkRow);
//                System.out.println("count : " + count);
                if(checkColumn >= 0 && checkColumn < 19 && checkRow >= 0 && checkRow < 19 && field[checkColumn][checkRow] == num) {
                    count++;
                    if(count == 5) {
                        // 육목 확인
                        if(column - dColumn >= 0 && column - dColumn < 19 && row - dRow >= 0 && row - dRow < 19 && field[column - dColumn][row - dRow] == num) {
                            break;
                        }

                        if(column + dColumn * 5 >= 0 && column + dColumn * 5 < 19 && row + dRow * 5 >= 0 && row + dRow * 5 < 19 && field[column + dColumn * 5][row + dRow * 5] == num) {
                            break;
                        }

                        return true;
                    }
                } else {
                    break;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        // Input data
        field = new int[19][19];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 19; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 탐색 후 승부가 정해지면 return
        for(int i = 0; i < 19; i++) {
            for(int j = 0; j < 19; j++) {
                if(field[i][j] > 0) {
                    boolean result = fiveLineCheck(new Node(i, j), field[i][j]);
                    if(result) {
                        System.out.println(field[i][j]);
                        System.out.println((i + 1) + " " + (j + 1));
                        return;
                    }
                }
            }
        }

        // 아직 승부가 정해지지 않음
        System.out.println(0);
    }
}