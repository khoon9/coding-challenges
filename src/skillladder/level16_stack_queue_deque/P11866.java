package skillladder.level16_stack_queue_deque;

/**
 *문제
 * 요세푸스 문제는 다음과 같다.
 *
 * 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
 *
 * N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 1,000)
 *
 * 출력
 * 예제와 같이 요세푸스 순열을 출력한다.
 *
 * 예제 입력 1
 * 7 3
 * 예제 출력 1
 * <3, 6, 2, 7, 5, 1, 4>
 */

import java.util.*;

public class P11866 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        Deque<Integer> targetDeque = new ArrayDeque<>();
        for (int i=1; i<=N; i++){
            targetDeque.addLast(i);
        }
        List<Integer> targetList = new ArrayList<>();
        while (!targetDeque.isEmpty()){
            for (int i=0; i<K-1; i++){
                targetDeque.addLast(targetDeque.removeFirst());
            }
            targetList.add(targetDeque.removeFirst());
        }
        sb.append("<");
        for (int i=0; i<targetList.size(); i++){
            if (i==0){
                sb.append(targetList.get(i));
            } else {
                sb.append(", "+targetList.get(i));
            }
        }
        sb.append(">");

        System.out.println(sb);
    }
}