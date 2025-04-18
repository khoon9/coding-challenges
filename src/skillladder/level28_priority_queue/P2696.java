package skillladder.level28_priority_queue;

/**
 *문제
 * 어떤 수열을 읽고, 홀수번째 수를 읽을 때 마다, 지금까지 입력받은 값의 중앙값을 출력하는 프로그램을 작성하시오.
 *
 * 예를 들어, 수열이 1, 5, 4, 3, 2 이면, 홀수번째 수는 1번째 수, 3번째 수, 5번째 수이고, 1번째 수를 읽었을 때 중앙값은 1, 3번째 수를 읽었을 때는 4, 5번째 수를 읽었을 때는 3이다.
 *
 * 입력
 * 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 각 테스트 케이스의 첫째 줄에는 수열의 크기 M(1 ≤ M ≤ 9999, M은 홀수)이 주어지고, 그 다음 줄부터 이 수열의 원소가 차례대로 주어진다. 원소는 한 줄에 10개씩 나누어져있고, 32비트 부호있는 정수이다.
 *
 * 출력
 * 각 테스트 케이스에 대해 첫째 줄에 출력하는 중앙값의 개수를 출력하고, 둘째 줄에는 홀수 번째 수를 읽을 때 마다 구한 중앙값을 차례대로 공백으로 구분하여 출력한다. 이때, 한 줄에 10개씩 출력해야 한다.
 *
 * 예제 입력 1
 * 3
 * 9
 * 1 2 3 4 5 6 7 8 9
 * 9
 * 9 8 7 6 5 4 3 2 1
 * 23
 * 23 41 13 22 -3 24 -31 -11 -8 -7
 * 3 5 103 211 -311 -45 -67 -73 -81 -99
 * -33 24 56
 * 예제 출력 1
 * 5
 * 1 2 3 4 5
 * 5
 * 9 8 7 6 5
 * 12
 * 23 23 22 22 13 3 5 5 3 -3
 * -7 -3
 */

import java.util.*;
import java.io.*;

public class P2696 {
    // 목표: 홀수 번째 입력마다 중앙값 구하기
    // 유의:
    // N 10^4 T 10^1000
    // O(TN^2) -> 10^11
    // O(TN * log N) -> 10^7
    // 중앙값 -> 가장 큰 수, 가장 작은 수 필요없음
    // 1 2 3(출구)    4    (출구)5 6 7
    // 최대 힙        최소 힙
    // 최대 힙에 넣고 만약 최소 힙의 peek와 최대 힙의 peek 크기가 서로 역전된다면
    // 역전 관계가 풀릴 때까지 최대 힙에서 최소 힙으로 이동
    // 이후 리벨런싱(K+1 개 : K 개) 진행
    // 10 20 30 40 50      31 32
    // 10 20 30         31 32 40 50
    // 10 20 30 31         32 40 50
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int T = Integer.parseInt(br.readLine());
            for (int i=0; i<T; i++){
                int N = Integer.parseInt(br.readLine());
                Queue<Integer> queue1 = new PriorityQueue<>(Comparator.reverseOrder());
                Queue<Integer> queue2 = new PriorityQueue<>();
                List<Integer> list = new ArrayList<>();
                List<Integer> inputList = new ArrayList<>();
                for (int j=0; j<(N+9)/10; j++){
                    StringTokenizer st1 = new StringTokenizer(br.readLine());
                    while (st1.hasMoreTokens()){
                        inputList.add(Integer.parseInt(st1.nextToken()));
                    }
                }
                for (int j=1; j<=N; j++){
                    int target = inputList.get(j-1);
                    queue1.offer(target);
                    while (queue1.size()!=0 && queue2.size()!=0 && queue1.peek()>queue2.peek()){
                        queue2.offer(queue1.poll());
                    }
                    if (j%2 == 1){
                        while (queue1.size()!=queue2.size()+1){
                            if (queue1.size()>queue2.size()+1){
                                queue2.offer(queue1.poll());
                            } else if (queue1.size()<queue2.size()+1){
                                queue1.offer(queue2.poll());
                            }
                        }
                        list.add(queue1.peek());
                    }
                }
                sb.append(list.size());
                for (int j=0; j<list.size(); j++){
                    if (j%10 == 0){
                        sb.append("\n");
                    }
                    sb.append(list.get(j)+" ");
                }
                sb.append("\n");
            }

            System.out.println(sb);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
