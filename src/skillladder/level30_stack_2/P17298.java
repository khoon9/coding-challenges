package skillladder.level30_stack_2;

/**
 * 문제
 * 크기가 N인 수열 A = A1, A2, ..., AN이 있다. 수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다. Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 그러한 수가 없는 경우에 오큰수는 -1이다.
 *
 * 예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다. A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.
 *
 * 입력
 * 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에 수열 A의 원소 A1, A2, ..., AN (1 ≤ Ai ≤ 1,000,000)이 주어진다.
 *
 * 출력
 * 총 N개의 수 NGE(1), NGE(2), ..., NGE(N)을 공백으로 구분해 출력한다.
 *
 * 예제 입력 1
 * 4
 * 3 5 2 7
 * 예제 출력 1
 * 5 7 7 -1
 * 예제 입력 2
 * 4
 * 9 5 4 8
 * 예제 출력 2
 * -1 8 8 -1
 */

import java.util.*;
import java.io.*;

public class P17298 {
    // 목표: 배열의 각 idx별 오른쪽의 큰 수가 저장되도록 수행
    // 유의:
    // n^2 = 10^12 -> O(n^2) 불가
    // 배열 <- 예시 기반 규칙성 탐색 수행
    // 7 1 4 2 3 5 6 1 4 3
    //   4 5 3 5 6-1 4-1-1
    // 바로 오른쪽 요소, 해당 요소가 선택한 요소, 다음 요소가 선택한 요소...
    // pop 수행할 경우, base 요소가 더 크다는 의미이므로 괜찮음
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st1.nextToken());
            }
            int[] targetArr = new int[N];
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i=N-1; i>=0; i--){
                int target = -1;
                int nowValue;
                while (deque.size()!=0){
                    if (arr[i]<(nowValue=deque.removeFirst())){
                        target = nowValue;
                        break;
                    }
                }
                targetArr[i] = target;
                deque.addFirst(target);
                deque.addFirst(arr[i]);
            }
            Arrays.stream(targetArr).forEach(target->sb.append(target+" "));

            System.out.println(sb);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
