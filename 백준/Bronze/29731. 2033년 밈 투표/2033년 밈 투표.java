import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static String[] memes = {
            "Never gonna give you up",
            "Never gonna let you down",
            "Never gonna run around and desert you",
            "Never gonna make you cry",
            "Never gonna say goodbye",
            "Never gonna tell a lie and hurt you",
            "Never gonna stop"
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int checkEqual = 0;
        for(int i = 0; i < N; i++) {
            String checkMeme = br.readLine();
            for(int j = 0; j < memes.length; j++) {
                if(memes[j].equals(checkMeme)) {
                    checkEqual++;
                }
            }
        }
        
        if(checkEqual != N) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
