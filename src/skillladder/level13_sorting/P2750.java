package skillladder.level13_sorting;

/**
 *문제: 수 정렬하기
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 *
 * 출력
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 *
 * 예제 입력 1
 * 5
 * 5
 * 2
 * 3
 * 4
 * 1
 * 예제 출력 1
 * 1
 * 2
 * 3
 * 4
 * 5
 */

import java.util.*;

public class P2750 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = scanner.nextInt();
        List<Integer> targetList = new ArrayList<>();
        for(int i=0; i<N; i++){
            targetList.add(scanner.nextInt());
        }
        Collections.sort(targetList);
        for(int targetElement: targetList){
            sb.append(targetElement).append("\n");
        }

        System.out.println(sb);
    }
}
