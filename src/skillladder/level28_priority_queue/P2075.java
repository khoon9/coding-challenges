package skillladder.level28_priority_queue;

/**
 *문제
 * N×N의 표에 수 N2개 채워져 있다. 채워진 수에는 한 가지 특징이 있는데, 모든 수는 자신의 한 칸 위에 있는 수보다 크다는 것이다. N=5일 때의 예를 보자.
 *
 * 12	7	9	15	5
 * 13	8	11	19	6
 * 21	10	26	31	16
 * 48	14	28	35	25
 * 52	20	32	41	49
 * 이러한 표가 주어졌을 때, N번째 큰 수를 찾는 프로그램을 작성하시오. 표에 채워진 수는 모두 다르다.
 *
 * 입력
 * 첫째 줄에 N(1 ≤ N ≤ 1,500)이 주어진다. 다음 N개의 줄에는 각 줄마다 N개의 수가 주어진다. 표에 적힌 수는 -10억보다 크거나 같고, 10억보다 작거나 같은 정수이다.
 *
 * 출력
 * 첫째 줄에 N번째 큰 수를 출력한다.
 *
 * 예제 입력 1
 * 5
 * 12 7 9 15 5
 * 13 8 11 19 6
 * 21 10 26 31 16
 * 48 14 28 35 25
 * 52 20 32 41 49
 * 예제 출력 1
 * 35
 */

import java.util.*;
import java.io.*;

public class P2075 {
    // 목표:
    // 유의:
    // 10^6 -> 4MB*3 -> 12MB.. 자바 11에 대해선 384MB 가능
    // 행렬 전체 행을 봐야할 수 있다. 단, 탐색 과정에서 어떤 열을 보고 안 볼지 결정할 순 있다.
    // -> idx row와 col에 대해 N 쌍개 지정해서 매 선택마다 N회의 순회 후 N번 나아가는 방식
    // -> O(N*2)
    // 만약 일차 배열로 취급해서 정렬 시킨다면 -> O(N^2 * log N^2) -> O(N^2 * log N)
    // -> OK -> 단, 더 오래 걸림 -> 229MB 1400ms
    // 혹은 우선순위 큐로 모든 행을 저장 O(N^2 * log n)하여 N번 poll O(N * log N) 수행하는 방법
    // -> OK -> 274MB 788ms
    // N번째 요소만을 원하므로, 큐의 크기가 N으로 유지되도록 사용해도 정답이 도출됨
    // -> OK -> 244MB 872ms
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new PriorityQueue<>();
            for (int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++){
                    queue.offer(Integer.parseInt(st.nextToken()));
                    if (queue.size()>N){
                        queue.poll();
                    }
                }
            }
            sb.append(queue.peek());

            System.out.println(sb);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
