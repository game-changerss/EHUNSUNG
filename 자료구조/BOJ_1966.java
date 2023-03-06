package DataStructure;

import java.io.*;
import java.util.*;

/**
 * 처음에 Queue로 풀다가 처음 거 꺼내고 queue에 담긴 나머지 것들 순회하면서
 * 우선순위 비교해야하는데 도무지 안되길래 걍 LinkedList로 풂.
 * 다른 사람들 거 보니까 iterator 사용해서 queue로 풀긴 했던데 나중에 겅부해야지
 */
public class BOJ_1966 {
    static LinkedList<Integer[]> ll = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int cnt = Integer.parseInt(br.readLine());

        for(int i = 0; i < cnt; i++){

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

//            System.out.println(i + "번째) n = " + n + " m = " + m);

            st = new StringTokenizer(br.readLine());

            // arr = {중요도, 인덱스}
            for(int j = 0; j < n; j++){

                Integer[] arr = new Integer[]{Integer.parseInt(st.nextToken()), j};
                ll.add(arr);

                // System.out.println("j) " + j + " arr[0] - " + arr[0] + " arr[1] - " + arr[1]);
            }


            while(!ll.isEmpty()){

                // 맨 앞 색기 꺼내고 우선순위, 인덱스 값 각각 변수에 저장해둔다.
                Integer[] cur = ll.poll();
                int max = cur[0];

                boolean check = true;

                // ll 돌면서 우선순위 비교해준다.
                for(int k = 0; k < ll.size(); k++){
                    if(ll.size() == 0) break;

                    int tmp = ll.get(k)[0];

                    // 만약 꺼낸 맨 앞 색기의 우선순위가 ll에 들어있는 요소들의 우선순위보다 크다면 비교 계속
                    if(max >= tmp) {
                        continue;
                    }
                    else { // 작다면 아직 제거할 타이밍 아니기 때문에 다시 큐의 맨 뒤에 넣어준 뒤 비교를 멈춘다.
                        ll.add(cur);
                        check = false;
                        break;
                    }
                }

                // 모두 확인했는데 우선순위가 가장 크고, 내가 궁금한 문서라면
                if(check == true && cur[1] == m){
                    int answer = n - ll.size();
                    bw.write(String.valueOf(answer) + "\n");
                    break;
                }
            }

            // ll 초기화
            ll.clear();
        }

        bw.flush();
        bw.close();
    }
}
