package DataStructure;

import java.io.*;
import java.util.Stack;

public class BOJ_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        String str = br.readLine();

        Stack<Double> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            arr[i] = br.readLine();
        }

        for(int i = 0; i < str.length(); i++){
            Character c = str.charAt(i);

            if(Character.isLetter(c)){
                stack.push(Double.parseDouble(arr[c-65]));
            } else {
                double num1 = stack.pop();
                double num2 = stack.pop();
                double answer = 0.00;

                switch(c) {
                    case '+': answer = num2 + num1; break;
                    case '-': answer = num2 - num1; break;
                    case '*': answer = num2 * num1; break;
                    case '/': answer = num2 / num1; break;
                }

                stack.push(answer);
            }
        }

        bw.write(String.format("%.2f", stack.pop()));
        bw.close();

    }

}
