package skillladder.level28_priority_queue;

/**
 *문제
 * 세계적인 도둑 상덕이는 보석점을 털기로 결심했다.
 *
 * 상덕이가 털 보석점에는 보석이 총 N개 있다. 각 보석은 무게 Mi와 가격 Vi를 가지고 있다. 상덕이는 가방을 K개 가지고 있고, 각 가방에 담을 수 있는 최대 무게는 Ci이다. 가방에는 최대 한 개의 보석만 넣을 수 있다.
 *
 * 상덕이가 훔칠 수 있는 보석의 최대 가격을 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N과 K가 주어진다. (1 ≤ N, K ≤ 300,000)
 *
 * 다음 N개 줄에는 각 보석의 정보 Mi와 Vi가 주어진다. (0 ≤ Mi, Vi ≤ 1,000,000)
 *
 * 다음 K개 줄에는 가방에 담을 수 있는 최대 무게 Ci가 주어진다. (1 ≤ Ci ≤ 100,000,000)
 *
 * 모든 숫자는 양의 정수이다.
 *
 * 출력
 * 첫째 줄에 상덕이가 훔칠 수 있는 보석 가격의 합의 최댓값을 출력한다.
 *
 * 예제 입력 1
 * 2 1
 * 5 10
 * 100 100
 * 11
 * 예제 출력 1
 * 10
 * 예제 입력 2
 * 3 2
 * 1 65
 * 5 23
 * 2 99
 * 10
 * 2
 * 예제 출력 2
 * 164
 */

import java.util.*;
import java.io.*;

public class P1202 {
    // 목표: 논리적으로 물건을 담아 종합 가치 최댓값 구하기
    // 유의:
    // 물건 N 개 - (무게 M, 가격 V)
    // 가방 K 개 - (최대 용량 C), 가방마다 물건 최대 한 개만 수용 가능
    // N, K - 3 * 10^5
    // M, V - 10^6
    // C - 10^8
    // 모든 숫자 -> 양의 정수
    // (그리디 알고리즘? 이라고 처음에 생각했으나 조회 과정이 특정 상태 전환 마다 이뤄지므로 결과적으로 아니었음)
    // O(NK) - 9 * 10^10  -> 불가
    // O(NlogNlogK) 정도로 어림 짐작
    // 단위:
    // 최대 (개수*가치) -> 3 * 10^5  * 10^6 -> 3 * 10*11 -> Long
    // queueItem1 -> 무게순 오름차순 저장
    // queueItem2 -> 현재 bag 용량에 들어갈 수 있는 모든 물건 저장 -> 가치순 내림차순 저장
    // queueBag -> 용량순 오름차순 저장
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st1.nextToken());
            int K = Integer.parseInt(st1.nextToken());
            long totalMax = 0l;
            // {{M, V}, ...}
            Queue<int[]> queueItem1 = new PriorityQueue<>(Comparator
                    .comparing((int[] target) -> target[0]));
            // {{M, V}, ...}
            Queue<int[]> queueItem2 = new PriorityQueue<>(Comparator
                    .comparing((int[] target) -> target[1], Comparator.reverseOrder()));
            // {C, ...}
            Queue<Integer> queueBag = new PriorityQueue<>();
            for (int i=0; i<N; i++){
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                queueItem1.offer(new int[]{
                        Integer.parseInt(st2.nextToken()),
                        Integer.parseInt(st2.nextToken())
                });
            }
            for (int i=0; i<K; i++){
                queueBag.offer(Integer.parseInt(br.readLine()));
            }
            while (true){
                if (queueBag.size()==0){
                    break;
                }
                if (queueItem1.size()==0 && queueItem2.size()==0){
                    break;
                }
                while (queueItem1.size() != 0 && queueItem1.peek()[0] <= queueBag.peek()) {
                    queueItem2.offer(queueItem1.poll());
                }
                if (queueItem2.size()==0){
                    queueBag.poll();
                    continue;
                }
                if (queueItem2.size()!=0 && queueItem2.peek()[0]<=queueBag.peek()){
                    totalMax += queueItem2.poll()[1];
                    queueBag.poll();
                } else {
                    break;
                }
            }
            sb.append(totalMax);

            System.out.println(sb);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
// 추론 과정
// 가방은 제일 큰 값어치를 가지는 대상을 저장하면 됨
// 동일 무게라면 더 높은 가치를 지닌 걸 먼저 저장하는게 우선임
// 하지만, 무게가 낮은 걸 무조건 우선적으로 저장할 경우 -> 더 높은 가치를 가지며 용량이 더 큰 대상을 못 고름
// 저장된 걸 불러와서 다시 입력 -> 다음 무게 도달 시에 가장 큰 가치를 가진 대상 poll
// queueItem1 -> 무게순 오름차순 최소 힙
// queueItem2 -> 가치순 내림차순 최대 힙
// queueBag -> 용량순 오름차순 최소 힙
// 용량 가장 작은 게 어떤 무게의 물건을 고르든 용량이 큰 가방의 선택에 부정적 영향 못 끼침
// queueBag 의 하나가 처리되면 종결
// 핵심. 해당 가방이 케어가능한 대상으로만 범위를 한정해서 가장 높은 가치를 택
// queue에서 고려할 수 있는 모든 부분에 대해 고려하려면
// queueItem1의 최상단 물건의 무게가 해당 배낭보다 높아야함
// queueItem2 물건이 있다는 건 가방에 어떤 물건이라도 일단 채우고 넘어갈 수 있다는 의미.