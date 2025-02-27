/**
 * 사과 : 12, 12, 12 500g / 포장 1000g
 * 3개에 12000원
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


class Box {
    String T;
    int W;
    int H;
    int L;
    int apples;

    public Box(String T, int W, int H, int L) {
        this.T = T;
        this.W = W;
        this.H = H;
        this.L = L;
    }
    
    public int calBoxWeight() {
        if(T.equals("B")) {
            return 120 * 50;
        } else {
            return 1000 + appleCount() * 500;
        }
    }

    public int appleCount() {
        int wCount = this.W / 12;
        int hCount = this.H / 12;
        int lCount = this.L / 12;

        return this.apples = wCount * hCount * lCount;
    }

    public int appleMoney() {
        return apples * 4000;
    }
}

public class Main {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int weightSum = 0;
        int moneySum = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String T = st.nextToken();
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            Box box = new Box(T, W, H, L);
            weightSum += box.calBoxWeight();
            moneySum += box.appleMoney();
        }

        System.out.println(weightSum);
        System.out.println(moneySum);
        
    }
}

