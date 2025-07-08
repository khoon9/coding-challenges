package skillladder.level30_stack_2;


/**
 * 문제
 * 크기가 N인 수열 A = A1, A2, ..., AN이 있다. 수열의 각 원소 Ai에 대해서 오등큰수 NGF(i)를 구하려고 한다.
 *
 * Ai가 수열 A에서 등장한 횟수를 F(Ai)라고 했을 때, Ai의 오등큰수는 오른쪽에 있으면서 수열 A에서 등장한 횟수가 F(Ai)보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 그러한 수가 없는 경우에 오등큰수는 -1이다.
 *
 * 예를 들어, A = [1, 1, 2, 3, 4, 2, 1]인 경우 F(1) = 3, F(2) = 2, F(3) = 1, F(4) = 1이다. A1의 오른쪽에 있으면서 등장한 횟수가 3보다 큰 수는 없기 때문에, NGF(1) = -1이다. A3의 경우에는 A7이 오른쪽에 있으면서 F(A3=2) < F(A7=1) 이기 때문에, NGF(3) = 1이다. NGF(4) = 2, NGF(5) = 2, NGF(6) = 1 이다.
 *
 * 입력
 * 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째에 수열 A의 원소 A1, A2, ..., AN (1 ≤ Ai ≤ 1,000,000)이 주어진다.
 *
 * 출력
 * 총 N개의 수 NGF(1), NGF(2), ..., NGF(N)을 공백으로 구분해 출력한다.
 *
 * 예제 입력 1
 * 7
 * 1 1 2 3 4 2 1
 * 예제 출력 1
 * -1 -1 1 2 2 1 -1
 */

import java.util.*;
import java.io.*;

public class P17299 {
    // 목표: 빈도수 기반 오른쪽 큰 수 구하기
    // 유의:
    // n^2 = 10^12 -> O(n^2) 불가
    // A의 값 범위가 1~10^6이므로 F는 크기가 10^6으로 볼 수 있다.
    // O(n)에 F의 값을 모두 구할 수 있음 -> 조건으로 사용할 수 있다.
    //  1  1 2 3 4 2  1
    // -1 -1 1 2 2 1 -1
    // stack size가 0이 아닐 때까지 stack.pop()을 하면서 비교한다.
    // 선택한 target과 현재 값을 stack에 저장한다.
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            int[] arrF = new int[1000001];
            for (int i=0; i<N; i++) {
                int target = Integer.parseInt(st1.nextToken());
                arr[i] = target;
                arrF[target] += 1;
            }
            Deque<Integer> deque = new ArrayDeque<>();
            Deque<Integer> dequeTarget = new ArrayDeque<>();
            for (int i=N-1; i>=0; i--) {
                int target = -1;
                int arrValue = arr[i];
                while (deque.size()!=0) {
                    int dequeValue = deque.removeFirst();
                    if (arrF[arrValue]<arrF[dequeValue]){
                        target = dequeValue;
                        break;
                    }
                }
                dequeTarget.addFirst(target);
                if (target!=-1) {
                    deque.addFirst(target);
                }
                deque.addFirst(arrValue);
            }
            dequeTarget.stream().forEach(t->sb.append(t+" "));

            System.out.println(sb);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

