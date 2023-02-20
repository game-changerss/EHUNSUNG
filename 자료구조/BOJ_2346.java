package DataStructure;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/** 보고 풂 */
public class BOJ_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Deque<int[]> deque = new ArrayDeque<>();

        bw.append("1 ");
        int move = Integer.parseInt(st.nextToken());

        for(int i = 2; i <= n; i++){
            deque.add(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        while(!deque.isEmpty()) {
            if (move > 0) {
                for (int j = 1; j < move; j++) {
                    deque.add(deque.pollFirst());
                }
                int[] next = deque.removeFirst();
                move = next[1];
                bw.append(String.valueOf(next[0])).append(" ");
            } else {
                for (int j = move; j < -1; j++) {
                    deque.addFirst(deque.pollLast());
                }
                int[] next = deque.removeLast();
                move = next[1];
                bw.append(String.valueOf(next[0])).append(" ");
            }
        }
        bw.flush();
        bw.close();
    }
}
