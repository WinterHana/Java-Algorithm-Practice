import java.io.BufferedReader;
import java.io.InputStreamReader;

// c= c- dz= d- lj nj s= z=
public class Main {
    public static void main(String[] args) throws Exception {
        String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputData = br.readLine();

        for(String croatiaStr : croatia) {
            if(inputData.contains(croatiaStr)) {
                inputData = inputData.replace(croatiaStr, "1");
            }
        }

        System.out.println(inputData.length());
    }
}