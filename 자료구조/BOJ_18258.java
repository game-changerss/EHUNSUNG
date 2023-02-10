package study;
import java.io.*;
import java.util.*;

public class BOJ_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> queue = new LinkedList<>();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push" :
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    bw.write((!queue.isEmpty() ? queue.poll() : "-1") + "\n");
                    break;
                case "size" :
                    bw.write(queue.size() + "\n");
                    break;
                case "empty" :
                    bw.write((queue.isEmpty() ? "1" : "0") + "\n");
                    break;
                case "front" :
                    bw.write((!queue.isEmpty() ? queue.peek() : "-1") + "\n");
                    break;
                case "back" :
                    bw.write((!queue.isEmpty() ? queue.peekLast() : "-1") + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();

    }
}
