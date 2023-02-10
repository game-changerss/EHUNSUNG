package study;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *  - 입력이 영어로 들어오는지 숫자로 들어오는지 구분은 어덯게..??
 *      -> Integer.parseInt(str) 해서 NumberFormatException 뱉으면
 *         영어, 정상 실행되면 숫자
 */
public class BOJ_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> nameMap = new HashMap<>();
        HashMap<Integer, String> numberMap = new HashMap<>();

        for(int i = 1; i <= n; i++){
            String poketmon = br.readLine();
            nameMap.put(poketmon, i);
            numberMap.put(i, poketmon);
        }

        for(int i = 0; i < m; i++){

            String str = br.readLine();

            if(isNumber(str)){
                bw.write(numberMap.get(Integer.parseInt(str)) + "\n");
            }
            else {
                bw.write(nameMap.get(str) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static boolean isNumber(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
