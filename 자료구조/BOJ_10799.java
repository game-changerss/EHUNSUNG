package DataStructure;

import java.io.*;
import java.util.Stack;

/**
 *  - 처음엔 stack에 괄호를 모두 넣고 하나씩 빼면서 하려고 함
 *  - 하지만 풀리지 않아서 답지 쬐금 봄.. -> 스택에 여는 괄호만 넣어서 한다는 사실을 알아냄
 *
 */

public class BOJ_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        Stack<String> stack = new Stack<>();

        int open = 0;
        int close = 0;
        int total = 0;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '(') {
                stack.push(String.valueOf(str.charAt(i)));
                open = 1;
                close = 0;
            } else {
                stack.pop();
                if(open == 1){
                    if(!stack.isEmpty()){
                        total += stack.size();
                    }
                } else {
                    total++;
                }
                open = 0;
                close = 1;
            }
        }

        bw.write(String.valueOf(total));
        bw.flush();
        bw.close();
    }
}
