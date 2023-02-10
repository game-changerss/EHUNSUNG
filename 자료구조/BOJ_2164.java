package DataStructure;

import java.io.*;
import java.nio.Buffer;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            queue.add(i);
        }

        while(queue.size()>1){
            queue.poll();
            int m = queue.poll();
            queue.add(m);
        }
        bw.write(queue.poll().toString());
        bw.close();

    }
}
