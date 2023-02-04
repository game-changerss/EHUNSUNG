package study;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command){
                case "push" :
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    if(stack.size() == 0)
                        bw.write("-1\n" );
                    else
                        bw.write(stack.pop() + "\n");
                    break;
                case "size" :
                    bw.write(stack.size() + "\n");
                    break;
                case "empty" :
                    bw.write((stack.empty() ? "1" : "0") + "\n");
                    break;
                case "top" :
                    if(stack.size() == 0)
                        bw.write("-1\n");
                    else
                        bw.write(stack.peek() + "\n");
                    break;
            }

        }

        bw.flush();
        bw.close();

    }
}
